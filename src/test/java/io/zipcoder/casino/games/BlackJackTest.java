package io.zipcoder.casino.games;

import io.zipcoder.casino.games.cardgames.blackjack.BlackJack;
import io.zipcoder.casino.games.cardgames.blackjack.BlackJackPlayer;
import io.zipcoder.casino.Person.gambling.GamblingDealer;
import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.games.cardgames.cardutilities.CardDeck;
import io.zipcoder.casino.games.cardgames.cardutilities.DecorationCards;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BlackJackTest {

    BlackJack blackJack = new BlackJack(new Console(System.in, System.out));
    CardDeck cardDeck = new CardDeck();
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();
    BlackJackPlayer player = new BlackJackPlayer(null, null);
    GamblingDealer dealer = new GamblingDealer(blackJack.getDealer().getBalance());
    DecorationCards decorationCards = new DecorationCards();

    @Before
    public void setup(){
        blackJack.clearHands(dealerHand, playerHand);
        cardDeck.shuffle();
    }

    @Test
    public void testConstructor(){
        //Given

        //When

        //Then
        Assert.assertNotNull(cardDeck);
        Assert.assertNotNull(player);
        Assert.assertNotNull(dealer);
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
        this.playerHand = blackJack.getPlayerHand();
        this.dealerHand = blackJack.getDealerHand();
        blackJack.dealCardsToPlayerAndDealerAndAddThemToRespectiveHands();

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

        sb.append("Your current cards: " + "\n" + "\n");
        sb.append("Your current hand value: " + playerHand.getSumOfHand() + "\n");
        sb.append("The Dealers first card: " + dealerHand.getACard(0).toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in,new PrintStream(outputStream)));

        decorationCards.setConsole(new Console(System.in,System.out));

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

        sb.append("Your current cards" + "\n" + "\n");
        sb.append("Your current hand value: ");
        sb.append(playerHand.getSumOfHand().toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        decorationCards.setConsole(new Console(System.in, System.out));

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

        sb.append("The dealer shows all cards: " + "\n" + "\n");
        sb.append("The dealers hand value is: ");
        sb.append(dealerHand.getSumOfHand().toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        decorationCards.setConsole(new Console(System.in, System.out));

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
        sb.append("The dealers hand is now: " + "\n" + "\n");
        sb.append("The dealers hand value is now: ");
        sb.append(dealerHand.getSumOfHand().toString() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        decorationCards.setConsole(new Console(System.in, System.out));

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

    @Test
    public void testDealerHandBeatsPlayerHand(){
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(100));
        StringBuilder sb = new StringBuilder();

        sb.append("The Dealer Stays" + "\n");
        sb.append("You lost this hand! The Dealers hand is larger than yours!" + "\n");
        sb.append("You lost: " + blackJack.getPot() + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerHandBeatsPlayerHand();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerHandAndDealerHandIsADraw(){
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(100));
        StringBuilder sb = new StringBuilder();

        sb.append("Its a draw!" + "\n");
        sb.append("You get your bet back" + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.playerHandAndDealerHandIsADraw();
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerPlayActions1(){
        this.player = blackJack.getPlayer();
        this.dealerHand = blackJack.getDealerHand();
        this.playerHand = blackJack.getPlayerHand();
        player.setBalance(new Balance(100));

        Card dealerCard = new Card(Card.Rank.ACE, Card.Suit.HEARTS, 11);
        Card dealerCard2 = new Card(Card.Rank.KING, Card.Suit.HEARTS, 10);
        dealerHand.addACard(dealerCard);
        dealerHand.addACard(dealerCard2);

        Card playerCard = new Card(Card.Rank.TWO, Card.Suit.HEARTS, 2);
        Card playerCard2 = new Card(Card.Rank.FIVE, Card.Suit.HEARTS, 5);
        playerHand.addACard(playerCard);
        playerHand.addACard(playerCard2);

        StringBuilder sb = new StringBuilder();

        sb.append("You lost this hand! The dealer has BlackJack!" + "\n");
        sb.append("You lost: " + blackJack.getPot() + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerPlayActions(player.getBalance());
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerPlayActions2(){
        this.player = blackJack.getPlayer();
        this.dealerHand = blackJack.getDealerHand();
        this.playerHand = blackJack.getPlayerHand();
        player.setBalance(new Balance(100));

        Card dealerCard = new Card(Card.Rank.KING, Card.Suit.HEARTS, 10);
        Card dealerCard2 = new Card(Card.Rank.KING, Card.Suit.HEARTS, 10);
        Card dealerCard3 = new Card(Card.Rank.FIVE, Card.Suit.HEARTS, 5);
        dealerHand.addACard(dealerCard);
        dealerHand.addACard(dealerCard2);
        dealerHand.addACard(dealerCard3);

        playerHand.addACard(cardDeck.dealCard());
        playerHand.addACard(cardDeck.dealCard());

        StringBuilder sb = new StringBuilder();

        sb.append("You Win! The Dealer Bust!" + "\n");
        sb.append("You collect double of the pot: " + blackJack.getPot() * 2 + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerPlayActions(player.getBalance());
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerPlayActions3(){
        this.player = blackJack.getPlayer();
        this.dealerHand = blackJack.getDealerHand();
        this.playerHand = blackJack.getPlayerHand();
        player.setBalance(new Balance(100));

        Card dealerCard = new Card(Card.Rank.KING, Card.Suit.HEARTS, 10);
        Card dealerCard2 = new Card(Card.Rank.KING, Card.Suit.DIAMONDS, 10);
        dealerHand.addACard(dealerCard);
        dealerHand.addACard(dealerCard2);

        Card playerCard = new Card(Card.Rank.FIVE, Card.Suit.HEARTS, 5);
        Card playerCard2 = new Card(Card.Rank.TEN, Card.Suit.HEARTS, 10);
        playerHand.addACard(playerCard);
        playerHand.addACard(playerCard2);

        StringBuilder sb = new StringBuilder();
        sb.append("The Dealer Stays" + "\n");
        sb.append("You lost this hand! The Dealers hand is larger than yours!" + "\n");
        sb.append("You lost: " + blackJack.getPot() + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerPlayActions(player.getBalance());
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerPlayActions4(){
        this.player = blackJack.getPlayer();
        this.dealerHand = blackJack.getDealerHand();
        this.playerHand = blackJack.getPlayerHand();
        player.setBalance(new Balance(100));

        Card dealerCard = new Card(Card.Rank.KING, Card.Suit.HEARTS, 10);
        Card dealerCard2 = new Card(Card.Rank.KING, Card.Suit.DIAMONDS, 10);
        dealerHand.addACard(dealerCard);
        dealerHand.addACard(dealerCard2);

        Card playerCard = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS, 10);
        Card playerCard2 = new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS, 10);
        playerHand.addACard(playerCard);
        playerHand.addACard(playerCard2);

        StringBuilder sb = new StringBuilder();

        sb.append("Its a draw!" + "\n");
        sb.append("You get your bet back" + "\n");
        sb.append("Your new balance is: " + player.getBalance().getBalance() + "\n");
        String expected = sb.toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blackJack.setConsole(new Console(System.in, new PrintStream(outputStream)));

        //When
        blackJack.dealerPlayActions(player.getBalance());
        String actual = outputStream.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerHasAPositiveBalance(){
        //Given
        this.player = blackJack.getPlayer();
        player.setBalance(new Balance(1));

        //When

        //Then
        Boolean actual = blackJack.playerHasAPositiveBalance();
        Assert.assertTrue(actual);
    }

    @Test
    public void testPlayerActionIfHit(){
        //Given
        this.playerHand = blackJack.getPlayerHand();

        //When
        blackJack.playerActionIfHit();
        Integer actual = playerHand.getNumberOfCards();

        //Then
        Integer expected = 1;
        Assert.assertEquals(expected, actual);
    }
}