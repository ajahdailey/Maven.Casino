package io.zipcoder.casino;

import io.zipcoder.casino.ioconsoles.*;
import io.zipcoder.casino.player.Player;

public class IOConsoleFactory {

    private GameType game;

    public IOConsoleFactory(GameType game) {
        this.game = game;
    }

    public static IOConsole CreateIOConsole(GameType gameType, Player player) {

        IOConsole console = null;
        switch(gameType) {
            case Crapes:
                console = new IOCrapsConsole(player.getName());
                break;
            case ChuckALuck:
                console = new IOChuckALuckConsole(player.getName());
                break;
            case BlackJack:
                console = new IOBlackJackConsole(player.getName());
                break;
            case GoFish:
                console = new IOGoFishConsole(player.getName());
                break;
        }
        return console;
    }
}
