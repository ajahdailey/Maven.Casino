package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.CasinoConsole;
import io.zipcoder.casino.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CasinoConsoleTest {

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
        CasinoConsole newConsole = new CasinoConsole();

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
        CasinoConsole casinoIO = new CasinoConsole();
        casinoIO.casinoSign();
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
        CasinoConsole casinoIO = new CasinoConsole(inputByteArray);
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
        CasinoConsole casinoIO = new CasinoConsole(inputByteArray);
        Integer actualOutput = casinoIO.getStartingMoney();

        //Then
        Assert.assertEquals(startingMoney, actualOutput);
    }


    @Test
    public void printGameIntroTest() {
        //Given

        String gameIntro = "\nWe have four games you can play, %s.\n\n" +
                "Black Jack and Craps require bets.\n\n" +
                "Chuck-A-Luck and Go Fish do not require bets.\n";
        String expectedOutput = String.format(gameIntro, playerName) + "\n";


        //When
        CasinoConsole casinoIO = new CasinoConsole();
        casinoIO.printGameIntro(playerName);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actual);
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
        CasinoConsole casinoIO = new CasinoConsole();
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
        CasinoConsole casinoIO = new CasinoConsole(inputByteArray );
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
        CasinoConsole casinoIO = new CasinoConsole(inputByteArray );
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
        CasinoConsole casinoIO = new CasinoConsole(inputByteArray );
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
        CasinoConsole casinoIO = new CasinoConsole();
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
        CasinoConsole casinoIO = new CasinoConsole();
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
        CasinoConsole casinoIO = new CasinoConsole(inputByteArray );
        String expectedOutput = "How much would you like to add?\n" + "Your new balance is $150.\n\n";
        casinoIO.addMoneyMessage(testPlayer);
        String actualOutput = testOutStream.toString();
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
