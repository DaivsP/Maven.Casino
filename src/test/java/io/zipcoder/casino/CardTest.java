package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void createCardTest(){
        //When
        Card card = new Card(Card.Rank.KING, Card.Suit.HEARTS);

        //Then
        Card actualRank = card.getRank();
        Card actualSuit = card.getSuit();

        Card.Rank expectedRank = Card.Rank.KING;
        Card.Suit expectedSuit = Card.Suit.HEARTS;

        Assert.assertEquals(expectedRank, actualRank);
        Assert.assertEquals(expectedSuit, actualSuit);


    }
}