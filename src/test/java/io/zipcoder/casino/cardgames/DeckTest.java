package io.zipcoder.casino.cardgames;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void createCards() {
        //Given
        Deck deck = new Deck(52);

    }

    @Test
    public void drawTest() {
        //Given
        Deck deck = new Deck(52);

        //When
        System.out.println(deck.draw());


    }

    @Test
    public void drawTest1() {
        //Given
        Deck deck = new Deck(52);

        //When
        for(int i=0; i<52;i++)
        System.out.println(deck.draw());

    }



}