package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.BlackJack.BlackJackCard;
import io.zipcoder.casino.cardgames.BlackJack.BlackJackDeck;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;

import java.util.Stack;

public class DummyDeckForBlackJackTest extends BlackJackDeck {

    public DummyDeckForBlackJackTest(int[] deck) {
        super(deck.length);

        deckOfcards = new Stack<>();
        for(int i = deck.length - 1; i >= 0 ; i--){
            deckOfcards.add(new BlackJackCard(deck[i], SignType.Clover)); // dummy sign. There will be duplicates don't panic
        }
    }
}