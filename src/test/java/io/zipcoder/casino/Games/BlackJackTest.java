package io.zipcoder.casino.Games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.GamblingDealer;
import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.HashAttributeSet;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class BlackJackTest {

    BlackJack blackJack = new BlackJack();
    CardDeck cardDeck = new CardDeck();
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();

    @Before
    public void setup(){
        blackJack.clearHands(dealerHand, playerHand);
        cardDeck.shuffle();

    }

    @Test
    public void testClearHands(){
        //Given
        Card playerCard = cardDeck.dealCard();
        Card dealerCard = cardDeck.dealCard();
        dealerHand.addACard(dealerCard);
        playerHand.addACard(playerCard);

        //When
        blackJack.clearHands(dealerHand, playerHand);
        Integer actualAmountOfCardsInDealerHand = dealerHand.getNumberOfCards();
        Integer actualAmountOfCardsInPlayerHand = playerHand.getNumberOfCards();

        //Then
        Integer expected = 0;
        Assert.assertEquals(expected, actualAmountOfCardsInDealerHand);
        Assert.assertEquals(expected, actualAmountOfCardsInPlayerHand);
    }

    @Test
    public void testAddCardToPlayerAndDealerHands(){
        //Given
        blackJack.dealCardsToPlayerAndDealerAndAddThemToRespectiveHands(dealerHand, playerHand);

        //When
        Integer actualAmountOfDealerCards = dealerHand.getNumberOfCards();
        Integer actualAmountOfPlayerCards = playerHand.getNumberOfCards();

        //Then
        Integer expected = 1;
        Assert.assertEquals(expected, actualAmountOfDealerCards);
        Assert.assertEquals(expected, actualAmountOfPlayerCards);
    }

    @Test
    public void testPlayerFirstHandAndDealerFirstCard(){
        //Given
        blackJack.printUserFirstHandAndDealerFirstCard();

        //When

    }
}