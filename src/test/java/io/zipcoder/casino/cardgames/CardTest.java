package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void constructorTest(){
        Card card = new Card(4);
        Integer expected = 4;

        Integer actual = card.getValue();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getValue() {
        Card card = new Card(5);
        Integer expected = 5;

        Integer actual = card.getValue();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getSign() {
        Card card = new Card(4, SignType.Clover);
        SignType expected = SignType.Clover;

        SignType actual = card.getSign();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void toStringTest() {
        Card card = new Card(4,SignType.Clover);
        String expected = "4Clover";

        String actual = card.toString();

        Assert.assertEquals(expected,actual);


    }

    @Test
    public void equalsWithNoValuesTest(){
        //Given
        Card card = new Card();
        Card newCard = new Card();
        Boolean expected = true;
        //When
        Boolean actual = card.equals(newCard);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void equalsTest() {
        //Given
        Card card = new Card(2,SignType.Spade);
        Card card1 = new Card(2, SignType.Spade);
        Boolean expected = true;
        //When
        Boolean actual = card.equals(card1);
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void equalsTest1(){
        //Given
        Card card = new Card(2, SignType.Clover);
        Card card1 = new Card(3, SignType.Clover);
        Boolean expected = false;
        //When
        Boolean actual = card.equals(card1);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void equalsTest2(){
        Card card = new Card(2, SignType.Diamond);
        Card card1 = new Card(2, SignType.Heart);
        Boolean expected = true;

        Boolean actual = card.equals(card1);

        Assert.assertEquals(expected, actual);

    }


}