package io.zipcoder.casino.player;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.cardgames.BlackJack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackPlayerTests {


    @Test
    public void BlackJackPlayerConstructorTest() {
        //Given
        Player newPlayer = new Player(100, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        //Then
        Assert.assertNotNull(testPlayer);
    }

    @Test
    public void betMoneyTest1() {
        //Given
        Integer blackJackBet = 15;
        Player newPlayer = new Player(100, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        //When
        Integer actualOutput = testPlayer.betMoney();
        Integer expectedOutput = blackJackBet;

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void betMoneyTest2() {
        //Given
        Integer blackJackBet = 15;
        Player newPlayer = new Player(10, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        //When
        Integer actualOutput = testPlayer.betMoney();
        Integer expectedOutput = -1;

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void winMoneyTest() {
        //Given
        Integer blackJackBet = 15;
        Player newPlayer = new Player(100, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        //When
        testPlayer.betMoney();
        testPlayer.winMoney();
        Integer expectedOutput = 115;
        Integer actualOutput = newPlayer.getMoney();

        //Then
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void getMoneyTest(){
        //Given
        Integer blackJackBet = 15;
        Player newPlayer = new Player(100, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        int retrievedMoney = testPlayer.getMoney();

        //Then
        Assert.assertEquals(retrievedMoney,100);
    }


    @Test
    public void getBetAmountTest() {
        //Given
        Player newPlayer = new Player(100, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        //When
        Integer expectedOutput = 15;
        Integer actualOutput = BlackJackPlayer.getBlackJackBetAmount();

        //Then
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void enoughMoneyToBetTest() {
        //Given
        Player newPlayer = new Player(100, "Kate");
        BlackJackPlayer testPlayer = new BlackJackPlayer(newPlayer);

        //Then
        Assert.assertTrue(testPlayer.enoughMoneyToBet());
    }
}
