package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;

public interface GamblingGame extends GameInterface {
    void play(Balance balance);
}
