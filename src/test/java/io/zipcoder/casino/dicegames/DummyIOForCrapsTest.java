package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.ioconsoles.IOCrapsConsole;

public class DummyIOForCrapsTest extends IOCrapsConsole {
    boolean pass;

    public DummyIOForCrapsTest(String name, boolean pass) {
        super("Aswathy");
        this.pass = pass;
    }

    @Override
    public void promptRollDice() {
        System.out.println("Time to roll the dice!");

    }
    @Override
    public boolean passOrNotPass() {
        System.out.println("You choose to : " + ((pass == true) ? "Pass" : "Do not pass"));
        return pass;
    }
}
