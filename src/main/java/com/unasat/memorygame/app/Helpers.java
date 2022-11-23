package com.unasat.memorygame.app;

public class Helpers {
    public static void clearConsole() {
        final String os = System.getProperty("os.name");

        ProcessBuilder process;

        if (os.contains("Windows")) {
            process = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
        } else {
            process = new ProcessBuilder("clear").inheritIO();
        }

        try {
            process.start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
