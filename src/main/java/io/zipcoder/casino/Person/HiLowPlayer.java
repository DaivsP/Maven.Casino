package io.zipcoder.casino.Person;

import io.zipcoder.casino.Hand;

public class HiLowPlayer extends CardPlayer {
    private Hand hand;
    private Integer score;

    public HiLowPlayer(String name) {
        super(name);
    }
}
