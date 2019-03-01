package io.zipcoder.casino.games.gameutilities;

import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import io.zipcoder.casino.games.interfaceutilities.GameInterface;

public class InvalidGame implements GameInterface {

    public InvalidGame(Console console){
        console.println("You selected an invalid game");
    }

    @Override
    public void play(Balance balance) {
        // this should never be called
    }
}
