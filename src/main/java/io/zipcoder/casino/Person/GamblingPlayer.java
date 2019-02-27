package io.zipcoder.casino.Person;

import io.zipcoder.casino.utilities.Balance;

public interface GamblingPlayer {
    void bet(Balance balance, Integer amount);

    void collect(Balance balance, Integer amount);
}
