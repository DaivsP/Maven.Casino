package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {


    @Test
    public void addACardTest(){
        // Given
        Card card = new Card(null,null);
        Hand hand = new Hand();

        // When
        hand.addACard(card);

        Integer expected = 1;
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getACardTest(){
        // Given
        Card card1 = new Card(Card.Rank.ACE , Card.Suit.CLUBS);
        Card card2 = new Card(null,null);
        Hand hand = new Hand();
        Card expected = card1;

        // When
        hand.addACard(card1);
        hand.addACard(card2);
        Card actual = hand.getACard(0);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getNumberOfCardsTest(){
        // Given
        Card card1 = new Card(null,null);
        Card card2 = new Card(null,null);
        Hand hand = new Hand();
        Integer expected = 2;

        // When
        hand.addACard(card1);
        hand.addACard(card2);
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getNumberOfCardsTestZero(){
        // Given
        Hand hand = new Hand();
        Integer expected = 0;

        // When
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void addASetOfCardsTest(){
        // Given
        Card card1 = new Card(null,null);
        Card card2 = new Card(null,null);
        Card card3 = new Card(null,null);
        Card card4 = new Card(null,null);
        Card card5 = new Card(null,null);
        Card[] cTest = new Card[]{card1, card2, card3, card4, card5};
        Hand hand = new Hand();
        Integer expected = 5;

        // When
        hand.addASetOfCards(cTest);
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void clearHandTest(){
        // Given
        Card card1 = new Card(null,null);
        Card card2 = new Card(null,null);
        Hand hand = new Hand();
        Integer expected = 0;

        // When
        hand.addACard(card1);
        hand.addACard(card2);
        hand.clearHand();
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeACard() {

        // Given
        Card card = new Card(null,null);
        Hand hand = new Hand();

        // When
        hand.addACard(card);
        hand.removeACard(card);
        Integer expected = 0;
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);

    }
}
