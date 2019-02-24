package io.zipcoder.casino.Games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.FunDealer;
import io.zipcoder.casino.Person.HiLowPlayer;
import org.junit.Assert;
import org.junit.Test;

public class HiLowGameTest {

    @Test
    public void constructorTest(){
        // Given

        // When
        HighLow highLow = new HighLow();
        CardDeck cardDeck = highLow.getCardDeck();
        FunDealer hlDealer = highLow.getHLDealer();
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();

        // Then
        Assert.assertNotNull(cardDeck);
        Assert.assertNotNull(hlDealer);
        Assert.assertNotNull(hiLowPlayer);
    }

    @Test
    public void winEqualTrueTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.ACE, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.ACE, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);


        // When
        Boolean actual = highLow.win("E");

        // Then
        Assert.assertTrue(actual);

    }

    @Test
    public void winEqualFalseTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.ACE, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.KING, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);


        // When
        Boolean actual = highLow.win("E");

        // Then
        Assert.assertFalse(actual);

    }

    @Test
    public void winHighTrueTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.THREE, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.KING, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);

        // When
        Boolean actual = highLow.win("H");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void winHighFalseTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.JACK, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);

        // When
        Boolean actual = highLow.win("H");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void winLowTrueTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.THREE, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.TWO, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);

        // When
        Boolean actual = highLow.win("L");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void winLowFalseTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.KING, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);

        // When
        Boolean actual = highLow.win("L");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void compareRankEqualTest() {
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);
        Integer expected = 0;

        // When
        Integer actual = highLow.compareRank();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareRankDealerHigherTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.KING, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);
        Integer expected = -1;

        // When
        Integer actual = highLow.compareRank();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareRankPlayerHigherTest(){
        // Given
        HighLow highLow = new HighLow();
        // prep player
        Hand playerHand = new Hand();
        playerHand.addACard(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS ));
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();
        hiLowPlayer.setHand(playerHand);
        // prep dealer
        Hand DealerHand = new Hand();
        DealerHand.addACard(new Card(Card.Rank.JACK, Card.Suit.HEARTS ));
        FunDealer hlDealer = highLow.getHLDealer();
        hlDealer.setHand(DealerHand);
        Integer expected = 1;

        // When
        Integer actual = highLow.compareRank();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
