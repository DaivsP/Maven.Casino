package io.zipcoder.casino;


import io.zipcoder.casino.Games.Games;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.Games.HighLow;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;

public class Casino {
    private Balance balance;

    public static void main(String[] args) {
        // write your tests before you start fucking with this
        Casino casino = new Casino();
        casino.gameRunner();
    }

    public void pickGame(Balance balance) {

        // Call games classes directly\
        Games games;
        Console console = new Console(System.in, System.out);
        Integer gamePicked = console.getIntegerInput("(1) HighLow (2) Craps (3) BlackJack (4) Go Fish" );
        switch (gamePicked){
            case 1:
                games = new HighLow();
                ((HighLow) games).play(balance);
                break;
            case 2:
                games = new HighLow();
             //  ((GoFish) games).play(balance);
                break;
            case 3:
                games = new HighLow();
             //  ((Craps) games).play(balance);
                break;
            case 4:
                games = new HighLow();
             //  ((BlackJack) games).play(balance);
                break;
            default:
                console.println("Incorrect game picked");
                break;
        }
        System.out.println(balance.getBalance());



    }

    public void gameRunner() {

      Balance balance =  new Balance();
      Console console = new Console(System.in, System.out);

      balance.setBalance(console.getIntegerInput("How many chips would you like to buy? :"));


      while(balance.getBalance() > 0){
          pickGame(balance);
          String play = console.getStringInput("Would you like to play again? (N) to quit ") ;
          if("N".equals(play) || "n".equals(play)){
              break;
          }
      }


    }

}
