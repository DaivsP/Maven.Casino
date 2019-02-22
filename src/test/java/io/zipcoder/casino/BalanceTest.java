package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BalanceTest {

    @Test
    public void constructorTest(){
        // Given
        Integer expected = 0;
        Balance balance = new Balance();

        // When
        Integer actual = balance.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorWithBalanceTest(){
        // Given
        Integer expected = 500;
        Balance balance = new Balance(expected);

        // When
        Integer actual = balance.getBalance();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setBalanceTest(){
        // Given
        Integer expected = 100;
        Balance balance = new Balance();

        // When
        balance.setBalance(expected);

        // Then
        Integer actual = balance.getBalance();
        Assert.assertEquals(expected, actual);

    }



}
