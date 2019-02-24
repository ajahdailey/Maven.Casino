package io.zipcoder.casino;


import io.zipcoder.casino.cardgames.BlackJack;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Game;

import java.util.List;

public class Casino {
    Game gameObject;
    IOConsole consoleObject;
    List<Player> players;
    GameType currentSelectedGame;

    public static void main(String[] args) {
        // write your tests before you start fucking with this
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }

    public void start() {

//        uses GameFactory, IOConsoleFactory, PlayerFactor



    }

}
