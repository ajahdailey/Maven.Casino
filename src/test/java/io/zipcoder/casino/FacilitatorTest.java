package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Deck;
import io.zipcoder.casino.cardgames.Hand;
import io.zipcoder.casino.cardgames.SignType;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class FacilitatorTest {

    @Test
    public void evaluateTurnTest() {
        //Given

        Boolean expected = true;

        //When
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer=new CardPlayer(new Player(200, "Swapna"));
        playerList.add(cardPlayer);
        Card card1=new Card(2);
        Card card2=new Card(5);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        Facilitator facilitator = new Facilitator(playerList, deck, 5);


        boolean actual = facilitator.evaluateTurn();


        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void distributeCardsTest() {
        //Given


        Integer expectedNumOfCards = 2;

        //When
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer=new CardPlayer(new Player(0, "Swapna"));
        playerList.add(cardPlayer);
        Card card1=new Card(2);
        Card card2=new Card(5);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        Facilitator facilitator = new Facilitator(playerList, deck, 5);

        facilitator.distributeCards();

        Integer actualCardsInHand = hand.getNumberOfCardsInHand();

        //Then
        Assert.assertEquals(expectedNumOfCards, actualCardsInHand);

    }

    @Test
    public void getWinner() {
        //Given
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer=new CardPlayer(new Player(0, "Swapna"));
        playerList.add(cardPlayer);
        Facilitator facilitator = new Facilitator(playerList, deck, 5);
        facilitator.distributeCards();
        Card card1=new Card(2, SignType.Clover);
        Card card2=new Card(5, SignType.Clover);
        Card card3=new Card(2, SignType.Clover);
        Card card4=new Card(5, SignType.Clover);

        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        //When

        facilitator.discardMatchedCards();
        facilitator.evaluateTurn();

        System.out.println(facilitator.getWinner());

        //Then

    }


    @Test
    public void facilitateTurn() {

    }

    @Test
    public void discardMatchedCards() {
    }
}

