package io.zipcoder.casino.games.diegames.dieutilities;

public class Die {

    public Integer diceValue;
    public Integer diceNum;


    public Die() {
        diceValue = 6;
        diceNum = 1;
    }


    public Die(int numofDice) {

        diceValue = numofDice * 6;
        diceNum = numofDice;


    }



    public Integer getDiceValue() {
        return diceValue;
    }

    public Integer getDiceNum() {
        return diceNum;
    }

}
