package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.GameType;
import io.zipcoder.casino.player.Player;

import java.util.ArrayList;
import java.util.List;

public class IOConsole {

    protected GameType gameType;

    public GameType getGameSelection(){
        System.out.println("Which Game you would like to play ? ");
        return GameType.ChuckALuck;
    }

    public Player getPlayer(){
        return new Player(200, "Aswathy");
    }

    public void printPlayerAccount(Player player) {

    }

    public boolean askPlayAgain() {
        return false;
    }
}
