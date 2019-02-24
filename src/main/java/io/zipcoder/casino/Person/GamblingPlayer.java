package io.zipcoder.casino.Person;

import io.zipcoder.casino.Balance;

public interface GamblingPlayer {
    void bet(Balance balance, Integer amount);

    void collect(Balance balance, Integer amount);
}
