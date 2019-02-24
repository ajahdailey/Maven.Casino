package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.*;
import io.zipcoder.casino.ioconsoles.IOBlackJackConsole;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Dealer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;

public class BlackJack extends CardGame implements GamblingGame {
    private Player player;
    private int score;
    private IOBlackJackConsole console;
    private Deck deck;
    private Facilitator facilitator;
    private Dealer dealer;

    public BlackJack(BlackJackPlayer bjPlayer, IOConsole console) {
        super();
    }


    public void play() {

    }

    public void bet() {

    }

    public void giveMoney() {

    }

    public void takeTurn() {

    }

    public void evaluateGame(){

    }



    public void exit() {

    }

    @Override
    public void printResults() {

    }
}
