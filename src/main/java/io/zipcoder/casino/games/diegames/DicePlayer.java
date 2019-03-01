package io.zipcoder.casino.games.diegames;

import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.games.diegames.dieutilities.Die;

import java.util.ArrayList;

public class DicePlayer extends Player {
    private ArrayList<Die> dice;

    public DicePlayer(String name) {
        super(name);
    }
}
