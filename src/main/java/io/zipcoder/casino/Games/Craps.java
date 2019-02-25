package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Die;
import io.zipcoder.casino.Person.CrapsPlayer;
import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Banners;


public class Craps extends DiceGames implements GamblingGame {
    private Casino casino = new Casino();
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
        Integer passLineBet = 0;
        Die die = new Die();
        DiceGames diceGames = new DiceGames();

        Integer passLineChoice = passLineChoice();


        if (passLineChoice == 1) {
            passLineBet = crapsBet(balance);
            console.println("You bet: "+passLineBet);
            do {
                String rollRequest = console.getStringInput("***** Press (R) to Roll\n***** Press (E) to exit");

                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    Integer roll = diceGames.tossTwoDie(diceGames, die);
                    pointer = setPointerPL(balance, passLineBet, roll);
                } else {
                    break;
                }

            } while (pointer == 0);

        } else if (passLineChoice == 2) {
            passLineBet = crapsBet(balance);
            do {
                String rollRequest = console.getStringInput("***** Press (R) to Roll\n***** Press (E) to exit");

                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    Integer roll = diceGames.tossTwoDie(diceGames, die);
                    pointer = setPointerDontPL(balance, passLineBet, roll);
                } else {
                    break;
                }
            } while (pointer == 0);

        }

        Integer crapsRoll = 0;
        while (crapsRoll != pointer && crapsRoll != 7 && pointer != 0) {

            String rollRequest = console.getStringInput("ROLL A " + pointer + " TO WIN!\n***** Press (R) to Roll\n***** Press (E) to exit");
            if (rollRequest.equals("R") || rollRequest.equals("r")) {
                crapsRoll = diceGames.tossTwoDie(diceGames, die);
                crapsRoundPL(balance, passLineBet, crapsRoll, pointer);
            } else {
                break;
            }

        }

        String anotherRound = console.getStringInput("Play another round? (Y)/(N)");
        if (anotherRound.equals("Y") || anotherRound.equals("y")) {
            passLineBet = 0;
            play(balance);
        }


    }

    //Selects where the user wants to place the initial bet
    protected Integer passLineChoice() {
        Integer passLineChoice = console.getIntegerInput("***** Where do you want to place your bet:\n" +
                "***** Select (1) Pass Line \n***** Select (2) Don't Pass Line");

        return passLineChoice;
    }


    protected Integer crapsBet(Balance balance) {
        console.println("Your balance is: "+balance.getBalance());
        Integer bet = console.getIntegerInput("***** How much do you want to bet?");
        if (bet <= balance.getBalance()) {
            balance.setBalance(balance.getBalance() - bet);
            return bet;
        } else {
            console.println("You do not have that much...");
            String buyMore = console.getStringInput("Would you like to buy more? (Y) / (N)");
            if (buyMore.equals("Y") || buyMore.equals("y")) {
                balance.addMoreChips();
                Integer newBet = crapsBet(balance);
                return newBet;
            } else {
                play(balance);
            }
        }
        return 0;
    }

    //Method that is used in the player decides to bet on the Pass Line - Sets the Pointer to On and equal to the roll
    protected Integer setPointerPL(Balance balance, Integer bet, Integer diceRoll) {
        Integer pointer = 0;

        console.println("***** You Rolled: " + diceRoll);
        if (diceRoll == 7 || diceRoll == 11) {
            console.println("***** Nice! you won: " + bet);
            balance.setBalance(balance.getBalance()+bet);
            console.println("***** Your balance is: " + balance.getBalance());

        } else if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12) {
            console.println("***** You Lose, Try Again!");
            //crapsCollect(balance, bet);
            play(balance);
            console.println("***** Your balance is: " + balance.getBalance());

        } else {
            console.println("***** Pointer set to: " + diceRoll + "\n\n");
            pointer = diceRoll;

        }
        return pointer;
    }

    protected Integer setPointerDontPL(Balance balance, Integer bet, Integer diceRoll) {
        Integer pointer = 0;

        console.println("***** You Rolled: " + diceRoll);
        if (diceRoll == 2 || diceRoll == 3) {
            console.println("***** Nice! you won: " + bet);
            crapsPayout(balance, bet);
            console.println("***** Your balance is: " + balance.getBalance());

        } else if (diceRoll == 7 || diceRoll == 11) {
            console.println("***** You Lose, Try Again!");
            crapsCollect(balance, bet);
            console.println("***** Your balance is: " + balance.getBalance());

        } else if (diceRoll == 12) {
            console.println("Push, Roll Again!");
        } else {
            console.println("***** Pointer set to: " + diceRoll);
            pointer = diceRoll;

        }
        return pointer;

    }

    protected Integer hedgeBet(Balance balance, Integer bet) {
        bet *= 2;
        balance.setBalance(balance.getBalance() - bet);
        return bet;
    }

    protected void crapsRoundPL(Balance balance, Integer bet, Integer diceRoll, Integer pointer) {

        console.println("***** You Rolled: " + diceRoll);
        if (diceRoll == pointer) {
            console.println("***** You WIN!\n Winnings: " + bet);
            crapsPayout(balance, bet);
            console.println("***** Your balance is: " + balance.getBalance());

        } else if (diceRoll == 7) {
            console.println("***** 7 OUT! Better Luck Next Time.\n***** Your balance is: " + balance.getBalance());

        } else {
            console.println("Roll Again\n");
        }
    }

    protected void crapsRoundDPL(Balance balance, Integer bet, Integer diceRoll, Integer pointer){
        console.println("***** You Rolled: " + diceRoll);
        if (diceRoll == pointer) {
            console.println("***** Don't Pass Line Loses! Better Luck Next Time.\n***** Your balance is: " + balance.getBalance());

        } else if (diceRoll == 7) {

            console.println("***** You WIN!\n Winnings: " + bet);
            crapsPayout(balance, bet);
            console.println("***** Your balance is: " + balance.getBalance());

        } else {
            console.println("Roll Again\n");
        }
    }

    //House wins and takes the bet
    protected void crapsCollect(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() - amount);
    }

    //Player wins and gets their cut
    protected void crapsPayout(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() + (amount * 2));
    }


    public void payout() {

    }

    public void collect() {

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
