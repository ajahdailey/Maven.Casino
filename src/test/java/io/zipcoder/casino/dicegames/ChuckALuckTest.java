package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.ioconsoles.IOChuckALuckConsole;
import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChuckALuckTest { ChuckALuck game;

    @Before
    public void setup(){
        Player player = new Player(10, "A");
        DicePlayer dicePlayer = new DicePlayer(player);

       game = new ChuckALuck(dicePlayer);
    }

    @Test
    public void chuckALuckConstructorTest() {
        //Given
        DicePlayer newPlayer = new DicePlayer();
        ChuckALuck newgame = new ChuckALuck(newPlayer);

        //Then
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

        //When
        int actualMatch = game.getMatches(userGuesses, diceResults);

        Assert.assertEquals(expected, actualMatch);
    }
    @Test
    public void getResult_whenThereIsNoMatch2() {
        //Given
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(1);
        diceResults.add(5);
        diceResults.add(6);

        int expected = 1;

        //When
        int actualMatch = game.getMatches(userGuesses, diceResults);

        Assert.assertEquals(expected, actualMatch);
    }
    @Test
    public void getResult_whenThereIsNoMatch3() {
        //Given
        List<Integer> userGuesses = new ArrayList<Integer>();
        userGuesses.add(5);
        userGuesses.add(2);
        userGuesses.add(4);

        List<Integer> diceResults = new ArrayList<Integer>();
        diceResults.add(5);
        diceResults.add(4);
        diceResults.add(2);

        int expected = 3;

        //When
        int actualMatch = game.getMatches(userGuesses, diceResults);

        Assert.assertEquals(expected, actualMatch);
    }

    @Test
    public void evaluateGame() {
        //sometimes pass
        //Given
        Random random = new Random(5);
        Dice dice = new Dice(1, random);

        Player player = new Player(10, "A");
        DicePlayer dicePlayer = new DicePlayer(player);

        String input = "3\n1\n6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOChuckALuckConsole console = createConsole(inputStream, outputStream);

        ChuckALuck game = new ChuckALuck(dicePlayer, console);
        game.play();

        //When
        game.printResults();

        //Then
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

        //When
        game.play();

        //Then
        String output = outputStream.toString();
        Assert.assertTrue(output.contains("Guess the outcome"));

    }

    private IOChuckALuckConsole createConsole(ByteArrayInputStream inputStream, ByteArrayOutputStream outputStream) {
        Console c = new Console(inputStream, new PrintStream(outputStream));
        IOChuckALuckConsole console = new IOChuckALuckConsole(c);
        return console;
    }

}