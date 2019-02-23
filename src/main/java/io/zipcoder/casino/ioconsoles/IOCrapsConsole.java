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
        System.out.println("Rolling");
    }

    public void printTossOutcome(Integer diceTossResult) {
        System.out.println("Rolled" + diceTossResult);
    }

    public void printContinueMessage() {
        System.out.println("You did not win yet !! But good news is that you did not lose yet!! ");
    }

    public void printGameResults() {

    }

    public int getBetMoney() {

        return 0;
    }

    public boolean passOrNotPass() {

        return true;
    }

}
