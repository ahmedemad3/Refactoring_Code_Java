package com.eg.refactor.magic.number;


/* Before refactoring: */
public class Calculation {
	
    public double calculateTotalPrice(int quantity, double price) {
    	
        double discount = 0.05;
        if (quantity >= 10 && quantity < 20) {
        	
            return quantity * price * (1 - discount);
        } else if (quantity >= 20) {
        	
            double superDiscount = 0.1;
            return quantity * price * (1 - superDiscount);
            
        } else {
            return quantity * price;
        }
    }
}

