package com.unasat.memorygame.screens;

import com.unasat.memorygame.app.Board;
import com.unasat.memorygame.app.Card;
import com.unasat.memorygame.app.ScreenManager;
import com.unasat.memorygame.input.KeyboardInput;
import com.unasat.memorygame.interfaces.Screen;

import java.util.ArrayList;
import java.util.List;

import static com.unasat.memorygame.app.Helpers.clearConsole;

public class GameScreen implements Screen {
    Board board;
    List<Card> cardPairs = new ArrayList<>();

    final int SCORE_MATCHED_PAIR = 2;
    final int SCORE_BONUS_MULTIPLIER = 3;
    final int MAX_FAILED_ATTEMPTS = 10;

    int score = 0;
    int failedAttempts = 0;

    public GameScreen() {
        createBoard();
    }

    @Override
    public void update(ScreenManager screenManager) {
        while (true) {
            clearConsole();
            showScore();
            showUsedAttempts();
            showBoard();

            String userInput = KeyboardInput.getText();

            if (userInput.equals("quit") || userInput.equals("exit")) {
                screenManager.switchScreen("menu");
                break;
            }

            if (this.board.isCardAlreadyOpened(Integer.parseInt(userInput))) {
                System.out.println("Card already opened!");
                continue;
            }

            // Open card
            Card openedCard = this.board.openCard(Integer.parseInt(userInput));

            cardPairs.add(openedCard);

            if (cardPairs.size() == 2) {
                if (cardPairs.get(0).getValue().equals(cardPairs.get(1).getValue())) {
                    System.out.println("Match!");
                    increaseScore();
                } else {
                    System.out.println("No match!");
                    closeUnmatchedCards();
                    failAttempt();
                }

                if (getFailedAttempts() == this.MAX_FAILED_ATTEMPTS) {
                    System.out.println("GAME OVER");
                    endGame();
                }

                if (this.board.allCardsOpen()) {
                    setScore(clampScore(getScore() + calculateBonusScore()));
                    endGame();
                }

                this.cardPairs.clear();
            }
        }
    }

    private void showScore() {
        System.out.println("SCORE: " + this.getScore());
    }

    private void showUsedAttempts() {
        System.out.println("ATTEMPTS USED: " + getFailedAttempts() + "/" + this.MAX_FAILED_ATTEMPTS);
    }

    private void showBoard() {
        System.out.println(this.board);
    }

    private void createBoard() {
        String[] cards = {
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J"
        };

        this.board = new Board(cards, 5);
        this.board.shuffle();
    }

    private int getScore() {
        return this.score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    private int getFailedAttempts() {
        return this.failedAttempts;
    }

    private void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    private void increaseScore() {
        setScore(getScore() + this.SCORE_MATCHED_PAIR);
    }

    private int calculateBonusScore() {
        return (getScore() - getFailedAttempts()) * this.SCORE_BONUS_MULTIPLIER;
    }

    private void failAttempt() {
        setFailedAttempts(getFailedAttempts() + 1);
    }

    private int clampScore(int score) {
        return Math.max(score, 0);
    }

    private void endGame() {
        if (this.board.allCardsOpen()) {
            // Game has been won
            System.out.println("YOU WON!");
        } else {
            // Game has been lost
            System.out.println("YOU LOST!");
        }
    }

    public void closeUnmatchedCards() {
        for (Card card : this.cardPairs) {
            this.board.closeCard(card.getPosition());
        }
    }
}
