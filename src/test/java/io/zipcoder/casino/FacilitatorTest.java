package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.CardUtilities.Hand;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;
import io.zipcoder.casino.cardgames.Facilitator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FacilitatorTest {

    @Test
    public void evaluateTurnTest() {
        //Given

        Boolean expected = true;

        //When
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer = new CardPlayer(new Player(200, "Swapna"));
        playerList.add(cardPlayer);
        Card card1 = new Card(2);
        Card card2 = new Card(5);
        Hand hand = new Hand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        Facilitator facilitator = new Facilitator(playerList, deck, 5);


        boolean actual = facilitator.evaluateTurn();


        //Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void anyCommonCardsAmongPlayersTest()
    {
        Integer expectedNumOfCards = 5;
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer = new CardPlayer(new Player(0, "Swapna"));
        CardPlayer cardPlayer2 = new CardPlayer(new Player(0, "Siri"));
        cardPlayer.addCardToHand(new Card(10));
        cardPlayer.addCardToHand(new Card(1));
        cardPlayer2.addCardToHand(new Card(11));
        cardPlayer2.addCardToHand(new Card(10));
        playerList.add(cardPlayer);
        playerList.add(cardPlayer2);
        //When
        Facilitator facilitator = new Facilitator(playerList, deck, 5);
        boolean present = facilitator.anyCommonCardsAmongPlayers();
        Assert.assertTrue(present);
    }
    @Test
    public void anyCommonCardsAmongPlayersFailTest()
    {
        Integer expectedNumOfCards = 5;
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer = new CardPlayer(new Player(0, "Swapna"));
        CardPlayer cardPlayer2 = new CardPlayer(new Player(0, "Siri"));
        cardPlayer.addCardToHand(new Card(10));
        cardPlayer.addCardToHand(new Card(1));
        cardPlayer2.addCardToHand(new Card(2));
        cardPlayer2.addCardToHand(new Card(3));
        playerList.add(cardPlayer);
        playerList.add(cardPlayer2);
        //When
        Facilitator facilitator = new Facilitator(playerList, deck, 5);
        boolean present = facilitator.anyCommonCardsAmongPlayers();
        Assert.assertFalse(present);
    }
    @Test
    public void distributeCardsTest() {
        //Given
        Integer expectedNumOfCards = 5;
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer = new CardPlayer(new Player(0, "Swapna"));
        playerList.add(cardPlayer);

        //When
        Facilitator facilitator = new Facilitator(playerList, deck, 5);
        facilitator.distributeCards();

        Integer actualCardsInHand = cardPlayer.getNumberOfCardsInHand();

        //Then
        System.out.println(cardPlayer.getNumberOfCardsInHand());
        Assert.assertEquals(expectedNumOfCards, actualCardsInHand);

    }

    @Test
    public void getWinner() {
        //Given
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer = new CardPlayer(new Player(0, "Swapna"));
        playerList.add(cardPlayer);
        Facilitator facilitator = new Facilitator(playerList, deck, 5);
       // facilitator.distributeCards();
        Card card1 = new Card(2, SignType.Clover);
        Card card2 = new Card(5, SignType.Clover);
        Card card3 = new Card(2, SignType.Clover);
        Card card4 = new Card(5, SignType.Clover);

        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);
        cardPlayer.addCardToHand(card3);
        cardPlayer.addCardToHand(card4);
        //When
        facilitator.discardMatchedCards();
        facilitator.evaluateTurn();

        //Then
        CardPlayer cardPlayer1 = facilitator.getWinner();
        String strRepresentationOfCardPlayer1 = cardPlayer1.toString();
        String expectedReperesentation = "";
        Assert.assertEquals(strRepresentationOfCardPlayer1, expectedReperesentation);

    }


    @Test
    public void discardMatchedCards() {
        Deck deck = new Deck(52);
        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        CardPlayer cardPlayer = new CardPlayer(new Player(0, "Swapna"));
        playerList.add(cardPlayer);
        Facilitator facilitator = new Facilitator(playerList, deck, 5);
       // facilitator.distributeCards();
        Card card1 = new Card(2, SignType.Clover);
        Card card2 = new Card(5, SignType.Clover);
        Card card3 = new Card(2, SignType.Clover);
        Card card4 = new Card(5, SignType.Clover);


        cardPlayer.addCardToHand(card1);
        cardPlayer.addCardToHand(card2);
        cardPlayer.addCardToHand(card3);
        cardPlayer.addCardToHand(card4);
        facilitator.discardMatchedCards();
        int actual = playerList.get(0).getNumberOfCardsInHand();

        //When
        Assert.assertEquals(0, actual);
    }
}
