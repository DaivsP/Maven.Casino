package io.zipcoder.casino.Person;

import io.zipcoder.casino.games.cardgames.highlow.HiLowPlayer;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HiLowPlayerTest {

    @Test
    public void getHand() {
        //given
        Integer score = 500;
        HiLowPlayer hiloForLyfe = new HiLowPlayer("hiloForLyfe", score);
        Hand hand = new Hand();
        //when
        hiloForLyfe.setHand(hand);
        // then
        assertEquals(hand, hiloForLyfe.getHand());

    }

    @Test
    public void setHand() {
        // given
        Integer score = 500;
        HiLowPlayer hiloForLyfe = new HiLowPlayer("hiloForLyfe", score);
        Hand hand = new Hand();
        // when
        hiloForLyfe.setHand(hand);
        Hand expected = hiloForLyfe.getHand();
        // then
        assertEquals(hand, expected);
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