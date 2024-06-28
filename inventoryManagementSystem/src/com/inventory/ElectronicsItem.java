package com.inventory;

public class ElectronicsItem extends InventoryItem {
        public ElectronicsItem(String itemId, int quantity, double price) {
            super(itemId, quantity, price);
        }

        @Override
        public String getDetails() {
            return "Electronics Item: " + getItemId() + ", Quantity: " + getQuantity() + ", Price: $" + getPrice();
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
