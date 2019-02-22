package io.zipcoder.casino.Games;

import io.zipcoder.casino.Die;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceGamesTest {

    @Test
    public void tossTest1(){
        //Given
        DiceGames game = new DiceGames();
        Die dice = new Die();
        Integer expected = 3;
        //When
        Integer actual = game.toss(dice, 3);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tossTest2(){
        //Given
        DiceGames game = new DiceGames();
        Die dice = new Die();
        //When
        Integer actual = game.toss(dice, 0);
        //then
        Assert.assertTrue(actual >= 2 && actual <= 12);
    }


}