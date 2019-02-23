package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.util.Scanner;

public class IOCrapsConsole extends IOConsole{
    String name;
    Console crapsConsole;

    public IOCrapsConsole(String name) {
        this.name = name;
        this.crapsConsole = new Console(System.in, System.out);
    }

    // this constructor used only for testing
    public IOCrapsConsole(String name, InputStream in) {
        this.name = name;
        this.crapsConsole = new Console(in, System.out);
    }

    public void crapsWelcome() {
        crapsConsole.println("Welcome to craps, %s. Let's play!", name);
    }

    public boolean passOrNotPass() {
        String typeOfBet = crapsConsole.getStringInput("Are you betting on Pass or No Pass?\nType P for Pass. NP for No Pass");
        return (typeOfBet.compareToIgnoreCase("P") == 0);
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



}
