package io.zipcoder.casino.Games;


import io.zipcoder.casino.Banners;

public class Craps extends DiceGames implements GamblingGame {
    private io.zipcoder.casino.Person.Player crapsPlayer;

    public void play() {
        Banners banners = new Banners();
        banners.getCrapsBanner();
    }

    public void collect() {
    }

    public void payout() {
    }
}
