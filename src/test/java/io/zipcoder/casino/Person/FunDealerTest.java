package io.zipcoder.casino.Person;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Hand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunDealerTest {

    @Test
    public void getHandTest() {
        //given
        Integer score = 500;
        FunDealer dealer = new FunDealer(score);
        Hand hand = new Hand();
        //when
        dealer.setHand(hand);
        // then
        Assert.assertEquals(hand, dealer.getHand());
    }

    @Test
    public void setHandTest() {
        //given
        Integer score = 500;
        FunDealer dealer = new FunDealer(score);
        Hand hand = new Hand();
        //when
        dealer.setHand(hand);
        Hand expected = dealer.getHand();
        // then
        Assert.assertEquals(hand, expected);
    }

    @Test
    public void getScoreTest() {
        //given
        Integer score = 5;
        FunDealer gamer = new FunDealer( 5);
        //when
        Integer actual = gamer.getScore();
        Integer expected = score;
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setScoreTest() {
        //given
        FunDealer gamer = new FunDealer(15);
        Integer newScore = 60;
        //when
        gamer.setScore(newScore);
        //then
        Assert.assertEquals(gamer.getScore(), newScore);
    }
}