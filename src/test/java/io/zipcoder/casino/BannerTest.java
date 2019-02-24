package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;
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
        String expected = "\u001B[32m*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getCasinoBanner();
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected,actual.substring(0,10));
    }

    @Test
    public void getBlackjackBannerTest(){
        Banners ban = new Banners();
        String expected = "\u001B[36m*****";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ban.setConsole(new Console(System.in , new PrintStream(outputStream)));

        // When
        ban.getBlackjackBanner();
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected,actual.substring(0,10));
    }






}
