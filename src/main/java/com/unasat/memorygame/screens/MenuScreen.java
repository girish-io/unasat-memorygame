package com.unasat.memorygame.screens;

import com.unasat.memorygame.app.ScreenManager;
import com.unasat.memorygame.input.KeyboardInput;
import com.unasat.memorygame.interfaces.Screen;

import static com.unasat.memorygame.app.Helpers.clearConsole;

public class MenuScreen implements Screen {
    @Override
    public void update(ScreenManager screenManager) {
//        screenManager.switchScreen("game");
        showMenu();

        String menuOption = KeyboardInput.getText();

        switch (menuOption) {
            case "1", "play" -> {
                screenManager.switchScreen("game");
            }

            case "3" -> {
                screenManager.switchScreen("credits");
            }

            case "99", "exit" -> System.exit(0);
        }

        clearConsole();
    }
    public static void showMenu() {
        System.out.println("""
                    Memory Game
                    -----------
                    
                        1) Start game
                        2) Leaderboard
                        3) Credits
                        4) Edit profile
                        
                        99) Exit
                """);
    }
}
