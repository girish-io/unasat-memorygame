package com.unasat.memorygame.app;

import java.util.*;


public class Board {
    int columns;

    ArrayList<Card> cards = new ArrayList<>();

    HashMap<Integer, Card> cardPositions = new HashMap<>();

    public Board(String[] cards, int columns) {
        this.columns = columns;

        // Create a pair for every card
        for (String card : cards) {
            this.cards.add(new Card(card));
            this.cards.add(new Card(card));
        }

        // Create card positions
        for (int p = 0; p < this.cards.size(); p++) {
            cardPositions.put(p, this.cards.get(p));
        }
    }

    public void shuffle() {
        cardPositions.clear();

        Random random = new Random();
        ArrayList<Card> cardsToProcess = new ArrayList<>(this.cards);

        for (int i = 0; i < this.cards.size(); i++) {
            Card randomCard = cardsToProcess.get(random.nextInt(cardsToProcess.size()));
            randomCard.setPosition(i);

            cardPositions.put(i, randomCard);
            cardsToProcess.remove(randomCard);
        }
    }

    public String getBoard() {
        System.out.println(this.cardPositions);
        StringBuilder boardString = new StringBuilder();
        int columnsProcessed = 0;

        String cardClosedCover = "*";
        String displayedCardValue;

        for (Card card : this.cardPositions.values()) {
            if (columnsProcessed == this.columns) {
                boardString.append("\n");
                columnsProcessed = 0;
            }

            if (card.isOpened()) {
                displayedCardValue = card.getValue();
            } else {
                displayedCardValue = cardClosedCover;
            }

            boardString
                    .append(" | ")
                    .append(displayedCardValue)
                    .append(" | ");

            columnsProcessed++;
        }

        return boardString.toString();
    }

    public boolean isCardAlreadyOpened(int position) {
        return this.cardPositions.get(position).isOpened();
    }

    public Card openCard(int position) {
        this.cardPositions.get(position).setOpened(true);
        return this.cardPositions.get(position);
    }

    public void closeCard(int position) {
        this.cardPositions.get(position).setOpened(false);
    }

    public boolean allCardsOpen() {
        for (Card card : this.cardPositions.values()) {
            if (!card.isOpened()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return getBoard();
    }
}
