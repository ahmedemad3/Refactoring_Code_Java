package com.eg.best.practices.code.comment;

/* before comment */
public class Calcualation {

	public void calculatePrice(int quantity, double price) {
		double discount = 0;
		if (quantity >= 10) {
			discount = 0.1;
		}
		double totalPrice = quantity * price * (1 - discount);
		System.out.println("Total price: " + totalPrice);
	}

}
