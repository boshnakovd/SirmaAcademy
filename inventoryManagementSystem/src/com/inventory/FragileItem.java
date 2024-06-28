package com.inventory;

public class FragileItem extends InventoryItem {
    private double weight;

    public FragileItem(String itemId, int quantity, double price, double weight) {
        super(itemId, quantity, price);
        this.weight = weight;
    }

    public double getWeight() { return weight; }

    @Override
    public String getDetails() {
        return "Fragile Item: " + getItemId() + ", Quantity: " + getQuantity() + ", Price: $" + getPrice() + ", Weight: " + weight + "kg";
    }

    @Override
    public String toCsvFormat() {
        return getItemId() + "," + getQuantity() + "," + getPrice() + "," + weight;
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity();
    }
}
