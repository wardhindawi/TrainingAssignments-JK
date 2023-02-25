package com.icsfs.training.jdbc.entities;

import java.util.Random;

public class Student {
	private int id;
	private String name;
	private int average;
	private String email;

	private Random randNum = new Random();
	
	public Student(int id, String name, int average, String email) {
		this.id = id;
		this.name = name;
		this.average = average;
		this.email = email;
	}

	public Student() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", average=");
		builder.append(average);
		builder.append("]");
		return builder.toString();
	}
}
