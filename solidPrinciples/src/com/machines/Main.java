package com.machines;

public class Main {
    public static void main(String[] args) {
        Printer simplePrinter = new simplePrinter();
        simplePrinter.print();

        Fax fax = new simpleFax();
        fax.fax();

        Scanner sc = new simpleScan();
        sc.scan();

        MultiFunctionPrinter mp = new MultiFunctionPrinter();
        mp.scan();
        mp.fax();
        mp.print();
    }
}
