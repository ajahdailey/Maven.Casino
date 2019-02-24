package io.zipcoder.casino;


import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;
import io.zipcoder.casino.utilities.Game;

import java.util.List;

public class Casino {
    Game gameObject;
    IOConsole consoleObject;
    List<Player> players;
    GameType currentSelectedGame;

   public static void main(String[] args) {
       new Casino().start();
    }

    public void start() {

       IOConsole console = new IOConsole();
       console.startCasinoConsole();
       Player player = console.getPlayer();
       console.printGameIntro(player.getName());
       boolean playAgain;
       do {
           playAgain = false;
           GameType gameType = console.getGameSelection();
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


    }

}
