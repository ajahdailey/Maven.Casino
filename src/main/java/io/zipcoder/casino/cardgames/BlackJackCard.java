package io.zipcoder.casino.cardgames;

public class BlackJackCard extends Card {

    public BlackJackCard(int value , SignType sign) {
        super(value, sign);
    }
    @Override
    public int getValue(){
        if(this.value >= 10 )
        return 10;
        else
            return value;
    }
}
