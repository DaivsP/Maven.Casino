package io.zipcoder.casino.Games;


import io.zipcoder.casino.*;
import io.zipcoder.casino.Person.BlackJackPlayer;
import io.zipcoder.casino.Person.GamblingDealer;
import io.zipcoder.casino.utilities.Console;

public class BlackJack extends Games implements GamblingGame {

    private BlackJackPlayer player;
    private GamblingDealer dealer;

    private DecorationCards decorationCards;
    private CardDeck cardDeck;
    private Integer pot = 0;
    private Console console;

    private Hand playerHand;

    private Hand dealerHand;

    public BlackJack(Console console){

        decorationCards = new DecorationCards();

        playerHand = new Hand();
        dealerHand = new Hand();
        player = new BlackJackPlayer(null, null);
        dealer = new GamblingDealer(new Balance(new Integer(0)));
        cardDeck = new CardDeck();
        this.console = console;
        cardDeck.shuffle();
    }

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getBlackjackBanner();
        //Setting Players balance to current balance
        player.setBalance(balance);
        if (player.getBalance().getBalance() <= 0) {
            console.println("You dont have enough chips to play.");
            console.println("Please buy more chips to play.");
        }
        while (playerHasAPositiveBalance()) {
            clearHands(dealerHand, playerHand);
            String userChoice = "";
            Integer userBet = console.getIntegerInput("How much do you want to Bet: ");
            player.bet(balance, userBet);
            pot = userBet;

            dealCardsToPlayerAndDealerAndAddThemToRespectiveHands();

            dealCardsToPlayerAndDealerAndAddThemToRespectiveHands();

            printUserFirstHandAndDealerFirstCard();

            do {
                userChoice = console.getStringInput("Do you want to (H)it or (S)tay: ");
                if ("H".equals(userChoice.toUpperCase())) {
                    Card nextPlayerCard = cardDeck.dealCard();
                    playerHand.addACard(nextPlayerCard);
                    dealACardToThePlayerAndPrintTheirNewHand();
                }
            } while (playerHitsAndDidNotBustAndDoesNotHave21(userChoice));

            if (playerHand.getSumOfHand() > 21) {
                playerLostHandWithValueLargerThan21();
                dealer.collect(balance, pot);
            } else if (playerHand.getSumOfHand() == 21) {
                playerGotBlackJack();
            } else if ("S".equals(userChoice.toUpperCase())) {
                printDealersFullHand();

                while (dealerHandIsLessThanPlayerHandAndDoesNotHave21()) {
                    Card dealerNextCard = cardDeck.dealCard();
                    dealerHand.addACard(dealerNextCard);
                    dealerDrawsACardAddsItToHisHandAndPrintDealerHand();
                }
                dealerPlayActions(balance);
            }
            String userInput = console.getStringInput("Would you like to continue? (Y/N)");
            if ("N".equals(userInput.toUpperCase())) {
                balance.setBalance(player.getBalance().getBalance());
                break;
            } else {
                cardDeck = new CardDeck();
                cardDeck.shuffle();
            }
        }
    }

    public void clearHands(Hand dealerHand, Hand playerHand) {
        dealerHand.clearHand();
        playerHand.clearHand();
    }

    public void dealCardsToPlayerAndDealerAndAddThemToRespectiveHands() {
        Card playerCard = cardDeck.dealCard();
        Card dealerCard = cardDeck.dealCard();
        dealerHand.addACard(dealerCard);
        playerHand.addACard(playerCard);
    }

    public void printUserFirstHandAndDealerFirstCard() {
        console.print("Your current cards: " + "\n");
        decorationCards.drawHand(playerHand);
        console.print("\nYour current hand value: ");
        console.println(playerHand.getSumOfHand().toString());
        console.print("The Dealers first card: ");
        console.println(dealerHand.getACard(0).toString());
    }

    public void dealACardToThePlayerAndPrintTheirNewHand() {
        console.print("Your current cards" + "\n");
        decorationCards.drawHand(playerHand);
        console.print("\nYour current hand value: ");
        console.println(playerHand.getSumOfHand().toString());
    }

    public void playerLostHandWithValueLargerThan21() {
        console.println("You lost this hand!");
        console.println("You lost: " + pot);
        console.println("Your new balance is: " + player.getBalance().getBalance());
    }

    public void playerGotBlackJack() {
        console.println("BLACKJACK!");
        console.println("You win your bet back plus double of the pot: " + pot * 3);
        player.setBalance(new Balance(new Integer(player.getBalance().getBalance().intValue() + (pot * 3))));
        console.println("Your new balance is: " + player.getBalance().getBalance());
    }

    public void printDealersFullHand() {
        console.print("The dealer shows all cards: " + "\n");
        decorationCards.drawHand(dealerHand);
        console.print("\nThe dealers hand value is: ");
        console.println(dealerHand.getSumOfHand().toString());
    }

    public void dealerDrawsACardAddsItToHisHandAndPrintDealerHand() {
        console.println("The dealer hits");
        console.print("The dealers hand is now: " + "\n");
        decorationCards.drawHand(dealerHand);
        console.print("\nThe dealers hand value is now: ");
        console.println(dealerHand.getSumOfHand().toString());
    }

    public void dealerGotBlackJack() {
        console.println("You lost this hand! The dealer has BlackJack!");
        console.println("You lost: " + pot);
        console.println("Your new balance is: " + player.getBalance().getBalance());
    }

    public void dealerBust() {
        console.println("You Win! The Dealer Bust!");
        console.println("You collect double of the pot: " + pot * 2);
        player.setBalance(new Balance(new Integer(player.getBalance().getBalance().intValue() + (pot * 2))));
        console.println("Your new balance is: " + player.getBalance().getBalance());
    }

    public void dealerHandBeatsPlayerHand() {
        console.println("The Dealer Stays");
        console.println("You lost this hand! The Dealers hand is larger than yours!");
        console.println("You lost: " + pot);
        console.println("Your new balance is: " + player.getBalance().getBalance());
    }

    public void playerHandAndDealerHandIsADraw() {
        console.println("Its a draw!");
        console.println("You get your bet back");
        player.setBalance(new Balance(new Integer(player.getBalance().getBalance().intValue() + pot)));
        console.println("Your new balance is: " + player.getBalance().getBalance());
    }

    public boolean playerHasAPositiveBalance() {
        return player.getBalance().getBalance() > 0;
    }

    public void dealerPlayActions(Balance balance) {
        if (dealerHand.getSumOfHand() == 21) {
            dealerGotBlackJack();
            dealer.collect(balance, pot);
        } else if (dealerHand.getSumOfHand() > 21) {
            dealerBust();
        } else if (dealerHand.getSumOfHand() > playerHand.getSumOfHand()) {
            dealerHandBeatsPlayerHand();
            dealer.collect(balance, pot);
        } else if (dealerHand.getSumOfHand() == playerHand.getSumOfHand()) {
            playerHandAndDealerHandIsADraw();
        }
    }

    public boolean dealerHandIsLessThanPlayerHandAndDoesNotHave21() {
        return dealerHand.getSumOfHand() < playerHand.getSumOfHand() && dealerHand.getSumOfHand() <= 21;
    }

    public boolean playerHitsAndDidNotBustAndDoesNotHave21(String userChoice) {
        return "H".equals(userChoice.toUpperCase()) && playerHand.getSumOfHand() < 22 && !playerHand.getSumOfHand().equals(21);
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public Integer getPot() {
        return pot;
    }

    public BlackJackPlayer getPlayer() {
        return player;
    }

    public GamblingDealer getDealer() {
        return dealer;
    }
}