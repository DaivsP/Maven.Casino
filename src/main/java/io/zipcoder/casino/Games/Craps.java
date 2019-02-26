package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Die;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Banners;


public class Craps extends DiceGames implements GameInterface{
    private Casino casino = new Casino();
    private DiceGames diceGames = new DiceGames();
    private Die dice = new Die();
    private Console console; // = new Console(System.in, System.out);
    private Balance balance;

    public Craps(Console console) {
        this.console = console;

    }


    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getCrapsBanner();
        this.balance = balance;
        Integer pointer = 0;
        Integer passLineBet = 0;
        Die die = new Die();
        DiceGames diceGames = new DiceGames();
        Integer hardwayBet = 0;
        Integer crapsRoll = 0;
        Integer hardwayNumber = 0;


        String choice = passLineChoice();

        if (passLine(choice)) {

            /**
             *
             * COME OUT ROLL SEQUENCE
             *
             * */
            passLineBet = crapsBet(balance);
            console.println("You bet: " + passLineBet);
            do {
                String rollRequest = console.getStringInput("***** Press (R) to Roll\n***** Press (E) to exit");
                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    Integer roll = diceGames.tossTwoDie(diceGames, die);
                    pointer = setPointerPL(balance, passLineBet, roll);
                } else {
                    break;
                }
            } while (pointer == 0);

            /**
             *
             * SECOND PHASE -- POINT HAS BEEN ESTABLISHED
             *
             * */

            //Hedge Bet Prompt
            passLineBet = hedgeBet(balance, passLineBet);



            if (hardWayPlayChoice() == true) {
                hardwayNumber = hardWayNumberChoice();
                hardwayBet = crapsBet(balance);
            }

