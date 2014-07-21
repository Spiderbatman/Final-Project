package com.example.web;


public abstract class DefaultWebWorker {
	protected String url;

	public DefaultWebWorker(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
}
