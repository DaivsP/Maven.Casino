package io.zipcoder.casino;

public class Card {
    private enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}

    private enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private Boolean hidden;
    private Suit cardSuit;
    private Rank cardRank;

    public Card (Suit cardSuit, Rank cardRank){
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public void createCard(){
        Card newCard = new Card(Suit.HEARTS, Rank.KING);
    }

}


