package com.refactor.tech.largeClass.model;

import java.util.List;

public class Order {
	private long id;
	private Customer customer;
	private List<OrderItem> orderItems;

	public Order(long id, Customer customer , List<OrderItem> orderItems) {
		this.id = id;
		this.customer = customer;
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
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("Customer Address: " + customer.getCustomerAddress());
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	/**
	 * Problem 
	 * In this example, we have a Order class that contains all the attributes and methods related to an order, 
	 * including a list of OrderItem objects. This can be problematic as the class is doing too much 
	 * and violating the Single Responsibility Principle. Additionally, the calculateTotal() and printInvoice() methods 
	 * are tightly coupled to the Order class and should be decoupled.
	 */

}
