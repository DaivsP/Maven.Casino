package io.zipcoder.casino.Games;

import io.zipcoder.casino.utilities.Balance;

public interface GamblingGame extends GameInterface {
    void play(Balance balance);
}
