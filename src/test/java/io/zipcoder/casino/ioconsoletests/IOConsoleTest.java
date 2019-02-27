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
    Integer startingMoney;

    @Before
    public void setup() {
        playerName = "Kate";
        startingMoney = 100;
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
    public void iOConsoleConstructorTest() {
        //Given
        IOConsole newConsole = new IOConsole();

        //Then
        Assert.assertNotNull(newConsole);
    }


    @Test
    public void startCasinoConsoleTest() {
        //Given
        String casinoStart = "" +
                "                                      ,`--.' |                    \n" +
                "  .--.--.                              |   :  :                    \n" +
                " /  /    '.                            |   |  '                    \n" +
                "|  :  /`. /                            '   :  |                    \n" +
                ";  |  |--`                 .---.       ;   |.'.--.--.              \n" +
                "|  :  ;_       ,---.     /.  ./|  ,---.'---' /  /    '             \n" +
                " \\  \\    `.   /     \\  .-' . ' | /     \\    |  :  /`./             \n" +
                "  `----.   \\ /    /  |/___/ \\: |/    /  |   |  :  ;_               \n" +
                "  __ \\  \\  |.    ' / |.   \\  ' .    ' / |    \\  \\    `.            \n" +
                " /  /`--'  /'   ;   /| \\   \\   '   ;   /|     `----.   \\           \n" +
                "'--'.     / '   |  / |  \\   \\  '   |  / |    /  /`--'  /           \n" +
                "  `--'---'  |   :    |   \\   \\ |   :    |   '--'.     /            \n" +
                "             \\   \\  /     '---\" \\   \\  /      `--'---'             \n" +
                "  ,----..     `----'             `----'                            \n" +
                " /   /   \\                           ,--,                          \n" +
                "|   :     :                        ,--.'|         ,---,    ,---.   \n" +
                ".   |  ;. /              .--.--.   |  |,      ,-+-. /  |  '   ,'\\  \n" +
                ".   ; /--`   ,--.--.    /  /    '  `--'_     ,--.'|'   | /   /   | \n" +
                ";   | ;     /       \\  |  :  /`./  ,' ,'|   |   |  ,\"' |.   ; ,. : \n" +
                "|   : |    .--.  .-. | |  :  ;_    '  | |   |   | /  | |'   | |: : \n" +
                ".   | '___  \\__\\/: . .  \\  \\    `. |  | :   |   | |  | |'   | .; : \n" +
                "'   ; : .'| ,\" .--.; |   `----.   \\'  : |__ |   | |  |/ |   :    | \n" +
                "'   | '/  :/  /  ,.  |  /  /`--'  /|  | '.'||   | |--'   \\   \\  /  \n" +
                "|   :    /;  :   .'   \\'--'.     / ;  :    ;|   |/        `----'   \n" +
                " \\   \\ .' |  ,     .-./  `--'---'  |  ,   / '---'                  \n" +
                "  `---`    `--`---'                 ---`-'                         \n\n\n";
//                "777777777777777777777777\n" +
//                "7                      7\n" +
//                "7   THE SEVES CASINO   7\n" +
//                "7    ____              7\n" +
//                "7   /\\' .\\    _____    7\n" +
//                "7  /: \\___\\  / .  /\\   7\n" +
//                "7  \\' / . / /____/..\\  7\n" +
//                "7   \\/___/  \\'  '\\  /  7\n" +
//                "7            \\'__'\\/   7\n" +
//                "7                      7\n" +
//                "777777777777777777777777\n";
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
    public void getStartingBetMoneyTest() {
        //Given
        String convertedExpected = startingMoney.toString();
        byte[] inputBytes = convertedExpected.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        Integer actualOutput = casinoIO.getStartingMoney();

        //Then
        Assert.assertEquals(startingMoney, actualOutput);
    }

//    @Test
//    public void getPlayer() {
//        //Given
//        byte[] inputBytes = playerName.getBytes();
//        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
//
//        //When
//        IOConsole casinoIO = new IOConsole(inputByteArray);
//        Player testPlayer = casinoIO.getPlayer();
//        String actualName = testPlayer.getName();
//        Integer expectedMoney = 100;
//        Integer actualMoney = testPlayer.getMoney();
//
//        //Then
//        Assert.assertEquals(playerName, actualName);
//        Assert.assertEquals(expectedMoney, actualMoney);
//    }

    @Test
    public void printGameIntroTest() {
        //Given
        String gameIntro = "\nWe have four games you can play, %s.\n\n" +
                "Black Jack and Craps require bets.\n\n" +
                "Chuck-A-Luck and Go Fish do not require bets.\n";
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
        Player testPlayer = new Player(startingMoney, playerName);
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection(testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameSelectionTest2() {
        //Given
        String gameSelection = "2";
        GameType expectedOutput = ChuckALuck;
        Player testPlayer = new Player(startingMoney, playerName);
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection(testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameSelectionTest3() {
        //Given
        String gameSelection = "3";
        GameType expectedOutput = Crapes;
        Player testPlayer = new Player(startingMoney, playerName);
        byte[] inputBytes = gameSelection.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection(testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameSelectionTest4() {
        //Given
        String gameSelection = "4";
        GameType expectedOutput = GoFish;
        byte[] inputBytes = gameSelection.getBytes();
        Player testPlayer = new Player(startingMoney, playerName);
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray);
        GameType actualOutput = casinoIO.getGameSelection(testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void printPlayerAccount() {
        //Given
        Integer balance = 90;
        String balanceMessage = "\n" +
                "------------------------------------------------------\n" +
                "Your current balance for betting games is $%d\n" +
                "------------------------------------------------------\n";
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
    public void goodbyeTest() {
        //Given
        String goodbyeMessage = "" +
                " _____\n" +
                "|A .  | _____\n" +
                "| /.\\ ||A ^  | _____\n" +
                "|(_._)|| / \\ ||A _  | _____\n" +
                "|  |  || \\ / || ( ) ||A_ _ |\n" +
                "|____V||  .  ||(_'_)||( v )|\n" +
                "       |____V||  |  || \\ / |\n" +
                "Thanks        |____V||  .  |\n" +
                "for playing!         |____V|\n" +
                "Goodbye, %s!\n";
        String expectedOutput = String.format(goodbyeMessage, playerName) + "\n";

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.goodbye(playerName);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void invalidMessageTest() {
        //Given
        String invalidMessage = "I'm sorry I didn't understand your selection. Please try again." + "\n";
        String expectedOutput = String.format(invalidMessage);

        //When
        IOConsole casinoIO = new IOConsole();
        casinoIO.invalidEntryMessage();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void notEnoughMoneyMessageTest() {
        //not sure how to test
    }

    @Test
    public void addMoneyMessageTest() {
        //Given
        Player testPlayer = new Player(startingMoney, playerName);
        Integer addMoney = 50;
        byte[] inputBytes = addMoney.toString().getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);

        //When
        IOConsole casinoIO = new IOConsole(inputByteArray );
        String expectedOutput = "How much would you like to add?\n" + "Your new balance is $150.\n\n";
        casinoIO.addMoneyMessage(testPlayer);
        String actualOutput = testOutStream.toString();
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
