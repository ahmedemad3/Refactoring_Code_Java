package com.refactor.code.smells.switchCases.service;

import org.springframework.http.ResponseEntity;

import com.refactor.code.smells.switchCases.model.PaymentRequest;
import com.refactor.code.smells.switchCases.service.refactor.PaymentService;

public class CreditCardPaymentService implements PaymentService {

	public ResponseEntity<?> processPayment(PaymentRequest paymentRequest) {
		// Implement the credit card payAment processing logic here
		// Use the paymentRequest object to access the necessary payment information

		// Perform the actual payment processing logic here

		// Once the payment has been processed, update the payment status in the
		// paymentRequest object
		 return ResponseEntity.badRequest().body("Invalid payment.");
	}

}
