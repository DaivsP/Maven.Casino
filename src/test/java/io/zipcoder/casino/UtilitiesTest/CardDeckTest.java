package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.games.cardgames.cardutilities.CardDeck;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardDeckTest {

    @Test
    public void checkFullDeck(){
        //Given
        CardDeck cardDeck = new CardDeck();

        //When
        List deck = CardDeck.getDECK();

        //Then
        int expectedSize = 52;
        Assert.assertEquals(expectedSize, deck.size());
        System.out.println(cardDeck);
    }

    @Test
    public void dealCardTest(){
        //Given
        CardDeck cardDeck = new CardDeck();

        //When
        Card expectedCard = cardDeck.checkNextCard();

        //Then
        Card actualCard = cardDeck.dealCard();
        Assert.assertEquals(expectedCard, actualCard);

        int expectedSize = 51;
        Assert.assertEquals(expectedSize, cardDeck.deckSize());
        System.out.println(actualCard);
    }

    @Test
    public void shuffleCardTest(){
        //Given
        CardDeck cardDeck = new CardDeck();

        //When
        Card expectedCard = cardDeck.checkNextCard();
        cardDeck.shuffle();

        //Then
        Card actualCard = cardDeck.dealCard();
        Assert.assertNotEquals(expectedCard, actualCard);

        int expectedSize = 51;
        Assert.assertEquals(expectedSize, cardDeck.deckSize());
    }
}