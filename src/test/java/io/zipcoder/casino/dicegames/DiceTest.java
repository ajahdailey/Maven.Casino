package io.zipcoder.casino.dicegames;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class DiceTest {

    private Dice dice;
    private Random random;
    private Integer[] expectedArray = new Integer[3];
    private int expectedSum;

    @Before
    public void setup(){
        random = new Random(40);
        dice = new Dice(3, random);

        expectedArray[0] = random.nextInt(6) + 1;
        expectedArray[1] = random.nextInt(6) + 1;
        expectedArray[2] = random.nextInt(6) + 1;
        expectedSum = expectedArray[0] + expectedArray[1] + expectedArray[2];


        random.setSeed(40);

    }

    @Test
    public void getSumTest(){
        dice.toss();
        int retrievedSum = dice.getSum();
        Assert.assertEquals(retrievedSum, expectedSum);
    }

    @Test
    public void tossTest(){ //Covers the getResults Test as well
        dice.toss();
        Integer[] retrievedResults = dice.getResults();
        Assert.assertArrayEquals(retrievedResults, expectedArray);

    }


}
