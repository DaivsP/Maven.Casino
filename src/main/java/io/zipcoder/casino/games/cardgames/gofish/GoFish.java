package io.zipcoder.casino.games.cardgames.gofish;

import io.zipcoder.casino.games.interfaceutilities.FunGame;
import io.zipcoder.casino.games.interfaceutilities.GameInterface;
import io.zipcoder.casino.games.gameutilities.Games;
import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.games.cardgames.cardutilities.CardDeck;
import io.zipcoder.casino.games.cardgames.cardutilities.DecorationCards;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import io.zipcoder.casino.games.gameutilities.bannerutilities.Banners;


public class GoFish extends Games implements FunGame, GameInterface {

    private io.zipcoder.casino.Person.Player goFishPlayer;
    private Console console;
    private GoFishPlayer player;
    private GoFishPlayer player2;
    private CardDeck cardDeck;
    private Hand player2Hand;
    private Hand playerHand;
    private Integer books;
    private String aiLastGuess;
    private String aiSecondLastGuess;
    private String lastGuess;
    private String lastDraw;

    public GoFish(Console console) {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
        player = new GoFishPlayer("You", 0);
        player2 = new GoFishPlayer("Dealer", 0);
        playerHand = new Hand();
        player2Hand = new Hand();
        player.setHand(playerHand);
        player2.setHand(player2Hand);
        player.setScore(0);
        player2.setScore(0);
        books = 0;
        this.console = console;
    }

