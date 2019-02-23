package io.zipcoder.casino.Person;

import io.zipcoder.casino.Balance;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackPlayerTest {

    @Test
    public void getHand() {
    }

    @Test
    public void setHand() {
    }
    @Test
    public void getBalanceTest() {
        Balance balance = new Balance(500);

        BlackJackPlayer guy = new BlackJackPlayer("guy", balance);

        Assert.assertEquals(guy.getBalance(), balance);

    }

    @Test
    public void setBalanceTest() {
        Balance balance = new Balance(500);

        Balance newBalance = new Balance(1000);

        CrapsPlayer guy = new CrapsPlayer("guy", balance);

        guy.setBalance(newBalance);

        Assert.assertEquals(guy.getBalance(), newBalance);
    }

    @Test
    public void betTest() {

        //given
        Balance balance = new Balance(500);
        BlackJackPlayer guy = new BlackJackPlayer("guy", balance);
        Integer betAmount = new Integer(100);
        Integer expected = 400;
        //when
        guy.bet(balance, betAmount);
        Balance actual = guy.getBalance();

        //then
        Assert.assertEquals(expected, actual.getBalance());
    }

    @Test
    public void collectTest() {
        //given
        Balance balance = new Balance(500);
        BlackJackPlayer guy = new BlackJackPlayer("guy", balance);
        Integer betAmount = new Integer(100);
        Integer expected = 600;
        //when
        guy.collect(balance, betAmount);
        Balance actual = guy.getBalance();
        //then
        Assert.assertEquals(expected, actual.getBalance());
    }
}