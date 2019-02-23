package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOCrapsConsoleTest {

    private PrintStream oldPrintStream;
    ByteArrayOutputStream testOutStream;
    String playerName;

    @Before
    public void setup() {
        playerName = "Kate";
        testOutStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOutStream);
        oldPrintStream = System.out;
        System.setOut(printStream);
    }

    @After
    public void cleanup() {
        System.setOut(oldPrintStream);
    }

    @Test
    public void crapsWelcomeTest() {
        //Given
        String welcomeMessage = "Welcome to craps, %s. Let's play!";
        String expectedOutput = String.format(welcomeMessage, playerName) +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.crapsWelcome();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);

    }
    @Test
    public void PassOrNotPassTest1() {
        //Given
        String typeOfBet = "P";
        byte[] inputBytes = typeOfBet.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName, inputByteArray );
        boolean actualOutput = crapsIO.passOrNotPass();

        //Then
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void PassOrNotPassTest2() {
        //Given
        String typeOfBet = "p";
        byte[] inputBytes = typeOfBet.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName, inputByteArray );
        boolean actualOutput = crapsIO.passOrNotPass();

        //Then
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void PassOrNotPassTest3() {
        //Given
        String typeOfBet = "NP";
        byte[] inputBytes = typeOfBet.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName, inputByteArray );
        boolean actualOutput = crapsIO.passOrNotPass();

        //Then
        Assert.assertFalse(actualOutput);
    }


    @Test
    public void promptRollDice() {
        //Given
        String rollDiceMessage = "Time to roll the dice!";
        String expectedOutput = String.format(rollDiceMessage) +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.promptRollDice();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void printTossOutcomeTest() {
        //Given
        String tossResultsMessage = "The number rolled is %d.";
        Integer tossResult = 4;
        String expectedOutput = String.format(tossResultsMessage, tossResult) +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.printTossOutcome(tossResult);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    public void printContinueMessage() {
        System.out.println("You did not win yet !! But good news is that you did not lose yet!! ");
    }

    public void printResult() {

    }


}
