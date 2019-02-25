package io.zipcoder.casino.Games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.GamblingDealer;
import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.HashAttributeSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void testPrintUserFirstHandAndDealerFirstCard(){
        //Given
        this.playerHand = blackJack.getPlayerHand();
        this.dealerHand = blackJack.getDealerHand();
        dealerHand.addACard(cardDeck.dealCard());
        dealerHand.addACard(cardDeck.dealCard());
        playerHand.addACard(cardDeck.dealCard());
        playerHand.addACard(cardDeck.dealCard());

        StringBuilder sb = new StringBuilder();

        sb.append("Your current cards: ");
        sb.append(playerHand.toString() + "\n");
        sb.append("Your current hand value: ");
        sb.append(playerHand.getSumOfHand().toString() + "\n");
        sb.append("The Dealers first card: ");
        sb.append(dealerHand.getACard(0).toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in,new PrintStream(outputStream)));

        //When
        blackJack.printUserFirstHandAndDealerFirstCard();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }
}