package io.zipcoder.casino;


import io.zipcoder.casino.cardgames.BlackJack;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;
import io.zipcoder.casino.utilities.Game;

import java.util.List;

public class Casino {
    Game gameObject;
    IOConsole consoleObject;
    List<Player> players;
    GameType currentSelectedGame;
    String playerName;
    Integer startingMoney;

    public static void main(String[] args) {
       new Casino().start();
    }

    public void start() {

       IOConsole console = new IOConsole();
       console.startCasinoConsole();
       playerName = console.getPlayerName();
       startingMoney = console.getStartingMoney();
       Player player = new Player(startingMoney, playerName);

//       console.printGameIntro(player.getName());

       boolean playAgain;
       do {
           playAgain = false;
           GameType gameType = console.getGameSelection(player);

           IOConsole gameConsole = IOConsoleFactory.CreateIOConsole(gameType, player);

           Game gameObject = GameFactory.CreateGameObject(player, gameType, gameConsole);
           gameObject.play();
           gameObject.printResults();

           if (gameObject instanceof GamblingGame) {
               GamblingGame gamblingGame = (GamblingGame) gameObject;
               gamblingGame.giveMoney();

           }

           console.printPlayerAccount(player.getMoney());
           playAgain = console.askPlayAgain();

       }while(playAgain);

    console.goodbye(player.getName());
    }

}
