package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Deck;
import io.zipcoder.casino.cardgames.Hand;
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

        Facilitator facilitator = new Facilitator(playerList, deck);


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
        CardPlayer cardPlayer=new CardPlayer(new Player(200, "Swapna"));
        playerList.add(cardPlayer);
        Card card1=new Card(2);
        Card card2=new Card(5);
        Hand hand=new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        Facilitator facilitator = new Facilitator(playerList, deck);

        facilitator.distributeCards();

        Integer actualCardsInHand = hand.getNumberOfCardsInHand();


        //Then
        Assert.assertEquals(expectedNumOfCards, actualCardsInHand);

    }

}

