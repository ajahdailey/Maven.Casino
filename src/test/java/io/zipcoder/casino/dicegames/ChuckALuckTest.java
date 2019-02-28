package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.dicegames.ChuckALuck.ChuckALuck;
import io.zipcoder.casino.dicegames.DiceUtilities.Dice;
import io.zipcoder.casino.dicegames.ChuckALuck.IOChuckALuckConsole;
import io.zipcoder.casino.dicegames.DiceUtilities.DicePlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ChuckALuckTest { ChuckALuck game;

    @Before
    public void setup(){
        Player player = new Player(10, "A");
        DicePlayer dicePlayer = new DicePlayer(player);
        game = new ChuckALuck(dicePlayer);
    }

    @Test
    public void chuckALuckConstructorTest() {
        DicePlayer newPlayer = new DicePlayer();
        ChuckALuck newgame = new ChuckALuck(newPlayer);

        Assert.assertNotNull(newgame);
    }

    @Test
    public void getResult_whenThereIsNoMatch() {
        //Given
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(1);
        diceResults.add(3);
        diceResults.add(6);
        int expected = 0;

        int actualMatch = game.getMatches(userGuesses, diceResults);

        Assert.assertEquals(expected, actualMatch);
    }
    @Test
    public void getResult_whenThereIsMatch2() {
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(1);
        diceResults.add(5);
        diceResults.add(6);

        int expected = 1;
        int actualMatch = game.getMatches(userGuesses, diceResults);

        Assert.assertEquals(expected, actualMatch);
    }
    @Test
    public void getResult_whenThereIsMatch3() {
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(5);
        diceResults.add(4);
        diceResults.add(2);
        int expected = 3;

        int actualMatch = game.getMatches(userGuesses, diceResults);
        Assert.assertEquals(expected, actualMatch);
    }

    @Test
    public void getResult_whenThereIsOneMatch() {
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(4);
        diceResults.add(4);
        diceResults.add(1);

        int expected = 1;

        int actualMatch = game.getMatches(userGuesses, diceResults);
        Assert.assertEquals(expected, actualMatch);
    }

    @Test
    public void getResult_whenThereIsOneMatch1() {
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(4);
        diceResults.add(4);
        diceResults.add(4);

        int expected = 1;

        int actualMatch = game.getMatches(userGuesses, diceResults);
        Assert.assertEquals(expected, actualMatch);
    }

    @Test
    public void printResults() {
        Dice dice = new Dice(1);

        Player player = new Player(10, "A");
        DicePlayer dicePlayer = new DicePlayer(player);

        String input = "3\n1\n6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOChuckALuckConsole console = createConsole(inputStream, outputStream);

        ChuckALuck game = new ChuckALuck(dicePlayer, console);
        game.play();

        game.printResults();

        String output = outputStream.toString();

        boolean retrievedMatches = output.contains("You have " );
        Assert.assertTrue(retrievedMatches);
    }

    @Test
    public void testPlay(){
        Dice dice = new Dice(1);

        Player player = new Player(10, "A");
        DicePlayer dicePlayer = new DicePlayer(player);
        String input = "3\n1\n6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        IOChuckALuckConsole console = createConsole(inputStream, outputStream);
        ChuckALuck game = new ChuckALuck(dicePlayer, console);
        game.play();

        String output = outputStream.toString();
        Assert.assertTrue(output.contains("Guess the outcome"));
    }
    private IOChuckALuckConsole createConsole(ByteArrayInputStream inputStream, ByteArrayOutputStream outputStream) {
        Console c = new Console(inputStream, new PrintStream(outputStream));
        IOChuckALuckConsole console = new IOChuckALuckConsole(c);
        return console;
    }
}