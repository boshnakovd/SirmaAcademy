package com.engines;

public class Main {
    public static void main(String[] args) {
        Engine combustionEngine = new combustionEngine();
        combustionEngine.start();
        Engine electric = new electricEngine();
        electric.start();
    }
}
