package io.zipcoder.casino.Person.gambling;

import io.zipcoder.casino.games.gameutilities.Balance;

public interface GamblingPlayer {
    void bet(Balance balance, Integer amount);

    void collect(Balance balance, Integer amount);
}
