package io.zipcoder.casino.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    protected Stack<Card> deckOfcards;
    private int numberOfCards;
    private final   SignType[] signArray;

    public Deck(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        this.deckOfcards = new Stack<>();
        this.signArray = new SignType[]{SignType.Heart, SignType.Diamond, SignType.Clover, SignType.Heart};
        createCards();
        Collections.shuffle(deckOfcards);

    }
    

    public void createCards(){
        for (int i = 0; i < signArray.length; i++) {
            SignType signType = signArray[i];
            for (int value = 1; value <= 13; value++) {
                Card card = new Card(value, signType);
                this.deckOfcards.push(card);
               // System.out.println(deck.cards);
            }
        }
    }

    public Card draw() {

        Card drwanCard = null;
        if (deckOfcards.size() > 0) {
            drwanCard = deckOfcards.get(deckOfcards.size() - 1);
            deckOfcards.remove(deckOfcards.size() - 1);
            System.out.println("Deck Size after drawing Card "+deckOfcards.size());
        }
        return (Card)drwanCard;
    }
}
