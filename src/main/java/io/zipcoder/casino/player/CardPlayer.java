package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Hand;

public class CardPlayer {
    private Hand cardsInHand;
    private Player player;

    public  CardPlayer(Player player){
        this.player = player;
        cardsInHand = new Hand(getNumberOfCardsInHand());
    }


    public void addCardToHand(Card card) {
        cardsInHand.addCardToHand(card);
    }

    public Integer getNumberOfCardsInHand() {
        return cardsInHand.getNumberOfCardsInHand();

    }

    public void discardMatchedCards() {
        cardsInHand.manageDuplicateCards();
    }
}
