package com.eg.best.practices.code.comment;

public class Calcualation_Refactor {
	
	/**
	* Calculates the total price based on the quantity and price, 
	* with a discount applied for large orders.
	* @param quantity The quantity of items to be purchased
	* @param price The price of each item
	*/
	public void calculatePrice(int quantity, double price) {
	    double discount = 0;
	    if(quantity >= 10) { // Apply discount for orders of 10 or more items
	        discount = 0.1;
	    }
	    double totalPrice = quantity * price * (1 - discount);
	    System.out.println("Total price: " + totalPrice);
	}


}
