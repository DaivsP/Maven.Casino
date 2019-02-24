package io.zipcoder.casino.Games;

import io.zipcoder.casino.Balance;

public interface GamblingGame {
    void collect();

    void payout();

    void play(Balance balance);
}
