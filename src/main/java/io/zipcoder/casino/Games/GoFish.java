package io.zipcoder.casino.Games;


import io.zipcoder.casino.Banners;

public class GoFish extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player goFishPlayer;

    public void play() {
        Banners banners = new Banners();
        banners.getGoFishBanner();
    }

    public void updateScore() {
    }
}