    public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getGoFishBanner();
        console.println("Please type 'E' to exit at any time");
        String input = console.getStringInput("Welcome to the Go Fish table. Press any key to draw a hand.");
        dealHands();
        while (player.score < 7) {
            if (input.equals("E") || input.equals("e")) {
                break;
            }
            console.println("\n* * * * Your Turn * * * * *\n");
            takeTurn(player);
            if (books == 13) {
                break;
            }
            if (books < 13) {
                console.println("\n* * * * AI Turn * * * * *\n");
                aITakeTurn(player2);
            }
        }
        earlyExit();
    }

    private void earlyExit() {
        if (player.score == 0 && player2.score == 0) {

            console.println("\nSo Soon? Alright, See Ya!\n");
        }
        findWinner();
        console.println("\nThanks for playing!\n");
    }

    public void takeTurn(GoFishPlayer anyPlayer) {
        anyPlayer.getHand().sort();
        checkForBooks(anyPlayer, anyPlayer.getHand());
        printHand(anyPlayer);
        checkIfNoCardsInHand(anyPlayer);
        if (cardDeck.deckSize() == 0 && numOfCards(anyPlayer) == 0) {
            findWinner();
        } else {
            String input = console.getStringInput("\nGuess a Card: (please spell the card)").toUpperCase();
            lastGuess = input;
            if (input.equals("E")) {
                books = 13;
                return;
            }
            if (checkForMatch(anyPlayer, input)) {
                if (checkForMatch(otherPlayer(anyPlayer), input)) {
                    removeMatchingCards(otherPlayer(anyPlayer), input);
                    takeTurn(anyPlayer);
                } else {
                    playerGoesFishPrintLn(anyPlayer);
                }
            } else {
                console.println("Your guess must also be in your hand");
                takeTurn(anyPlayer);
            }
            checkForBooks(anyPlayer, anyPlayer.getHand());
        }
    }

    private void playerGoesFishPrintLn(GoFishPlayer anyPlayer) {
        console.println("Go Fish!");
        goFish(anyPlayer);
        printHand(anyPlayer);
        console.print(" <- new card\n");
        fishWhatYouWish(anyPlayer);
    }

    private void fishWhatYouWish(GoFishPlayer anyPlayer) {
        if (lastGuess.equals(lastDraw) && anyPlayer.equals(player)) {
            console.println("\nYOU FISHED WHAT YOU WISHED! HA! GO AGAIN!\n");
            takeTurn(anyPlayer);
        }
        if (lastGuess.equals(lastDraw) && anyPlayer.equals(player2)) {
            console.println("\nDEALER FISHED WHAT THEY WISHED! THEY GO AGAIN!\n");
            aITakeTurn(anyPlayer);
        }
    }


    private void checkIfNoCardsInHand(GoFishPlayer anyPlayer) {
        if (numOfCards(anyPlayer) == 0) {
            console.println("\nLooks like you are out of cards!");
            goFish(anyPlayer);
            printHand(anyPlayer);
        }
    }

    public void aITakeTurn(GoFishPlayer anyPlayer) {
        anyPlayer.getHand().sort();
        checkForBooks(anyPlayer, anyPlayer.getHand());
        if (anyPlayer.getHand().getNumberOfCards() > 0) {
            String input = aIGuessingMagic(anyPlayer);
            console.getStringInput("Do you have a " + input + "?");
            if (checkForMatch(otherPlayer(anyPlayer), input)) {
                removeMatchingCards(otherPlayer(anyPlayer), input);
                aITakeTurn(anyPlayer);
            } else {
                console.println("AI Goes Fish!");
                goFish(anyPlayer);
                fishWhatYouWish(anyPlayer);
            }
        } else {
            console.println("Looks like " + anyPlayer.getName() + " is out of cards. Go Fish!");
            goFish(anyPlayer);
        }
        checkForBooks(anyPlayer, anyPlayer.getHand());
    }

    public String aIGuessingMagic(GoFishPlayer anyPlayer) {
        int range = numOfCards(anyPlayer);
        int index;
        if (range > 1) {
            index = (int) (Math.random() * range);
        } else {
            index = range - 1;
        }
        String input = getPlayerCardRank(anyPlayer, index).toString();
        if (anyPlayer.getHand().getNumberOfCards() > 1) {
            if (!input.equals(aiLastGuess)) {
                aILastGuess(input);
                return input;
            } else if (anyPlayer.getHand().getNumberOfCards() <= 2) {
                return anyPlayer.getHand().getACard(1).getRank().toString();
            } else {
                aIGuessingMagic(anyPlayer);
            }
        }
        return getPlayerCard(anyPlayer, 0).getRank().toString();
    }

    public Hand handNoDuplicates(GoFishPlayer anyPlayer){
        Hand newHand = anyPlayer.getHand();
        anyPlayer.getHand().removeDuplicates();

        return newHand;
    }



    public void aILastGuess(String input) {
        setAiSecondLastGuess(aiLastGuess);
        aiLastGuess = input;
    }

    public String getAiLastGuess() {
        return aiLastGuess;
    }

    public void setAiSecondLastGuess(String input) {
        aiSecondLastGuess = input;
    }

    public String getAiSecondLastGuess() {
        return aiSecondLastGuess;
    }

    public String getLastGuess() {
        return lastGuess;
    }

    public void setLastGuess(String lastGuess) {
        this.lastGuess = lastGuess;
    }

    public void removeMatchingCards(GoFishPlayer anyPlayer, String input) {
        Card removedCard;
        for (int i = 0; i <= numOfCards(anyPlayer) - 1; i++) {
            if (getPlayerCardRank(anyPlayer, i).toString().equals(input)) {
                removedCard = getPlayerCard(anyPlayer, i);
                otherPlayer(anyPlayer).getHand().addACard(removedCard);
                anyPlayer.getHand().removeACard(getPlayerCard(anyPlayer, i));
                gotAWish(anyPlayer, input);
                i--;
            }
        }
    }

    private void gotAWish(GoFishPlayer anyPlayer, String input) {
        console.println("\n" + otherPlayer(anyPlayer).getName() +
                " received a " + input + "! " + otherPlayer(anyPlayer).getName() + " can go again!\n");
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
        anyPlayer.getHand().sort();
        if (hand.getNumberOfCards() >= 3) {
            int j = 0;
            for (int i = 3; i <= hand.getNumberOfCards() - 1; i++) {
                if (getPlayerCardRank(anyPlayer, j).equals(getPlayerCardRank(anyPlayer, i))) {
                    String bookName = hand.getACard(i).getRank().toString();
                    removeBook(hand, j);
                    books++;
                    printBookRemoved(anyPlayer, bookName);
                    j++;
                } else {
                    j++;
                }
            }
        }
    }

    private void printBookRemoved(GoFishPlayer anyPlayer, String bookName) {
        console.println("\n" + anyPlayer.getName() + " made a Book of " + bookName + "'s!");
        anyPlayer.setScore(anyPlayer.score + 1);
        console.println("\n" + anyPlayer.getName() + " Score is now " + anyPlayer.score + "!\n");
    }

    private void removeBook(Hand hand, int j) {
        hand.removeACard(hand.getACard(j));
        hand.removeACard(hand.getACard(j));
        hand.removeACard(hand.getACard(j));
        hand.removeACard(hand.getACard(j));
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
            Card card = cardDeck.dealCard();
            setLastDraw(card.getRank().toString());
            hand.addACard(card);
        } else {
            console.println("No more cards left!");

            console.println(books.toString());

        }
    }

    public String getLastDraw() {
        return lastDraw;
    }

    public void setLastDraw(String lastDraw) {
        this.lastDraw = lastDraw;
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
        console.println("Your score: " + player.score.toString());
        console.println("Dealer score: " + player2.score.toString());
    }

    public void loser() {
        console.println("\nYou Lost. Maybe try guessing better cards next time?\n");
        console.println("Your score: " + player.score.toString());
        console.println("Dealer score: " + player2.score.toString());
    }

    public void findWinner() {
        if (player.score > player2.score) {
            winner();
        } else {
            loser();
        }
    }

    public void printHand(GoFishPlayer anyPlayer) {
        console.println("***** Your Hand ******");
        DecorationCards decor = new DecorationCards();
        decor.drawHand(anyPlayer.getHand());
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

    public int getBooks() {
        return books;
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}
