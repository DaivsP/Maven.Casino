package io.zipcoder.casino.Person;

import io.zipcoder.casino.Person.gambling.GamblingDealer;
import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GamblingDealerTest {

    @Test
    public void setBalanceTest() {

        //given
        Balance balance = new Balance(500);

        Balance newBalance = new Balance(1000);

        GamblingDealer dealer = new GamblingDealer(balance);

        //when

        dealer.setBalance(newBalance);
        //then
        Assert.assertEquals(dealer.getBalance(), newBalance);
    }

    @Test
    public void getBalanceTest() {
        Balance balance = new Balance(500);

        GamblingDealer dealer = new GamblingDealer(balance);

        Assert.assertEquals(dealer.getBalance(), balance);
    }

    @Test
    public void betTest() {
        //given
        Balance balance = new Balance(500);
        GamblingDealer dealer = new GamblingDealer(balance);
        Integer betAmount = new Integer(100);
        Integer expected = 400;
        //when
        dealer.bet(balance, betAmount);
        Balance actual = dealer.getBalance();

        //then
        Assert.assertEquals(expected, actual.getBalance());
    }

    @Test
    public void collectTest() {
        //given
        Balance balance = new Balance(500);
        GamblingDealer dealer = new GamblingDealer(balance);
        Integer betAmount = new Integer(100);
        Integer expected = 600;
        //when
        dealer.collect(balance, betAmount);
        Balance actual = dealer.getBalance();
        //then
        Assert.assertEquals(expected, actual.getBalance());
    }

    @Test
    public void getHandTest() {
        //given
        Balance balance = new Balance(500);
        GamblingDealer dealer = new GamblingDealer(balance);
        Hand hand = new Hand();
        //when
        dealer.setHand(hand);
        // then
        assertEquals(hand, dealer.getHand());

    }

    @Test
    public void setHandTest() {

        //given
        Balance balance = new Balance(500);
        GamblingDealer dealer = new GamblingDealer(balance);
        Hand hand = new Hand();
        //when
        dealer.setHand(hand);
        Hand expected = dealer.getHand();
        // then
        assertEquals(hand, expected);
    }
}