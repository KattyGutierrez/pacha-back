package com.pacha.Pacha.bean;

import java.util.LinkedHashSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMPBean {
	private String description;
	private long external_reference;
	private LinkedHashSet<ItemMPBean> items;
	private String additional_info;
	private PayerMPBean payer;
	private double transaction_amount;
	private BackUrlsMPBean back_urls;
	
	public  String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getExternal_reference() {
		return external_reference;
	}
	public void setExternal_reference(long external_reference) {
		this.external_reference = external_reference;
	}
	public LinkedHashSet<ItemMPBean> getItems() {
		return items;
	}
	public void setItems(LinkedHashSet<ItemMPBean> items) {
		this.items = items;
	}
	public String getAdditional_info() {
		return additional_info;
	}
	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}
	public PayerMPBean getPayer() {
		return payer;
	}
	public void setPayer(PayerMPBean payer) {
		this.payer = payer;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public BackUrlsMPBean getBack_urls() {
		return back_urls;
	}
	public void setBack_urls(BackUrlsMPBean back_urls) {
		this.back_urls = back_urls;
	}
	
	
}
