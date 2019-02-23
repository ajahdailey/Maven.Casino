package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;


public class IOCrapsConsole extends IOConsole{
    String playerName;
    Console crapsConsole;

    public IOCrapsConsole(String playerName, InputStream input, PrintStream output) {
        crapsConsole = new Console(input, output);
        this.playerName = playerName;

    }


    public void startCrapsGame() {
        crapsConsole.println("Welcome to craps, %s. Let's play!", playerName);
    }

    public void promptRollDice() {

    }

    public void printOutcome(Integer[] diceTossResults) {

    }


    public void printResult() {

    }

    public int getBetMoney() {
        return 0;
    }

    public void passOrNotPass() {

    }


}
