package io.zipcoder.casino.Games;


import io.zipcoder.casino.*;
import io.zipcoder.casino.Person.BlackJackPlayer;
import io.zipcoder.casino.Person.GamblingDealer;
import io.zipcoder.casino.utilities.Console;

public class BlackJack extends CardGames implements GamblingGame {

    private BlackJackPlayer player;
    private GamblingDealer dealer;
    private CardDeck cardDeck;
    private Integer pot = 0;

    private Console console;

    private Hand playerHand;
    private Hand dealerHand;

    public BlackJack(){
        playerHand = new Hand();
        dealerHand = new Hand();
        player = new BlackJackPlayer(null, null);
        dealer = new GamblingDealer(new Balance(new Integer(0)));
        cardDeck = new CardDeck();
        console = new Console(System.in, System.out);
        cardDeck.shuffle();
    }

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getBlackjackBanner();
        console.println("Please type 'E' to exit");
        //Setting Players balance to current balance
        player.setBalance(balance);
        if (player.getBalance().getBalance() <= 0){
            console.println("You dont have enough chips to play.");
            console.println("Please buy more chips to play.");
        }
        while(player.getBalance().getBalance() > 0){

            dealerHand.clearHand();
            playerHand.clearHand();

            Integer userBet = console.getIntegerInput("How much do you want to Bet: ");
            player.bet(balance, userBet);
            pot = userBet;

            Card playerCard = cardDeck.dealCard();
            Card dealerCard = cardDeck.dealCard();
            dealerHand.addACard(dealerCard);
            playerHand.addACard(playerCard);

            Card playerCard2 = cardDeck.dealCard();
            Card dealerCard2 = cardDeck.dealCard();
            //dealerCard2.setHidden(true);
            dealerHand.addACard(dealerCard2);
            playerHand.addACard(playerCard2);


            console.print("Your current cards: ");
            console.println(playerHand.toString());
            console.print("Your current hand value: ");
            console.println(playerHand.getSumOfHand().toString());
            console.print("The Dealers first card: ");
            console.println(dealerHand.getACard(0).toString());
                String userChoice = "";
            do {
                userChoice = console.getStringInput("Do you want to (H)it or (S)tay: ");
                if ("H".equals(userChoice.toUpperCase())){
                    Card nextPlayerCard = cardDeck.dealCard();
                    playerHand.addACard(nextPlayerCard);
                    console.print("Your current cards");
                    console.println(playerHand.toString());
                    console.print("Your current hand value: ");
                    console.println(playerHand.getSumOfHand().toString());
                }
            }while ("H".equals(userChoice.toUpperCase()) && playerHand.getSumOfHand() < 22 && !playerHand.getSumOfHand().equals(21));

            if (playerHand.getSumOfHand() > 21){
                console.println("You lost this hand!");
                console.println("You lost: " + pot);
                console.println("Your new balance is: " + player.getBalance().getBalance());
                dealer.collect(balance, pot);
            }
            else if (playerHand.getSumOfHand() == 21){
                console.println("BLACKJACK!");
                console.println("You win your bet back plus double of the pot: " + pot * 3);
                player.setBalance(new Balance(new Integer(player.getBalance().getBalance().intValue() + (pot * 3))));
                console.println("Your new balance is: " + player.getBalance().getBalance());
            }
            else if ("S".equals(userChoice.toUpperCase())){
                console.print("The dealers shows all cards: ");
                console.println(dealerHand.toString());
                console.print("The dealers hand value is: ");
                console.println(dealerHand.getSumOfHand().toString());
                while (dealerHand.getSumOfHand() < playerHand.getSumOfHand() && dealerHand.getSumOfHand() <= 21){
                    Card dealerNextCard = cardDeck.dealCard();
                    dealerHand.addACard(dealerNextCard);
                    console.println("The dealers hits");
                    console.print("The dealers hand is now: ");
                    console.println(dealerHand.toString());
                    console.print("The dealers hand value is now: ");
                    console.println(dealerHand.getSumOfHand().toString());
                }
                if (dealerHand.getSumOfHand() == 21){
                    console.println("You lost this hand! The dealer has BlackJack!");
                    console.println("You lost: " + pot);
                    console.println("Your new balance is: " + player.getBalance().getBalance());
                    dealer.collect(balance, pot);
                }
                else if (dealerHand.getSumOfHand() > 21){
                    console.println("You Win! The Dealer Bust!");
                    console.println("You collect double of the pot: " + pot * 2);
                    player.setBalance(new Balance(new Integer(player.getBalance().getBalance().intValue() + (pot * 2))));
                    console.println("Your new balance is: " + player.getBalance().getBalance());
                }
                else if (dealerHand.getSumOfHand() > playerHand.getSumOfHand()){
                    console.println("The Dealer Stays");
                    console.println("You lost this hand! The Dealers hand is larger than yours!");
                    console.println("You lost: " + pot);
                    console.println("Your new balance is: " + player.getBalance().getBalance());
                    dealer.collect(balance, pot);
                }
                else if (dealerHand.getSumOfHand() == playerHand.getSumOfHand()){
                    console.println("Its a draw!");
                    console.println("You get your bet back");
                    player.setBalance(new Balance(new Integer(player.getBalance().getBalance().intValue() + pot)));
                    console.println("Your new balance is: " + player.getBalance().getBalance());
                }
            }
            String userInput = console.getStringInput("Would you like to continue? (Y/N)");
            if ("N".equals(userInput.toUpperCase())){
                break;
            }
            else{
                cardDeck = new CardDeck();
                cardDeck.shuffle();
            }
        }
    }

    public void collect() {
    }

    public void payout() {
    }
}