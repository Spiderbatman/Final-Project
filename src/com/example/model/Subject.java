package com.example.model;

public class Subject {
	private String name;
	private int credits;
	private double percent;
	private boolean isFinished;
	private int id;
	

	public Subject(String name, int credits, double percent, boolean isFinished, int id) {
		this.setId(id);
		this.setFinished(isFinished);
		this.name = name;
		this.credits = credits;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
