package io.zipcoder.casino;
import io.zipcoder.casino.Games.Games;
import io.zipcoder.casino.Games.HighLow;
import io.zipcoder.casino.utilities.Console;


public class Casino {
    private Balance balance;
    Console console ;

    public static void main(String[] args) {
        // write your tests before you start fucking with this
        Casino casino = new Casino();
        Banners banners = new Banners();
        banners.getCasinoBanner();
        casino.gameRunner();
    }

    public Casino()
    {
        this.balance = new Balance();
        this.console = new Console(System.in, System.out);
    }

    public void pickGame(Balance balance) {

        // Call games classes directly

        Games games;
        console.println("***** Please Enter The Number Of A Game To Play *****");
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


    }

    public void gameRunner() {

       setInitialBalance();


      while(balance.getBalance() > 0){
          pickGame(balance);
          showCurrentBalance();
          String play = console.getStringInput("Would you like to play again? (Q) to quit ") ;
          if("Q".equals(play) || "q".equals(play)){
              break;
          }
      }


    }

    public void setInitialBalance(){
         this.balance.setBalance(console.getIntegerInput("How many chips would you like to buy? :"));
    }

    public void showCurrentBalance(){
        console.println("Your current chip count: " + this.balance.getBalance());
    }

    // used for UNIT testing - Should not be called outside unit testing
    public void setConsole(Console console){
        this.console = console;
    }

    public Balance getBalance(){
        return this.balance;

    }


}
