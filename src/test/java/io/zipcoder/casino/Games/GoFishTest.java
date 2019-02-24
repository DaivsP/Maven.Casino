package io.zipcoder.casino.Games;

import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Person.CardPlayer;
import io.zipcoder.casino.Person.FunDealer;
import io.zipcoder.casino.Person.GoFishPlayer;
import io.zipcoder.casino.Person.HiLowPlayer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {

    @Test
    public void constructorTest(){
        // Given

        // When
        GoFish goFish = new GoFish();
        CardDeck cardDeck = goFish.getCardDeck();
        FunDealer dealer = goFish.getDealer();
        GoFishPlayer player = goFish.getPlayer();

        // Then
        Assert.assertNotNull(cardDeck);
        Assert.assertNotNull(dealer);
        Assert.assertNotNull(player);
    }

    @Test
    public void play() {
        //given

        //when

        //then
    }

    @Test
    public void playerGuessACard() {
        //given

        //when

        //then
    }

    @Test
    public void dealerGuessACard() {
        //given

        //when

        //then
    }

    @Test
    public void goFish() {
        //given

        //when

        //then
    }

    @Test
    public void makeBook() {
        //given

        //when

        //then
    }


    @Test
    public void winner() {
        //given

        //when

        //then
    }

    @Test
    public void looser() {
        //given

        //when

        //then
    }

    @Test
    public void drawFirstHAnd() {
        //given

        //when

        //then
    }

    @Test
    public void equals() {
        //given

        //when

        //then
    }

    @Test
    public void isABook() {
        //given

        //when

        //then
    }

    @Test
    public void printHand() {
        //given

        //when

        //then
    }

    @Test
    public void addOneToScoreTest() {

//        //given
//        Integer score = 10;
//        CardPlayer mike = new CardPlayer("mike", score);
//
//        //when
//        (mike);
//        //then
//        Assert.assertEquals(mike.getScore(), 11);
    }
}