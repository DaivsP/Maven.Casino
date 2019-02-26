package io.zipcoder.casino;

import io.zipcoder.casino.Games.DiceGames;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Symbols;
import sun.font.Decoration;


public class DecorationCards {

    Integer setDelay = 0;
    Console console ;

    public DecorationCards(){
        this.console = new Console(System.in, System.out);
    }

    public void drawHand( Hand hand ){
        Symbols sym = new Symbols();
        String suitOfCard = "";
        String rankOfCard = "";

        String containerT = "";
        String container1 = "";
        String container2 = "";
        String container3 = "";
        String container4 = "";
        String container5 = "";

        for (int i = 0; i < hand.getNumberOfCards(); i++) {
            rankOfCard =  String.valueOf( hand.getACard(i).getRank() );
            suitOfCard =  String.valueOf( hand.getACard(i).getSuit() );

            container1 += sym.switchFrame("lU") + String.format( sym.gethL(5) ) + sym.switchFrame("rU") ;
            container2 += sym.switchFrame("vL") + String.format("%s", sym.switchRank(rankOfCard).length() == 2 ? sym.switchRank(rankOfCard) : sym.switchRank(rankOfCard) + " ") + "   "+ sym.switchFrame("vL");
            container3 += sym.switchFrame("vL") + String.format("  " + "%s"  + "  ", sym.switchSuit(suitOfCard) ) + sym.switchFrame("vL");
            container4 += sym.switchFrame("vL") + String.format("   %2.2s", sym.switchRank(rankOfCard).length() == 2 ? sym.switchRank(rankOfCard)  + "" : sym.switchRank(rankOfCard)) + sym.switchFrame("vL");
            container5 += sym.switchFrame("lD") + String.format( sym.gethL(5) + sym.switchFrame("rD") );

            containerT = container1 + "\n" + container2 + "\n"
                    + container3 + "\n" + container4 + "\n" + container5;
        }
        console.print(containerT);
    }

//    public void drawDies(Die die){
//        String containerT = "";
//
//        console.print( containerT );
//
//    }

//    public static void main(String[] args) {
//        DecorationCards decoration = new DecorationCards();
//        DiceGames setDices = new DiceGames();
//        Die die = new Die();
//        Symbols sym = new Symbols();
////        setDices.toss(die,1);
////        Integer number = 1;
//        System.out.println( setDices.toss(die,1) );
//        String container1 = "";
//        String container2 = "";
//        String container3 = "";
//        String container4 = "";
//        String container5 = "";
//        String containerT = "";
//
//        container1 += sym.switchFrame("lU") + String.format( sym.gethL(5) ) + sym.switchFrame("rU") ;
//        container2 += sym.switchFrame("vL") + String.format("%s",sym.getCircle(1) ) + " " + sym.switchFrame("vL");
//        container3 += sym.switchFrame("vL") + String.format("%s","* * *") + sym.switchFrame("vL");
//        container4 += sym.switchFrame("vL") + String.format("%s","* * *") + sym.switchFrame("vL");
//        container5 += sym.switchFrame("lD") + String.format( sym.gethL(5) + sym.switchFrame("rD") );
//
//        containerT = container1 + "\n" + container2 + "\n" + container3
//                + "\n" + container4 + "\n" + container5;
//        System.out.println( containerT );
//    }
}
