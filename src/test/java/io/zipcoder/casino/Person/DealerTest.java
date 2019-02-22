package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest {

    @Test
    public void collect() {
    }
    @Test
    public void getNameTest() {

        String name = "The Dealer";
        Dealer dealer = new Dealer();

        String expected = "The Dealer";
        String actual = dealer.getName();

        Assert.assertEquals(expected, actual);
    }

}