package com.light;

public class Main {
    public static void main(String[] args) {
        Switchable bulb = new bulb();
        lightSwitch lightSwitch = new lightSwitch(bulb);

        lightSwitch.operate();
    }
}