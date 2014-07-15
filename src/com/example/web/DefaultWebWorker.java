package com.example.web;

import java.util.ArrayList;

import com.example.model.Subject;

public abstract class DefaultWebWorker {
	protected String url;

	public DefaultWebWorker(String url) {
		this.url = url;
	}

	public abstract ArrayList<Subject> getSubjects();

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
}
