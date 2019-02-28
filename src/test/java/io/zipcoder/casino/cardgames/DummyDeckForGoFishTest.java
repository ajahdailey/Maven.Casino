package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;

import java.util.Stack;

public class DummyDeckForGoFishTest extends Deck {

    public DummyDeckForGoFishTest(int[] deck) {
        super();
        deckOfcards = new Stack<>();
        for(int cardNo : deck){
            deckOfcards.add(new Card(cardNo, SignType.Clover)); // dummy sign. There will be duplicates don't panic
        }
    }
}
