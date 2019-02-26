package io.zipcoder.casino;

import io.zipcoder.casino.Games.DiceGames;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Symbols;


public class DecorationCards {

    Console console ;
    private static String containerT = "";
    private static String container1 = "";
    private static String container2 = "";
    private static String container3 = "";
    private static String container4 = "";
    private static String container5 = "";

    public DecorationCards(){
        this.console = new Console(System.in, System.out);
    }

    public void drawHand( Hand hand ){
        Symbols sym = new Symbols();
        String suitOfCard , rankOfCard = "";

        for (int i = 0; i < hand.getNumberOfCards(); i++) {
            rankOfCard =  String.valueOf( hand.getACard(i).getRank() );
            suitOfCard =  String.valueOf( hand.getACard(i).getSuit() );
            container1 += sym.switchFrame("lU") + String.format( sym.gethL(5) ) + sym.switchFrame("rU") ;
            container2 += sym.switchFrame("vL") + String.format("%s", sym.switchRank(rankOfCard).length() == 2 ? sym.switchRank(rankOfCard) : sym.switchRank(rankOfCard) + " ") + "   "+ sym.switchFrame("vL");
            container3 += sym.switchFrame("vL") + String.format("  " + "%s"  + "  ", sym.switchSuit(suitOfCard) ) + sym.switchFrame("vL");
            container4 += sym.switchFrame("vL") + String.format("   %2.2s", sym.switchRank(rankOfCard).length() == 2 ? sym.switchRank(rankOfCard)  + "" : sym.switchRank(rankOfCard)) + sym.switchFrame("vL");
            container5 += sym.switchFrame("lD") + String.format( sym.gethL(5) + sym.switchFrame("rD") );
            fillContainer();
        }
        clearString();
        console.print(containerT);
    }

    public void drawDices(Integer[] dices){
        String containerT = "";
        Symbols sym = new Symbols();
        for (int i = 0; i < dices.length; i++) {
            container1 += sym.switchDie(i + 1)[0];
            container2 += sym.switchDie(i + 1)[1];
            container3 += sym.switchDie(i + 1)[2];
            container4 += sym.switchDie(i + 1)[3];
            container5 += sym.switchDie(i + 1)[4];
            fillContainer();
        }
        clearString();
        console.print(containerT);
    }

    public void clearString(){
        this.container1 = "";
        this.container2 = "";
        this.container3 = "";
        this.container4 = "";
        this.container5 = "";
    }

    public void fillContainer(){
        this.containerT = container1 + "\n" + container2 + "\n"
                + container3 + "\n" + container4 + "\n" + container5;
    }


    public void setConsole(Console console){
        this.console = console;
    }

}
