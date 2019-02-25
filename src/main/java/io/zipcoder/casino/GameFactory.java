package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.BlackJack;
import io.zipcoder.casino.cardgames.GoFish;
import io.zipcoder.casino.dicegames.ChuckALuck;
import io.zipcoder.casino.dicegames.Craps;
import io.zipcoder.casino.dicegames.Dice;
import io.zipcoder.casino.ioconsoles.*;
import io.zipcoder.casino.player.*;
import io.zipcoder.casino.utilities.Game;

import java.util.List;

public class GameFactory {


    public static Game CreateGameObject(Player player, GameType gameType, IOConsole console) {
            Dice dice = null;
        Game gameObject = null;
        DicePlayer dicePlayer = null ;
        switch(gameType) {
            case Crapes:
                dicePlayer = new CrapsPlayer(player);
                gameObject = new Craps(dicePlayer, console);
                break;
            case ChuckALuck:
                dicePlayer = new DicePlayer(player);
                gameObject = new ChuckALuck(dicePlayer, (IOChuckALuckConsole) console, dice);
                break;
            case BlackJack:
                BlackJackPlayer bjPlayer = new BlackJackPlayer(player);
                gameObject = new BlackJack(bjPlayer, console);
                break;
            case GoFish:
                CardPlayer goFishPlayer = new CardPlayer(player);
                gameObject = new GoFish(goFishPlayer, (IOGoFishConsole)console);
                break;
        }
        return gameObject;

    }
}
