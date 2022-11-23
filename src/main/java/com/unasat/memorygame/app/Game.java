package com.unasat.memorygame.app;

public class Game {
//    public static void main(String[] args) {
//        String[] cards = {
//                "A", "B", "C", "D", "E",
//                "F", "G", "H", "I", "J",
////                "K", "L", "M", "N", "O",
////                "P", "Q", "R", "S", "T",
////                "U", "V", "W", "X", "Y"
//        };
//
//        Board board = new Board(cards, 5);
//        board.shuffle();
//
//        System.out.println(board.getBoard());
//
//        board.openCard(1);
//    }

    Board board;
    ScreenManager screenManager;

    Game(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void loop() {

    }

    Game() {
        String[] cards = {
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J"
        };

        this.board = new Board(cards, 5);
        this.board.shuffle();

        System.out.println(board.getBoard());


//        board.openCard(1);
    }
}
