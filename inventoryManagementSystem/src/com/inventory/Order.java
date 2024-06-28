package com.inventory;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<InventoryItem> items = new ArrayList<>();
    private double total;

    public void addItem(InventoryItem item) {
        items.add(item);
        total += item.calculateValue();
    }

    public double calculateTotal() {
        return total;
    }

    public void processPayment(Payment payment) {
        if (payment.getAmount() >= total) {
            System.out.println("Payment successful. Order processed.");
        } else {
            System.out.println("Insufficient payment.");
        }
    }
}