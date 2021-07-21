package com.pacha.Pacha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacha.Pacha.bean.DetalleVPBean;
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

}
