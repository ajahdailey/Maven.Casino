package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class IOChuckALuckConsole extends IOConsole{

    private Console console;

    public IOChuckALuckConsole(Console console){
        this.console = console;

    }


    public IOChuckALuckConsole(String name) {
        super();
        this.console = new Console(System.in, System.out);
    }

    public List<Integer> getGuesses(){
        List<Integer> userGuesses = new ArrayList<Integer>();

        int guessInput1 =getGuess("first");
        int guessInput2 =getGuess("second");
        int guessInput3 =getGuess("third");
        userGuesses.add(guessInput1);
        userGuesses.add(guessInput2);
        userGuesses.add(guessInput3);

        return userGuesses;
    }

    public Integer getGuess(String numberDice) {

        Integer guess = console.getIntegerInput("Guess the outcome of the " + numberDice +" dice");
        while (guess < 1 || guess > 6) {
            guess = console.getIntegerInput("Please enter a number between 1 -6");
        }
        return guess;
    }

    public void printDiceResult(int result){
        console.println("The number is " + result);
    }


    public void printResult(Integer matches) {
        console.println("You have " + matches + " matches");
    }

}
