package io.zipcoder.casino.Games;

import io.zipcoder.casino.Die;

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

    public static void main(String[] args) {
        Integer sum;
        Integer die1;
        Integer die2;

        Die dice = new Die();
        //Die dice2 = new Die();
        DiceGames one = new DiceGames();

        die1 = one.toss(dice, null);
        die2 = one.toss(dice, null);
        sum = die1 + die2;
        System.out.println(die1);
        System.out.println(die2);
        System.out.println(sum);
    }


}
