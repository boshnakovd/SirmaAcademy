package com.light;

public class lightSwitch {
    private Switchable device;
    private boolean isOn;

    public lightSwitch(Switchable device) {
        this.device = device;
        this.isOn = false;
    }

    public void operate() {
        if (isOn) {
            device.turnOff();
            isOn = false;
            System.out.println("Device turned off.");
        } else {
            device.turnOn();
            isOn = true;
            System.out.println("Device turned on.");
        }
    }
}