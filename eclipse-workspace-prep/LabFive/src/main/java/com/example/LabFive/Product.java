package com.example.LabFive;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
	@NotNull(message="is required")
	@Min(1)
	@Max(100)
	private Long id;
	
	@Min(1)
	@NotNull(message="should not be null")
	private Double price;
	
	@NotBlank(message = "should be not blank")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
