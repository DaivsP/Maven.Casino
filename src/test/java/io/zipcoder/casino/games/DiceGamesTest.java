package io.zipcoder.casino.games;

import io.zipcoder.casino.games.diegames.DiceGames;
import io.zipcoder.casino.games.diegames.dieutilities.Die;
import org.junit.Assert;
import org.junit.Test;

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
        Integer expected = 5;
        //When
        Integer actual = game.toss(dice, 2);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tossTest3(){
        //Given
        DiceGames game = new DiceGames();
        Die dice = new Die(2);
        //When
        Integer actual = game.toss(dice, null);
        System.out.println(actual);
        //then
        Assert.assertTrue(actual >= 2 && actual <= 12);
    }

    @Test
    public void tossTest4(){
        //Given
        DiceGames game = new DiceGames();
        Die dice = new Die(4);
        //When
        Integer actual = game.toss(dice, null);
        //then
        Assert.assertTrue(actual >= 4 && actual <= 24);
    }

    @Test
    public void tossTwoTest(){
        //Given
        DiceGames game = new DiceGames();
        Die die = new Die();
        //When
        Integer actual = game.tossTwoDie(game, die);
        //Then
        Assert.assertTrue(actual >= 2 && actual <= 12);
    }
}