package com.invoice;

public class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000, "John", 3);
        invoiceRepo invoiceRepo = new invoiceRepo();
        invoiceRepo.saveInvoice(invoice);
        invoicePrint print = new invoicePrint();
        print.printInvoice(invoice);
    }
}
