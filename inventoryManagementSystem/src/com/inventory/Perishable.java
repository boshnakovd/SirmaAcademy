package com.inventory;

public interface Perishable {
    boolean isPerishable();
    void handleExpiration();
}