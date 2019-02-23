package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HiLowPlayerTest {

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
        HiLowPlayer gamer = new HiLowPlayer("hardcore gamer", score);
        //when

        //then
        Assert.assertEquals(gamer.getScore(), score);
    }

    @Test
    public void setScoreTest() {
        //given
        HiLowPlayer gamer = new HiLowPlayer("hardcorer gamerer", 15);
        Integer newScore = 60;
        //when
        gamer.setScore(newScore);
        //then
        Assert.assertEquals(gamer.getScore(), newScore);
    }
}