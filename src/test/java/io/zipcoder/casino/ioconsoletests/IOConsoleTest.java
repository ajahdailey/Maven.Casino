package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.GameType;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static io.zipcoder.casino.GameType.*;

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
        String gameIntro = "Welcome, %s. We have four games you can play.\n" +
                "Black Jack and Craps require bets. Chuck-A-Luck and Go Fish do not.\n" +
                "We've given you $100 to play in the betting games.\n" +
                "\n";
        String expectedOutput = String.format(gameIntro, playerName) + "\n";

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.printGameIntro(playerName);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void getGameSelectionTest1() {
        //Given
        String gameSelection = "1";
        GameType expectedOutput = BlackJack;
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection();

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameSelectionTest2() {
        //Given
        String gameSelection = "2";
        GameType expectedOutput = ChuckALuck;
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection();

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameSelectionTest3() {
        //Given
        String gameSelection = "3";
        GameType expectedOutput = Crapes;
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection();

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameSelectionTest4() {
        //Given
        String gameSelection = "4";
        GameType expectedOutput = GoFish;
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection();

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void printPlayerAccount() {
        //Given
        Integer balance = 90;
        String balanceMessage = "\nYour current balance for betting games is $%d";
        String expectedOutput = String.format(balanceMessage, balance) + "\n";

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.printPlayerAccount(balance);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void askPlayAgain1() {
        //Given
        String playAgain = "Y";
        byte[] inputBytes = playAgain.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray );
        boolean actualOutput = casinoIO.askPlayAgain();
        //Then
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void askPlayAgain2() {
        //Given
        String playAgain = "y";
        byte[] inputBytes = playAgain.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray );
        boolean actualOutput = casinoIO.askPlayAgain();
        //Then
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void askPlayAgain3() {
        //Given
        String playAgain = "N";
        byte[] inputBytes = playAgain.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray );
        boolean actualOutput = casinoIO.askPlayAgain();
        //Then
        Assert.assertFalse(actualOutput);
    }

    @Test
    public void goodbye() {
        //Given
        String goodbyeMessage = "Thanks for playing, %s. Goodbye!";
        String expectedOutput = String.format(goodbyeMessage, playerName) + "\n";

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.goodbye(playerName);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

}
