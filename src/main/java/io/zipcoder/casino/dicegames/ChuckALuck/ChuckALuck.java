package io.zipcoder.casino.dicegames.ChuckALuck;

import io.zipcoder.casino.dicegames.DiceUtilities.Dice;
import io.zipcoder.casino.dicegames.DiceUtilities.DiceGame;
import io.zipcoder.casino.dicegames.DiceUtilities.DicePlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class ChuckALuck extends DiceGame {
    private static final int NUMBER_OF_GUESS = 3;
    private int numberOfDice;
    private Dice dice;
    private DicePlayer player;
    private IOChuckALuckConsole console;
    private List<Integer> guesses;
    private List<Integer> results = new ArrayList<Integer>();

    public ChuckALuck(DicePlayer dicePlayer){
        console = new IOChuckALuckConsole(new Console(System.in, System.out));
        this.player = dicePlayer;
        this.dice = new Dice(numberOfDice);
    }

    public ChuckALuck(DicePlayer player, IOChuckALuckConsole console){
        this.player = player;
        this.console = console;
        this.dice = new Dice(numberOfDice);
    }

    public void play() {
        console.welcome();
        guesses = console.getGuesses();
        rollDices();
    }

    public void rollDices(){
        try {
            console.diceRoll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= NUMBER_OF_GUESS; i++){
            int diceResult = dice.roll();
            console.printDiceResult(diceResult);
            results.add(diceResult);
        }
    }
    public int getMatches(List<Integer> userGuesses, List<Integer> diceResults) {
        int numOfMatch = 0;
        for(int i = 0; i < userGuesses.size(); i++){
            int result = userGuesses.get(i);
            if(diceResults.contains(result)){
                numOfMatch++;
                diceResults.remove(diceResults.contains(result));
            }
        }
        return numOfMatch;
    }

    public void exit() {
    }

    @Override
    public void printResults() {
        int matches = getMatches(guesses, results);
        console.printResult(matches);
    }
}



