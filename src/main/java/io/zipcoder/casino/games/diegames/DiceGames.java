package io.zipcoder.casino.games.diegames;

import io.zipcoder.casino.games.gameutilities.Games;
import io.zipcoder.casino.games.diegames.dieutilities.Die;

import java.util.Random;

public class DiceGames extends Games {

    private Die dice;
    private Integer result;

    //Seed needs to be set to null for true random number.
    public Integer toss(Die dice, Integer seed) {
        Random random;
        this.dice = new Die();

        if (seed != null) {
            random = new Random(seed);
        } else {
            random = new Random();
        }

        result = random.nextInt(dice.diceValue);
        if (result < dice.diceNum) {
            result += dice.diceNum;
        } else if (result <= dice.diceValue) {
            result++;
        }
        return result;
    }

    public Integer tossTwoDie(DiceGames game, Die dice) {
        Integer die1 = game.toss(dice, null);
        Integer die2 = game.toss(dice, null);
        Integer sum = die1 + die2;

        return sum;
    }

}
