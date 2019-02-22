package io.zipcoder.casino.Person;

import io.zipcoder.casino.Die;
import io.zipcoder.casino.Person.Player;

import java.util.ArrayList;

public class DicePlayer extends Player {
    private ArrayList<Die> dice;

    public DicePlayer(String name) {
        super(name);
    }
}
