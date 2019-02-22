package io.zipcoder.casino.cardgames;

public class Card {

    private int value;
    private SignType sign ;

    public Card(int value, SignType sign) {
        this.value = value;
        this.sign = sign;
    }

    public int getValue() {
        return 0;
    }

    public SignType getSign() {
        return SignType.Spade;
    }


}
