package com.refactor.code.smells.longclasses.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

	private Long Id;
	private BigDecimal totalPrice;
	private LocalDate orderDate;
	private List<OrderItemDTO> orderItemDTOs;

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

	public List<OrderItemDTO> getOrderItemDTOs() {
		return orderItemDTOs;
	}

	public void setOrderItemDTOs(List<OrderItemDTO> orderItemDTOs) {
		this.orderItemDTOs = orderItemDTOs;
	}
}
