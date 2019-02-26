package io.zipcoder.casino.dicegames;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinTest {

    private Bin bin;
    private Integer[] givenResults;
    @Before
    public void setup(){
        bin = new Bin();
        givenResults = new Integer[] {2 , 4, 6};
    }

    @Test
    public void binConstructorTest() {
        //Given
        Bin newBin = new Bin();

        //Then
        Assert.assertNotNull(newBin);
    }

    @Test
    public void addTest(){ // This Covers the test of getResult api as well

        bin.add(givenResults);

        //Then
        Integer[] retrievedResult = bin.getResult(1);
        Assert.assertArrayEquals(retrievedResult, givenResults);

    }

    @Test
    public void addNullTest(){
        bin.add(null);

        //Then
        Integer[] retrievedResult = bin.getResult(1);
        Assert.assertNull(retrievedResult);

    }



    @Test
    public void getResultOfInvalidBinTest(){
        bin.add(givenResults);

        //Then
        Integer[] retrievedResult = bin.getResult(2); // Invalid Bin Number
        Assert.assertNull(retrievedResult);

    }

    @Test
    public void getSumTest(){
        bin.add(givenResults);

        //Then
        int retrievedSum = bin.getSum(1);
        Assert.assertEquals(retrievedSum, 12);

    }

    @Test
    public void getSumOfInvalidBinTest(){
        bin.add(givenResults);

        //Then
        int retrievedSum = bin.getSum(2); // Give a invalid Bin Number
        Assert.assertEquals(retrievedSum, 0);

    }
}
