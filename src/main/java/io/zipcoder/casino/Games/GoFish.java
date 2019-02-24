package io.zipcoder.casino.Games;

import io.zipcoder.casino.Banners;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.*;
import io.zipcoder.casino.utilities.Console;

public class GoFish extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player goFishPlayer;
    Console console;
    private GoFishPlayer player ;
    private FunDealer dealer;
    private CardDeck cardDeck;

    public GoFish() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        player = new GoFishPlayer(null, 0 );
        player.setHand(playerHand);
        dealer = new FunDealer(0);
        dealer.setHand(dealerHand);
        cardDeck = new CardDeck();

    }

    public void play() {
        Banners banners = new Banners();
        banners.getGoFishBanner();
//        String start = console.getStringInput("Welcome to the Go Fish table. (D) to draw a hand.");
//        if (start.equals("D") || start.equals("d")) {
//
//        }
        Boolean playing = true;
        while(playing){

        }
    }

    public void playerGuessACard() {

    }
    public void dealerGuessACard(){

    }

    public void goFish() {

    }

    public void makeBook() {

    }

    public void updateScore() {
  //      player.setScore(+1);
    }

    public void winner() {

    }

    public void looser() {

    }

    public void drawFirstHAnd() {

    }

    public boolean equals() {
        return true;
    }

    public void isABook(Hand hand) {

    }
    public void printHand(){

    }

    public GoFishPlayer getPlayer() {
        return player;
    }

    public FunDealer getDealer() {
        return dealer;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }
}
