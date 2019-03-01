package io.zipcoder.casino.games;

import io.zipcoder.casino.games.diegames.craps.Craps;
import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static io.zipcoder.casino.games.gameutilities.bannerutilities.AnsiScapeCodes.*;

public class CrapsTest {


    Console defautConsole;

    @Before
    public void setUp() {
        defautConsole = new Console(System.in, System.out);
    }

    @Test
    public void passLineChoiceTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "p".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        String expected = "p";

        //When
        String actual = craps.passLineChoice();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passLineChoiceTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "d".getBytes();
        ByteArrayInputStream inoutString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inoutString, System.out));
        String expected = "d";

        //When
        String actual = craps.passLineChoice();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsBetTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(500);
        byte[] inputBytes = "100".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = 100;

        //When
        Integer actual = craps.crapsBet(balance,0);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsBetTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(500);
        byte[] inputBytes = "100".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = 100;

        //When

        Integer actual = craps.crapsBet(balance,0);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetLoserTestPL() {
        //Given
        Integer pointer;
        Integer expected = 0;
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "9".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, System.out));

        //When
        pointer = craps.setPointerPL(balance, 5, 2);

        //Then
        Assert.assertEquals(expected, pointer);
    }

    @Test
    public void pointerSetWinnerTestPL() {
        //Given
        Integer expected = 105;
        Integer actual;
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);

        //When
        craps.setPointerPL(balance, 5, 7);
        actual = balance.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetNumberTestPL() {
        //Given
        Integer expected = 4;
        Integer bet = 0;
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);


        Integer actual = craps.setPointerPL(balance, 5, 4);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance();
        balance.setBalance(200);
        Integer bet = 100;
        Integer expected = 100;
        //When
        craps.crapsCollect(balance, bet);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance();
        balance.setBalance(500);
        Integer bet = 100;
        Integer expected = 700;
        //When
        craps.crapsPayout(balance, bet);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hedgeBetTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        byte[] inputBytes = "y".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer bet = 100;
        Integer expected = 200;
        //When
        Integer actual = craps.hedgeBet(balance, bet);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hedgeBetTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        byte[] inputBytes = "n".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer bet = 100;
        Integer expected = 100;
        //When
        Integer actual = craps.hedgeBet(balance, bet);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayPlayChoiceTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "y".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        //When
        boolean actual = craps.hardWayPlayChoice();
        //Then

        Assert.assertTrue(actual);

    }

    @Test
    public void hardWayPlayChoiceTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "n".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        //When
        boolean actual = craps.hardWayPlayChoice();
        //Then
        Assert.assertFalse(actual);

    }

    @Test
    public void hardWayNumberChoiceTest() {
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "4".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = 4;
        //When
        Integer actual = craps.hardWayNumberChoice();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayNumberChoiceTest2() {
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "5".getBytes();
        ByteArrayInputStream inputString = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputString, System.out));
        Integer expected = null;
        //When
        Integer actual = craps.hardWayNumberChoice();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayWinnings() {
        //Given
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        Integer expected = 700;
        //When
        craps.hardWayWinnings(balance,2, 2, 100, 4);
        Integer actual = balance.getBalance();
                //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayWinnings2() {
        //Given
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        Integer expected = 900;
        //When
        craps.hardWayWinnings(balance, 3, 3, 100, 6);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hardWayPayoutTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        Integer winnings = 1000;
        Integer expected = 2000;
        //When
        craps.hardWayPayout(balance, winnings);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betCheckTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        String expected = "\n\n***** Bet: 50 *****\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.betCheck(50);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundPLTest1() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\n***ROLL** (( "+ANSI_RED+"8"+ANSI_RESET+" )) **ROLL***\n" +
                             "\n***** You WIN! *****\n Winnings: "+ ANSI_GREEN +"100"+ ANSI_RESET+"\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundPL(balance, 100, 8, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundPLTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\n***ROLL** (( "+ANSI_RED+"2"+ANSI_RESET+" )) **ROLL***\n\nRoll Again\n\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundPL(balance, 100, 2, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundPLTest3() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\n***ROLL** (( "+ANSI_RED+"7"+ANSI_RESET+" )) **ROLL***\n" +
                "\n***** 7 OUT! Better Luck Next Time. *****\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundPL(balance, 100, 7, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundDPLTest1() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\n***ROLL** (( "+ANSI_RED+"5"+ANSI_RESET+" )) **ROLL***\n\nRoll Again\n\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundDPL(balance, 100, 5, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crapsRoundDPLTest2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\n***ROLL** (( "+ANSI_RED+"7"+ANSI_RESET+" )) **ROLL***\n" +
                                "\n***** You WIN! *****\n Winnings: "+ ANSI_GREEN +"100"+ ANSI_RESET+"\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundDPL(balance, 100, 7, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    //@Test
    public void crapsRoundDPLTest3() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\n***ROLL** (( "+ANSI_RED+"8"+ANSI_RESET+" )) **ROLL***\n\n***** Don't Pass Line Loses! Better Luck Next Time.\n***** Your balance is: 1000\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        craps.setConsole(new Console(System.in, new PrintStream(outputStream)));
        //When
        craps.crapsRoundDPL(balance, 100, 8, 8);
        String actual = outputStream.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void secondPhaseRollWithHardWayTest() {
        //Given
        Craps craps = new Craps(defautConsole);
        //When
        Integer expected = craps.secondPhaseRollWithHardWayCheck(100, 0, 0);
        //then
        Assert.assertTrue(expected >= 2 && expected <= 12);
    }

    @Test
    public void setPointerTestDPL() {
        //Given
        Integer expected = 4;
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);
        //When
        Integer actual = craps.setPointerDontPL(balance, 5, 4);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointerSetWinnerTestDPL() {
        //Given
        Integer pointer;
        Balance balance = new Balance(1000);
        Craps craps = new Craps(defautConsole);
        Integer expected = 1005;
        //When
        craps.setPointerDontPL(balance, 5, 2);
        Integer actual = balance.getBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPointerLoserDPL() {
        //Given
        Integer pointer;
        Integer expected = 0;
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "7".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, System.out));

        //When
        pointer = craps.setPointerDontPL(balance, 5, 7);

        //Then
        Assert.assertEquals(expected, pointer);
    }

    @Test
    public void setPointerLoserPrintOut() {
        //Given
        String expected = "\n***ROLL** (( "+ANSI_RED+"7"+ANSI_RESET+" )) **ROLL***\n\n"+
                "***** You Lose, Try Again! *****\n"+
                "Play another round? (Y)/(N)\n";
        Balance balance = new Balance(100);
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "7".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));

        //When
        craps.setPointerDontPL(balance, 100, 7);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPointerLoserPrintOut2() {
        //Given
        String expected = "\n***ROLL** (( "+ANSI_RED+"12"+ANSI_RESET+" )) **ROLL***\n\n"+
                "Push, Roll Again!\n";
        Balance balance = new Balance();
        Craps craps = new Craps(defautConsole);
        byte[] inputBytes = "12".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));

        //When
        craps.setPointerDontPL(balance, 5, 12);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void secondPhaseHardwayCheck() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        Integer expected = 900;
        byte[] inputBytes = "4".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, System.out));
        //when
        craps.hardWayWinnings(balance,1,3,100, 4);
        Integer actual = balance.getBalance();
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void secondPhaseHardwayCheck2() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nSoft 6 hit, You lost: "+ANSI_RED+"100"+ANSI_RESET+"\n";
        byte[] inputBytes = "6".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,2,4,100, 6);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void secondPhaseHardwayCheck3() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nSoft 8 hit, You lost: "+ANSI_RED+"100"+ANSI_RESET+"\n";
        byte[] inputBytes = "8".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,3,5,100, 8);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void secondPhaseHardwayCheck4() {
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nSoft 10 hit, You lost: "+ANSI_RED+"100"+ANSI_RESET+"\n";
        byte[] inputBytes = "10".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,6,4,100, 10);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void secondPhaseHardwayCheck5() {
        //Given
        Integer expectedInt = 1700;
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nHard Way HIT! You Win: "+ ANSI_GREEN +"700"+ ANSI_RESET+"\n";
        byte[] inputBytes = "4".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,2,2,100, 4);
        Integer actualInt = balance.getBalance();
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedInt, actualInt);

    }

    @Test
    public void secondPhaseHardwayCheck6() {
        //Given
        Integer expectedInt = 1900;
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nHard Way HIT! You Win: "+ ANSI_GREEN +"900"+ ANSI_RESET+"\n";
        byte[] inputBytes = "6".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,3,3,100, 6);
        Integer actualInt = balance.getBalance();
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedInt, actualInt);

    }

    @Test
    public void secondPhaseHardwayCheck7() {
        //Given
        Integer expectedInt = 1900;
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nHard Way HIT! You Win: "+ ANSI_GREEN +"900"+ ANSI_RESET+"\n";
        byte[] inputBytes = "8".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,4,4,100, 8);
        Integer actualInt = balance.getBalance();
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedInt, actualInt);

    }

    @Test
    public void secondPhaseHardwayCheck8() {
        //Given
        Integer expectedInt = 1700;
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(1000);
        String expected = "\nHard Way HIT! You Win: "+ ANSI_GREEN +"700"+ ANSI_RESET+"\n";
        byte[] inputBytes = "10".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hardWayWinnings(balance,5,5,100, 10);
        Integer actualInt = balance.getBalance();
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedInt, actualInt);

    }

    @Test
    public void hedgeBetCheck(){
        //Given
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(0);
        String expected = "Do you want to Hedge your Bet? (Y)/(N)\n" +
                            "Sorry but.... You're Broke.\n" +
                                "***** Balance: 0 *****\n\n\n";
        byte[] inputBytes = "y".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.hedgeBet(balance, 1000);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
    }

    //@Test
    public void crapsBetTest3(){
        Craps craps = new Craps(defautConsole);
        Balance balance = new Balance(0);
        String expected = "Do you want to Hedge your Bet? (Y)/(N)\n" +
                "Sorry but.... You're Broke.\n" +
                "***** Balance: 0 *****\n\n\n";
        byte[] inputBytes = "1000\r".getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        craps.setConsole(new Console(inputStream, new PrintStream(outputStream)));
        //when
        craps.crapsBet(balance, 0);
        String actual = outputStream.toString();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void balanceCheckTest(){
        //Given
        Balance balance = new Balance(1000);
        Craps craps = new Craps(defautConsole);
        String expected = "***** Balance: " + ANSI_BLUE + "1000" + ANSI_RESET + " *****";
        //When
        String actual = craps.balanceCheck(balance);
        //Then
        Assert.assertEquals(expected,actual);
    }

}