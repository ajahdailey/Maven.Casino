package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class IOConsoleTest {
    //start game
    //what kind of bet do you want to make pass/no pass
    //how much do you want to bet
    //Dice roll one -->
        // win
        // lose
        // set point
    //roll two
        //

    @Test
    public void startCrapsGameTest() {
        //Given
        String playerName = "Kate";
        String outPutString = "Welcome to craps, %s. Let's play!";
        String expectedOutput = String.format(outPutString, playerName);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOCrapsConsole testCrapsConsole = new IOCrapsConsole(playerName);

        //When

        testCrapsConsole.startCrapsGame();
        String actualOutput = outputStream.toString();

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    // Given
//    String expected = String.format(outputString, stringArguments);
//    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    Console console = new Console(System.in, System.out);
////        IOCrapsConsole console = new IOCrapsConsole();
//
//    // When
//        console.println(outputString, stringArguments);
//    String actual = outputStream.toString();
//
//    // Then
//        Assert.assertEquals(expected, actual);
//



    @Test
    public void promptRollDiceTest() {
        //Given

        //When

        //Then


    }

    @Test
    public void printOutcomeTest() {
        //Given

        //When

        //Then
    }

    @Test
    public void printResultTest() {
        //Given

        //When

        //Then
    }

    @Test
    public void getBetMoneyTest() {

        //Given

        //When

        //Then

    }

    @Test
    public void passOrNotPassTest() {

    }




}