            betCheck(passLineBet);
            while (crapsRoll != pointer && crapsRoll != 7 && pointer != 0) {

                String rollRequest = console.getStringInput("ROLL A " + pointer + " TO WIN!\n***** Press (R) to Roll\n***** Press (E) to exit");
                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    crapsRoll = secondPhaseRollWithHardWay(hardwayBet, hardwayNumber);
                    crapsRoundPL(balance, passLineBet, crapsRoll, pointer);
                } else {
                    break;
                }
            }

            anotherRound(balance);

        }
        else if (dontPassLine(choice)) {

            /**
             *
             * COME OUT ROLL SEQUENCE
             *
             * */
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



            /**
             *
             * SECOND PHASE -- POINT HAS BEEN ESTABLISHED
             *
             * */

            //Hedge Bet Prompt
            passLineBet = hedgeBet(balance, passLineBet);

            if (hardWayPlayChoice() == true) {
                hardwayNumber = hardWayNumberChoice();
                hardwayBet = crapsBet(balance);
            }

            while (crapsRoll != pointer && crapsRoll != 7 && pointer != 0) {
                betCheck(passLineBet);
                String rollRequest = console.getStringInput("ROLL A 7 before " + pointer + " TO WIN!\n***** Press (R) to Roll\n***** Press (E) to exit");
                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    crapsRoll = secondPhaseRollWithHardWay(hardwayBet, hardwayNumber);
                    crapsRoundDPL(balance, passLineBet, crapsRoll, pointer);

                } else {
                    break;
                }
            }
            anotherRound(balance);
        }


    }

    protected void betCheck(Integer passLineBet) {
        console.println("***** Bet: " + passLineBet + " *****\n");
    }

    protected Integer secondPhaseRollWithHardWay(Integer hardwayBet, Integer hardWayNumber) {
        Die die = new Die();
        DiceGames diceGames = new DiceGames();
        Integer die1 = diceGames.toss(die, null);
        Integer die2 = diceGames.toss(die, null);
        Integer crapsRoll = die1 + die2;
        console.println("****** [ " + die1 + " ] / [ " + die2 + " ] ******");
        hardWayWinnings(die1, die2, hardwayBet, hardWayNumber);
        return crapsRoll;
    }

    protected void anotherRound(Balance balance) {
        Integer passLineBet;
        String anotherRound = console.getStringInput("Play another round? (Y)/(N)");
        if (anotherRound.equals("Y") || anotherRound.equals("y")) {
            passLineBet = 0;
            play(balance);
        }
    }

    protected String passLineChoice() {
        String passLineChoice = console.getStringInput("***** Where do you want to place your bet:\n" +
                "***** Select (P) Pass Line \n***** Select (D) Don't Pass Line\n***** Select (E) to Exit");

        return passLineChoice;
    }

    protected Integer crapsBet(Balance balance) {
        console.println("***** Balance: " + balance.getBalance() + " *****");
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

    protected boolean passLine(String passLineChoice) {
        return passLineChoice.equals("p") || passLineChoice.equals("P");
    }

    protected Integer setPointerPL(Balance balance, Integer bet, Integer diceRoll) {
        Integer pointer = 0;

        console.println("***** You Rolled: " + diceRoll);
        if (diceRoll == 7 || diceRoll == 11) {
            console.println("***** Nice! you won: " + bet);
            balance.setBalance(balance.getBalance() + bet);
            console.println("***** Your balance is: " + balance.getBalance());

        } else if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12) {
            console.println("***** You Lose, Try Again!");
            console.println("***** Your balance is: " + balance.getBalance());
            anotherRound(balance);

        } else {
            console.println("***** Pointer set to: " + diceRoll + "\n");
            pointer = diceRoll;

        }
        return pointer;
    }

    protected void crapsRoundPL(Balance balance, Integer bet, Integer diceRoll, Integer pointer) {

        console.println("***** You Rolled: " + diceRoll + "\n");
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

    protected boolean dontPassLine(String passLineChoice) {
        return passLineChoice.equals("d") || passLineChoice.equals("D");
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
            anotherRound(balance);

        } else if (diceRoll == 12) {
            console.println("Push, Roll Again!");
        } else {
            console.println("***** Pointer set to: " + diceRoll + "\n");
            pointer = diceRoll;

        }
        return pointer;

    }

    protected void crapsRoundDPL(Balance balance, Integer bet, Integer diceRoll, Integer pointer) {
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

    protected Integer hedgeBet(Balance balance, Integer bet) {
        String hedgeBetChoice = console.getStringInput("Do you want to Hedge your Bet? (Y)/(N)");
        if (hedgeBetChoice.equals("Y") || hedgeBetChoice.equals("y")) {
            if (bet <= balance.getBalance()) {
                balance.setBalance(balance.getBalance() - bet);
                bet *= 2;
                return bet;
            } else {
                console.println("Sorry but.... You're Broke.\n***** Balance: " + balance.getBalance() + " *****\n\n");
            }
        }
        return bet;
    }

    protected boolean hardWayPlayChoice() {
        String choice = console.getStringInput("Do you want to bet a Hardway? (Y)/(N)");
        if (choice.equals("Y") || choice.equals("y")) {
            return true;
        }
        return false;
    }

    protected Integer hardWayNumberChoice() {
        Integer numberChoice = null;
        Integer choice = console.getIntegerInput("Pick One: (4)/(6)/(8)/(10)");
        if (choice == 4 || choice == 6 || choice == 8 || choice == 10) {
            numberChoice = choice;
        } else {
            console.println("Invalid choice....");
        }
        return numberChoice;
    }

    protected Integer hardWayWinnings(Integer dice1, Integer dice2, Integer bet, Integer hardWayNumber) {
        Integer total = dice1 + dice2;
        Integer winnings = 0;
        switch (total) {
            case 4:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 7;
                    console.println("Hard Way HIT! You Win: " + winnings);
                    break;
                }else{
                    console.println("Soft 4 hit, You lost: "+bet);
                }
                break;

            case 6:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 9;
                    console.println("Hard Way HIT! You Win: " + winnings);
                    break;
                }else{
                    console.println("Soft 6 hit, You lost: "+bet);
                }
                break;

            case 8:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 9;
                    console.println("Hard Way HIT! You Win: " + winnings);
                    break;
                }else{
                    console.println("Soft 8 hit, You lost: "+bet);
                }
                break;

            case 10:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 7;
                    console.println("Hard Way HIT! You Win: " + winnings);
                    break;
                }else{
                    console.println("Soft 10 hit, You lost: "+bet);
                }
                break;

        }
        return winnings;
    }

    protected void hardWayPayout(Balance balance, Integer winnings) {
        balance.setBalance(balance.getBalance() + winnings);
    }


    //House wins and takes the bet
    protected void crapsCollect(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() - amount);
    }

    //Player wins and gets their cut
    protected void crapsPayout(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() + (amount * 2));
    }

    //Used for unit Testing
    public void setConsole(Console console) {
        this.console = console;
    }

}
