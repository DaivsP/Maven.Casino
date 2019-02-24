package io.zipcoder.casino.Games;


import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Banners;

public class BlackJack extends CardGames implements GamblingGame {
    private io.zipcoder.casino.Person.Player blackjackPlayer;

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getBlackjackBanner();
    }

    public void collect() {
    }

    public void payout() {
    }
}
