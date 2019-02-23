package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunDealerTest {

    @Test
    public void getHand() {
    }

    @Test
    public void setHand() {
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
    public void setScore() {
        //given
        FunDealer gamer = new FunDealer(15);
        Integer newScore = 60;
        //when
        gamer.setScore(newScore);
        //then
        Assert.assertEquals(gamer.getScore(), newScore);
    }
}