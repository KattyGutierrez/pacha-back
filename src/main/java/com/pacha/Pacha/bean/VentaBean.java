package com.pacha.Pacha.bean;

import java.util.List;

public class VentaBean {
	private Long id_comprador;
	private List<DetalleVPBean> productos;
	
	
	public Long getId_comprador() {
		return id_comprador;
	}
	public void setId_comprador(Long id_comprador) {
		this.id_comprador = id_comprador;
	}
	public List<DetalleVPBean> getProductos() {
		return productos;
	}
	public void setProductos(List<DetalleVPBean> productos) {
		this.productos = productos;
	}
	
	
	
	
}
