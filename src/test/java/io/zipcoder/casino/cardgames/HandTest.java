package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.player.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void discardCard() {
        //Given
        Player player;
        Hand cardsInHand;
        Card card1 = new Card(1);
        List<Card> list = new ArrayList<Card>();
        list.add(card1);

        //When
        Hand hand=new Hand();
        //String actual = hand.discardCard();
        hand.discardCard(card1);


        //

    }

    @Test
    public void clearAllCardsInHand() {
    }

    @Test
    public void addCardToHand() {
    }
}

