package io.zipcoder.casino.Games;
import io.zipcoder.casino.Banners;
import io.zipcoder.casino.Person.GoFishPlayer;
import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.utilities.Console;

public class GoFish extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player goFishPlayer;
    Console console ;

    public void play() {
        Banners banners = new Banners();
        banners.getGoFishBanner();
        String start = console.getStringInput("Welcome to the Go Fish table. (D) to draw a hand.");
        if (start.equals("D") || start.equals("d")){

        }
    }



    public void makeBook(){

    }

    public void updateScore() {
    }
}
