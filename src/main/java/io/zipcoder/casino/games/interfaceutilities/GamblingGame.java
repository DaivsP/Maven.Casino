package io.zipcoder.casino.games.interfaceutilities;

import io.zipcoder.casino.games.gameutilities.Balance;

public interface GamblingGame extends GameInterface {
    void play(Balance balance);
}
