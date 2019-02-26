package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Symbols;


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

        String totalContainer = "";
        String fistContainer = "";
        String secondContainer = "";
        String thirdContainer = "";
        String fourContainer = "";
        String fifthContainer = "";

        for (int i = 0; i < hand.getNumberOfCards(); i++) {
            rankOfCard =  String.valueOf( hand.getACard(i).getRank() );
            suitOfCard =  String.valueOf( hand.getACard(i).getSuit() );

            fistContainer += String.format( sym.getlU() + sym.gethL(5) + sym.getrU() ) ;
            secondContainer += String.format( sym.getvL() + "%s" + "    " + sym.getvL(), sym.switchRank(rankOfCard));
            thirdContainer += String.format( sym.getvL() + "  "  + "%s"  + "  "      + sym.getvL(), sym.switchSuit(suitOfCard) );
            fourContainer += String.format( sym.getvL() + "    " + "%s"  + sym.getvL() ,sym.switchRank(rankOfCard) );
            fifthContainer += String.format( sym.getlD() + sym.gethL(5) + sym.getrD() );

            totalContainer = fistContainer + "\n" + secondContainer + "\n"
                    + thirdContainer + "\n" + fourContainer + "\n" + fifthContainer;
        }
        console.print(totalContainer);
    }


}
