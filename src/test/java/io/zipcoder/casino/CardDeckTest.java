package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardDeckTest {

    @Test
    public void dealCardTest(){
        //Given
        CardDeck cardDeck = new CardDeck();

        //When
        Card expectedCard = cardDeck.checkNextCard();

        //Then
        Card actualCard = cardDeck.dealCard();
        Assert.assertEquals(expectedCard, actualCard);
    }

    @Test
    public void shuffleCardTest(){
        //Given
        CardDeck cardDeck = new CardDeck();

        //When
        Card expectedCard = cardDeck.checkNextCard();

        //Then
        Card actualCard = cardDeck.dealCard();
        Assert.assertNotEquals(expectedCard, actualCard);
    }
}