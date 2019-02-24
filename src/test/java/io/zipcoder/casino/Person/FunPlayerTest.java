package io.zipcoder.casino.Person;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunPlayerTest {

    @Test
    public void constructorTest(){
        String name = "guy";
        FunPlayer guy = new FunPlayer(name);

        Assert.assertEquals(name, guy.getName());


    }

}