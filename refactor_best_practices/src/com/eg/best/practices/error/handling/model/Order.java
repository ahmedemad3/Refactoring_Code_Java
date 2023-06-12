package com.eg.best.practices.error.handling.model;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int orderId;
    private LocalDate orderDate;
    private String customerName;
    private List<OrderItem> items;

    public Order(int orderId, LocalDate orderDate, String customerName, List<OrderItem> items) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getSubTotal().doubleValue();
        }
        return total;
    }
}

