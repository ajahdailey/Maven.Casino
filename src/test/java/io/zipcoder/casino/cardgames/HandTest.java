package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class HandTest {

    @Test
    public void discardCardTest1() {
        //Given
        Hand hand=new Hand(52);

        Card card = new Card(3,SignType.Clover);
        hand.addCardToHand(card);

        int expected = 0;
        //When


        hand.discardCard(card);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void discardCardNullTest1() {
        //Given
        Hand cardsInHand;
        Hand hand=new Hand(52);

        List<Card> expectedCardsInhand = new ArrayList<>(4);
        Card card = new Card(3,SignType.Clover);
        int expected = expectedCardsInhand.size();
        //When


        hand.discardCard(null);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }



    @Test
    public void clearAllCardsInHand() {
        //Given

         Card card1 = new Card(4, SignType.Clover);
        Card card2 = new Card(4, SignType.Clover);



        //When
        Hand hand=new Hand(52);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        hand.clearAllCardsInHand();
        int actual=hand.getNumberOfCardsInHand();
                System.out.println(actual);
       //Then
       Assert.assertEquals(0, actual);
    }



    @Test
    public void addCardToHandTest() {
        //Given
        Hand cardsInHand;

        Card card1 = new Card(3, SignType.Diamond);
        Card card2 = new Card(5, SignType.Diamond);
        //When
        Hand hand=new Hand(52);

         hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        int actual =hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(2,actual);
    }
}

