package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

public class IOCrapsConsole extends IOConsole{
    String name;
    Console crapsConsole;

    public IOCrapsConsole(String name) {
        this.name = name;
        this.crapsConsole = new Console(System.in, System.out);

    }

    public void crapsWelcome() {
        crapsConsole.println("Welcome to craps, %s. Let's play!", name);
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
