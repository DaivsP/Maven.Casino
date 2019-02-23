package io.zipcoder.casino.Person;

import io.zipcoder.casino.Hand;

public class HiLowPlayer extends CardPlayer {
    private Hand hand;
    private Integer score;

    public HiLowPlayer(String name, Integer score) {
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
