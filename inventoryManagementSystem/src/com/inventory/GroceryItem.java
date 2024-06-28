package com.inventory;

import com.inventory.InventoryItem;

public class GroceryItem extends InventoryItem {
    public GroceryItem(String itemId, int quantity, double price) {
        super(itemId, quantity, price);
    }

    @Override
    public String getDetails() {
        return "Grocery Item: " + getItemId() + ", Quantity: " + getQuantity() + ", Price: $" + getPrice();
    }

    @Override
    public String toCsvFormat() {
        return getItemId() + "," + getQuantity() + "," + getPrice();
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity();
    }
}