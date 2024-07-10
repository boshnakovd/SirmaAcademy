package com.invoice;

public class invoicePrint {
    public void printInvoice(Invoice invoice) {
        System.out.println("Printing invoice for " + invoice.getCustomerName());
        System.out.println("Amount: " + invoice.getAmount());
        System.out.println("Quantity: " + invoice.getQuantity());
    }
}
