package io.zipcoder.casino.utilities;

public class StringForSymbols {

    Symbols sym = new Symbols();

    public static String[] getFirstAndLastLines(){
        Symbols sym = new Symbols();
        String initialLine = sym.switchFrame("lU") + sym.gethL(7) + sym.switchFrame("rU");
        String finalLine = sym.switchFrame("lD") + sym.gethL(7) + sym.switchFrame("rD");
        String[] result = new String[]{initialLine,finalLine};
        return result;
    }

    public String[] getOne(){

        return new String[]{getFirstAndLastLines()[0]
                , sym.switchFrame("vL") + "  "     + sym.getBullet(0) + "     " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "   "    + sym.getBullet(1) +  "   "  + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "      " + sym.getBullet(0) +  " "    + sym.switchFrame("vL")
                , getFirstAndLastLines()[1]};
    }

    public String[] getTwo(){
        return new String[] { getFirstAndLastLines()[0]
                , sym.switchFrame("vL") + " "     + sym.getBullet(1) + "     "  + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "  "    + sym.getBullet(0) +  "     " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "     " + sym.getBullet(1) +  " "     + sym.switchFrame("vL")
                , getFirstAndLastLines()[1]};
    }

    public String[] getThree(){
        return new String[] { getFirstAndLastLines()[0]
                , sym.switchFrame("vL") + " "     + sym.getBullet(1) + "     " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "   "   + sym.getBullet(1) + "   "   + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "     " + sym.getBullet(1) +  " "    + sym.switchFrame("vL")
                , getFirstAndLastLines()[1]};
    }

    public String[] getFour(){
        return new String[] { getFirstAndLastLines()[0]
                , sym.switchFrame("vL") + " "  + sym.getBullet(1) + "   "    + sym.getBullet(1) + " " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "  " + sym.getBullet(0) +  "     " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + " "  + sym.getBullet(1) + "   "    + sym.getBullet(1) + " " + sym.switchFrame("vL")
                , getFirstAndLastLines()[1]};
    }

    public String[] getFive(){
        return new String[] { getFirstAndLastLines()[0]
                , sym.switchFrame("vL") + " " +   sym.getBullet(1) + "   " +  sym.getBullet(1) + " " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "   " + sym.getBullet(1) +  "   " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + " " +   sym.getBullet(1) + "   " +  sym.getBullet(1) + " " + sym.switchFrame("vL")
                , getFirstAndLastLines()[1]};
    }

    public String[] getSix(){
        return new String[] { getFirstAndLastLines()[0]
                , sym.switchFrame("vL") + " " +   sym.getBullet(1) + " " +     sym.getBullet(1) + " " + sym.getBullet(1) + " " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + "   " + sym.getBullet(0) +  "    " + sym.switchFrame("vL")
                , sym.switchFrame("vL") + " " +   sym.getBullet(1) + " " +     sym.getBullet(1) + " " + sym.getBullet(1) + " " + sym.switchFrame("vL")
                , getFirstAndLastLines()[1]};
        }
}
