package io.zipcoder.casino;


import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.bannerutilities.Banners;
import io.zipcoder.casino.games.gameutilities.Console;
import io.zipcoder.casino.games.gameutilities.GameEnum;
import io.zipcoder.casino.games.interfaceutilities.GameInterface;

public class Casino {
    private Balance balance;
    private static Console console  = new Console(System.in, System.out);
    GameInterface gameInterface;


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

        console.println("***** Please Enter The Name Of A Game To Play *****");

        String continueString = "";
        while(!"QUIT".equals(continueString.toUpperCase())){

            String userInput = console.getStringInput("HighLow  / Craps / BlackJack / GoFish" );
            GameEnum enumeration = GameEnum.getValueOf(userInput);

            gameInterface = enumeration.create(console);
            gameInterface.play(balance);
            continueString = console.getStringInput("'Quit' to exit the game lobby and back to the casino, Any key to play again");
        }


    }

    public void gameRunner() {

       gamblerSetInitialBal();

      while(balance.getBalance() >= 0){
          pickGame(balance);
          showCurrentBalance();
          String play = console.getStringInput("Would you like to play again? \n(Q) to Exit the Casino / (A)ny key to Enter the Game Lobby / (B)uy more chips : ") ;

          if("Q".equals(play.toUpperCase())){
              break;
          }

          if("B".equals(play.toUpperCase())) {
              balance.addMoreChips();
          }
      }
    }

    public void gamblerSetInitialBal(){
        String gambling =   console.getStringInput("Would you like to buy chips ? (Y/N) ") ;
        if("Y".equals(gambling.toUpperCase())){
            setInitialBalance();
        }
    }

    public void setInitialBalance(){
         this.balance.setBalance(console.getIntegerInput("How many chips would you like to buy? :"));
    }

    public void showCurrentBalance(){
        console.println("Your current chip count: " + this.balance.getBalance());
    }


    public Balance getBalance(){
        return this.balance;
    }

    // Below this lines methods are used for testing
    // used for UNIT testing - Should not be called outside unit testing
    public void setConsole(Console console){
        this.console = console;
    }

}
