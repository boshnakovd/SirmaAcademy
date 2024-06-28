package com.payment;

import com.exceptions.PaymentException;

public class PaymentProcessor {
    public void processPayment(Payment payment) throws PaymentException {
        if (!payment.validate()) {
            throw new PaymentException("Payment validation failed.");
        }
        // Simulate payment authorization
        boolean authorized = authorizePayment(payment.getAmount());
        if (!authorized) {
            throw new PaymentException("Payment authorization failed.");
        }
        System.out.println("Payment processed successfully.");
    }

    private boolean authorizePayment(double amount) {
        // Simulate payment authorization process
        return Math.random() < 0.9; // 90% success rate
    }
}