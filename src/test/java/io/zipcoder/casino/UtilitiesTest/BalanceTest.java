package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

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


    @Test
    public void addMoreChips(){
        // Given
        Balance balance = new Balance();
        balance.setBalance(100);

        Integer expected = 200;
        balance.setConsole(getConsoleInputConsole("100"));

        // When
        balance.addMoreChips();
        Integer actual = balance.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    // set up - input stream
    private Console getConsoleInputConsole(String inputString) {
        byte[] inputBytes = inputString.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(inputByteArray , System.out);
        return console;

    }


}
