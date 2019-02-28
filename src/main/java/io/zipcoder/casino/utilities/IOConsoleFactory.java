package io.zipcoder.casino.utilities;

import io.zipcoder.casino.CasinoConsole;
import io.zipcoder.casino.cardgames.BlackJack.IOBlackJackConsole;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;
import io.zipcoder.casino.dicegames.ChuckALuck.IOChuckALuckConsole;
import io.zipcoder.casino.dicegames.Craps.IOCrapsConsole;
import io.zipcoder.casino.Player;

public class IOConsoleFactory {

    private GameType game;

    public IOConsoleFactory(GameType game) {
        this.game = game;
    }

    public static CasinoConsole CreateIOConsole(GameType gameType, Player player) {

        CasinoConsole console = null;
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
