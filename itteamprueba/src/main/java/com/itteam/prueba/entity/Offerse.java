package com.itteam.prueba.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Offerse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int offerse_id;
	private float price_value;
	private String description;
	private String name;
	
	
	public Offerse() {
		super();
	}


	public Offerse(float price_value, String description, String name) {
		super();
		this.price_value = price_value;
		this.description = description;
		this.name = name;
	}


	public int getOfferse_id() {
		return offerse_id;
	}


	public void setOfferse_id(int offerse_id) {
		this.offerse_id = offerse_id;
	}


	public float getPrice_value() {
		return price_value;
	}


	public void setPrice_value(float price_value) {
		this.price_value = price_value;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
