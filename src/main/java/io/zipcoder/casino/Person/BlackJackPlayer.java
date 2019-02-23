package io.zipcoder.casino.Person;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Hand;

public class BlackJackPlayer extends CardPlayer implements GamblingPlayer {
    private Hand hand;
    private Balance balance;

    public BlackJackPlayer(String name, Balance balance) {
        super(name);
        this.balance = balance;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public void bet(Balance balance, Integer amount) {
        Balance balanceOb = getBalance();
        Integer myCurrentAmount = balanceOb.getBalance();

        myCurrentAmount -= amount;

        balanceOb.setBalance(myCurrentAmount);
    }

    public void collect(Balance balance, Integer amount) {
        Balance balanceOb = getBalance();
        Integer myCurrentAmount = balanceOb.getBalance();

        myCurrentAmount += amount;

        balanceOb.setBalance(myCurrentAmount);
    }
}
