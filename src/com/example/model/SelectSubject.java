package com.example.model;

public class SelectSubject {
	private String subjName;
	private boolean isSelected;
	
	public SelectSubject(String name, boolean isSelected) {
		this.subjName = name;
		this.setSelected(isSelected);
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String getSubjName() {
		return subjName;
	}

	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}
	
	
	
	
}
