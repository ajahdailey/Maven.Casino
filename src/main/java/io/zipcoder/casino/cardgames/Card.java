package io.zipcoder.casino.cardgames;

import java.util.Objects;

public class Card {

    private int value;
    private SignType sign ;

    public Card(){

    }
    public Card(int value , SignType sign) {
        this.value = value;
        this.sign = sign;
    }

    public Card(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public SignType getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return  value + sign.toString() ;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card)) return false;
        Card cardToCompare = (Card) o;
        return cardToCompare.value == this.value;

    }
}
