package io.zipcoder.casino.games.diegames.craps;

import io.zipcoder.casino.*;
import io.zipcoder.casino.games.interfaceutilities.GameInterface;
import io.zipcoder.casino.games.cardgames.cardutilities.DecorationCards;
import io.zipcoder.casino.games.diegames.DiceGames;
import io.zipcoder.casino.games.diegames.dieutilities.Die;
import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import io.zipcoder.casino.games.gameutilities.bannerutilities.Banners;

import static io.zipcoder.casino.games.gameutilities.bannerutilities.AnsiScapeCodes.*;


public class Craps extends DiceGames implements GameInterface {
    private Casino casino = new Casino();
    private DecorationCards diceArt = new DecorationCards();
    private Console console; // = new Console(System.in, System.out);
    private Balance balance;
    private Integer pointer = 0;
    private Integer passLineBet = 0;
    private Integer dontPassLineBet = 0;
    private Die die = new Die();
    private DiceGames diceGames = new DiceGames();
    private Integer hardwayBet = 0;
    private Integer crapsRoll = 0;
    private Integer hardwayNumber = 0;

    public Craps(Console console) {
        this.console = console;

    }

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getCrapsBanner();
        this.balance = balance;


        String choice = passLineChoice();

        if (passLine(choice)) {

            /**
             *
             * COME OUT ROLL SEQUENCE
             *
             * */
            console.println(balanceCheck(balance));
            passLineBet = crapsBet(balance, 0);
            console.println("You bet: " + ANSI_YELLOW + passLineBet + ANSI_RESET);
            do {
                String rollRequest = console.getStringInput("***** Press (R) to Roll\n***** Press (E) to exit");
                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    Integer roll = secondPhaseRollWithHardWayCheck(0,0, 0);
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
            Integer runner = 0;
            while(pointer!=0 && runner != 5){

                dontPassLineBet = hedgeBet(balance, dontPassLineBet);
                if (hardWayPlayChoice() == true) {
                    hardwayNumber = hardWayNumberChoice();
                    hardwayBet = crapsBet(balance, dontPassLineBet);

                }
                runner = 5;
            }


            betCheck(passLineBet);
            while (crapsRoll != pointer && crapsRoll != 7 && pointer != 0) {

                String rollRequest = console.getStringInput("ROLL A " + ANSI_RED + pointer + ANSI_RESET + " TO WIN!\n" +
                        "***** Press (R) to Roll\n***** Press (E) to exit");
                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    crapsRoll = secondPhaseRollWithHardWayCheck(hardwayBet, hardwayNumber, pointer);
                    crapsRoundPL(balance, passLineBet, crapsRoll, pointer);

                } else if(rollRequest.equals("e")||rollRequest.equals("E")){
                    break;
                }
            }
            pointer = 0;
            crapsRoll = 0;
            passLineBet = 0;
            hardwayBet = 0;
            console.println(balanceCheck(balance));
            anotherRound(balance);

        }
        else if (dontPassLine(choice)) {

            /**
             *
             * COME OUT ROLL SEQUENCE
             *
             * */
            console.println(balanceCheck(balance));
            dontPassLineBet = crapsBet(balance, 0);

            do {
                String rollRequest = console.getStringInput("***** Press (R) to Roll\n***** Press (E) to exit");

                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    Integer roll = secondPhaseRollWithHardWayCheck(0, 0,0);
                    pointer = setPointerDontPL(balance, dontPassLineBet, roll);
                } else {
                    break;
                }
            } while (pointer == 0);


            /**
             *
             * SECOND PHASE -- POINT HAS BEEN ESTABLISHED
             *
             * */

            Integer runner = 0;
            while(pointer!=0 && runner != 5){

                dontPassLineBet = hedgeBet(balance, dontPassLineBet);
                if (hardWayPlayChoice() == true) {
                    hardwayNumber = hardWayNumberChoice();
                    hardwayBet = crapsBet(balance, dontPassLineBet);

                }
                runner = 5;
            }


            betCheck(dontPassLineBet);
            while (crapsRoll != pointer && crapsRoll != 7 && pointer != 0) {

                String rollRequest = console.getStringInput("ROLL A " + ANSI_RED + 7 + ANSI_RESET + " before " + ANSI_RED + pointer + ANSI_RESET + " TO WIN!\n" +
                        "***** Press (R) to Roll\n***** Press (E) to exit");
                if (rollRequest.equals("R") || rollRequest.equals("r")) {
                    crapsRoll = secondPhaseRollWithHardWayCheck(hardwayBet, hardwayNumber,0);
                    crapsRoundDPL(balance, dontPassLineBet, crapsRoll, pointer);
                    //console.println(balanceCheck(balance));
                } else {
                    break;
                }
            }

