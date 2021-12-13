package com.pacha.Pacha.bean;

public class ItemMPBean {
	private String id;
	private String title;
	private long quantity;
	private String currency_id;
	private long unit_price;
	private String category_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}
	public long getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(long unit_price) {
		this.unit_price = unit_price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
}
