package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//import java.util.Scanner;

public class IOCrapsConsoleTest {

    private PrintStream oldPrintStream;
    private ByteArrayOutputStream testOutStream;
    private String playerName;

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
    public void iOCrapsConsoleConstructorTest() {
        //Given
        IOCrapsConsole newConsole = new IOCrapsConsole(playerName);

        //Then
        Assert.assertNotNull(newConsole);
    }

    @Test
    public void crapsWelcomeTest() {
        //Given
        String welcomeMessage = "" +
                "  ____\n" +
                " /\\' .\\    _____\n" +
                "/: \\___\\  / .  /\\\n" +
                "\\' / . / /____/..\\\n" +
                " \\/___/  \\'  '\\  /\n" +
                "          \\'__'\\/\n" +
                "WELCOME\n" +
                "TO CRAPS! \n" +
                "------------------\n" +
                "Let's play, %s!\n" +
                "------------------";
        String expectedOutput = String.format(welcomeMessage, playerName) +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.crapsWelcome();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void setPointMessageTest() {
        //Given
        String setPointMessage = "The set point is %d.";
        Integer setPoint = 4;
        String expectedOutput = String.format(setPointMessage, setPoint) +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.setPointMessage(setPoint);
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

    public void promptRollDice() {
        //Given
        String rollDiceMessage = "Time to roll the dice!";
        String expectedOutput = String.format(rollDiceMessage) +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        try {
            crapsIO.promptRollDice();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    @Test
    public void printContinueMessageTest() {
        //Given
        String continueMessage = "The set point wasn't rolled, so the game continues!\n";
        String expectedOutput = continueMessage +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.printContinueMessage();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }
    @Test
    public void printResultWin() {
        //Given
        String resultMessage = "Congratulations, you won!";
        String expectedOutput = resultMessage +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.printResult(true);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void printResultLose() {
        //Given
        String resultMessage = "Sorry, you lost!";
        String expectedOutput = resultMessage +"\n";

        //When
        IOCrapsConsole crapsIO = new IOCrapsConsole(playerName);
        crapsIO.printResult(false);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

}
