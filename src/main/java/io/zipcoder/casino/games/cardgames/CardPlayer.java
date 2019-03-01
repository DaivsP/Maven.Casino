package io.zipcoder.casino.games.cardgames;

import io.zipcoder.casino.Person.Player;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;

public class CardPlayer extends Player {
    private Hand hand;

    public CardPlayer(String name) {
        super(name);
    }
}
