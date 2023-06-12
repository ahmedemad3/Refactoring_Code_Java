package com.refactor.code.smells.longclasses.model;

import java.math.BigDecimal;

public class OrderItemDTO {

	private Long Id;
	private BigDecimal totalPrice;
	private String productName;
	private Integer quantity;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
