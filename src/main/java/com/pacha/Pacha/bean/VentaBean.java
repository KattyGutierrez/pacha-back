package com.pacha.Pacha.bean;

import java.util.LinkedHashSet;


public class VentaBean {
	private Long id_comprador;
	private LinkedHashSet<DetalleVPBean> productos;
	
	
	public Long getId_comprador() {
		return id_comprador;
	}
	public void setId_comprador(Long id_comprador) {
		this.id_comprador = id_comprador;
	}
	public LinkedHashSet<DetalleVPBean> getProductos() {
		return productos;
	}
	public void setProductos(LinkedHashSet<DetalleVPBean> productos) {
		this.productos = productos;
	}
	
	
	
	
}
