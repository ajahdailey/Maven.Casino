package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Hand;
import io.zipcoder.casino.cardgames.SignType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CardPlayerTest {


    @Test
    public void addCardToHandTest() {
        //Given

        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card1=new Card(2);
        Card card2=new Card(5);

        //When
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);

         Integer actual = cardPlayer.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals((Integer)2, actual);
    }

    @Test
    public void getNumberOfCardsInHandTest() {
        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card1=new Card(2);
        Card card2=new Card(5);


        //When
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);

        Integer actual = cardPlayer.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals((Integer)3, actual);
    }

    @Test
    public void discardMatchedCardsTest() {

        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card1=new Card(2);
        Card card2=new Card(5);



        //When
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);
        cardPlayer.addCardToHand(card2);
        cardPlayer.discardMatchedCards();

        Integer actual = cardPlayer.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals((Integer)0, actual);

    }

    @Test
    public void discardMatchedCardsTest1() {

        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card1=new Card(2);
        Card card2=new Card(5);
        Card card3=new Card(9);



        //When
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);
        cardPlayer.addCardToHand(card2);
        cardPlayer.addCardToHand(card3);
        cardPlayer.discardMatchedCards();

        Integer actual = cardPlayer.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals((Integer)1, actual);

    }

    @Test
    public void getName() {
        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        String expected = "Swapna";


        //When
        String actual = cardPlayer.getName();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRandomCardFromHand() {
        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card = new Card(1);
        Card card1 = new Card(2);
        Card card2 = new Card(4);
        cardPlayer.addCardToHand(card);
        cardPlayer.addCardToHand(card1);



        //When
        System.out.println(cardPlayer.getRandomCardFromHand());

    }

    @Test
    public void removeCardFromHand() {
        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card = new Card(1);
        Card card1 = new Card(2);
        cardPlayer.addCardToHand(card);
        cardPlayer.addCardToHand(card1);
        Integer expected = 1;

        //When
       cardPlayer.removeCardFromHand(card);
       Integer actual = cardPlayer.getNumberOfCardsInHand();

       //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasCardTest() {
        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card = new Card(1);
        Card card1 = new Card(2);
        cardPlayer.addCardToHand(card);
        cardPlayer.addCardToHand(card1);
        Boolean expected = true;

        //When
        Boolean actual = cardPlayer.hasCard(card);

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getHandCardsTest() {
        //Given
        Player player = new Player(0,"Swapna");
        CardPlayer cardPlayer = new CardPlayer(player);
        Card card = new Card(1, SignType.Diamond);
        Card card1 = new Card(2, SignType.Clover);
        Card card2 = new Card(12, SignType.Heart);
        cardPlayer.addCardToHand(card);
        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);

        //When
        Card[] expectedArray =  new Card[]{card, card1, card2};
        String expectedString = Arrays.toString(expectedArray);
        String actualString = cardPlayer.getHandCards().toString();

        //Then
        Assert.assertEquals(expectedString, actualString);



    }
}