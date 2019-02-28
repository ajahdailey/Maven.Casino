package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.dicegames.Craps.Craps;
import io.zipcoder.casino.dicegames.DiceUtilities.Dice;
import io.zipcoder.casino.dicegames.DiceUtilities.DiceGame;
import io.zipcoder.casino.dicegames.Craps.CrapsPlayer;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

public class DiceGameTest {

    @Test
    public void rollTest() {
        Integer[] toss1 = {1};
        Integer[] toss2 = {3};
        Dice dice = new DummyDiceForCrapsTest(toss1,toss2);
        DiceGame game = new Craps(new CrapsPlayer(new Player(100,"Aswathy")),
                new DummyIOForCrapsTest("Aswathy", false), dice);
        game.roll();
        Integer[] results = game.getResults();

        Assert.assertEquals(results[0], toss1[0]);
        Assert.assertEquals(results[1], toss2[0]);

    }

    @Test
    public void didWinTest(){
        DiceGame game = new Craps(null, null);
        game.setWin(true);;
        boolean retrievedWin = game.didWin();

        Assert.assertTrue(retrievedWin);
    }
}
