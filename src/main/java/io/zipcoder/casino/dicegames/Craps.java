package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.utilities.GamblingGame;

public class Craps extends DiceGame implements GamblingGame {

    private int numberOfDice;
    private Dice dice;
    private DicePlayer player;
    private int sumOfToss;
    private IOCrapsConsole console;


    public int giveMoney() {
        return 0;
    }

    public void bet() {

    }


    public void evaluateGame(){

    }

    public void play() {

    }

    public void exit() {

    }
}
