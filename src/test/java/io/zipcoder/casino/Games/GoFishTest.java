package io.zipcoder.casino.Games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.DecorationCards;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.CardPlayer;
import io.zipcoder.casino.Person.FunDealer;
import io.zipcoder.casino.Person.GoFishPlayer;
import io.zipcoder.casino.Person.HiLowPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GoFishTest {

    Console defautConsole;
    private GoFishPlayer player;
    private GoFishPlayer player2;
    private CardDeck cardDeck;
    private Hand player2Hand;
    private Hand playerHand;
    private Integer books;
    private Integer score;

    @Before
    public void setUp(){
        cardDeck = new CardDeck();
        defautConsole = new Console(System.in, System.out);
        player = new GoFishPlayer("You", 9);
        player2 = new GoFishPlayer( "Dealer",1);
        playerHand = new Hand();
        player.setHand(playerHand);
        GoFish goFish = new GoFish(defautConsole);


    }

    @Test
    public void constructorTest(){
        // Given

        // When
        GoFish goFish = new GoFish(defautConsole);
        CardDeck cardDeck = goFish.getCardDeck();
        GoFishPlayer player2 = goFish.getPlayer();
        GoFishPlayer player = goFish.getPlayer();

        // Then
        Assert.assertNotNull(cardDeck);
        Assert.assertNotNull(player2);
        Assert.assertNotNull(player);
    }

    @Test
    public void removeMatchingCardsTest() {
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        Card fiveSpades = new Card(Card.Rank.FIVE, Card.Suit.SPADES, null);
        Card twoClubs = new Card(Card.Rank.TWO, Card.Suit.CLUBS, null);
        //given
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(fiveClubs);
//        cards.add(fiveSpades);
//        cards.add(twoClubs);
        playerHand.addACard(fiveClubs);
        playerHand.addACard(fiveSpades);
        playerHand.addACard(twoClubs);
        player.setHand(playerHand);
        String input = "FIVE";
        //when
        Integer expected = 1;
        goFish.removeMatchingCards(player, input);
        //then
        System.out.println(player.getHand().getNumberOfCards());
        Assert.assertEquals(player.getHand().getNumberOfCards(),expected);
    }
    @Test
    public void aIRemoveMatchingCardsTest() {
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        Card fiveSpades = new Card(Card.Rank.FIVE, Card.Suit.SPADES, null);
        Card twoClubs = new Card(Card.Rank.TWO, Card.Suit.CLUBS, null);
        //given
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(fiveClubs);
//        cards.add(fiveSpades);
//        cards.add(twoClubs);
        playerHand.addACard(fiveClubs);
        playerHand.addACard(fiveSpades);
        playerHand.addACard(twoClubs);
        player.setHand(playerHand);
        String input = "FIVE";
        //when
        Integer expected = 1;
        goFish.aIRemoveMatchingCards(player, input);
        //then
        System.out.println(player.getHand().getNumberOfCards());
        Assert.assertEquals(player.getHand().getNumberOfCards(),expected);
    }

    @Test
    public void getPlayerCardTest() {
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        playerHand.addACard(fiveClubs);

        //when
        Card expected = goFish.getPlayerCard(player,0);

        //then
        Assert.assertEquals(expected, fiveClubs);
    }

    @Test
    public void printHandTest() {
        DecorationCards dec = new DecorationCards();
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        Hand playerHand = new Hand();
        playerHand.addACard(fiveClubs);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in , new PrintStream(outputStream)));

        goFish.printHand(player);
        String actual = outputStream.toString();


        String expected = "***** Your Hand ******\n";


        System.out.println(expected);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findWinnerTest() {

        GoFish goFish = new GoFish(defautConsole);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in, new PrintStream(outputStream)));

        goFish.findWinner();
        String actual = outputStream.toString();
        String expected = "\n" +
                "You Lost. Maybe try guessing better cards next time?\n" +
                "\n" +
                "Your score: 0\n" +
                "Dealer score: 0\n";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findWinnerTest2() {

        GoFish goFish = new GoFish(defautConsole);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in, new PrintStream(outputStream)));
        goFish.getPlayer().setScore(9);
        goFish.getPlayer2().setScore(0);
        goFish.findWinner();
        String actual = outputStream.toString();
        String expected = "\n" +
                "WOW YOU WIN! YOU'RE SO GOOD AT THIS GAME!\n" +
                "\n" +
                "Your score: 9\n" +
                "Dealer score: 0\n";
        defautConsole.println(outputStream.toString());
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void winnerTest() {
        GoFish goFish = new GoFish(defautConsole);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in, new PrintStream(outputStream)));

        goFish.winner();
        String actual = outputStream.toString();
        String expected = "\n" +
                "WOW YOU WIN! YOU'RE SO GOOD AT THIS GAME!\n" +
                "\n" +
                "Your score: 0\n" +
                "Dealer score: 0\n";
        defautConsole.println(outputStream.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void loserTest() {
        GoFish goFish = new GoFish(defautConsole);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in, new PrintStream(outputStream)));

        goFish.loser();
        String actual = outputStream.toString();
        String expected = "\n" +
                "You Lost. Maybe try guessing better cards next time?\n" +
                "\n" +
                "Your score: 0\n" +
                "Dealer score: 0\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateScoreTest() {
        GoFish goFish = new GoFish(defautConsole);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in, new PrintStream(outputStream)));
        goFish.updateScore();
        int actual = goFish.getBooks();
        int expected = 1;
        defautConsole.println(outputStream.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealHandsTest() {
        DecorationCards dec = new DecorationCards();
        GoFish goFish = new GoFish(defautConsole);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in , new PrintStream(outputStream)));
        GoFishPlayer player = goFish.getPlayer();
        goFish.dealHands();
        goFish.printHand(player);
        //defautConsole.println(outputStream.toString());
        Assert.assertNotNull(outputStream);
    }

    @Test
    public void goFishTEST() {
        GoFish goFish = new GoFish(defautConsole);
        GoFishPlayer player = goFish.getPlayer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in , new PrintStream(outputStream)));
        CardDeck deck = goFish.getCardDeck();
        for(int i = 0 ; i<52; i++){
            deck.dealCard();
        }
        defautConsole.println(deck.toString());
        goFish.goFish(player);
        String actual = outputStream.toString();
        String expected = "\n" +
                "No more cards left!\n" +
                "0";
        defautConsole.println(actual);
        Assert.assertNotNull(expected, actual);


    }

    @Test
    public void checkForMatchTest() {
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        Card fiveSpades = new Card(Card.Rank.FIVE, Card.Suit.SPADES, null);
        Card twoClubs = new Card(Card.Rank.TWO, Card.Suit.CLUBS, null);
        playerHand.addACard(fiveClubs);
        playerHand.addACard(fiveSpades);
        playerHand.addACard(twoClubs);
        player.setHand(playerHand);
        String input = "FIVE";
        //when
        Boolean expected = true;
        Boolean actual = goFish.checkForMatch(player, input);
        //then
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void checkForMatchTest2() {
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        Card fiveSpades = new Card(Card.Rank.FIVE, Card.Suit.SPADES, null);
        Card twoClubs = new Card(Card.Rank.TWO, Card.Suit.CLUBS, null);
        playerHand.addACard(fiveClubs);
        playerHand.addACard(fiveSpades);
        playerHand.addACard(twoClubs);
        player.setHand(playerHand);
        String input = "SIX";
        //when
        Boolean expected = false;
        Boolean actual = goFish.checkForMatch(player, input);
        //then
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void checkForBooks() {
        GoFish goFish = new GoFish(defautConsole);
        Card fiveClubs = new Card(Card.Rank.FIVE, Card.Suit.CLUBS, null);
        Card fiveSpades = new Card(Card.Rank.FIVE, Card.Suit.SPADES, null);
        Card fiveDim = new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS, null);
        Card fiveHearts = new Card(Card.Rank.FIVE, Card.Suit.HEARTS, null);
        Card twoClubs = new Card(Card.Rank.TWO, Card.Suit.CLUBS, null);
        GoFishPlayer player = goFish.getPlayer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        goFish.setConsole(new Console(System.in , new PrintStream(outputStream)));
        Hand playerHand = new Hand();
        playerHand.addACard(fiveClubs);
        playerHand.addACard(fiveSpades);
        playerHand.addACard(fiveDim);
        playerHand.addACard(fiveHearts);
        playerHand.addACard(twoClubs);
        player.setHand(playerHand);
        //when
        goFish.checkForBooks(player, playerHand);

        String actual = outputStream.toString();
        String expected = "\n" +
                "You made a Book of FIVE's!\n" +
                "\n" +
                "You Score is now 1!\n" +
                "\n";
        //then
//        defautConsole.println(actual);
//        defautConsole.println(expected);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void otherPlayerTest() {
        GoFish goFish = new GoFish(defautConsole);
        GoFishPlayer player = goFish.getPlayer();
        GoFishPlayer player2 = goFish.getPlayer2();

        //oFish.otherPlayer(player);

        Assert.assertEquals(player2, goFish.otherPlayer(player));
    }

    @Test
    public void aILastGuessTest() {
        GoFish goFish = new GoFish(defautConsole);
        goFish.aILastGuess("FIVE");


        String actual = goFish.getLastGuess();

        Assert.assertEquals("FIVE", actual);
    }

    @Test
    public void getLastGuessTest(){
        GoFish goFish = new GoFish(defautConsole);
        String actual = goFish.getLastGuess();

        Assert.assertEquals(null, actual);
    }

    @Test
    public void aIGuessingMagic() {
    }
}

