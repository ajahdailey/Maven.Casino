package io.zipcoder.casino.utilities;

import io.zipcoder.casino.CasinoConsole;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.cardgames.BlackJack.BlackJack;
import io.zipcoder.casino.cardgames.BlackJack.BlackJackPlayer;
import io.zipcoder.casino.cardgames.BlackJack.IOBlackJackConsole;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;
import io.zipcoder.casino.cardgames.GoFish.GoFish;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;
import io.zipcoder.casino.dicegames.ChuckALuck.ChuckALuck;
import io.zipcoder.casino.dicegames.ChuckALuck.IOChuckALuckConsole;
import io.zipcoder.casino.dicegames.Craps.Craps;
import io.zipcoder.casino.dicegames.Craps.CrapsPlayer;
import io.zipcoder.casino.dicegames.DiceUtilities.DicePlayer;

public class GameFactory {


    public static Game CreateGameObject(Player player, GameType gameType, CasinoConsole console) {
        Game gameObject = null;
        DicePlayer dicePlayer = null ;
        switch(gameType) {
            case Crapes:
                dicePlayer = new CrapsPlayer(player);
                gameObject = new Craps(dicePlayer, console);
                break;
            case ChuckALuck:
                dicePlayer = new DicePlayer(player);
                gameObject = new ChuckALuck(dicePlayer, (IOChuckALuckConsole) console);
                break;
            case BlackJack:
                BlackJackPlayer bjPlayer = new BlackJackPlayer(player);
                gameObject = new BlackJack(bjPlayer, (IOBlackJackConsole) console);
                break;
            case GoFish:
                CardPlayer goFishPlayer = new CardPlayer(player);
                gameObject = new GoFish(goFishPlayer, (IOGoFishConsole)console);
                break;
        }
        return gameObject;

    }
}
