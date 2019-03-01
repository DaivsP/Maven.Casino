package io.zipcoder.casino.games.cardgames.gofish;

import io.zipcoder.casino.games.cardgames.CardPlayer;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;

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
