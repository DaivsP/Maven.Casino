package io.zipcoder.casino.games.cardgames.cardutilities;

import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card>{


    public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}

    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    public List<Integer> bjCardValueList = new ArrayList<Integer>();


    private Suit cardSuit;
    private Rank cardRank;
    private Integer cardValue;



    public Card(Rank cardRank, Suit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public Card(Rank cardRank, Suit cardSuit, Integer cardValue){
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public int compareTo(Card card){
        int ordinalNum = card.cardRank.ordinal();
        return this.getRank().ordinal() - ordinalNum;
    }

    public Rank getRank() {
        return this.cardRank;
    }

    public Suit getSuit() {
        return this.cardSuit;
    }


    public Integer getCardValue(){return this.cardValue;}


    public void createBJCardValue(){
        bjCardValueList.add(2);
        bjCardValueList.add(3);
        bjCardValueList.add(4);
        bjCardValueList.add(5);
        bjCardValueList.add(6);
        bjCardValueList.add(7);
        bjCardValueList.add(8);
        bjCardValueList.add(9);
        bjCardValueList.add(10);
        bjCardValueList.add(10);
        bjCardValueList.add(10);
        bjCardValueList.add(10);
        bjCardValueList.add(11);
    }
  
    @Override
    public String toString(){
        String cardVal = getRank().toString();
        cardVal = cardVal + " " + getSuit().toString();
        return cardVal;
    }
}