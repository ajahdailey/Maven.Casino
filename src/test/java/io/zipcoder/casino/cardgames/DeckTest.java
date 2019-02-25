package io.zipcoder.casino.cardgames;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void createCards() {
        //Given
        Deck deck = new Deck(52);
        //When
        //deck.createCards();
        System.out.println(deck.deckOfcards+"\n");



    }

    @Test
    public void draw() {
        //Given
        Deck deck = new Deck(52);

        //When
        System.out.println(deck.draw());
      


    }

    @Test
    public void shuffle() {
    }


}