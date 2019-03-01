package io.zipcoder.casino;


import io.zipcoder.casino.games.cardgames.blackjack.BlackJack;
import io.zipcoder.casino.games.diegames.craps.Craps;
import io.zipcoder.casino.games.cardgames.gofish.GoFish;
import io.zipcoder.casino.games.cardgames.highlow.HighLow;
import io.zipcoder.casino.games.gameutilities.Balance;
import org.junit.Assert;
import org.junit.Test;

import io.zipcoder.casino.games.gameutilities.Console;

import java.io.*;

public class CasinoTest {

    @Test
    public void runnerOpenCloseTest() {
        // Given
        Casino casino = new Casino();

        StringBuilder sb = new StringBuilder();

        sb.append("Would you like to buy chips ? (Y/N) \n");
        sb.append("***** Please Enter The Name Of A Game To Play *****\n");
        sb.append("HighLow  / Craps / BlackJack / GoFish\n");
        sb.append("You selected an invalid game\n");
        sb.append("'Quit' to exit the game lobby and back to the casino, Any key to play again\n");
        sb.append("Your current chip count: 0\n");
        sb.append("Would you like to play again? \n");
        sb.append("(Q) to Exit the Casino / (A)ny key to Enter the Game Lobby / (B)uy more chips : \n");
        String expected = sb.toString();


        byte[] inputBytes = "n\r5\rquit\rq".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(inputStream,new PrintStream(outputStream) ));

        // When
        casino.gameRunner();
        String actual = outputStream.toString() ;


        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void runnerBuyMoreChipTest() {
        // Given
        Casino casino = new Casino();
        Integer expected = 5;
        // prep input for casino
        byte[] inputBytes = "n\rq\rquit\rb\rq\rquit\rq".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        // prep input for wallet (balance)
        byte[] inputBytes2 = "5".getBytes();
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(inputBytes2);

        casino.setConsole(new Console(inputStream, System.out));
        Balance balance = casino.getBalance();
        balance.setConsole(new Console(inputStream2, System.out));

        // When
        casino.gameRunner();
        Integer actual = casino.getBalance().getBalance();

        // Then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void gamblerSetInitialBalYesConditionTest(){
        // Given
        Casino casino = new Casino();

        Integer expected = 5;

        byte[] inputBytes = "y\r5".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(inputStream,new PrintStream(outputStream) ));

        // When
        casino.gamblerSetInitialBal();
        Balance balance = casino.getBalance();
        Integer actual = balance.getBalance();

        // Then
        Assert.assertEquals(expected, actual);

    }


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
    public void pickGameLaunchedHLTest(){
        // Given
        Casino casino = new Casino();

        byte[] inputBytes = "HIGHLOW\rE\rQUIT".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(leaveString, System.out));
        boolean result = false;

        // When
        casino.pickGame(new Balance(100));
        if(casino.gameInterface instanceof HighLow)
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

        byte[] inputBytes = "GOFISH\rE\rQUIT\r".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        casino.setConsole(new Console(inputStream, System.out));
        boolean result = false;

        // When
        casino.pickGame(new Balance(100));
        if(casino.gameInterface instanceof GoFish)
        {
            result = true;
        }

        // Then
        Assert.assertTrue(result);
    }

       // @Test
        public void gpickGameLaunchedCrapTest(){
            // Given
            Casino casino = new Casino();
            byte[] inputBytes = "CRAPS\rE\rQUIT".getBytes();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
            casino.setConsole(new Console(inputStream, System.out));
            boolean result = false;

            // When
            casino.pickGame(new Balance(100));
            if(casino.gameInterface instanceof Craps) {
                result = true;
            }
            // Then
            Assert.assertTrue(result);
        }

        @Test
        public void pickGameLaunchedBJTest(){
            // Given
            Casino casino = new Casino();
            byte[] inputBytes = "blackjack\rno\r9\rs\nn\nquit".getBytes();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
            casino.setConsole(new Console(inputStream, System.out));
            boolean result = false;

            // When
            casino.pickGame(new Balance(100));
            if(casino.gameInterface instanceof BlackJack)
            {
                result = true;
            }

            // Then
            Assert.assertTrue(result);
        }



    @Test
    public void pickGameInvalidInputTest(){
        // Given
        Casino casino = new Casino();
        StringBuilder sb = new StringBuilder();
        sb.append("***** Please Enter The Name Of A Game To Play *****\n");
        sb.append("HighLow  / Craps / BlackJack / GoFish\n");
        sb.append("You selected an invalid game\n");
        sb.append("'Quit' to exit the game lobby and back to the casino, Any key to play again\n");
        String expected = sb.toString();
        byte[] inputBytes = "b\rQUIT".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);

        casino.setConsole(new Console(inputStream,new PrintStream(outputStream) ));

        // When
        casino.pickGame(new Balance(100));
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }



}
