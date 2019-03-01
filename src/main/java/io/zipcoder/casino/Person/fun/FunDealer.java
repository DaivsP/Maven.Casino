package io.zipcoder.casino.Person.fun;
import io.zipcoder.casino.games.cardgames.CardPlayer;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;



public class FunDealer extends CardPlayer {
    private Hand hand;
    public Integer score;


    public FunDealer(Integer score) {
        super("Fun Dealer");
        this.score = score;
    }
    public Hand getHand() {

        return hand;
    }

    public void setHand(Hand hand) {

        this.hand = hand;
    }

    public Integer getScore() {

        return score;
    }

    public void setScore(Integer score) {

        this.score = score;
    }
}

