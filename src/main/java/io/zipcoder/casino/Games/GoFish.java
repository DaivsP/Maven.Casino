package io.zipcoder.casino.Games;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.*;
import io.zipcoder.casino.Person.*;
import io.zipcoder.casino.utilities.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoFish extends Games implements FunGame {
    private io.zipcoder.casino.Person.Player goFishPlayer;
    private Console console;
    private GoFishPlayer player;
    private GoFishPlayer player2;
    private CardDeck cardDeck;
    private Hand player2Hand;
    private Hand playerHand;
    private GoFishPlayer[] Players;
    private Integer books;
    private Integer score;

    public GoFish(Console console) {
        cardDeck = new CardDeck();
        cardDeck.shuffle();

        player = new GoFishPlayer("You", 0);
        player2 = new GoFishPlayer("Dealer", 0);
        Players = new GoFishPlayer[]{player, player2};

        playerHand = new Hand();
        player2Hand = new Hand();
        player.setHand(playerHand);
        player2.setHand(player2Hand);

        player.setScore(0);
        player2.setScore(0);
        books = 0;

        this.console = console;


    }

    public void play() {
        Banners banners = new Banners();
        banners.getGoFishBanner();
        console.println("Please type 'E' to exit at any time");
        String input = console.getStringInput("Welcome to the Go Fish table. (D) to draw a hand.");
        dealHands();

        while (books < 13) {
            if (input.equals("D") || input.equals("d")) {
                takeTurn(player);
                console.println("\n* * * * AI Turn * * * * *\n");
                if (books >= 13) {
                    break;
                }
                //takeTurn(player2);
                aITakeTurn(player2);
                console.println("\n* * * * Your Turn * * * * *\n");
            }
            if (input.equals("E") || input.equals("e")) {
                break;
            }
        }
        if (player.score == 0 && player2.score == 0) {
            console.println("\nSo Soon? Alright, See Ya!\n");
        }
        if (player.score > player2.score) {
            winner();
        } else {
            looser();
        }
        console.println("\nThanks for playing!\n");

    }

    public void takeTurn(GoFishPlayer anyPlayer) {
        anyPlayer.getHand().sort();
        checkForBooks(anyPlayer, anyPlayer.getHand());
        printHand(anyPlayer);
        if (numOfCards(anyPlayer) == 0){
            console.println("\nLooks like you are out of cards!");
            goFish(anyPlayer);
        }
        String input = console.getStringInput("\nGuess a Card:").toUpperCase();

        if (input.equals("E")) {
            books = 13;
            return;
        }
        if (checkForMatch(anyPlayer, input)) {
            if (checkForMatch(otherPlayer(anyPlayer), input)) {
                removeMatchingCards(otherPlayer(anyPlayer), input);
                takeTurn(anyPlayer);
            } else {
                console.println("Go Fish!");
                goFish(anyPlayer);
                printHand(anyPlayer);
                console.print(" <- new card\n");
            }
        } else {
            console.println("Your guess must also be in your hand");
            takeTurn(anyPlayer);
        }
    }

    public void aITakeTurn(GoFishPlayer anyPlayer) {
        anyPlayer.getHand().sort();
        checkForBooks(anyPlayer, anyPlayer.getHand());
        String input = aIGuessingMagic(anyPlayer);
        console.getStringInput("\nDo you have a "+input+"?\n");
        if (checkForMatch(otherPlayer(anyPlayer), input)) {
            aIRemoveMatchingCards(otherPlayer(anyPlayer), input);
            aITakeTurn(anyPlayer);
        } else {
            console.println("Go Fish!");
            goFish(anyPlayer);
        }

    }

    public String aIGuessingMagic(GoFishPlayer anyPlayer){
        String input;
        int range = numOfCards(anyPlayer);
        int index = (int)(Math.random()*range)+0;
        input = getPlayerCardRank(anyPlayer, index).toString();
        return input;
    }

    public void removeMatchingCards(GoFishPlayer anyPlayer, String input) {
        Card removedCard;
        for (int i = 0; i <= numOfCards(anyPlayer) - 1; i++) {
            if (getPlayerCardRank(anyPlayer, i).toString().equals(input)) {
                removedCard = getPlayerCard(anyPlayer, i);
                otherPlayer(anyPlayer).getHand().addACard(removedCard);
                anyPlayer.getHand().removeACard(getPlayerCard(anyPlayer, i));
                console.println("\nYou received a " + input + "! Go Again!\n");
                i--;
            }
        }
    }
    public void aIRemoveMatchingCards(GoFishPlayer anyPlayer, String input) {
        Card removedCard;
        for (int i = 0; i <= numOfCards(anyPlayer) - 1; i++) {
            if (getPlayerCardRank(anyPlayer, i).toString().equals(input)) {
                removedCard = getPlayerCard(anyPlayer, i);
                otherPlayer(anyPlayer).getHand().addACard(removedCard);
                anyPlayer.getHand().removeACard(getPlayerCard(anyPlayer, i));
                console.println("\nDealer took a " + input + " card from you! Dealer goes Again!\n");
                i--;
            }
        }
    }

    public GoFishPlayer otherPlayer(GoFishPlayer anyPlayer) {
        if (anyPlayer == player) {
            return player2;
        } else {
            return player;
        }
    }

    public int numOfCards(GoFishPlayer anyPlayer) {
        return anyPlayer.getHand().getNumberOfCards();
    }

    public void checkForBooks(GoFishPlayer anyPlayer, Hand hand) {
        if (hand.getNumberOfCards() >= 3) {
            int j = 0;
            for (int i = 3; i <= hand.getNumberOfCards() - 1; i++) {
                if (getPlayerCardRank(anyPlayer, j).equals(getPlayerCardRank(anyPlayer, i))) {
                    String bookName = hand.getACard(i).getRank().toString();
                    hand.removeACard(hand.getACard(j));
                    hand.removeACard(hand.getACard(j));
                    hand.removeACard(hand.getACard(j));
                    hand.removeACard(hand.getACard(j));
                    books++;
                    console.println("\n"+anyPlayer.getName()+" made a Book of " + bookName + "'s!");
                    anyPlayer.setScore(anyPlayer.score + 1);
                    console.println("\n"+anyPlayer.getName()+" Score is now " + anyPlayer.score + "!\n");
                    j++;

                } else {
                    j++;
                }
            }
        }
    }

    public Boolean checkForMatch(GoFishPlayer anyPlayer, String input) {
        Boolean cardIsInHand = false;
        for (int i = 0; i <= anyPlayer.getHand().getNumberOfCards() - 1; i++) {
            if (getPlayerCardRank(anyPlayer, i).toString().equals(input)) {
                cardIsInHand = true;
            }
        }
        return cardIsInHand;
    }

    public void goFish(GoFishPlayer anyPlayer) {
        if (cardDeck.deckSize() > 0) {
            Hand hand = anyPlayer.getHand();
            hand.addACard(cardDeck.dealCard());
        } else {
            console.println("No more cards left!");
        }
    }

    public void updateScore() {
        books++;
    }

    public void dealHands() {
        for (int i = 0; i < 7; i++) {
            goFish(player);
            goFish(player2);
        }
    }

    public void winner() {
        console.println("\nWOW YOU WIN! YOU'RE SO GOOD AT THIS GAME!\n");
    }

    public void looser() {
        console.println("\nYou Lost. Maybe try guessing better cards next time?\n");

    }

    public void printHand(GoFishPlayer anyPlayer) {
        console.println("***** Your Hand ******");
        for (int i = 0; i <= anyPlayer.getHand().getNumberOfCards() - 1; i++) {

            console.print(anyPlayer.getHand().getACard(i).getRank().toString() + " : ");
        }
    }

    public Card.Rank getPlayerCardRank(GoFishPlayer anyPlayer, int i) {
        return anyPlayer.getHand().getACard(i).getRank();
    }

    public Card getPlayerCard(GoFishPlayer anyPlayer, int i) {
        return anyPlayer.getHand().getACard(i);
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
