package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.CardGame;
import org.junit.Assert;
import org.junit.Test;

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
        public void printResults() {

        }
    }
}