package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.Test;

import io.zipcoder.casino.utilities.Console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CasinoTest {


    @Test
    public void setInitialBalanceTest(){
        // Given
        Casino casino = new Casino();
        Integer expected = 1000;
        casino.setConsole(getConsoleWithBuffetedInput("1000"));

        // When
        casino.setInitialBalance();
        Balance balance = casino.getBalance();
        Integer actual = balance.getBalance();

        // Then
        //System.out.println(balance.getBalance());
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void showBalanceTest(){
        // Given
        Casino casino = new Casino();
        String expected = "Your current chip count: 0\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        casino.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        casino.showCurrentBalance();
        String actual = outputStream.toString() ;

        // Then
        Assert.assertEquals(expected, actual);

    }

    // set up - input stream
    private Console getConsoleWithBuffetedInput(String inputString) {
        byte[] inputBytes = inputString.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(inputByteArray , System.out);
        return console;

    }
/*
    @Test
    public void pickGameExit(){
        // Given
        Casino casino = new Casino();
        String expected = "(1) HighLow (2) Craps (3) BlackJack (4) Go Fish\nIncorrect game picked";
        casino.setConsole(getConsoleWithBuffetedInput("Leave"));

        // When

        Balance balance = casino.getBalance();
        casino.pickGame(balance);
     //   String actual = outputStream.toString() ;

        // Then
        //System.out.println(balance.getBalance());
     //   Assert.assertEquals(expected, actual);

    }
    */


}
