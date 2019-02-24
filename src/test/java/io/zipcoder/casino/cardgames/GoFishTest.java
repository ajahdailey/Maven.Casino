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
    Deck deck = new Deck(52);
    List<CardPlayer> playerList = new ArrayList<CardPlayer>();
    IOGoFishConsole console;
    CardPlayer player;
    //Facilitator facilitator= new Facilitator(playerList, deck);
    GoFish goFish = new GoFish(player, console);

    @Test
    public void playTest() {
        //Given
        Boolean expected = true;
        CardPlayer player;
        CardPlayer player1;

        //When
        goFish.play();

        //Then


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