package io.zipcoder.casino;


import io.zipcoder.casino.Games.BlackJack;
import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.Games.HighLow;
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

    @Test
    public void pickGameIncorrectNumTest(){
        // Given
        Casino casino = new Casino();
        String expected = "***** Please Enter The Number Of A Game To Play *****\n(1) HighLow (2) Craps (3) BlackJack (4) Go Fish\nIncorrect game picked\n";
        byte[] inputBytes = "7".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(leaveString,new PrintStream(outputStream) ));

        // When
        casino.pickGame(new Balance(100));
       String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void pickGameLaunchedHLTest(){
        // Given
        Casino casino = new Casino();
        byte[] inputBytes = "1".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(leaveString, System.out));
        boolean result = false;

        // When
        casino.pickGame(new Balance(100));
        if(casino.getGames() instanceof HighLow)
        {
            result = true;
        }

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void pickGameLaunchedCrapTest(){
        // Given
        Casino casino = new Casino();
        byte[] inputBytes = "2".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(leaveString, System.out));
        boolean result = false;

        // When
        casino.pickGame(new Balance(100));
        if(casino.getGames() instanceof Craps)
        {
            result = true;
        }

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void pickGameLaunchedBJTest(){
        // Given
        Casino casino = new Casino();
        byte[] inputBytes = "3".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(leaveString, System.out));
        boolean result = false;

        // When
        casino.pickGame(new Balance(100));
        if(casino.getGames() instanceof BlackJack)
        {
            result = true;
        }

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void pickGameLaunchedFishTest(){
        // Given
        Casino casino = new Casino();
        byte[] inputBytes = "4".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(leaveString, System.out));
        boolean result = false;

        // When
        casino.pickGame(new Balance(100));
        if(casino.getGames() instanceof GoFish)
        {
            result = true;
        }

        // Then
        Assert.assertTrue(result);
    }


/*
    @Test
    public void pickGameInvalidInputTest(){
        // Given
        Casino casino = new Casino();
        StringBuilder sb = new StringBuilder();
        sb.append("(1) HighLow (2) Craps (3) BlackJack (4) Go Fish\n");
        sb.append("[ l ] is an invalid user input!\n");
        sb.append("Try inputting an integer value!\n");
        sb.append("(1) HighLow (2) Craps (3) BlackJack (4) Go Fish\n");
        String expected = sb.toString();
        byte[] inputBytes = "b".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);

        casino.setConsole(new Console(leaveString,new PrintStream(outputStream) ));



        // When
        casino.pickGame(new Balance(100));
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
*/


}
