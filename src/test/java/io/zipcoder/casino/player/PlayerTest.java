package io.zipcoder.casino.player;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void constructorTest(){
        Player player = new Player(10, "Pie");
        Integer expected = 10;

        Integer actual = player.getMoney();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ConstructorTest2(){
        Player player = new Player(10, "Pie");
        String expected = "Pie";

        String actual = player.getName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMoneyTest() {
        Player player = new Player(10, "Cake");
        Integer expected = 10;

        Integer actual = player.getMoney();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void reduceMoneyTest() {
        Player player = new Player(10 , "Apple");
       // Integer amountToBeReduced = 5;
        int expected = 5;

        player.reduceMoney(5);
        int actual = player.getMoney();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addMoneyTest() {
        Player player = new Player(10,"Apple");
        int expected = 15;

        player.addMoney(5);
        int actual = player.getMoney();

        Assert.assertEquals(expected,actual);

        }



    @Test
    public void getNameTest() {
        Player player = new Player(10, "Cake");
        String expected = "Cake";

        String actual = player.getName();

        Assert.assertEquals(expected,actual);
    }
}