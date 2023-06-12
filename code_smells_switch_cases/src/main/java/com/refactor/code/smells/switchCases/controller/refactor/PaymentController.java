package com.refactor.code.smells.switchCases.controller.refactor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.switchCases.model.PaymentRequest;
import com.refactor.code.smells.switchCases.service.refactor.PaymentService;
import com.refactor.code.smells.switchCases.service.refactor.PaymentServiceFactory;

@RestController
public class PaymentController {

	@PostMapping("/refactor/pay")
	public ResponseEntity<?> pay(@RequestBody PaymentRequest paymentRequest) {
		PaymentService paymentService = PaymentServiceFactory
				.createPaymentService(paymentRequest.getPaymentMethod());
		return paymentService.processPayment(paymentRequest);
	}

}
