package io.zipcoder.casino.cardgames;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardGameTest {

    @Test
    public void didWin() {
        //Given
        CardGame cardGame = new MockCardGame();
        Boolean expected = false;
        //When
        Boolean actual = cardGame.didWin();
        //Then
        Assert.assertEquals(expected, actual);


    }

    class MockCardGame extends CardGame {

        @Override
        public void takeTurn() {

        }

        @Override
        public void play() {

        }

        @Override
        public void exit() {

        }

        @Override
        public void printResults() {

        }
    }
}