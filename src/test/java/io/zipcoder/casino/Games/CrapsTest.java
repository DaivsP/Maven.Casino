package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CrapsTest {


    Console defautConsole;

    @Before
    public void setUp() {
        defautConsole = new Console(System.in, System.out);
    }

    @Test
    public void passLineChoiceTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "p".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        String expected = "p";

        //When
        String actual = craps.passLineChoice();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passLineChoiceTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "d".getBytes();
        ByteArrayInputStream inoutString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inoutString, System.out));
        String expected = "d";

        //When
        String actual = craps.passLineChoice();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsBetTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(500);
        byte[] inputBytes = "100".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = 100;

        //When
        Integer actual = craps.crapsBet(balance);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsBetTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(500);
        byte[] inputBytes = "100".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = 400;

        //When
        craps.crapsBet(balance);
        Integer actual = balance.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetLoserTestPL() {
        //Given
        Integer pointer;
        Integer expected = 0;
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "9".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, System.out));

        //When
        pointer = craps.setPointerPL(balance, 5, 2);

        //Then
        Assert.assertEquals(expected, pointer);
    }

    @Test
    public void pointerSetWinnerTestPL() {
        //Given
        Integer expected = 105;
        Integer actual;
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);

        //When
        craps.setPointerPL(balance, 5, 7);
        actual = balance.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetNumberTestPL() {
        //Given
        Integer expected = 4;
        Integer bet = 0;
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);


        Integer actual = craps.setPointerPL(balance, 5, 4);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance();
        balance.setBalance(200);
        Integer bet = 100;
        Integer expected = 100;
        //When
        craps.crapsCollect(balance, bet);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance();
        balance.setBalance(500);
        Integer bet = 100;
        Integer expected = 700;
        //When
        craps.crapsPayout(balance, bet);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hedgeBetTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        byte[] inputBytes = "y".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer bet = 100;
        Integer expected = 200;
        //When
        Integer actual = craps.hedgeBet(balance, bet);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hedgeBetTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        byte[] inputBytes = "n".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer bet = 100;
        Integer expected = 100;
        //When
        Integer actual = craps.hedgeBet(balance, bet);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayPlayChoiceTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "y".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        //When
        boolean actual = craps.hardWayPlayChoice();
        //Then

        Assert.assertTrue(actual);

    }

    @Test
    public void hardWayPlayChoiceTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "n".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        //When
        boolean actual = craps.hardWayPlayChoice();
        //Then
        Assert.assertFalse(actual);

    }

    @Test
    public void hardWayNumberChoiceTest() {
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "4".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = 4;
        //When
        Integer actual = craps.hardWayNumberChoice();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayNumberChoiceTest2() {
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "5".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = null;
        //When
        Integer actual = craps.hardWayNumberChoice();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayWinnings() {
        //Given
        Craps craps = new Craps(defautConsole);
        Integer expected = 700;
        //When
        Integer actual = craps.hardWayWinnings(2, 2, 100, 4);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayWinnings2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Integer expected = 900;
        //When
        Integer actual = craps.hardWayWinnings(3, 3, 100, 6);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayPayoutTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        Integer winnings = 1000;
        Integer expected = 2000;
        //When
        craps.hardWayPayout(balance, winnings);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betCheckTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        String expected = "***** Bet: 50 *****\n\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.betCheck(50);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundPLTest1() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "***** You Rolled: 8\n\n***** You WIN!\n Winnings: 100\n***** Your balance is: 1200\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundPL(balance, 100, 8, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundPLTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "***** You Rolled: 2\n\nRoll Again\n\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundPL(balance, 100, 2, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundPLTest3() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "***** You Rolled: 7\n\n***** 7 OUT! Better Luck Next Time.\n***** Your balance is: 1000\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundPL(balance, 100, 7, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundDPLTest1() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "***** You Rolled: 5\nRoll Again\n\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundDPL(balance, 100, 5, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundDPLTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "***** You Rolled: 7\n***** You WIN!\n Winnings: 100\n***** Your balance is: 1200\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundDPL(balance, 100, 7, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundDPLTest3() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "***** You Rolled: 8\n***** Don't Pass Line Loses! Better Luck Next Time.\n***** Your balance is: 1000\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundDPL(balance, 100, 8, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void secondPhaseRollWithHardWayTest() {
//        //Given
//        Craps craps = new Craps(defautConsole);
//        //When
//        Integer expected = craps.secondPhaseRollWithHardWay(100, 0);
//        //then
//        Assert.assertTrue(expected >= 2 && expected <= 12);
//    }

//    @Test
//    public void anotherRoundTest(){
//        //Given
//        Craps craps = new Craps(defautConsole);
//        Balance balance = new Balance(1000);
//        byte[] inputBytes = "y".getBytes();
//        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        craps.setConsole(new Console(inputString, new PrintStream(outputStream)));
//        //When
//        craps.anotherRound(balance);
//        String expected ="";
//        String actual = outputStream.toString();
//        //then
//        Assert.assertEquals(expected, actual);
//
//    }

    @Test
    public void setPointerTestDPL() {
        //Given
        Integer expected = 4;
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);
        //When
        Integer actual = craps.setPointerDontPL(balance, 5, 4);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetWinnerTestDPL() {
        //Given
        Integer pointer;
        Balance balance = new Balance(1000);
        Craps craps = new Craps(defautConsole);
        Integer expected = 1010;
        //When
        craps.setPointerDontPL(balance, 5, 2);
        Integer actual = balance.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPointerLoserDPL() {
        //Given
        Integer pointer;
        Integer expected = 0;
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "7".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, System.out));

        //When
        pointer = craps.setPointerPL(balance, 5, 2);

        //Then
        Assert.assertEquals(expected, pointer);
    }

}