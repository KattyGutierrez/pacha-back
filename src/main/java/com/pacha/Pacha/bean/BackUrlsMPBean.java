package com.pacha.Pacha.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BackUrlsMPBean {
	private String succes;
	private String pending;
	private String failure;
	
	public BackUrlsMPBean(String succes, String pending, String failure) {
		super();
		this.succes = succes;
		this.pending = pending;
		this.failure = failure;
	}
	public String getSucces() {
		return succes;
	}
	public void setSucces(String succes) {
		this.succes = succes;
	}
	public String getPending() {
		return pending;
	}
	public void setPending(String pending) {
		this.pending = pending;
	}
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	
}
