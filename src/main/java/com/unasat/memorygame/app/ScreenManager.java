package com.unasat.memorygame.app;

import com.unasat.memorygame.interfaces.Screen;

import java.util.HashMap;

import static com.unasat.memorygame.app.Helpers.clearConsole;

public class ScreenManager {
    Screen defaultScreen;
    Screen currentScreen;
    HashMap<String, Screen> screens = new HashMap<>();

    public int number = 1;

    public void register(String screenName, Screen screen) {
        this.screens.put(screenName, screen);
    }

    public void setDefaultScreen(String screenName) {
        this.defaultScreen = screens.get(screenName);
        this.currentScreen = this.defaultScreen;
    }

    public void update() throws Exception {
        if (this.currentScreen == null) {
            throw new Exception("No default screen was specified.");
        }

        this.currentScreen.update(this);
    }

    public void switchScreen(String screenName) {
        this.currentScreen = this.screens.get(screenName);
    }
}
