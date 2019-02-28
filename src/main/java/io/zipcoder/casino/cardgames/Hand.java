package io.zipcoder.casino.cardgames;


import java.util.*;

public class Hand {

    List<Card> cardsInHand;

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
        boolean foundMatch = false;
        int i = 0;
        while(i < cardsInHand.size()) {
            foundMatch = false;
            Card cardTobeMatched = cardsInHand.get(i);
            for (int j = i + 1; j < cardsInHand.size(); j++) {
                foundMatch = removeMatchingCards(cardTobeMatched, cardsInHand.get(j));
                if (foundMatch) {
                    break;
                }
            }
            if(!foundMatch) {
                i++;
            }
        }
        return foundMatch;
    }

    private boolean removeMatchingCards(Card card1, Card card2) {
        boolean matchfound = false;
        if (card1.equals(card2)) {
            cardsInHand.remove(card1);
            cardsInHand.remove(card2);
            matchfound = true;
        }
        return matchfound;
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
        return new ArrayList<>(this.cardsInHand);
    }
}
