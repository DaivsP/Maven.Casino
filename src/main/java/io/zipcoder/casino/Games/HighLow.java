package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;

public class HighLow extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player highLowPlayer;

    // Use funDealer

    public HighLow()
    {
    }


    public void play(Balance balance) {
        System.out.println("Playing");
        System.out.println(balance.getBalance());
        balance.setBalance(balance.getBalance()-100);

    }

    public void updateScore() {
    }
}
