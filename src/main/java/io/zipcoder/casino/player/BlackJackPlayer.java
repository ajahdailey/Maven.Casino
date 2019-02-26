package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.GamblingPlayer;

public class BlackJackPlayer extends CardPlayer implements GamblingPlayer {

    private int score;

    public BlackJackPlayer(Player player) {

        super(player);
    }


    private static final int blackJackBetMoney = 15;

    public int betMoney(){
        int betMoney = -1;
        if (player.getMoney() > blackJackBetMoney){
            player.reduceMoney(blackJackBetMoney);
            betMoney = blackJackBetMoney;
        }
        return betMoney;
    }

    public void winMoney() {
        player.addMoney(blackJackBetMoney * 2);
    }
}
