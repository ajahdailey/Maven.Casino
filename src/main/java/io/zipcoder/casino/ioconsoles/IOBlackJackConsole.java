package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;

public class IOBlackJackConsole extends IOConsole {
    Console blackJackConsole;
    String name;

    public IOBlackJackConsole(String name) {
        this.name = name;
        this.blackJackConsole = new Console(System.in, System.out);

    }

    public void blackJackWelcomeMessage(String name) {
        blackJackConsole.println("Welcome " + name + ", to the Black Jack room");
    }

    public void betMessage() {
        blackJackConsole.println("How much are you betting?");
    }

    public void playerBetAmountMessage(String name, int betAmount) {
        blackJackConsole.println(name + " is betting " + betAmount + " coins.");
    }

    public void playerHandMessage() {
        blackJackConsole.println("The dealer has dealt the cards.\nPlayer: [K][8]\nDealer: [Q][?]");
    }

    public void NeedMoreCards() {
        //A loop that will continue until the player decides to stop drawing.
        String input = blackJackConsole.getStringInput("Would you like to hit? Yes or No.").toLowerCase();
        if (input == "yes") {
            if (input == "yes") {
                blackJackConsole.println("You have drawn a [2]. Would you like to draw again?");
            } else if (input == "no") {
                blackJackConsole.println("Dealer's Turn.");
            } else {
                input = blackJackConsole.getStringInput("Please type in Yes or No");
            }
        }
    }

   /* public void dealerTurnMessage() {
        if (dealer.hand < 15) {
            blackJackConsole.println("The dealer have drawn a [5].");
        } else {
            blackJackConsole.println("Dealer stays");
        }
    }

    public void printResultMessage() {
        if (playerwin = true) {
            blackJackConsole.println("Player: [K][8][2]\nDealer:[Q][4][5]\nYou have won.");
        } else {
            blackJackConsole.println("Player: [K][8][2]\nDealer:[Q][4][7]\nYou Lose!");
        }
    }
*/
    public void tryAgainMessage() {
        blackJackConsole.println("Would you like to play again?");
    }

}
