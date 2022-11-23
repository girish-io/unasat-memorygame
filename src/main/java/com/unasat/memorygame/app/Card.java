package com.unasat.memorygame.app;

public class Card {
    public String value;
    public boolean opened = false;
    public int position = -1;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Card(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
