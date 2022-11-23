package com.unasat.memorygame.screens;

import com.unasat.memorygame.app.ScreenManager;
import com.unasat.memorygame.interfaces.Screen;

import java.util.HashMap;

public class CreditsScreen implements Screen {
    public void show() {
        System.out.println("""
                Credits
                -------

                    * Rajiv Ramsing
                    * Girish Oemrawsingh
                    * Emilio Partoredjo
                    
                Memory Game - SEM 2 - UNASAT 2022
        """);
    }

    @Override
    public void update(ScreenManager screenManager) {

    }
}
