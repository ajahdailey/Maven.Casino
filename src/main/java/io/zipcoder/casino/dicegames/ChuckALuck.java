package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.ioconsoles.IOChuckALuckConsole;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * Console will ask "What is your first guess? second? and third?
 * return list of numbers
 * generate random number between 1-6 3 times
 * console prints dice results
 * compare numbers
 * console return number of matches
 * ask player if they want to play again or exit the game
 */
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
        console.diceRoll();
        for(int i = 1; i <= NUMBER_OF_GUESS; i++){
            //for every round, generate a random number form 1 -6
            int diceResult = dice.roll();
            //print result of the tossed dice
            console.printDiceResult(diceResult);
            // add result to list
            results.add(diceResult);
        }
    }
    public int getMatches(List<Integer> userGuesses, List<Integer> diceResults) {
        int numOfMatch = 0;
        for(int i = 0; i < userGuesses.size(); i++){

            if(userGuesses.contains(diceResults.get(i))){
                numOfMatch++;

            }
        }

        return numOfMatch;
    }


    //Will ask if they want to play another game or continue playing this game or exit. Will come from the console.
    public void exit() {

    }


    //Todo: Implement printResults

    @Override
    public void printResults() {
        int matches = getMatches(guesses, results);
        console.printResult(matches);
    }

//   public static void main(String[] args) {
//        Player player = new Player(10, "A");
//        DicePlayer dicePlayer = new DicePlayer(player);
//
//        ChuckALuck game = new ChuckALuck(dicePlayer);
//        game.play();
//        game.printResults();
//    }
}

//

