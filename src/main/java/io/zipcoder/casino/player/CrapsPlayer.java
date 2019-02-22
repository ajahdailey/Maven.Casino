package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.GamblingPlayer;

import java.util.List;

public class CrapsPlayer extends DicePlayer implements GamblingPlayer {

    private List<Integer> bin;

    public int betMoney() {
        return 0;
    }

    public int winMoney() {
        return 0;
    }

}
