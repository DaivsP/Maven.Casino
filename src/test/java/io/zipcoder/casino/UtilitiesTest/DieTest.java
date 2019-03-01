package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.diegames.dieutilities.Die;
import org.junit.Assert;
import org.junit.Test;

public class DieTest {

    @Test
    public void defaultConstructorTest(){
        //Given
        Die dice = new Die();
        int expectedTotal  = 6;
        int expectedNumOfDie = 1;
        //When
        int actualTotal = dice.getDiceValue();
        int actualNumOfDie = dice.getDiceNum();
        //Then
        Assert.assertEquals(expectedNumOfDie, actualNumOfDie);
        Assert.assertEquals(expectedTotal,actualTotal);
    }

    @Test
    public void constructorTest(){
        //Given
        Die dice = new Die(2);
        int expectedTotal = 12;
        int expectedNumOfDie = 2;
        //When
        int actualTotal = dice.getDiceValue();
        int actualNumOfDice = dice. getDiceNum();
        //Then
        Assert.assertEquals(expectedNumOfDie, actualNumOfDice);
        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @Test
    public void constructorTest2(){
        Die dice = new Die(6);
        int expectedTotal = 36;
        int expectedNumOfDie = 6;
        //When
        int actualTotal = dice.getDiceValue();
        int actualNumOfDice = dice. getDiceNum();
        //Then
        Assert.assertEquals(expectedNumOfDie, actualNumOfDice);
        Assert.assertEquals(expectedTotal, actualTotal);
    }
}