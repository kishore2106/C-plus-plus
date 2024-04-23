package com.example.TestFive;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Product {
	
	@Min(1)
	@Max(100)
	@NotNull(message="id should not be null")
	Long id;
	
	@NotEmpty(message="Name field should not be blank")
	String name;
	
	@Min(1)
	@NotNull(message="Price field shoulb not be null")
	double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
