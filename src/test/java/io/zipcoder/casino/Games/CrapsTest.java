package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

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
    public void pointerSetLoserTest() {
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
    public void pointerSetWinnerTest() {
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
    public void pointerSetNumberTest() {
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
        Integer actual = craps.hardWayWinnings( 2, 2, 100, 4);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayWinnings2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Integer expected = 900;
        //When
        Integer actual = craps.hardWayWinnings(3,3, 100, 6);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayPayoutTest(){
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

//    @Test
//    public void betCheckTest(){
//        //Given
//        Craps craps = new Craps(defautConsole);
//        String expected = "***** Bet: 50 *****\n";
//        //When
//        String actual = craps.betCheck(50);
//        //then
//        Assert.assertEquals(expected, );
//    }
}