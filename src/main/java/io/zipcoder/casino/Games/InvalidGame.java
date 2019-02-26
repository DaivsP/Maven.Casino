package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;
import io.zipcoder.casino.utilities.Console;

public class InvalidGame implements GameInterface {

    public InvalidGame(Console console){
        console.println("You selected an invalid game");
    }

    @Override
    public void play(Balance balance) {
        // this should never be called
    }
}
