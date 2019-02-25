package io.zipcoder.casino.Games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.CardPlayer;
import io.zipcoder.casino.Person.FunDealer;
import io.zipcoder.casino.Person.GoFishPlayer;
import io.zipcoder.casino.Person.HiLowPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        player = new GoFishPlayer(null, 0);
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
       // Assert.assertEquals(player.getHand().getNumberOfCards(),expected);
    }
}