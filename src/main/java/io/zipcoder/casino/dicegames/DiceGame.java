package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.utilities.Game;

public abstract class DiceGame implements Game {

    private int numberOfDice;
    protected Dice dice;
    protected boolean didWin;

    public void roll() {
        dice.toss();
    }

    public abstract void play() ;

    public DiceGame(){
        numberOfDice = 3;
        dice = new Dice(numberOfDice);
        didWin = false;
    }

}