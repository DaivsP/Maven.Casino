package io.zipcoder.casino.Games;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import io.zipcoder.casino.*;
import io.zipcoder.casino.Person.BlackJackPlayer;
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
    BlackJackPlayer player = new BlackJackPlayer(null, null);

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

    @Test
    public void testDealACardToThePlayerAndPrintTheirNewHand(){
        //Given
        this.playerHand = blackJack.getPlayerHand();
        this.dealerHand = blackJack.getDealerHand();
        dealerHand.addACard(cardDeck.dealCard());
        dealerHand.addACard(cardDeck.dealCard());
        playerHand.addACard(cardDeck.dealCard());
        playerHand.addACard(cardDeck.dealCard());

        StringBuilder sb = new StringBuilder();

        sb.append("Your current cards");
        sb.append(playerHand.toString() + "\n");
        sb.append("Your current hand value: ");
        sb.append(playerHand.getSumOfHand().toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealACardToThePlayerAndPrintTheirNewHand();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerLostHandWithValueLargerThan21(){
        //Given
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(100));
        StringBuilder sb = new StringBuilder();

        sb.append("You lost this hand!" + "\n");
        sb.append("You lost: " + blackJack.getPot() + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance().intValue() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.playerLostHandWithValueLargerThan21();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGotBlackJack(){
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(100));
        StringBuilder sb = new StringBuilder();

        sb.append("BLACKJACK!" + "\n");
        sb.append("You win your bet back plus double of the pot: " + (blackJack.getPot() * 3) + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance().intValue() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.playerGotBlackJack();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintDealersFullHand(){
        this.dealerHand = blackJack.getDealerHand();
        dealerHand.addACard(cardDeck.dealCard());
        dealerHand.addACard(cardDeck.dealCard());

        StringBuilder sb = new StringBuilder();

        sb.append("The dealer shows all cards: ");
        sb.append(dealerHand.toString() + "\n");
        sb.append("The dealers hand value is: ");
        sb.append(dealerHand.getSumOfHand().toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.printDealersFullHand();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerDrawsACardAddsItToHisHandAndPrintDealerHand(){
        this.dealerHand = blackJack.getDealerHand();
        dealerHand.addACard(cardDeck.dealCard());

        StringBuilder sb = new StringBuilder();

        sb.append("The dealer hits" + "\n");
        sb.append("The dealers hand is now: ");
        sb.append(dealerHand.toString() + "\n");
        sb.append("The dealers hand value is now: ");
        sb.append(dealerHand.getSumOfHand().toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerDrawsACardAddsItToHisHandAndPrintDealerHand();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerGotBlackJack(){
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(100));
        StringBuilder sb = new StringBuilder();

        sb.append("You lost this hand! The dealer has BlackJack!" + "\n");
        sb.append("You lost: " + blackJack.getPot() + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerGotBlackJack();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerBust(){
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(100));
        StringBuilder sb = new StringBuilder();

        sb.append("You Win! The Dealer Bust!" + "\n");
        sb.append("You collect double of the pot: " + (blackJack.getPot() * 2) + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance().intValue() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerBust();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }
}