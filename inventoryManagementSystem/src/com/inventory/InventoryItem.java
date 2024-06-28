package com.inventory;

import com.exceptions.InvalidItemTypeException;

public abstract class InventoryItem {
    private String itemId;
    private int quantity;
    private double price;

    public InventoryItem(String itemId, int quantity, double price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public abstract String getDetails();
    public abstract String toCsvFormat();
    public abstract double calculateValue();

    public static InventoryItem fromCsvFormat(String csv) throws InvalidItemTypeException {
        String[] parts = csv.split(",");
        String itemId = parts[0];
        int quantity = Integer.parseInt(parts[1]);
        double price = Double.parseDouble(parts[2]);
        if (parts.length == 3) {
            return new ElectronicsItem(itemId, quantity, price);
        } else if (parts.length == 4) {
            double weight = Double.parseDouble(parts[3]);
            return new FragileItem(itemId, quantity, price, weight);
        } else {
            throw new InvalidItemTypeException("Invalid item type or CSV format: " + csv);
        }
    }
}