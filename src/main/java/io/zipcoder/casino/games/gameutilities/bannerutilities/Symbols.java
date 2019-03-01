package io.zipcoder.casino.games.gameutilities.bannerutilities;

public class Symbols {


    public String switchFrame(String side){
        switch (side){
            case "lU" :
                return Character.toString((char) 0x250C );
            case "lD" :
                return Character.toString((char) 0x2514 );
            case "rU" :
                return Character.toString((char) 0x2510 );
            case "rD" :
                return Character.toString((char) 0x2518 );
            case "hL" :
                return Character.toString((char) 0x2500 );
            case "vL" :
                return Character.toString((char) 0x2502 );
            default:
                return null;
        }
    }

    String hL = Character.toString((char) 0x2500 ); // Horizontal Line

    public String gethL(Integer number){
        String result = "";
        for (int i = 0; i < number; i++) {
            result += this.hL;
        }
        return result;
    }



    public String switchRank(String rankCard){
        switch ( rankCard ) {
            case "ACE" :
                return "A";
            case "KING" :
                return "K";
            case "QUEEN" :
                return "Q";
            case "JACK" :
                return "J";
            case "TEN" :
                return "10";
            case "NINE" :
                return "9";
            case "EIGHT" :
                return "8";
            case "SEVEN" :
                return "7";
            case "SIX" :
                return "6";
            case "FIVE" :
                return "5";
            case "FOUR" :
                return "4";
            case "THREE" :
                return "3";
            case "TWO" :
                return "2";
            default:
                return "?";
        }
    }

    public String switchSuit(String suitCard){
        switch ( suitCard ) {
            case "HEARTS" :
                return Character.toString((char) 0x2665 );
            case "SPADES" :
                return Character.toString((char) 0x2660 );
            case "DIAMONDS" :
                return Character.toString((char) 0x2666 );
            case "CLUBS" :
                return Character.toString((char) 0x2663 );
            default: return "?";
        }
    }

    public String getBullet(Integer number){
        String result = "";
        for (int i = 0; i < number; i++) {
            result += Character.toString((char) 0x25CF );
        }
        return result;
    }

    public String[] switchDie(Integer number){
        String initialLine = switchFrame("lU") + gethL(7) + switchFrame("rU");
        String finalLine = switchFrame("lD") + gethL(7) + switchFrame("rD");
        switch (number){
            case 1 :
                return new String[]{initialLine
                         , switchFrame("vL") + "  " +  getBullet(0) + "     " + switchFrame("vL")
                         , switchFrame("vL") + "   " + getBullet(1) +  "   " + switchFrame("vL")
                         , switchFrame("vL") + "      " + getBullet(0) +  " " + switchFrame("vL")
                         , finalLine};
            case 2 :
                return new String[]{initialLine
                        , switchFrame("vL") + " " +  getBullet(1) + "     " + switchFrame("vL")
                        , switchFrame("vL") + "  " + getBullet(0) +  "     " + switchFrame("vL")
                        , switchFrame("vL") + "     " + getBullet(1) +  " " + switchFrame("vL")
                        , finalLine};
            case 3 :
                return new String[]{initialLine
                        , switchFrame("vL") + " " +  getBullet(1) + "     " + switchFrame("vL")
                        , switchFrame("vL") + "   " + getBullet(1) + "   " + switchFrame("vL")
                        , switchFrame("vL") + "     " + getBullet(1) +  " " + switchFrame("vL")
                        , finalLine};
            case 4 :
                return new String[]{initialLine
                        , switchFrame("vL") + " " + getBullet(1) + "   " + getBullet(1) + " " + switchFrame("vL")
                        , switchFrame("vL") + "  " + getBullet(0) +  "     " + switchFrame("vL")
                        , switchFrame("vL") + " " + getBullet(1) + "   " + getBullet(1) + " " + switchFrame("vL")
                        , finalLine};
            case 5 :
                return new String[]{initialLine
                        , switchFrame("vL") + " " + getBullet(1) + "   " + getBullet(1) + " " + switchFrame("vL")
                        , switchFrame("vL") + "   " + getBullet(1) +  "   " + switchFrame("vL")
                        , switchFrame("vL") + " " + getBullet(1) + "   " + getBullet(1) + " " + switchFrame("vL")
                        , finalLine};
            case 6 :
                return new String[]{initialLine
                        , switchFrame("vL") + " " + getBullet(1) + " " + getBullet(1) + " " + getBullet(1) + " " + switchFrame("vL")
                        , switchFrame("vL") + "   " + getBullet(0) +  "    " + switchFrame("vL")
                        , switchFrame("vL") + " " + getBullet(1) + " " + getBullet(1) + " " + getBullet(1) + " " + switchFrame("vL")
                        , finalLine};
                default:
                    return null;
        }
    }

}
