package io.zipcoder.casino.cardgames.CardUtilities;

public class Card {

    protected int value;
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

        String cardsStr = String.valueOf(value);
        if(sign != null ){
            cardsStr += sign.toString();
        }
        return cardsStr;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card)) return false;
        Card cardToCompare = (Card) o;
        return cardToCompare.value == this.value;

    }
}

