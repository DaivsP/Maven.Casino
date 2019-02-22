package io.zipcoder.casino.Games;

import io.zipcoder.casino.Die;

import java.util.Random;

public class DiceGames extends Games {

    private Die dice;
    private Integer result;


    public Integer toss(Die dice, Integer seed) {
        Random random = new Random(seed);
        this.dice = new Die();
        result = random.nextInt(dice.diceValue);
        if(result < dice.diceNum){
            result+= dice.diceNum;
        } else if(result <= dice.diceValue) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Die dice = new Die();
        DiceGames one = new DiceGames();
        System.out.println(one.toss(dice,null));
    }


}
