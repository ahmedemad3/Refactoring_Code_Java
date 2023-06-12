package com.refactor.tech.largeClass.model.refactor;


public class Invoice {
	
	private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : order.getOrderItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
    
    public void printInvoice() {
    	
		System.out.println("Order ID: " + order.getId());
		System.out.println("Customer Name: " + order.getCustomerName());
		System.out.println("Customer Address: " + order.getCustomerAddress());
		System.out.println("Order Items: ");
		for (OrderItem item : order.getOrderItems()) {
			System.out.println(item.getName() + " - " + item.getPrice() + " - " + item.getQuantity());
		}
		System.out.println("Total: " + calculateTotal());
	}


}
