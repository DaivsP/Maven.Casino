package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static junit.framework.TestCase.assertTrue;

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
    public void getNumberOfCardsZeroTest(){
        // Given
        Hand hand = new Hand();
        Integer expected = 0;

        // When
        Integer actual = hand.getNumberOfCards();

        // Then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void addASetOfCardTest(){
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
    public void removeACardTest() {

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

    @Test
    public void sortTest() {

        // Given
        Card card1 = new Card(Card.Rank.ACE , Card.Suit.CLUBS,0);
        Card card2 = new Card(Card.Rank.QUEEN , Card.Suit.CLUBS,0);
        Card card3 = new Card(Card.Rank.ACE , Card.Suit.HEARTS,0);
        Hand hand = new Hand();
        String expected = "QUEEN CLUBS, ACE CLUBS, ACE HEARTS";

        // When
        hand.addACard(card1);
        hand.addACard(card2);
        hand.addACard(card3);
        hand.sort();
        String actual = hand.toString();


        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void publicConstructorTest() throws Exception {
        // Given
        Constructor constructor = Hand.class.getDeclaredConstructor();
        Assert.assertTrue("Constructor is not private", Modifier.isPublic(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }
  
    @Test
    public void constructorTest(){
        Hand hand = new Hand();

        Object expected = hand;

        Assert.assertEquals(expected,hand);
    }

    @Test
    public void toStringTest1(){
        // Given
        Card card1 = new Card(Card.Rank.ACE,Card.Suit.HEARTS, 11);
        Card card2 = new Card(Card.Rank.TWO,Card.Suit.HEARTS, 2);
        Hand hand = new Hand();
        String expected = "ACE HEARTS, TWO HEARTS";

        // When
        hand.addACard(card1);
        hand.addACard(card2);
        String actual = hand.toString();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void toStringTest2(){
        // Given
        Hand hand = new Hand();

        // Then
        Assert.assertNull( hand.toString() );
    }

    @Test
    public void getSumOfHand(){
        // Given
        Card card1 = new Card(Card.Rank.ACE,Card.Suit.HEARTS, 11);
        Card card2 = new Card(Card.Rank.TWO,Card.Suit.HEARTS, 2);
        Hand hand = new Hand();
        Integer expected = 13;

        // When
        hand.addACard(card1);
        hand.addACard(card2);
        Integer actual = hand.getSumOfHand();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void handConstructorTest(){
        // Given
        Hand hand = new Hand();

        // Then
        Assert.assertTrue(hand.isEmpty());

    }
}
