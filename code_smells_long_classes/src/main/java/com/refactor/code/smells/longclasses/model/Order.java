package com.refactor.code.smells.longclasses.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {

	private Long Id;
	private BigDecimal totalPrice;
	private LocalDate orderDate;
	private List<OrderItem> orderItems;

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

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
