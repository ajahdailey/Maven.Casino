package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;
import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void iOGoFishConsoleConstructorTest() {
        //Given
        String name = "Kate";
        IOGoFishConsole newConsole = new IOGoFishConsole(name);

        //Then
        Assert.assertNotNull(newConsole);
    }


    @Test
    public void goFishWelcomeMessageTest() {
        //Given
        String name = "John";
        String expected = String.format("Welcome %s, to the Go Fish room\n",name);

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.goFishWelcomeMessage();
        String actual = testOutStream.toString();



        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void cardToAskForMessageTest() {
        //Given
        String expected = "John has chosen a [Spade K].\n";
        String name = "John";
        int number = 4;
        Card card = new Card(13, SignType.Spade);


        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.cardToAskForMessage(card);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void doesNotHaveCardMessageTest() {
        //Given
        String expected = "John - Your opponent does not have a [K]. Go Fish!\n";
        String name = "John";
        Card card = new Card(13, SignType.Spade);

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.doesNotHaveCardMessage(card);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

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
        String expected = "John have taken the [4] from his opponent. John have a match.\n" +
                "You have a match in your hand.\n" +
                "John have taken the [5] from his opponent. John have a match.\n" +
                "You have a match in your hand.\n" +
                "John have taken the [5] from his opponent. John have a match.\n";
        String name = "John";
        Card card = new Card(5,SignType.Spade);

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);


        goFishConsole.doesHaveCardMessage(new Card(4, SignType.Clover));


        goFishConsole.doesHaveCardMessage();



        goFishConsole.doesHaveCardMessage(card);



        goFishConsole.doesHaveCardMessage();


        goFishConsole.doesHaveCardMessage(card);
        //goFishConsole.doesHaveCardMessage();

        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void winningMessage() {
        //Given
        String expected = "Mark have won! Would you like to play again?\n";
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
    public void printResultTest() {
        //Given
        String expected = "Java have won! Would you like to play again?\n";
        String name = "Java";

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.printResult(true);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void pickACardForPlayerMessageTest() {
        //Given
        String expected = "What card would the player like to choose?\n[5]\n";
        String name = "Java";
        List<Card> hand = new ArrayList<>();
        Card card = new Card(5,SignType.Spade);
        hand.add(card);

        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        //Todo: Fix it
        //goFishConsole.pickACardForPlayerMessage(hand);
        String actual = testOutStream.toString();

        //Then
        //Assert.assertEquals(expected,actual);

    }


    @Test
    public void displayCurrentHandMessageTest() {
        //Given
        String expected =   "┌─────────┐ ┌─────────┐ \n"+
                            "│5        │ │7        │ \n"+
                            "│         │ │         │ \n"+
                            "│    ♠    │ │    ♠    │ \n"+
                            "│         │ │         │ \n"+
                            "│       5 │ │       7 │ \n"+
                            "└─────────┘ └─────────┘ \n";
        String name = "Java";
        List<Card> hand = new ArrayList<>();
        Card card = new Card(5,SignType.Spade);
        Card card2 = new Card(7,SignType.Spade);
        hand.add(card);
        hand.add(card2);


        //When
        IOGoFishConsole goFishConsole = new IOGoFishConsole(name);
        goFishConsole.displayCurrentHand(hand);
        String actual = testOutStream.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }

}