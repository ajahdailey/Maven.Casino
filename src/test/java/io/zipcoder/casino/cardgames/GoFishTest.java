package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.Facilitator;
import io.zipcoder.casino.ioconsoles.IOGoFishConsole;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GoFishTest {

    @Test
    public void playTest() {

        int[] deckValues = {11,3,8,2,11,6,6,4,3,3,2,3,4,2};
        Deck deck = new DummyDeckForGoFishTest(deckValues);
        IOGoFishConsole console = new DummyIOForGoFishTest("Aswathy");

        GoFish game = new GoFish(new CardPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        game.printResults();
    }

    @Test
    public void evaluateGame() {
    }

    @Test
    public void exit() {
    }

    @Test
    public void takeTurn() {
    }
}