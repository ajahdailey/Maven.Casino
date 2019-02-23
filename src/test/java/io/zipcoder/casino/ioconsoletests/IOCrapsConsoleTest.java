package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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


    public void promptRollDice() {

    }

    public void printOutcome(Integer[] diceTossResults) {

    }


    public void printResult() {

    }

    public int getBetMoney() {
        return 0;
    }

    public void passOrNotPass() {

    }
}
