package io.zipcoder.casino.Person;

import io.zipcoder.casino.games.cardgames.gofish.GoFishPlayer;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

    @Test
    public void getHandTest() {
        //given
        Integer score = 500;

        GoFishPlayer bestGuesser = new GoFishPlayer("best guesser", score);
        Hand hand = new Hand();
        //when
        bestGuesser.setHand(hand);
        // then
        assertEquals(hand, bestGuesser.getHand());
    }

    @Test
    public void setHandTest() {
        //given
        Integer score = 500;

        GoFishPlayer bestGuesser = new GoFishPlayer("best guesser", score);
        Hand hand = new Hand();
        //when
        bestGuesser.setHand(hand);
        Hand expected = bestGuesser.getHand();
        // then
        assertEquals(hand, expected);
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