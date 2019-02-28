package io.zipcoder.casino.dicegames.Craps;

import io.zipcoder.casino.CasinoConsole;
import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class IOCrapsConsole extends CasinoConsole {
    private String name;
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
        crapsConsole.println("" +
                "  ____\n" +
                " /\\' .\\    _____\n" +
                "/: \\___\\  / .  /\\\n" +
                "\\' / . / /____/..\\\n" +
                " \\/___/  \\'  '\\  /\n" +
                "          \\'__'\\/\n" +
                "WELCOME\n" +
                "TO CRAPS! \n" +
                "------------------\n" +
                "Let's play, %s!\n" +
                "------------------", name);
    }

    public boolean passOrNotPass() {
        String typeOfBet = crapsConsole.getStringInput("Are you betting on Pass or No Pass?\nType P for Pass. NP for No Pass");
        return (typeOfBet.compareToIgnoreCase("P") == 0);
    }


    public void promptRollDice() throws Exception {
//        crapsConsole.println("Time to roll the dice!");
//        TimeUnit.SECONDS.sleep(1);

        crapsConsole.println("" +
                "               (( _______\n" +
                "     _______     /\\O    O\\\n" +
                "    /O     /\\   /  \\      \\\n" +
                "   /   O  /O \\ / O  \\O____O\\ ))\n" +
                "((/_____O/    \\\\    /O     /\n" +
                "  \\O    O\\    / \\  /   O  /\n" +
                "   \\O    O\\ O/   \\/_____O/\n" +
                "    \\O____O\\/ ))          ))\n" +
                "  ((\n");
        TimeUnit.SECONDS.sleep(2);

    }

    public void setPointMessage(Integer setPoint) {
        crapsConsole.println("The set point is %d.", setPoint);
    }

    public void printTossOutcome(Integer diceTossResult) {
        crapsConsole.println("The number rolled is %d.", diceTossResult);
    }


    public void printContinueMessage() {
        crapsConsole.println("The set point wasn't rolled, so the game continues!\n");
    }

    public void printResult(boolean gameResult) {
        if (gameResult) {
            crapsConsole.println("Congratulations, you won!");
        } else {
            crapsConsole.println("Sorry, you lost!");
        }
    }

    public void tooLittleMoney() {
        crapsConsole.println("You have too little money to bet. Please choose Go Fish or Chuck-A-Luck");
    }

}
