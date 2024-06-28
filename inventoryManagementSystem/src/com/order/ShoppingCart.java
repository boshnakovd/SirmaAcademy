package com.order;

import java.util.ArrayList;
import java.util.List;
import com.inventory.InventoryItem;

public class ShoppingCart {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(InventoryItem item, int quantity) {
        items.add(new OrderItem(item, quantity));
    }

    public void viewCart() {
        for (OrderItem orderItem : items) {
            System.out.println(orderItem.getItem().getDetails() + " | Quantity: " + orderItem.getQuantity());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem orderItem : items) {
            total += orderItem.getItem().calculateValue() * orderItem.getQuantity();
        }
        return total;
    }

    public void placeOrder() {
        items.clear();
    }

    public Iterable<? extends OrderItem> getItems() {
        return items;
    }
}