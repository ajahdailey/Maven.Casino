package io.zipcoder.casino.dicegames.Craps;

import io.zipcoder.casino.dicegames.DiceUtilities.DicePlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.GamblingPlayer;

import java.util.List;

public class CrapsPlayer extends DicePlayer implements GamblingPlayer {

    private List<Integer> bin;

    private static final int CrapsBetMoney = 10;

    public CrapsPlayer(Player player) {
        super(player);
    }

    public int betMoney(){
        int betMoney = -1;
        if (player.getMoney() > CrapsBetMoney){
            player.reduceMoney(CrapsBetMoney);
            betMoney = CrapsBetMoney;
        }
        return betMoney;
    }

    public void winMoney() {
            player.addMoney(CrapsBetMoney * 2);
    }

    public static Integer getCrapsBetAmount() {
        return CrapsBetMoney;}

    public boolean enoughMoneyToBet() {
        return player.getMoney() >= CrapsBetMoney;
        }


}
