package com.refactor.code.smells.longmethods.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDTO {
	
	private Long id;
    private BigDecimal totalPrice;
    private LocalDate orderDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
    
    

}
