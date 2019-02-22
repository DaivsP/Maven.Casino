package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void getNameTest() {

        String name = "Timmay";
        Player player = new Player(name);

        String expected = "Timmay";
        String actual = player.getName();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void personConstructTest() {

        String name = null;
        Player player = new Player(name);

        String expected = null;
        String actual = player.getName();

        Assert.assertEquals(expected, actual);
    }

}