package com.refactor.code.smells.dataClumps.model;

import java.math.BigDecimal;

public class Product {
	
	private Long id;
	private BigDecimal price;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
