package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Die;
import io.zipcoder.casino.Person.CrapsPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class CrapsTest {

    @Test
    public void passLineChoiceTest(){
        //Given
        Craps craps = new Craps();
        byte[] inputBytes = "1".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
        Integer expected = 1;

        //When
        Integer actual = craps.passLineChoice();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passLineChoiceTest2(){
        //Given
        Craps craps = new Craps();
        byte[] inputBytes = "2".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
        Integer expected = 2;

        //When
        Integer actual = craps.passLineChoice();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsBetTest(){
        //Given
        Craps craps = new Craps();
        byte[] inputBytes = "100".getBytes();
        ByteArrayInputStream leaveString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(leaveString, System.out));
        Integer expected = 100;

        //When
        Integer actual = craps.crapsBet();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetTest(){
        //Given
        Integer pointer;
        Integer bet = 0;
        Balance balance = new Balance();
        //CrapsPlayer player = new CrapsPlayer("Bubba", balance);
        Craps craps = new Craps();
        DiceGames diceGames = new DiceGames();
        Die die = new Die();

        //When
        do{
            Integer roll = diceGames.tossTwoDie(diceGames, die);
           pointer = craps.setPointer(balance, bet, roll);

        }while(pointer == 0);

        //Then
        Assert.assertTrue(pointer == 4 || pointer == 5 || pointer == 6
        || pointer == 8 || pointer == 9 || pointer == 10);


    }

    @Test
    public void collectTest(){
        //Given
        Craps craps = new Craps();
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
    public void payoutTest(){
        //Given
        Craps craps = new Craps();
        Balance balance = new Balance();
        balance.setBalance(500);
        Integer bet = 100;
        Integer expected = 600;
        //When
        craps.crapsPayout(balance, bet);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);

    }





}