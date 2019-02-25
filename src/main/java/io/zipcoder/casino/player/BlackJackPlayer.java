package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.GamblingPlayer;

public class BlackJackPlayer extends CardPlayer implements GamblingPlayer {

    private int score;

    private static final int BlackJackBetMoney = 15;

    public BlackJackPlayer(Player player) { super(player); }

    public int betMoney() {
      return 0;
    }

    public void winMoney() {

    }
}
