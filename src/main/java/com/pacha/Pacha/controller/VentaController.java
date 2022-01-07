package com.pacha.Pacha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pacha.Pacha.bean.RequestMPBean;
import com.pacha.Pacha.bean.VentaBean;
import com.pacha.Pacha.entity.DetalleVP;
import com.pacha.Pacha.service.VentaService;

@RestController
@CrossOrigin("*")
public class VentaController {

	@Autowired
	VentaService vService;

	@PostMapping({ "/registrarVenta" })
	public ResponseEntity<RequestMPBean> registrarVenta(@RequestBody VentaBean vb) {
		RequestMPBean list = vService.registrarVenta(vb);
		return list != null ? ResponseEntity.status(HttpStatus.CREATED).body(list)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	@GetMapping({"/venta/{id}"})
	public Iterable<DetalleVP> getDetallesVenta(@PathVariable Long id){
		return vService.getDetallesVenta(id);
	}
	@GetMapping({"/mercadopago/{id}"})
	public RequestMPBean getRequestMercadoPago(@PathVariable Long id){
		return vService.getRequestMercadoPago(id);
	}

}
