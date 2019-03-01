package io.zipcoder.casino.games.gameutilities;

import io.zipcoder.casino.games.cardgames.blackjack.BlackJack;
import io.zipcoder.casino.games.cardgames.gofish.GoFish;
import io.zipcoder.casino.games.cardgames.highlow.HighLow;
import io.zipcoder.casino.games.diegames.craps.Craps;
import io.zipcoder.casino.games.interfaceutilities.GameInterface;

import java.util.function.Function;

public enum GameEnum {
    HIGHLOW(HighLow::new),
    CRAPS(Craps::new),
    BLACKJACK(BlackJack::new),
    GOFISH(GoFish::new),
    INVALID(InvalidGame::new);

    private final Function<Console, GameInterface> function;


    GameEnum(Function<Console, GameInterface> function) {
        this.function = function;
    }

    public GameInterface create(Console console) {
        return function.apply(console);
    }

    public static GameEnum getValueOf(String userInput){

        userInput = userInput.toUpperCase().replace(" ","");
        try {
            return valueOf(userInput);
        }
        catch(Exception iae){
            return  INVALID;
        }
    }


}
