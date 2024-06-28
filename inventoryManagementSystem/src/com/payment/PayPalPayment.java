package com.payment;

public class PayPalPayment extends Payment {
    private String email;
    private String password;

    public PayPalPayment(double amount, String email, String password) {
        super(amount);
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean validate() {
        // Simplified validation for demonstration purposes
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }
}