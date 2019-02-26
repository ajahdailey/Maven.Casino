package io.zipcoder.casino.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    protected Stack<Card> deckOfcards;
    protected int numberOfCards;
    protected final   SignType[] signArray;


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
            }
        }
        System.out.println(deckOfcards);
    }


    public Card draw(){
        return deckOfcards.size() > 0 ? deckOfcards.pop() : null;
    }

}
