package com.logInfo;

public class logger {
    private logStrat logStrat;

    public logger(logStrat logStrategy) {
        this.logStrat = logStrategy;
    }

    public void log(String message) {
        logStrat.log(message);
    }
}