package io.zipcoder.casino.cardgames;

public class BlackJackCard extends Card {

    public BlackJackCard(int value , SignType sign) {
        super(value, sign);
    }

    public int getBlackJackValue(){
        int cardValue = value;
        if(this.value >= 10 ) {
            cardValue = 10;
        }
        else if(value == 1){
            cardValue = 11;
        }
        return cardValue;
    }
}
