package com.refactor.tech.largeClass.model.refactor;

import java.util.List;

public class Order {
	private long id;
	private String customerName;
	private String customerAddress;
	private List<OrderItem> orderItems;

	public Order(long id, String customerName, String customerAddress, List<OrderItem> orderItems) {
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.orderItems = orderItems;
	}

	public double calculateTotal() {
		double total = 0;
		for (OrderItem item : orderItems) {
			total += item.getPrice() * item.getQuantity();
		}
		return total;
	}

	public void printInvoice() {
		System.out.println("Order ID: " + id);
		System.out.println("Customer Name: " + customerName);
		System.out.println("Customer Address: " + customerAddress);
		System.out.println("Order Items: ");
		for (OrderItem item : orderItems) {
			System.out.println(item.getName() + " - " + item.getPrice() + " - " + item.getQuantity());
		}
		System.out.println("Total: " + calculateTotal());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}