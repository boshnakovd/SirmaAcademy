package com.logInfo;

import java.io.FileWriter;
import java.io.IOException;


public class consoleLog implements logStrat {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

