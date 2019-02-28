package io.zipcoder.casino.cardgames.BlackJack;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;

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
