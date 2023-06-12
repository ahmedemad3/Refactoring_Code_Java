package com.eg.refactor.magic.number;

public class Calculation_Refactor {
	
	private static final double DISCOUNT = 0.05;
    private static final double SUPER_DISCOUNT = 0.1;

    public double calculateTotalPrice(int quantity, double price) {
        if (quantity >= 10 && quantity < 20) {
        	// update db with product discount 
            return quantity * price * (1 - DISCOUNT);
            
        } else if (quantity >= 20) {
            return quantity * price * (1 - SUPER_DISCOUNT);
        } else {
            return quantity * price;
        }
    }
}
