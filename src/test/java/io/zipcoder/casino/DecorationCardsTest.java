package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DecorationCardsTest {

    @Test
    public void drawDicesTest(){
        // Given
        DecorationCards decoration = new DecorationCards();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        decoration.setConsole(new Console(System.in,new PrintStream(outputStream)));
        String expected = "┌───────┐┌───────┐" + "\n"
                        + "│ ●     ││ ●   ● │" + "\n"
                        + "│   ●   ││   ●   │" + "\n"
                        + "│     ● ││ ●   ● │" + "\n"
                        + "└───────┘└───────┘";
        // When
        decoration.drawDices(new Integer[]{3,5});
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected,actual);

    }
}
