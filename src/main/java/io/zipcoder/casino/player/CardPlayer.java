package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Hand;

import java.util.List;


public class   CardPlayer {
    protected Hand cardsInHand;

    protected Player player;

    public  CardPlayer(Player player){
        this.player = player;
        cardsInHand = new Hand();
    }


    public void addCardToHand(Card card) {
        if(card != null)
        cardsInHand.addCardToHand(card);
    }

    public Integer getNumberOfCardsInHand() {
        return cardsInHand.getNumberOfCardsInHand();

    }

    public boolean discardMatchedCards() {
        return cardsInHand.manageDuplicateCards();
    }

    public String getName() {
        return player.getName();
    }

    public Card getRandomCardFromHand() {
        return cardsInHand.getRandomCard();
    }

    public void removeCardFromHand(Card card) {
        cardsInHand.removeCardFromHand(card);
    }

    public boolean hasCard(Card card) {
        return cardsInHand.hasCard(card);
    }

    public List<Card> getHandCards() {
        return cardsInHand.getHandCards();

    }

    public void clearCardsInHand() {
        cardsInHand.clearAllCardsInHand();
    }
    public boolean hasAce(){
        return cardsInHand.hasCard(new Card(1));
    }
}
