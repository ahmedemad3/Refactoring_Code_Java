package com.refactor.code.smells.switchCases.model;

public class PaymentRequest {
    private String paymentMethod;
    private double amount;
    private String customerId;
    private String orderId;
    
    public PaymentRequest(String paymentMethod, double amount, String customerId, String orderId) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.customerId = customerId;
        this.orderId = orderId;
    }
    
    // getters and setters
    
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
