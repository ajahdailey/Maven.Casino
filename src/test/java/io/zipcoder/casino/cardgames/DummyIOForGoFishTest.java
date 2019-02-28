package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;

import java.util.List;

public class DummyIOForGoFishTest extends IOGoFishConsole {
    public DummyIOForGoFishTest(String name) {
        super(name);
    }

    @Override
    public Card pickACardForPlayerMessage(List<Card> hand){

        return hand.get(0);
    }
}
