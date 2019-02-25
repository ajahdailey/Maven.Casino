package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.SignType;
import io.zipcoder.casino.ioconsoles.IOGoFishConsole;
import io.zipcoder.casino.player.Dealer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static io.zipcoder.casino.GameType.GoFish;
import static org.junit.Assert.*;

public class IOGoFishConsoleTest {
    Console goFishConsole;
    private PrintStream oldPrintStream;
    ByteArrayOutputStream testOutStream;

    @Before
    public void setup() {
        testOutStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOutStream);
        oldPrintStream = System.out;
        System.setOut(printStream);
    }

    @After
    public void cleanup() {
        System.setOut(oldPrintStream);
    }


//    @Test
//    public void goFishWelcomeMessageTest() {
//        //Given
//        String name = "John";
//        String expected = String.format("Welcome %s, to the Go Fish room\n",name);
//
//        //When
//        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
//        goFishConsole.goFishWelcomeMessage(name);
//        String actual = testOutStream.toString();
//
//
//
//        //Then
//        Assert.assertEquals(expected,actual);
//
//    }
//
//    @Test
//    public void cardToAskForMessageTest() {
//        //Given
//        String expected = "John has chosen the number 4.\n";
//        String name = "John";
//        int number = 4;
//        Card card = new Card(13, SignType.Spade);
//
//
//        //When
//        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
//        goFishConsole.cardToAskForMessage(name, card);
//        String actual = testOutStream.toString();
//
//        //Then
//        Assert.assertEquals(expected,actual);
//
//    }
//
//    @Test
//    public void doesNotHaveCardMessageTest() {
//        //Given
//        String expected = "Dealer does not have the card you requested. Go Fish!\n";
//        String name = "John";
//
//        //When
//        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
//        goFishConsole.doesNotHaveCardMessage();
//        String actual = testOutStream.toString();
//
//        //Then
//        Assert.assertEquals(expected,actual);
//    }

    @Test
    public void distributeCardMessageTest() {
        //Given
        String expected = "The dealer has distributed the cards.\n";
        String name = "John";


        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.distributeCardMessage();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void doesHaveCardMessageTest() {
        //Given
        String expected = "You have taken the number 4 from the dealer. You have a match.\n";
        String name = "John";

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.doesHaveCardMessage(4);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void winningMessage() {
        //Given
        String expected = "You have won! Would you like to play again?\n";
        String name = "Mark";

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.winningMessage();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void losingMessage() {
        //Given
        String expected = "You Lose. Would you like to try again?\n";
        String name = "Java";

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.losingMessage();
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void resultTest() {
        //Given
        String expected = "You have won! Would you like to play again?\n";
        String name = "Java";

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.result(true);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

}