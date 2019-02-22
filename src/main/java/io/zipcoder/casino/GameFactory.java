package io.zipcoder.casino;

import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.Player;

import java.util.List;

public class GameFactory {
    private List<Player> playerList;
    private GameType game;
    private IOConsole console;

    public GameFactory(List<Player> playerList, GameType game, IOConsole console) {
        this.playerList = playerList;
        this.game = game;
        this.console = console;
    }
}
