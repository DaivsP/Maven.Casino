package io.zipcoder.casino.games;

import io.zipcoder.casino.games.cardgames.highlow.HighLow;
import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.games.cardgames.cardutilities.CardDeck;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import io.zipcoder.casino.Person.fun.FunDealer;
import io.zipcoder.casino.games.cardgames.highlow.HiLowPlayer;
import io.zipcoder.casino.games.gameutilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HiLowGameTest {
    Console defautConsole;

    @Before
    public void setUp(){
        defautConsole = new Console(System.in, System.out);
    }

    @Test
    public void constructorTest(){
        // Given

        // When
        HighLow highLow = new HighLow(defautConsole);
        CardDeck cardDeck = highLow.getCardDeck();
        FunDealer hlDealer = highLow.getHLDealer();
        HiLowPlayer hiLowPlayer = highLow.getHLPlayer();

        // Then
        Assert.assertNotNull(cardDeck);
        Assert.assertNotNull(hlDealer);
        Assert.assertNotNull(hiLowPlayer);
    }
/*
    @Test
    public void playTest(){
        // Given
        byte[] inputBytes = "h\rh\rh".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);

        HighLow highLow = new HighLow(defautConsole);
        highLow.setConsole(new Console(inputStream, System.out));

        // When
        highLow.play();


        // Then
    }*/

    @Test
    public void winEqualTrueTest(){
        // Given
        HighLow highLow = new HighLow(defautConsole);
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
        Boolean actual = highLow.win("S");

        // Then
        Assert.assertTrue(actual);

    }

    @Test
    public void updateScoreTest(){
        // Given
        HighLow highLow = new HighLow(defautConsole);
        Integer expected =1;

        // When
        highLow.updateScore();
        Integer actual = highLow.getScore();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void winEqualFalseTest(){
        // Given
        HighLow highLow = new HighLow(defautConsole);
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
        Boolean actual = highLow.win("S");

        // Then
        Assert.assertFalse(actual);

    }

    @Test
    public void winHighTrueTest(){
        // Given
        HighLow highLow = new HighLow(defautConsole);
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
        HighLow highLow = new HighLow(defautConsole);
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
        HighLow highLow = new HighLow(defautConsole);
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
        HighLow highLow = new HighLow(defautConsole);
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
        HighLow highLow = new HighLow(defautConsole);
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
        HighLow highLow = new HighLow(defautConsole);
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
        HighLow highLow = new HighLow(defautConsole);
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
