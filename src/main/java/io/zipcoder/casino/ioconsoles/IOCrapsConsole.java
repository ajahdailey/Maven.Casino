package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.GameType;

public class IOCrapsConsole extends IOConsole{

    public IOCrapsConsole() {
        gameType = (GameType.Crapes);
    }

    public void promptRollDice() {
        System.out.println("Rolling");
    }

    public void printOutcome(Integer diceTossResult) {
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
