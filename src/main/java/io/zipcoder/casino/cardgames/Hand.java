package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Hand {


    List<Card> cardsInHand;
    //List<Card> matchedCards = new ArrayList<Card>();
    //Card card;

    public Hand(List<Card> cards){
    this.cardsInHand = cards;
    }

    public Hand() {
        this.cardsInHand = new ArrayList<>();

    }


    public void discardCard(Card card) {
        for(int i = 0 ; i < cardsInHand.size(); i++){
            Card inHand = cardsInHand.get(i);
            if(inHand.equals(card)){
                cardsInHand.remove(inHand);
            }
        }

    }

    public void clearAllCardsInHand() {
        cardsInHand.clear();

    }

    public void  addCardToHand(Card card){

        cardsInHand.add(card);
    }


    public int getNumberOfCardsInHand() {

        return cardsInHand.size();
    }

    public boolean manageDuplicateCards() {
        boolean anyMatchFound = false;
        boolean foundMatch;

        for (int i = 0; i < cardsInHand.size(); ) {
            foundMatch = false;
            Card cardTobeMatched = cardsInHand.get(i);
            for (int j = i + 1; j < cardsInHand.size(); j++) {
                Card thisCard = cardsInHand.get(j);
                if (thisCard.equals(cardTobeMatched)) {
                    //matchedCards.add(card);

                    cardsInHand.remove(cardTobeMatched);
                    cardsInHand.remove(thisCard);
                    foundMatch = true;
                    anyMatchFound = true;
                    break;
                }
            }
            if(!foundMatch)
                i++;

        }
        return anyMatchFound;
    }

    public Card getRandomCard() {
        Random random = new Random();
        int randomIdx = random.nextInt(cardsInHand.size());
        return cardsInHand.get(randomIdx);
    }

    public void removeCardFromHand(Card card) {
        cardsInHand.remove(card);
    }

    public boolean hasCard(Card card) {
        return cardsInHand.contains(card);
    }

    public List<Card> getHandCards() {
        return new ArrayList<Card>(this.cardsInHand);
    }
}
