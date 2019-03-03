package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.GoFish.GoFish;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;
import io.zipcoder.casino.cardgames.GoFish.GoFishPlayer;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {

    @Test
    public void goFishConstructorTest() {
        //Given
        String name = "kate";
        IOGoFishConsole console = new IOGoFishConsole(name);
        Player player = new Player(100, name);
        GoFishPlayer newPlayer = new GoFishPlayer(player);
        GoFish newgame = new GoFish(newPlayer, console);

        //Then
        Assert.assertNotNull(newgame);
    }

    @Test
    public void playTestDealerWins() {

        int[] deckValues = {11,3,8,2,10,7,6,4,3,3,2,3,4,2};
        Deck deck = new DummyDeckForGoFishTest(deckValues);
        IOGoFishConsole console = new DummyIOForGoFishTest("Aswathy");

        GoFish game = new GoFish(new CardPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        game.printResults();
        boolean didwin =  game.didWin();
        Assert.assertFalse(didwin);
    }
    @Test
    public void playTestPlayerWins() {

        int[] deckValues = {10,2,8,2,11,6,6,4,3,3,2,11,4,2};
        Deck deck = new DummyDeckForGoFishTest(deckValues);
        IOGoFishConsole console = new DummyIOForGoFishTest("Aswathy");

        GoFish game = new GoFish(new CardPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        game.printResults();
        boolean didwin =  game.didWin();
        Assert.assertTrue(didwin);
    }
    @Test
    public void playTestPlayerQuits() {

        int[] deckValues = {11,2,8,2,11,6,6,4,3,3};
        Deck deck = new DummyDeckForGoFishTest(deckValues);
        IOGoFishConsole console = new DummyIOForGoFishTest("Aswathy", true);

        GoFish game = new GoFish(new CardPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        game.printResults();
        boolean didQuit =  game.isQuit();
        Assert.assertTrue(didQuit);
    }
    @Test
    public void exit() {
    }

    @Test
    public void takeTurn() {
    }
}