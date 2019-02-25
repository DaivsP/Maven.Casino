package io.zipcoder.casino.utilities;

public class Symbols {


    String lU = Character.toString((char) 0x250C ); // Corner Left Up
    String lD = Character.toString((char) 0x2514 ); // Corner Left Down
    String rU = Character.toString((char) 0x2510 ); // Corner Right Up
    String rD = Character.toString((char) 0x2518 ); // Corner Right Down
    String hL = Character.toString((char) 0x2500 ); // Horizontal Line
    String vL = Character.toString((char) 0x2502 ); // Vertical Line

    String sS = Character.toString((char) 0x2660 ); // Symbol Spades to print on Card
    String sH = Character.toString((char) 0x2665 ); // Symbol Hearth to print on Card
    String sD = Character.toString((char) 0x2666 ); // Symbol Diamonds to print on Card
    String sC = Character.toString((char) 0x2663 ); // Symbol Clubs to print on Card

    String sA = "A"; // Letter A to print on Card
    String sK = "K"; // Letter K to print on Card
    String sQ = "Q"; // Letter Q to print on Card
    String sJ = "J"; // Letter J to print on Card
    String sT = "X"; // Letter K to print on Card
    String s9 = "9"; // Letter 9 to print on Card
    String s8 = "8"; // Letter 8 to print on Card
    String s7 = "7"; // Letter 7 to print on Card
    String s6 = "6"; // Letter 6 to print on Card
    String s5 = "5"; // Letter 5 to print on Card
    String s4 = "4"; // Letter 4 to print on Card
    String s3 = "3"; // Letter 3 to print on Card
    String s2 = "2"; // Letter 2 to print on Card
    String sM = "?"; // Letter 2 to print on Card

    public String getlU(){
        return this.lU;
    }

    public String getlD(){
        return this.lD;
    }

    public String getrU(){
        return this.rU;
    }

    public String getrD(){
        return this.rD;
    }

    public String gethL(){
        return this.hL;
    }

    public String gethL(Integer number){
        String result = "";
        for (int i = 0; i < number; i++) {
            result += this.hL;
        }
        return result;
    }

    public String getvL(){
        return this.vL;
    }

    public String getsS(){
        return this.sS;
    }

    public String getsH(){
        return this.sH;
    }

    public String getsD(){
        return this.sD;
    }

    public String getsC(){
        return this.sC;
    }

    public String switchRank(String rankCard){
        switch ( rankCard ) {
            case "ACE" :
                return sA;
            case "KING" :
                return sK;
            case "QUEEN" :
                return sQ;
            case "JAKE" :
                return sJ;
            case "TEN" :
                return sT;
            case "NINE" :
                return s9;
            case "EIGHT" :
                return s8;
            case "SEVEN" :
                return s7;
            case "SIX" :
                return s6;
            case "FIVE" :
                return s5;
            case "FOUR" :
                return s4;
            case "THREE" :
                return s3;
            case "TWO" :
                return s2;
            default: return sM;
        }
    }

    public String switchSuit(String suitCard){
        switch ( suitCard ) {
            case "HEARTS" :
                return sH;
            case "SPADES" :
                return sS;
            case "DIAMONDS" :
                return sD;
            case "CLUBS" :
                return sC;
            default: return sM;
        }
    }

}
