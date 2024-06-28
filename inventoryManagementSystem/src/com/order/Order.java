package com.order;

import java.util.ArrayList;
import java.util.List;
import com.inventory.InventoryItem;
import com.payment.Payment;

public class Order {
    private String orderId;
    private List<OrderItem> orderItems;
    private double totalCost;
    private Payment payment;

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderItems = new ArrayList<>();
    }

    public void addItem(InventoryItem item, int quantity) {
        orderItems.add(new OrderItem(item, quantity));
        totalCost += item.calculateValue() * quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean processOrder() {
        if (payment.validate() && payment.getAmount() >= totalCost) {
            for (OrderItem orderItem : orderItems) {
                orderItem.getItem().setQuantity(orderItem.getItem().getQuantity() - orderItem.getQuantity());
            }
            return true;
        }
        return false;
    }
}