package io.zipcoder.casino.cardgames;

import java.util.Collections;
import java.util.Stack;

public class BlackJackDeck extends Deck {

    public BlackJackDeck(int numberOfCards) {
        super(numberOfCards);
    }

    @Override
    public void createCards(){
        for (int i = 0; i < signArray.length; i++) {
            SignType signType = signArray[i];
            for (int value = 1; value <= 13; value++) {
                Card card = new BlackJackCard(value, signType);
                this.deckOfcards.push(card);
            }
        }
    }
}
