package com.inventory;

import com.exceptions.InvalidItemTypeException;
import com.exceptions.InventoryException;
import com.inventory.InventoryItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static void saveToFile(String filename, List<InventoryItem> items) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (InventoryItem item : items) {
                writer.write(item.toCsvFormat());
                writer.newLine();
            }
        }
    }

    public static List<InventoryItem> loadFromFile(String filename) throws InventoryException {
        List<InventoryItem> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    InventoryItem item = InventoryItem.fromCsvFormat(line);
                    items.add(item);
                } catch (InvalidItemTypeException e) {
                    System.err.println("Error loading item: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new InventoryException("Error loading inventory from file: " + filename, e);
        }
        return items;
    }
}