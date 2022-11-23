package com.unasat.memorygame.input;

import java.util.Scanner;

public class KeyboardInput {
    public static String getText() {
        String prompt = "> ";

        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);

        String userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();
        userInput = userInput.trim();

        return userInput;
    }
}
