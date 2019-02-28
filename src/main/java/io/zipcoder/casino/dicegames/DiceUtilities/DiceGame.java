package io.zipcoder.casino.dicegames.DiceUtilities;

import io.zipcoder.casino.dicegames.DiceUtilities.Dice;
import io.zipcoder.casino.utilities.Game;

public abstract class DiceGame implements Game {

    private int numberOfDice;
    protected Dice dice;
    protected boolean didWin;
    public abstract void play() ;

    public void roll() {
        dice.toss();
    }

    public DiceGame(){
        numberOfDice = 3;
        dice = new Dice(numberOfDice);
        didWin = false;
    }

    public boolean didWin(){
        return didWin;
    }

    public void setWin(boolean didWin){
        this.didWin = didWin;
    }

    public Integer[] getResults(){
        return dice.getResults();
    }
}