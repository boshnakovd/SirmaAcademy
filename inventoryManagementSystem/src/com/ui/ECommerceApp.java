package com.ui;

import com.inventory.*;
import com.order.*;
import com.order.Order;
import com.payment.*;
import com.exceptions.*;
import com.payment.Payment;

import java.util.Scanner;

public class ECommerceApp {
    private static InventoryManager inventoryManager = new InventoryManager();
    private static PaymentProcessor paymentProcessor = new PaymentProcessor();
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the E-commerce Console Application!");

        try {
            loadInventoryData();
            displayMenu();
            boolean isRunning = true;
            while (isRunning) {
                System.out.print("Enter command (1-5): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        inventoryManager.listItems();
                        break;
                    case 2:
                        addToCart();
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        processOrder();
                        break;
                    case 5:
                        isRunning = false;
                        System.out.println("Exiting application.");
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void loadInventoryData() throws InventoryException {
        try {
            inventoryManager.loadItemsFromFile("data/inventory.csv");
            System.out.println("Inventory loaded successfully.");
        } catch (Exception e) {
            throw new InventoryException("Error loading inventory data: " + e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. List Items");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Process Order");
        System.out.println("5. Exit");
    }

    private static void addToCart() {
        try {
            inventoryManager.listItems();
            System.out.print("Enter item ID to add to cart: ");
            String itemId = scanner.nextLine();
            InventoryItem item = inventoryManager.getItemById(itemId);
            if (item == null) {
                System.out.println("Item not found.");
                return;
            }
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (item.getQuantity() < quantity) {
                System.out.println("Not enough stock available.");
                return;
            }

            cart.addItem(item, quantity);
            System.out.println("Item added to cart.");
        } catch (Exception e) {
            System.err.println("Error adding item to cart: " + e.getMessage());
        }
    }

    private static void viewCart() {
        cart.viewCart();
        System.out.println("Total: $" + cart.calculateTotal());
    }

    private static void processOrder() {
        try {
            viewCart();
            System.out.print("Enter payment amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Select payment method (1 - Credit Card, 2 - PayPal): ");
            int paymentMethod = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Payment payment = null;
            switch (paymentMethod) {
                case 1:
                    payment = createCreditCardPayment(amount);
                    break;
                case 2:
                    payment = createPayPalPayment(amount);
                    break;
                default:
                    System.out.println("Invalid payment method selection.");
                    return;
            }

            paymentProcessor.processPayment(payment);

            Order order = createOrder();
            if (order.processOrder()) {
                System.out.println("Order processed successfully.");
                cart.placeOrder();
            } else {
                System.out.println("Order processing failed. Payment not authorized.");
            }
        } catch (Exception e) {
            System.err.println("Error processing order: " + e.getMessage());
        }
    }

    private static CreditCardPayment createCreditCardPayment(double amount) {
        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter expiry date (MM/YY): ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();
        return new CreditCardPayment(amount, cardNumber, expiryDate, cvv);
    }

    private static PayPalPayment createPayPalPayment(double amount) {
        System.out.print("Enter PayPal email: ");
        String email = scanner.nextLine();
        System.out.print("Enter PayPal password: ");
        String password = scanner.nextLine();
        return new PayPalPayment(amount, email, password);
    }

    private static Order createOrder() {
        Order order = new Order("ORD-" + (int) (Math.random() * 1000));
        for (OrderItem orderItem : cart.getItems()) {
            order.addItem(orderItem.getItem(), orderItem.getQuantity());
        }
        order.setPayment(cart.calculateTotal() > 0 ? createCreditCardPayment(cart.calculateTotal()) : null);
        return order;
    }
}