package com.unasat.memorygame.app;

import com.unasat.memorygame.interfaces.Screen;
import com.unasat.memorygame.screens.CreditsScreen;
import com.unasat.memorygame.screens.GameScreen;
import com.unasat.memorygame.screens.MenuScreen;

public class Application {
    public static void main(String[] args) {
        Helpers.clearConsole();

        ScreenManager screenManager = initScreenManager();
        loop(screenManager);
    }

    public static ScreenManager initScreenManager() {
        Screen menuScreen = new MenuScreen();
        Screen gameScreen = new GameScreen();
        Screen creditsScreen = new CreditsScreen();

        ScreenManager screenManager = new ScreenManager();
        screenManager.register("menu", menuScreen);
        screenManager.register("game", gameScreen);
        screenManager.register("credits", creditsScreen);

        screenManager.setDefaultScreen("menu");

        return screenManager;
    }

    public static void loop(ScreenManager screenManager) {
        while (true) {
            try {
                screenManager.update();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
