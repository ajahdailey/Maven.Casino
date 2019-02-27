package io.zipcoder.casino.cardgames;

import org.junit.Assert;
import org.junit.Test;

public class BlackJackCardTest {
    @Test
    public void getBlackJackValueTest(){

        BlackJackCard card = new BlackJackCard(11, SignType.Clover);
        int retrievedValue = card.getBlackJackValue();
        Assert.assertEquals(retrievedValue, 10);

    }

    @Test
    public void getBlackJackValueTestForAce(){
        BlackJackCard card = new BlackJackCard(1, SignType.Clover);
        int retrievedValue = card.getBlackJackValue();
        Assert.assertEquals(retrievedValue, 11);

    }
    @Test
    public void constructorTest(){
        BlackJackCard card = new BlackJackCard(1, SignType.Clover);
        int retrievedValue = card.getValue();
        SignType sign = card.getSign();

        Assert.assertEquals(retrievedValue, 1);
        Assert.assertEquals(sign, SignType.Clover);

    }
}
