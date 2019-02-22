package io.zipcoder.casino.Person;

import io.zipcoder.casino.Hand;

public class GoFishPlayer extends CardPlayer {
    private Hand hand;
    private Integer score;

    public GoFishPlayer(String name) {
        super(name);
    }
}
