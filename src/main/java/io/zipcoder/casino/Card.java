package io.zipcoder.casino;

public class Card {


    public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}

    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private Boolean hidden;

    private Suit cardSuit;
    private Rank cardRank;
    public Card(Rank cardRank, Suit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public Rank getRank() {
        return this.cardRank;
    }

    public Suit getSuit() {
        return this.cardSuit;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString(){
        String cardVal = getRank().toString();
        cardVal =cardVal + " " + getSuit().toString();
        return cardVal;
    }
}