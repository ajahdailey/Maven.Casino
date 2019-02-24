package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.Facilitator;
import io.zipcoder.casino.cardgames.Deck;
import io.zipcoder.casino.utilities.Game;

public abstract class CardGame implements Game {

    private Deck deck;
    private Facilitator facilitator;



    public abstract void takeTurn();
}


