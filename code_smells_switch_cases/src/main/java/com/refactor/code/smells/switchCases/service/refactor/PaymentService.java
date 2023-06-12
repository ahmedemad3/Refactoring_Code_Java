package com.refactor.code.smells.switchCases.service.refactor;

import org.springframework.http.ResponseEntity;

import com.refactor.code.smells.switchCases.model.PaymentRequest;

public interface PaymentService {
    ResponseEntity<?> processPayment(PaymentRequest paymentRequest);
}

