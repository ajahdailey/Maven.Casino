package io.zipcoder.casino.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    protected Stack<Card> cards;
    private int numberOfCards;
    private final   SignType[] signArray;

    public Deck(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        this.cards = new Stack<>();
        this.signArray = new SignType[]{SignType.Heart, SignType.Diamond, SignType.Clover, SignType.Heart};
        createCards();
        Collections.shuffle(cards);

    }


    public void createCards(){
        for (int i = 0; i < signArray.length; i++) {
            SignType signType = signArray[i];
            for (int value = 1; value <= 13; value++) {
                Card card = new Card(value, signType);
                this.cards.push(card);
               // System.out.println(deck.cards);
            }

        }

    }

    public Card draw(){
        return cards.size() > 0 ? cards.pop() : null;
    }

    public void shuffle() {

    }

}
