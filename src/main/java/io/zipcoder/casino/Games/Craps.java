package io.zipcoder.casino.Games;
import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Die;
import io.zipcoder.casino.Person.CrapsPlayer;
import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Banners;


public class Craps extends DiceGames implements GamblingGame {
        Banners banners = new Banners();
  //      banners.getCrapsBanner();
  
    private Console console = new Console(System.in, System.out);
    private Player crapsPlayer;
    private String name;

    public void play(Balance balance) {
    Die die = new Die();
    DiceGames craps = new DiceGames();
    name = console.getStringInput("What is your name?");
    crapsPlayer = new CrapsPlayer(name, balance);

    do{





    }while(true);
    }

    public void collect() {

    }

    public void payout() {
    }
}
