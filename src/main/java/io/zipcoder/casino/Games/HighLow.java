package io.zipcoder.casino.Games;
import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Banners;


public class HighLow extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player highLowPlayer;

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getHighLowBanner();
        System.out.println("Playing");
        System.out.println(balance.getBalance());
        balance.setBalance(balance.getBalance()-100);

    }

    public void updateScore() {
    }
}
