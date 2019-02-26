package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandTest {

    @Test
    public void discardCardTest1() {
        //Given
        Hand hand=new Hand();

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
        Hand hand=new Hand();

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
    public void clearAllCardsInHandTest() {
        //Given

         Card card1 = new Card(4, SignType.Clover);
        Card card2 = new Card(4, SignType.Clover);



        //When
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        hand.clearAllCardsInHand();
        int actual=hand.getNumberOfCardsInHand();
                System.out.println(actual);
       //Then
       Assert.assertEquals(0, actual);
    }


    @Test
    public void clearAllCardsInHandTest1() {
        //Given

        Card card1 = new Card(4, SignType.Clover);
        Card card2 = new Card(4, SignType.Clover);

        //When
        Hand hand=new Hand();


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
        Hand hand=new Hand();

         hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        int actual =hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(2,actual);
    }

    @Test
    public void manageDuplicateCardsTest() {
        //Given

            Card card1 = new Card(4, SignType.Clover);
            Card card2 = new Card(4, SignType.Clover);
            Card card3 = new Card(5, SignType.Diamond);
            Card card4 = new Card(6, SignType.Clover);
            Hand hand=new Hand();
            hand.addCardToHand(card1);
            hand.addCardToHand(card1);
            hand.addCardToHand(card3);
            hand.addCardToHand(card4);

        //When
            hand.manageDuplicateCards();

            int actual=hand.getNumberOfCardsInHand();
            System.out.println(actual);
            //Then
            Assert.assertEquals(2, actual);
        }


    @Test
    public void manageDuplicateCardsTest1() {
        //Given

        Card card1 = new Card(1, SignType.Clover);
        Card card2 = new Card(4, SignType.Clover);
        Card card3 = new Card(5, SignType.Diamond);
        Card card4 = new Card(6, SignType.Clover);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        //When
        hand.manageDuplicateCards();

        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);
        //Then
        Assert.assertEquals(4, actual);
    }

    @Test
    public void manageDuplicateCardsTest2() {
        //Given

        Card card1 = new Card(4, SignType.Clover);
        Card card2 = new Card(4, SignType.Clover);
        Card card3 = new Card(5, SignType.Diamond);
        Card card4 = new Card(6, SignType.Clover);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card1);
        hand.addCardToHand(card1);
        hand.addCardToHand(card4);

        //When
        hand.manageDuplicateCards();

        int actual=hand.getNumberOfCardsInHand();
        System.out.println(actual);
        //Then
        Assert.assertEquals(2, actual);
    }

    @Test
    public void getRandomCardTest() {

        //Given

        Hand hand = new Hand();
        Card card = new Card(1);
        Card card1 = new Card(2);
        Card card2 = new Card(4);
        hand.addCardToHand(card);
        hand.addCardToHand(card1);



        //When
        System.out.println(hand.getRandomCard());

    }

    @Test
    public void removeCardFromHand() {
        //Given

        Hand hand = new Hand();
        Card card = new Card(1);
        Card card1 = new Card(2);
        Card card2 = new Card(4);
        hand.addCardToHand(card);
        hand.addCardToHand(card1);
        int expected = 1;

        //When
        hand.removeCardFromHand(card);
        int actual = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasCard() {

        //Given

        Hand hand = new Hand();
        Card card = new Card(1);
        Card card1 = new Card(2);
        Card card2 = new Card(4);
        hand.addCardToHand(card);
        hand.addCardToHand(card1);
        boolean expected = true;

        //When
       boolean actual = hand.hasCard(card);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasCardTest() {

        //Given

        Hand hand = new Hand();
        Card card = new Card(1);
        Card card1 = new Card(2);
        Card card2 = new Card(4);
        hand.addCardToHand(card);
        hand.addCardToHand(card1);
        boolean expected = false;

        //When
        boolean actual = hand.hasCard(card2);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandCards() {


            //Given

            Hand hand = new Hand();
            Card card = new Card(4, SignType.Clover);
            Card card2 = new Card(1, SignType.Diamond);
            Card card1 = new Card(2, SignType.Clover);
            hand.addCardToHand(card);
            hand.addCardToHand(card1);
            hand.addCardToHand(card2);

            //When
        Card[] expectedArray =  new Card[]{card, card1, card2};
        String expectedString = Arrays.toString(expectedArray);
        String actualString = hand.getHandCards().toString();

            //Then
        Assert.assertEquals(expectedString, actualString);


        }
    }



