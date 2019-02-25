package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Die;
import io.zipcoder.casino.Person.CrapsPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class CrapsTest {

    Console defautConsole;

    @Before
    public void setUp(){
        defautConsole = new Console(System.in, System.out);
    }

    @Test
    public void passLineChoiceTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "p".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
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
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
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
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
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
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
        Integer expected = 400;

        //When
        craps.crapsBet(balance);
        Integer actual = balance.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetTest() {
        //Given
        Integer pointer;
        Integer bet = 0;
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        DiceGames diceGames = new DiceGames();
        Die die = new Die();

        //When
        do {
            Integer roll = diceGames.tossTwoDie(diceGames, die);
            pointer = craps.setPointerPL(balance, bet, roll);

        } while (pointer == 0);

        //Then
        Assert.assertTrue(pointer == 4 || pointer == 5 || pointer == 6
                || pointer == 8 || pointer == 9 || pointer == 10);
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


}