package io.zipcoder.casino.Person;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Hand;

public class GamblingDealer extends Dealer implements GamblingPlayer {
    private Balance balance;
    private Hand hand;

    public GamblingDealer(Balance balance) {
        this.balance = balance;
    }
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }

    public void bet(Balance balance, Integer amount) {
        Balance balanceOb = getBalance();
        Integer myCurrentAmount = balanceOb.getBalance();

        myCurrentAmount -= amount;

        balanceOb.setBalance(myCurrentAmount);
    }

    public void collect(Balance balance, Integer amount){
        Balance balanceOb = getBalance();
        Integer myCurrentAmount = balanceOb.getBalance();

        myCurrentAmount += amount;

        balanceOb.setBalance(myCurrentAmount);

    }
}
