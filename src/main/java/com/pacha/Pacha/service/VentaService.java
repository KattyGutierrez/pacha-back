package com.pacha.Pacha.service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacha.Pacha.bean.DetalleVPBean;
import com.pacha.Pacha.bean.ItemMPBean;
import com.pacha.Pacha.bean.PayerMPBean;
import com.pacha.Pacha.bean.RequestMPBean;
import com.pacha.Pacha.bean.VentaBean;
import com.pacha.Pacha.entity.DetalleVP;
import com.pacha.Pacha.entity.Venta;
import com.pacha.Pacha.repository.CompradorRepository;
import com.pacha.Pacha.repository.DetalleVPRepository;
import com.pacha.Pacha.repository.ProductoRepository;
import com.pacha.Pacha.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	CompradorRepository repoComprador;

	@Autowired
	VentaRepository repoVenta;

	@Autowired
	ProductoRepository repoProducto;

	@Autowired
	DetalleVPRepository repoDetalle;

	@Transactional
	public Iterable<DetalleVP> registrarVenta(VentaBean vb) {

		try {
			Venta v = new Venta();
			v.setComprador(repoComprador.findById(vb.getId_comprador()).get());
			v = repoVenta.save(v);
	
			if (!vb.getProductos().isEmpty()) {
				for (DetalleVPBean item : vb.getProductos()) {
					DetalleVP d = new DetalleVP();
	
					d.setProducto(repoProducto.findById(item.getId_producto()).get());
					d.setCantidad(item.getCantidad());
					d.setVenta(v);
	
					repoDetalle.save(d);
				}
			}
	
			return repoDetalle.findAllByVenta(v);
		} catch(Exception e) {
			return null;
		}

	}
	
	public Iterable<DetalleVP> getDetallesVenta(Long id){
		Venta v= repoVenta.findById(id).get();
		return repoDetalle.findAllByVenta(v);
	}
	public Iterable<ItemMPBean> getItemMPBeans(Iterable<DetalleVP> detalle){
		LinkedHashSet<ItemMPBean> listItems= new LinkedHashSet<>();
		for (Iterator<DetalleVP> iterator = detalle.iterator(); iterator.hasNext();) {
			DetalleVP dt = iterator.next();
			ItemMPBean itemmp=new ItemMPBean();
			itemmp.setCategory_id(""+dt.getProducto().getCategoria());
			itemmp.setCurrency_id("PEN");
			itemmp.setQuantity(dt.getCantidad());
			itemmp.setTitle(dt.getProducto().getNombre());
			itemmp.setId(""+dt.getProducto().getId());
			listItems.add(itemmp);
		}
		return listItems;
		
	}
	public RequestMPBean getRequestMercadoPago(Long id) {
		RequestMPBean rq=new RequestMPBean();
		PayerMPBean payerMP = new PayerMPBean();
		rq.setAdditional_info("Informacion Adicional");
		rq.setDescription("Descripcion Pago");
		rq.setExternal_reference(id);
		rq.setPayer(payerMP);
		rq.setProductos((LinkedHashSet<ItemMPBean>) getItemMPBeans(this.getDetallesVenta(id)));
		return rq;
	}

}
