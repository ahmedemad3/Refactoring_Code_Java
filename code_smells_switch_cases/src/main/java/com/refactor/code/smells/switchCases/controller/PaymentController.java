package com.refactor.code.smells.switchCases.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.switchCases.model.PaymentRequest;
import com.refactor.code.smells.switchCases.service.BitcoinPaymentService;
import com.refactor.code.smells.switchCases.service.CreditCardPaymentService;
import com.refactor.code.smells.switchCases.service.PayPalPaymentService;

@RestController
public class PaymentController {

	@PostMapping("/pay")
	public ResponseEntity<?> pay(@RequestBody PaymentRequest paymentRequest) {
		switch (paymentRequest.getPaymentMethod()) {
		case "credit":
			CreditCardPaymentService creditCardService = new CreditCardPaymentService();
			return creditCardService.processPayment(paymentRequest);
		case "paypal":
			PayPalPaymentService paypalService = new PayPalPaymentService();
			return paypalService.processPayment(paymentRequest);
		case "bitcoin":
			BitcoinPaymentService bitcoinService = new BitcoinPaymentService();
			return bitcoinService.processPayment(paymentRequest);
		default:
			return ResponseEntity.badRequest().body("Invalid payment method.");
		}
	}

}
