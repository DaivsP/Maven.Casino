package io.zipcoder.casino.games.diegames.craps;

import io.zipcoder.casino.Person.gambling.GamblingPlayer;
import io.zipcoder.casino.games.diegames.DicePlayer;
import io.zipcoder.casino.games.gameutilities.Balance;

public class CrapsPlayer extends DicePlayer implements GamblingPlayer {
    private Balance balance;

    public CrapsPlayer(String name, Balance balance) {
        super(name);
        this.balance = balance;
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
