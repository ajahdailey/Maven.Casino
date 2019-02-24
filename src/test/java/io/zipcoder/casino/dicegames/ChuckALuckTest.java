package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChuckALuckTest {
    ChuckALuck game;

    @Before
    public void setup(){
        Player player = new Player(10, "A");
        DicePlayer dicePlayer = new DicePlayer(player);

        game = new ChuckALuck(dicePlayer);
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

}