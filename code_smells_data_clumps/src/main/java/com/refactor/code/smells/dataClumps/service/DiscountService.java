package com.refactor.code.smells.dataClumps.service;

import java.math.BigDecimal;

public class DiscountService {

	public double calculateDiscount(String role, BigDecimal productPrice) {
		if (role.equals("premium")) {
			return productPrice.subtract(BigDecimal.TEN).doubleValue();
		} 
		return 0;
	}

	
	// role [free , enterprise  , premium] calculate discount based on user role
}
