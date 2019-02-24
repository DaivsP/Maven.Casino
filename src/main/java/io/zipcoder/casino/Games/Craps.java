package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Die;
import io.zipcoder.casino.Person.CrapsPlayer;
import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Banners;


public class Craps extends DiceGames implements GamblingGame {


    private DiceGames diceGames = new DiceGames();
    private Die dice = new Die();
    private Console console = new Console(System.in, System.out);
    private Player crapsPlayer;
    private String name;
    private Balance balance;

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getCrapsBanner();
        this.balance = balance;
        Integer pointer = 0;


        Die die = new Die();
        DiceGames diceGames = new DiceGames();

//        name = console.getStringInput("What is your name?");
//        crapsPlayer = new CrapsPlayer(name, balance);

        Integer passLineChoice = passLineChoice();
        Integer passLineBet = passLineBet();

        do{
            console.println("Lets Roll these things!");
            Integer roll = diceGames.tossTwoDie(diceGames, die);
            pointer = setPointer(balance, passLineBet, roll);

        }while(pointer == 0);


    }

    //Selects where the user wants to place the initial bet
    protected Integer passLineChoice() {
        Integer passLineChoice = console.getIntegerInput("***** Where do you want to place your bet:\n" +
                "***** Select (1) Pass Line \n***** Select (2) Don't Pass Line");

        return passLineChoice;
    }

    protected Integer passLineBet() {
        Integer bet = console.getIntegerInput("How much do you want to bet?");

        return bet;
    }


    protected Integer setPointer(Balance balance, Integer bet, Integer diceRoll) {
        Integer pointer = 0;
        //boolean stopCond = true;

        console.println("You Rolled: " + diceRoll);
        if (diceRoll == 7 || diceRoll == 11) {
            console.println("Nice! you won!");
            crapsPayout(balance, bet);
        } else if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12) {
            console.println("You Lose");
            //stopCond = false;
        } else {
            console.println("Pointer set to: " + diceRoll);
            pointer = diceRoll;
            //stopCond = false;
        }


        return pointer;
    }


    public void collect() {

    }

    protected void crapsPayout(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() + amount);
    }

    public void payout() {

    }


    //Used for unit Testing
    public void setConsole(Console console) {
        this.console = console;
    }

//    public static void main(String[] args) {
//        Balance balance =  new Balance();
//        Integer bet = 0;
//        Craps craps  = new Craps();
//
//       craps.setPointer(balance,bet);
//
//    }


}
