package io.zipcoder.casino;


import io.zipcoder.casino.utilities.GameType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class CasinoTest {

    private PrintStream oldPrintStream;
    ByteArrayOutputStream testOutStream;
    String playerName;
    Integer startingMoney;

    @Before
    public void setup() {
        playerName = "Kate";
        startingMoney = 90;
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
    public void getGameValidationTest1() {
        //Given
        Casino testCasino = new Casino();
        Integer gameSelection = 1;
        GameType expectedOutput = GameType.BlackJack;
        Player testPlayer = new Player(startingMoney, playerName);

        //When
        GameType actualOutput = testCasino.gameValidation(gameSelection, testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameValidationTest2() {
        //Given
        Casino testCasino = new Casino();
        Integer gameSelection = 2;
        GameType expectedOutput = GameType.ChuckALuck;
        Player testPlayer = new Player(startingMoney, playerName);

        //When
        GameType actualOutput = testCasino.gameValidation(gameSelection, testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameValidationTest3() {
        //Given
        Casino testCasino = new Casino();
        Integer gameSelection = 3;
        GameType expectedOutput = GameType.Crapes;
        Player testPlayer = new Player(startingMoney, playerName);

        //When
        GameType actualOutput = testCasino.gameValidation(gameSelection, testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getGameValidationTest4() {
        //Given
        Casino testCasino = new Casino();
        Integer gameSelection = 4;
        GameType expectedOutput = GameType.GoFish;
        Player testPlayer = new Player(startingMoney, playerName);

        //When
        GameType actualOutput = testCasino.gameValidation(gameSelection, testPlayer);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void validateBlackJackTest1() {
        //Given
        Casino testCasino = new Casino();
        Player testPlayer = new Player(startingMoney, playerName);

        //Then
        Assert.assertTrue(testCasino.validateBlackJack(testPlayer));
    }

    @Test
    public void validateBlackJackTest2() {
        //Not sure how to test this
    }

    @Test
    public void validateCrapsTest1() {
        //Given
        Casino testCasino = new Casino();
        Player testPlayer = new Player(startingMoney, playerName);

        //Then
        Assert.assertTrue(testCasino.validateCraps(testPlayer));
    }

    @Test
    public void validateCrapsTest2() {
        //Not sure how to test this
    }
}
