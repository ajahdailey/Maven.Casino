package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IOChuckALuckConsole extends IOConsole{

    private Console console;

    public IOChuckALuckConsole(Console console){
        this.console = console;
    }

    public IOChuckALuckConsole(String name) {
        super();
        this.console = new Console(System.in, System.out);
    }

    public void welcome(){
        console.println("                __    __     _                                          \n" +
                "               / / /\\ \\ \\___| | ___ ___  _ __ ___   ___                 \n" +
                "               \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\                \n" +
                "                \\  /\\  /  __/ | (_| (_) | | | | | |  __/                \n" +
                "                 \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|                \n" +
                "                                                                        \n" +
                "                               _                                        \n" +
                "                              | |_ ___                                  \n" +
                "                              | __/ _ \\                                 \n" +
                "                              | || (_) |                                \n" +
                "                               \\__\\___/                                 \n" +
                "                                                                        \n" +
                "   ___                ___              _           __         ___       \n" +
                "  / __\\ /\\  /\\/\\ /\\  / __\\ /\\ /\\      /_\\         / / /\\ /\\  / __\\ /\\ /\\\n" +
                " / /   / /_/ / / \\ \\/ /   / //_/____ //_\\\\ _____ / / / / \\ \\/ /   / //_/\n" +
                "/ /___/ __  /\\ \\_/ / /___/ __ \\_____/  _  \\_____/ /__\\ \\_/ / /___/ __ \\ \n" +
                "\\____/\\/ /_/  \\___/\\____/\\/  \\/     \\_/ \\_/     \\____/\\___/\\____/\\/  \\/ \n" +
                "                                                                        ");
    }

    public void diceRoll () throws Exception {
        TimeUnit.SECONDS.sleep(2);

        console.println("               (( _______\n" +
                "     _______     /\\O    O\\   (( _______\n" +
                "    /O     /\\   /  \\      \\    /O     /\\\n" +
                "   /   O  /O \\ / O  \\O____O\\  /   O  /O \\\n" +
                "((/_____O/    \\\\    /O     / /_____O/    \\\n" +
                "  \\O    O\\    / \\  /   O  /  \\O    O\\    /\n" +
                "   \\O    O\\ O/   \\/_____O/    \\O    O\\ O/\n" +
                "    \\O____O\\/ ))          ))   \\O____O\\/ ))\n");
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
