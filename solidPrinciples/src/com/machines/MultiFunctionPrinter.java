package com.machines;

public class MultiFunctionPrinter implements Printer, Fax, Scanner {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void fax() {
        System.out.println("Sending fax...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }
}
