package com.invoice;

public class Invoice {
    private double amount;
    private String customerName;
    private int quantity;

    public Invoice(double amount, String customerName, int quantity) {
        this.amount = amount;
        this.customerName = customerName;
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }
    public int getQuantity(){
        return quantity;
    }
}
