package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

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
        GoFishPlayer gamer = new GoFishPlayer("fishy gamer", 5);
        //when
        Integer actual = gamer.getScore();
        Integer expected = score;
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setScoreTest() {
        //given
        GoFishPlayer gamer = new GoFishPlayer("fishiest gamer", 15);
        Integer newScore = 60;
        //when
        gamer.setScore(newScore);
        //then
        Assert.assertEquals(gamer.getScore(), newScore);
    }
}