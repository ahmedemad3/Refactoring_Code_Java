package com.refactor.code.dry.principle.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class Order {
	
	
	private Long Id;
	private String customerName;
	private BigDecimal total;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}
