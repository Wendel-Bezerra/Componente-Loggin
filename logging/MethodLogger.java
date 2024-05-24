package com.yourpackage.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodLogger {
    private static final Logger LOGGER = Logger.getLogger(MethodLogger.class.getName());
    private static final List<String> logMessages = new ArrayList<>();

    static {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        LOGGER.addHandler(handler);
    }

    public static void log(String message) {
        LOGGER.info(message);
        logMessages.add(message);
    }

    public static void showLogs() {
        System.out.println("Registros anteriores:");
        for (String logMessage : logMessages) {
            System.out.println(logMessage);
        }
    }
}
