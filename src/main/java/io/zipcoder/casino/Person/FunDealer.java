package io.zipcoder.casino.Person;
import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.Hand;



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

