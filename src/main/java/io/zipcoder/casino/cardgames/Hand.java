package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Hand {


    List<Card> cardsInHand;
    List<Card> matchedCards = new ArrayList<Card>();
    Card card;

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

    public void manageDuplicateCards() {
        boolean foundMatch = false;

        for (int i = 0; i < cardsInHand.size(); ) {
            foundMatch = false;
            for (int j = i + 1; j < cardsInHand.size(); j++) {
                if (cardsInHand.get(j).equals(cardsInHand.get(i))) {
                    matchedCards.add(card);

                    cardsInHand.remove(cardsInHand.get(j));
                    cardsInHand.remove(cardsInHand.get(i));
                    foundMatch = true;
                    break;
                }
            }
            if(!foundMatch)
                i++;

        }
    }
}
