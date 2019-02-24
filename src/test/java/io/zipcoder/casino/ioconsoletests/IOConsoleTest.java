package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class IOConsoleTest {

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
    public void startCasinoConsoleTest() {
        //Given
        String casinoStart = "777777777777777777777777\n" +
                "7                      7\n" +
                "7   THE SEVES CASINO   7\n" +
                "7    ____              7\n" +
                "7   /\\' .\\    _____    7\n" +
                "7  /: \\___\\  / .  /\\   7\n" +
                "7  \\' / . / /____/..\\  7\n" +
                "7   \\/___/  \\'  '\\  /  7\n" +
                "7            \\'__'\\/   7\n" +
                "7                      7\n" +
                "777777777777777777777777";
        String expectedOutput = String.format(casinoStart) + "\n";

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.startCasinoConsole();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void getPlayerNameTest() {
        //Given
        byte[] inputBytes = playerName.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        String actualOutput = casinoIO.getPlayerName();

        //Then
        Assert.assertEquals(playerName, actualOutput);
    }

    @Test
    public void printGameIntroTest() {
        //Given
        String gameIntro = "Welcome, %s. We have four games you can play. Black Jack and Craps require bets. Chuck-A-Luck and Go Fish do not. We've given you $100 to play in the betting games.";
        String expectedOutput = String.format(gameIntro, playerName) + "\n";

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.printGameIntro(playerName);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }


}
