package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public class PayPalPaymentService implements PaymentService {

	@Override
	public boolean supports(String paymentType) {
		 return paymentType.equalsIgnoreCase("paypal");
	}

	@Override
	public void processPayment(Payment payment) {

	}

}
