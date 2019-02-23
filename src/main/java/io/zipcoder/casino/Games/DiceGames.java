package io.zipcoder.casino.Games;

import io.zipcoder.casino.Die;

import java.util.Random;

public class DiceGames extends Games {

    private Die dice;
    private Integer result;

    //Seed needs to be set to Null for true random number.
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

    public static void main(String[] args) {
        Die dice = new Die();
        DiceGames one = new DiceGames();
        System.out.println(one.toss(dice, null));
    }


}