            console.println(balanceCheck(balance));
            pointer = 0;
            crapsRoll = 0;
            dontPassLineBet = 0;
            hardwayBet = 0;
            anotherRound(balance);
        }


    }

    public Integer secondPhaseRollWithHardWayCheck(Integer hardwayBet, Integer hardWayNumber, Integer pointer) {
        die = new Die();
        diceGames = new DiceGames();
        Integer die1 = diceGames.toss(die, null);
        Integer die2 = diceGames.toss(die, null);
        Integer[] diceArr = {die1, die2};
        Integer crapsRoll = die1 + die2;
        diceArt.drawDices(diceArr);
        if (crapsRoll == hardWayNumber || crapsRoll == pointer) {
            hardWayWinnings(balance, die1, die2, hardwayBet, hardWayNumber);
        }
        return crapsRoll;
    }

    public void betCheck(Integer passLineBet) {
        console.println("\n\n***** Bet: " + passLineBet + " *****");
    }

    public void anotherRound(Balance balance) {

        String anotherRound = console.getStringInput("Play another round? (Y)/(N)");
        if (anotherRound.equals("Y") || anotherRound.equals("y")) {
            play(balance);
        }
    }

    public String passLineChoice() {
        String passLineChoice = console.getStringInput("***** Where do you want to place your bet:\n" +
                "***** Select (P) Pass Line \n***** Select (D) Don't Pass Line\n***** Select (E) to Exit");

        return passLineChoice;
    }

    public Integer crapsBet(Balance balance, Integer firstBet) {

        Integer bet = console.getIntegerInput("***** How much do you want to bet? *****");
        if (bet <= balance.getBalance() - firstBet) {
            return bet;
        } else if (bet >= balance.getBalance()) {
            console.println("You do not have that much...");
            console.println("***** Balance: " + ANSI_BLUE + (balance.getBalance() - firstBet) + ANSI_RESET + " *****");
            Integer trueBet = crapsBet(balance, firstBet);
            return trueBet;
        }
        return 0;
    }

    public boolean passLine(String passLineChoice) {
        return passLineChoice.equals("p") || passLineChoice.equals("P");
    }

    public Integer setPointerPL(Balance balance, Integer bet, Integer diceRoll) {
        Integer pointer = 0;

        console.println("\n***ROLL** (( " + ANSI_RED + diceRoll + ANSI_RESET + " )) **ROLL***\n");
        if (diceRoll == 7 || diceRoll == 11) {
            winComeOutRoll(balance, bet);

        } else if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12) {
            youLosePlayAgain(balance, bet);

        } else {
            console.println("***** Pointer set to: " + ANSI_RED + diceRoll + ANSI_RESET + " *****\n");
            pointer = diceRoll;

        }
        return pointer;
    }

    public void winComeOutRoll(Balance balance, Integer bet) {
        console.println("***** Nice! you won: " + ANSI_GREEN + bet + ANSI_RESET + " *****");
        balance.setBalance(balance.getBalance() + bet);
        //console.println(balanceCheck(balance));
    }

    public void youLosePlayAgain(Balance balance, Integer bet) {
        console.println("***** You Lose, Try Again! *****");
        balance.setBalance(balance.getBalance() - bet);
        //console.println(balanceCheck(balance));
        anotherRound(balance);
    }

    public void crapsRoundPL(Balance balance, Integer bet, Integer diceRoll, Integer pointer) {

        console.println("\n***ROLL** (( " + ANSI_RED + diceRoll + ANSI_RESET + " )) **ROLL***\n");
        if (diceRoll == pointer) {
            youWinSecondPhase(balance, bet);

        } else if (diceRoll == 7) {
            sevenOutLoss(balance, bet);

        } else {
            console.println("Roll Again\n");
        }
    }

    private void sevenOutLoss(Balance balance, Integer bet) {
        console.println("***** 7 OUT! Better Luck Next Time. *****");
        balance.setBalance(balance.getBalance() - bet);
        //console.println(balanceCheck(balance));
    }

    public boolean dontPassLine(String passLineChoice) {
        return passLineChoice.equals("d") || passLineChoice.equals("D");
    }

    public Integer setPointerDontPL(Balance balance, Integer bet, Integer diceRoll) {
        Integer pointer = 0;

        console.println("\n***ROLL** (( " + ANSI_RED + diceRoll + ANSI_RESET + " )) **ROLL***\n");
        if (diceRoll == 2 || diceRoll == 3) {
            winComeOutRoll(balance, bet);

        } else if (diceRoll == 7 || diceRoll == 11) {
            youLosePlayAgain(balance, bet);

        } else if (diceRoll == 12) {
            console.println("Push, Roll Again!");
        } else {
            console.println("***** Pointer set to: " + ANSI_RED + diceRoll + ANSI_RESET + "\n");
            pointer = diceRoll;

        }
        return pointer;

    }

    public void crapsRoundDPL(Balance balance, Integer bet, Integer diceRoll, Integer pointer) {
        console.println("\n***ROLL** (( " + ANSI_RED + diceRoll + ANSI_RESET + " )) **ROLL***\n");
        if (diceRoll == pointer) {
            youLosePlayAgain(balance, bet);

        } else if (diceRoll == 7) {

            youWinSecondPhase(balance, bet);


        } else {
            console.println("Roll Again\n");
        }

    }

    public void youWinSecondPhase(Balance balance, Integer bet) {
        console.println("***** You WIN! *****\n Winnings: " + ANSI_GREEN + bet + ANSI_RESET);
        crapsPayout(balance, bet);
        //console.println(balanceCheck(balance));
    }

    public String balanceCheck(Balance balance) {
        return "***** Balance: " + ANSI_BLUE + balance.getBalance() + ANSI_RESET + " *****";
    }

    public Integer hedgeBet(Balance balance, Integer bet) {
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

    public boolean hardWayPlayChoice() {
        String choice = console.getStringInput("Do you want to bet a Hardway? (Y)/(N)");
        if (choice.equals("Y") || choice.equals("y")) {
            return true;
        }
        return false;
    }

    public Integer hardWayNumberChoice() {
        Integer numberChoice = null;
        Integer choice = console.getIntegerInput("Pick One: (4)/(6)/(8)/(10)");
        if (choice == 4 || choice == 6 || choice == 8 || choice == 10) {
            numberChoice = choice;
        } else {
            console.println("Invalid choice....");
        }
        return numberChoice;
    }

    public void hardWayWinnings(Balance balance, Integer dice1, Integer dice2, Integer bet, Integer hardWayNumber) {
        Integer total = dice1 + dice2;
        Integer winnings = 0;
        switch (total) {
            case 4:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 7;
                    console.println("\nHard Way HIT! You Win: " + ANSI_GREEN + winnings + ANSI_RESET);
                    balance.setBalance(balance.getBalance() + winnings);
                    break;
                } else {
                    console.println("\nSoft 4 hit, You lost: " +ANSI_RED+ bet+ANSI_RESET);
                    balance.setBalance(balance.getBalance() - bet);
                }
                break;

            case 6:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 9;
                    console.println("\nHard Way HIT! You Win: " + ANSI_GREEN + winnings + ANSI_RESET);
                    balance.setBalance(balance.getBalance() + winnings);
                    break;
                } else {
                    console.println("\nSoft 6 hit, You lost: " +ANSI_RED+ bet+ANSI_RESET);
                    balance.setBalance(balance.getBalance() - bet);
                }
                break;

            case 8:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 9;
                    console.println("\nHard Way HIT! You Win: " + ANSI_GREEN + winnings + ANSI_RESET);
                    balance.setBalance(balance.getBalance() + winnings);
                    break;
                } else {
                    console.println("\nSoft 8 hit, You lost: " +ANSI_RED+ bet+ANSI_RESET);
                    balance.setBalance(balance.getBalance() - bet);
                }
                break;

            case 10:
                if (total == hardWayNumber && dice1 == dice2) {
                    winnings = bet * 7;
                    console.println("\nHard Way HIT! You Win: " + ANSI_GREEN + winnings + ANSI_RESET);
                    balance.setBalance(balance.getBalance() + winnings);
                    break;
                } else {
                    console.println("\nSoft 10 hit, You lost: " +ANSI_RED+ bet+ANSI_RESET);
                    balance.setBalance(balance.getBalance() - bet);
                }
                break;
            default:balance.setBalance(balance.getBalance() - bet);
                break;
        }
    }

    public void hardWayPayout(Balance balance, Integer winnings) {
        balance.setBalance(balance.getBalance() + winnings);
    }

    public void crapsCollect(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() - amount);
    }

    public void crapsPayout(Balance balance, Integer amount) {
        balance.setBalance(balance.getBalance() + (amount*2));
    }


//balance.setBalance(balance.getBalance()+hedgeBet);


    //Used for unit Testing
    public void setConsole(Console console) {
        this.console = console;
    }
}
