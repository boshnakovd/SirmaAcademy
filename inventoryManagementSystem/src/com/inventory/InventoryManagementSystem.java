package com.inventory;

import com.exceptions.InventoryException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {

    private static List<InventoryItem> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. List Items");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    listItems();
                    break;
                case 3:
                    saveToFile(scanner);
                    break;
                case 4:
                    loadFromFile(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item type (1: Electronics, 2: Grocery, 3: Fragile): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        switch (type) {
            case 1:
                inventory.add(new ElectronicsItem(itemId, quantity, price));
                break;
            case 2:
                inventory.add(new GroceryItem(itemId, quantity, price));
                break;
            case 3:
                System.out.print("Enter weight: ");
                double weight = scanner.nextDouble();
                inventory.add(new FragileItem(itemId, quantity, price, weight));
                break;
            default:
                System.out.println("Invalid item type");
        }
    }

    private static void listItems() {
        for (InventoryItem item : inventory) {
            System.out.println(item.getDetails());
        }
    }

    private static void saveToFile(Scanner scanner) {
        System.out.print("Enter filename: ");
        String filename = scanner.next();
        try {
            FileService.saveToFile(filename, inventory);
            System.out.println("Inventory saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private static void loadFromFile(Scanner scanner) {
        System.out.print("Enter filename: ");
        String filename = scanner.next();
        try {
            inventory = FileService.loadFromFile(filename);
            System.out.println("Inventory loaded from file.");
        } catch (InventoryException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}