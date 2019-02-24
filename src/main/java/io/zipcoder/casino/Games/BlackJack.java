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
        dealer = new GamblingDealer(null);
        cardDeck = new CardDeck();
        console = new Console(System.in, System.out);
        cardDeck.shuffle();
    }

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getBlackjackBanner();
        console.println("Please type 'E' to exit");
        Integer amount = balance.getBalance();
        while(amount > 0){
            dealerHand.clearHand();
            playerHand.clearHand();
            Card playerCard = cardDeck.dealCard();
            Card dealerCard = cardDeck.dealCard();
            dealerHand.addACard(dealerCard);
            playerHand.addACard(playerCard);
            Card playerCard2 = cardDeck.dealCard();
            Card dealerCard2 = cardDeck.dealCard();
            dealerHand.addACard(dealerCard2);
            playerHand.addACard(playerCard2);

            console.print("Your current cards: ");
            console.println(playerHand.toString());
            Integer userBet = console.getIntegerInput("How much do you want to Bet: ");
            player.bet(balance,userBet);
            pot = userBet;


            String userChoice = console.getStringInput("Do you want to (H)it or (S)tay. :");
            if ("H".equals(userChoice.toUpperCase())){
                Card nextPlayerCard = cardDeck.dealCard();
                playerHand.addACard(nextPlayerCard);
            }
            else if ("S".equals(userChoice.toUpperCase())){
                compareSumOfHands();
            }
            else if ("E".equals(userChoice.toUpperCase())){
                break;
            }
        }
    }

    public Integer compareSumOfHands(){
        return null;
    }

    public void collect() {
    }

    public void payout() {
    }


}