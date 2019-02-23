package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.GamblingPlayer;

public class BlackJackPlayer extends CardPlayer implements GamblingPlayer {

    private int score;

    public int betMoney() {
        return 0;
    }
    public void winMoney() {
        return 0;
    }
}
