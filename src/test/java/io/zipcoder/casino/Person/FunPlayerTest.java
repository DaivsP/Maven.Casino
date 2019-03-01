package io.zipcoder.casino.Person;

import io.zipcoder.casino.Person.fun.FunPlayer;
import org.junit.Assert;
import org.junit.Test;

public class FunPlayerTest {

    @Test
    public void constructorTest(){
        String name = "guy";
        FunPlayer guy = new FunPlayer(name);

        Assert.assertEquals(name, guy.getName());


    }

}