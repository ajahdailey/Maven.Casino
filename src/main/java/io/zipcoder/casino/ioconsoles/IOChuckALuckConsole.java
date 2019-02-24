package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class IOChuckALuckConsole extends IOConsole{

    private Console console;

    public IOChuckALuckConsole(Console console){
        this.console = console;

    }
    public List<Integer> getGuesses(){
        List<Integer> userGuesses = new ArrayList<Integer>();
        Integer guess1 = console.getIntegerInput("Guess the outcome of the first dice ");
        Integer guess2 = console.getIntegerInput("Guess the outcome of the second dice ");
        Integer guess3 = console.getIntegerInput("Guess the outcome of the third dice");
        userGuesses.add(guess1);
        userGuesses.add(guess2);
        userGuesses.add(guess3);

        return userGuesses;
    }
    public void printDiceResult(int result){
        console.println("The number is " + result);
    }


    public void printResult(Integer matches) {
        console.println("You have " + matches + " matches");
    }



//add "please enter a number from 1-6" if they enter any value other than 1-6.

}
