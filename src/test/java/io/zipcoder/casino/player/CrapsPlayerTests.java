package io.zipcoder.casino.player;

import org.junit.Assert;
import org.junit.Test;

public class CrapsPlayerTests {

    @Test
    public void crapsPlayerConstructorTest() {
        //Given
        Player newPlayer = new Player(100, "Kate");
        CrapsPlayer testPlayer = new CrapsPlayer(newPlayer);

        //Then
        Assert.assertNotNull(testPlayer);
    }

    @Test
    public void betMoneyTest1() {
        //Given
        Integer crapsBetMoney = 10;
        Player newPlayer = new Player(100, "Kate");
        CrapsPlayer testPlayer = new CrapsPlayer(newPlayer);

        //When
        Integer actualOutput = testPlayer.betMoney();
        Integer expectedOutput = crapsBetMoney;

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void betMoneyTest2() {
        //Given
        Integer crapsBetMoney = 10;
        Player newPlayer = new Player(5, "Kate");
        CrapsPlayer testPlayer = new CrapsPlayer(newPlayer);

        //When
        Integer actualOutput = testPlayer.betMoney();
        Integer expectedOutput = -1;

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void winMoneyTest() {
        //Given
        Integer crapsBetMoney = 10;
        Player newPlayer = new Player(100, "Kate");
        CrapsPlayer testPlayer = new CrapsPlayer(newPlayer);

        //When
        testPlayer.betMoney();
        testPlayer.winMoney();
        Integer expectedOutput = 110;
        Integer actualOutput = newPlayer.getMoney();

        //Then
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void getBetAmountTest() {
        //Given
        Player newPlayer = new Player(100, "Kate");
        CrapsPlayer testPlayer = new CrapsPlayer(newPlayer);

        //When
        Integer expectedOutput = 10;
        Integer actualOutput = CrapsPlayer.getCrapsBetAmount();

        //Then
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void enoughMoneyToBetTest() {
        //Given
        Player newPlayer = new Player(100, "Kate");
        CrapsPlayer testPlayer = new CrapsPlayer(newPlayer);

        //Then
        Assert.assertTrue(testPlayer.enoughMoneyToBet());

    }

}
