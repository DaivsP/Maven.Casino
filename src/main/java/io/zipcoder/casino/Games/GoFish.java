package io.zipcoder.casino.Games;
import io.zipcoder.casino.Banners;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.*;
import io.zipcoder.casino.utilities.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoFish extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player goFishPlayer;
    private Console console;
    private GoFishPlayer player ;
    private GoFishPlayer player2;
    private CardDeck cardDeck;
    private Hand player2Hand;
    private Hand playerHand;
    private GoFishPlayer[] Players;
    private Integer books;
    private Integer score;

    public GoFish() {
        cardDeck = new CardDeck();
        cardDeck.shuffle();

        player = new GoFishPlayer(null, 0 );
        player2 = new GoFishPlayer(null, 0 );
        Players = new GoFishPlayer[] {player, player2};

        playerHand = new Hand();
        player2Hand = new Hand();
        player.setHand(playerHand);
        player2.setHand(player2Hand);

        console = new Console(System.in, System.out);
        player.setScore(0);
        player2.setScore(0);
        books = 0;


    }

    public void play() {
        Banners banners = new Banners();
        banners.getGoFishBanner();
        console.println("Please type 'E' to exit at any time");
        String input = console.getStringInput("Welcome to the Go Fish table. (D) to draw a hand.");

        dealHands();


        while (books < 13){

            if (input.equals("D") || input.equals("d")) {
                takeTurn(player);
                console.println("\n*********");
                takeTurn(player2);
                console.println("\n*********");
                break;
           }
            if (input.equals("E") || input.equals("e")){
            break;
        }


        }


    }


    public void takeTurn(GoFishPlayer anyPlayer){
        printHand(anyPlayer);
        String input = console.getStringInput("\nGuess A Card");


    }

    public void goFish(GoFishPlayer anyPlayer) {
        if (cardDeck.deckSize() > 0){
            Hand hand = anyPlayer.getHand();
            hand.addACard(cardDeck.dealCard());
        }
        else {
            console.println("No more cards left!");
        }
    }

    public void makeBook() {

    }

    public void updateScore() {
        score++;
    }
    public void dealHands(){
        for(int i = 0 ; i < 7 ; i++){
            goFish(player);
            goFish(player2);
        }
    }

    public void winner() {

    }

    public void looser() {

    }

    public boolean equals() {
        return true;
    }

    public void isABook(Hand hand) {

    }
    public void printHand(GoFishPlayer anyPlayer){
        console.println("***** Your Hand ******");
        for (int i = 0 ; i <= anyPlayer.getHand().getNumberOfCards()-1 ; i++) {

            console.print(anyPlayer.getHand().getACard(i).getRank().toString()+" : ");
        }
    }

    public GoFishPlayer getPlayer() {
        return player;
    }

    public GoFishPlayer getPlayer2() {
        return player2;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }
}
