package io.zipcoder.casino.cardgames.CardUtilities;

import io.zipcoder.casino.cardgames.Facilitator;
import io.zipcoder.casino.utilities.Game;

public abstract class CardGame implements Game {

    private Deck deck;
    private Facilitator facilitator;

    public boolean didWin() {
        return didWin;
    }

    protected boolean didWin = false;


    public abstract void takeTurn();
}


