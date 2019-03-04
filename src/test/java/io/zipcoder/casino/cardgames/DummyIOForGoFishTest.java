package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;

import java.util.List;

public class DummyIOForGoFishTest extends IOGoFishConsole {
    private final boolean quit;

    public DummyIOForGoFishTest(String name, boolean quit) {
        super(name);
        this.quit = quit;
    }
    public DummyIOForGoFishTest(String name) {
        super(name);
        this.quit = false;
    }

    @Override
    public Card pickACardForPlayerMessage(List<Card> hand){

        if(quit)
            return null;
        return hand.get(0);
    }
}
