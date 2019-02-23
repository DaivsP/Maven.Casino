package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {


    @Test
    public void addACardTest(){
        // Given
        Card card = new Card();
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
        Card card1 = new Card();
        Card card2 = new Card();
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
        Card card1 = new Card();
        Card card2 = new Card();
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
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();
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
        Card card1 = new Card();
        Card card2 = new Card();
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
    public void compareNegativeOneTest(){
        // Given
        Card card1 = new Card();
        Card card2 = new Card();
        Hand hand = new Hand();
        Integer expected = -1;

        // when
        Integer actual = hand.compare(card1, card2);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareZeroTest(){
        // Given
        Card card1 = new Card();
        Card card2 = new Card();
        Hand hand = new Hand();
        Integer expected = 0;

        // when
        Integer actual = hand.compare(card1, card2);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void comparePositiveOneTest(){
        // Given
        Card card1 = new Card();
        Card card2 = new Card();
        Hand hand = new Hand();
        Integer expected = 1;

        // when
        Integer actual = hand.compare(card1, card2);

        // then
        Assert.assertEquals(expected, actual);
    }

}
