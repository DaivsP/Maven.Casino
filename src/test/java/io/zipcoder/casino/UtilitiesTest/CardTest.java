package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void createCardTest1(){
        //When
        Card card = new Card(Card.Rank.KING, Card.Suit.HEARTS);

        //Then
        Card.Rank actualRank = card.getRank();
        Card.Suit actualSuit = card.getSuit();

        Card.Rank expectedRank = Card.Rank.KING;
        Card.Suit expectedSuit = Card.Suit.HEARTS;

        Assert.assertEquals(expectedRank, actualRank);
        Assert.assertEquals(expectedSuit, actualSuit);
    }

    @Test
    public void createCardTest2(){
        //When
        Card card = new Card(Card.Rank.ACE, Card.Suit.CLUBS);

        //Then
        Card.Rank actualRank = card.getRank();
        Card.Suit actualSuit = card.getSuit();

        Card.Rank expectedRank = Card.Rank.ACE;
        Card.Suit expectedSuit = Card.Suit.CLUBS;

        Assert.assertEquals(expectedRank, actualRank);
        Assert.assertEquals(expectedSuit, actualSuit);
    }
}