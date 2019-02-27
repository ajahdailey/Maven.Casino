package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.GamblingPlayer;

public class BlackJackPlayer extends CardPlayer implements GamblingPlayer {

    private int score;

    private static final int BLACKJACKBETMONEY = 15;

    public BlackJackPlayer(Player player) { super(player); }

    public int getMoney(){
        return player.getMoney();
    }

    public int betMoney() {
        if(player.getMoney() > BLACKJACKBETMONEY) {
            player.reduceMoney(BLACKJACKBETMONEY);
            return BLACKJACKBETMONEY;
        }else
            return -1;
    }

    public void winMoney() {
        player.addMoney(BLACKJACKBETMONEY*2);
    }

    public static Integer getBlackJackBetAmount() {
        return BLACKJACKBETMONEY;
    }

    public boolean enoughMoneyToBet() {
        return player.getMoney() >= BLACKJACKBETMONEY;
    }
}


