package com.payment;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(double amount, String cardNumber, String expiryDate, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean validate() {

        return cardNumber != null && cardNumber.length() == 16 && expiryDate != null && cvv != null && cvv.length() == 3;
    }
}
