package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class GameTable {
    private io.zipcoder.casino.Person.Dealer dealer;
    private io.zipcoder.casino.Games.Games game;
    private Integer pot;
    private io.zipcoder.casino.Person.Person player;

    public GameTable() {
    }

    public void printGameOptions() {
    }

    public void chooseGame() {
       // InputStream inputStream; //= new ByteArrayInputStream(System.in);
       // PrintStream printStream = new PrintStream(System.out);

        Console openConsole = new Console(System.in, System.out);

        Double test = openConsole.getDoubleInput("Get Double");
        openConsole.println("accepted"+test);
    }

    public static void main(String[] args){

        GameTable play = new GameTable();
        play.chooseGame();
    }
}
