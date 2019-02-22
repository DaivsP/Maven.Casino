package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getNameTest() {

        String name = "Timmay";
        Player player = new Player(name);

        String expected = "Timmay";
        String actual = player.getName();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void playerConstructTest() {

        String name = null;
        Player player = new Player(name);

        String expected = null;
        String actual = player.getName();

        Assert.assertEquals(expected, actual);
    }



}