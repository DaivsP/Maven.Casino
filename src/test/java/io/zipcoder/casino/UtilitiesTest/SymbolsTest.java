package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.gameutilities.bannerutilities.Symbols;
import org.junit.Assert;
import org.junit.Test;

public class SymbolsTest {

    @Test
    public void switchFrameTest(){
        // Given
        Symbols symbols = new Symbols();

        // When
        String actual = symbols.switchFrame("");

        // Then
        Assert.assertNull(actual);
    }

    @Test
    public void switchFrameTest2(){
        // Given
        Symbols symbols = new Symbols();

        // When
        String expected = "─";
        String actual = symbols.switchFrame( "hL" );
        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void switchRankTest(){
        // Given
        Symbols symbols = new Symbols();
        String expected1 = "A";
        String expected2 = "2";
        String expected3 = "3";
        String expected4 = "4";
        String expected5 = "5";
        String expected6 = "6";
        String expected7 = "7";
        String expected8 = "8";
        String expected9 = "9";
        String expected10 = "10";
        String expected11 = "J";
        String expected12 = "Q";
        String expected13 = "K";
        String expected14 = "?";

        // When
        String actual1 = symbols.switchRank("ACE");
        String actual2 = symbols.switchRank("TWO");
        String actual3 = symbols.switchRank("THREE");
        String actual4 = symbols.switchRank("FOUR");
        String actual5 = symbols.switchRank("FIVE");
        String actual6 = symbols.switchRank("SIX");
        String actual7 = symbols.switchRank("SEVEN");
        String actual8 = symbols.switchRank("EIGHT");
        String actual9 = symbols.switchRank("NINE");
        String actual10 = symbols.switchRank("TEN");
        String actual11 = symbols.switchRank("JACK");
        String actual12 = symbols.switchRank("QUEEN");
        String actual13 = symbols.switchRank("KING");
        String actual14 = symbols.switchRank("");

        // Then
        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
        Assert.assertEquals(expected4,actual4);
        Assert.assertEquals(expected5,actual5);
        Assert.assertEquals(expected6,actual6);        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected7,actual7);
        Assert.assertEquals(expected8,actual8);
        Assert.assertEquals(expected9,actual9);
        Assert.assertEquals(expected10,actual10);
        Assert.assertEquals(expected11,actual11);
        Assert.assertEquals(expected12,actual12);
        Assert.assertEquals(expected13,actual13);
        Assert.assertEquals(expected14,actual14);
    }

    @Test
    public void switchSuitTest(){
        // Given
        Symbols symbols = new Symbols();
        String expected = "?";
        // When

        String actual = symbols.switchSuit("");
        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBulletTest(){
        // Given
        Symbols symbols = new Symbols();
        String expected = "●●";
        // When
        String actual = symbols.getBullet(2);
        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void switchDieTest(){
        // Given
        Symbols symbols = new Symbols();
        String expected1 = "┌───────┐";
        String expected2 = "┌───────┐";
        String expected3 = "┌───────┐";
        String expected4 = "┌───────┐";
        String expected5 = "┌───────┐";
        String expected6 = "┌───────┐";
        // When
        String actual1 = symbols.switchDie(1)[0];
        String actual2 = symbols.switchDie(2)[0];
        String actual3 = symbols.switchDie(3)[0];
        String actual4 = symbols.switchDie(4)[0];
        String actual5 = symbols.switchDie(5)[0];
        String actual6 = symbols.switchDie(6)[0];
        // Then
        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
        Assert.assertEquals(expected4,actual4);
        Assert.assertEquals(expected5,actual5);
        Assert.assertEquals(expected6,actual6);
    }

    @Test(expected=NullPointerException.class)
    public void switchDieTest2() {
        // Given
        Symbols symbols = new Symbols();
        // When
        String actual = symbols.switchDie(9)[0];
    }


}
