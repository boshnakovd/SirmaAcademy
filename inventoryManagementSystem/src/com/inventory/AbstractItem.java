package com.inventory;

import com.inventory.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    private String category;
    private double price;
    private boolean breakable;
    private boolean perishable;

    public AbstractItem(double price, boolean breakable, boolean perishable) {
        this.price = price;
        this.breakable = breakable;
        this.perishable = perishable;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public void handleBreakage() {
        System.out.println("Handling breakage of the item.");
    }

    @Override
    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public void handleExpiration() {
        System.out.println("Handling expiration of the item.");
    }

    @Override
    public void displayDescription() {
        System.out.println(getDetails());
    }
}