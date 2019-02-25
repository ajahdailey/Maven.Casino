package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Hand;
import io.zipcoder.casino.cardgames.SignType;
import org.junit.Assert;
import org.junit.Test;

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
}