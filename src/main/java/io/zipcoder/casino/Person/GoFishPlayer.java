package io.zipcoder.casino.Person;

import io.zipcoder.casino.utilities.Hand;

public class GoFishPlayer extends CardPlayer {
    private Hand hand;
    public Integer score;

    public GoFishPlayer(String name, Integer score) {
        super(name);
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
