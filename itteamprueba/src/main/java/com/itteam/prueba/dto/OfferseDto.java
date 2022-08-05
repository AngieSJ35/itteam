package com.itteam.prueba.dto;

public class OfferseDto {
	
	private Float price_value;
	private String description;
	private String name;

	public OfferseDto() {
		super();
	}
	
	public OfferseDto(Float price_value, String description, String name) {
		super();
		this.price_value = price_value;
		this.description = description;
		this.name = name;
	}

	public Float getPrice_value() {
		return price_value;
	}

	public void setPrice_value(Float price_value) {
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
