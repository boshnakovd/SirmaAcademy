package com.inventory;

import com.exceptions.InventoryException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<InventoryItem> items = new ArrayList<>();


    public void addItem(InventoryItem item) {
        items.add(item);
    }

    public void listItems() {
        for (InventoryItem item : items) {
            System.out.println(item.getDetails());
        }
    }

    public InventoryItem getItemById(String itemId) {
        for (InventoryItem item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public List<InventoryItem> getItems() {
        return items;
    }


    public void loadItemsFromFile(String filename) throws InventoryException {
        items = FileService.loadFromFile(filename);
    }
}