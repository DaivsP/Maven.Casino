package io.zipcoder.casino.UtilitiesTest;

import io.zipcoder.casino.games.gameutilities.bannerutilities.Banners;
import io.zipcoder.casino.games.gameutilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

public class BannerTest {


    @Test
    public void printDelayTest(){
        // Given
        Banners ban = new Banners();
        String expected = "123";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.printDelay("123",1);
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getCasinoBannerTest(){
        Banners ban = new Banners();
        String expected = "*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getCasinoBanner();
        String actual = outputStream.toString();
        actual = actual.substring(actual.indexOf('*'),10);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBlackjackBannerTest(){
        Banners ban = new Banners();
        String expected = "*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getBlackjackBanner();
        String actual = outputStream.toString();
        actual = actual.substring(actual.indexOf('*'),10);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getCrapsBannerTest(){
        Banners ban = new Banners();
        String expected = "*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getCrapsBanner();
        String actual = outputStream.toString();
        actual = actual.substring(actual.indexOf('*'),10);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getGoFishBannerTest(){
        Banners ban = new Banners();
        String expected = "*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getGoFishBanner();
        String actual = outputStream.toString();
        actual = actual.substring(actual.indexOf('*'),10);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getHighLowBannerTest(){
        Banners ban = new Banners();
        String expected = "*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getHighLowBanner();
        String actual = outputStream.toString();
        actual = actual.substring(actual.indexOf('*'),10);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getOutOfFundsBannerTest(){
        Banners ban = new Banners();
        String expected = "*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getOutOfFundsBanner();
        String actual = outputStream.toString();
        actual = actual.substring(actual.indexOf('*'),10);

        // Then
        Assert.assertEquals(expected,actual);
    }
}
