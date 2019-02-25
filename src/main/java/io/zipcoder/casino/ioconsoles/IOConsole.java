package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.GameType;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IOConsole {

    protected GameType gameType;
    private String playerName;
    Console casinoConsole;

    public IOConsole() {
        this.casinoConsole = new Console(System.in, System.out);
    }

    // this constructor used only for testing
    public IOConsole(InputStream in) {
        this.casinoConsole = new Console(in, System.out);
    }


    public void startCasinoConsole() {
        casinoConsole.println("777777777777777777777777\n" +
                "7                      7\n" +
                "7   THE SEVES CASINO   7\n" +
                "7    ____              7\n" +
                "7   /\\' .\\    _____    7\n" +
                "7  /: \\___\\  / .  /\\   7\n" +
                "7  \\' / . / /____/..\\  7\n" +
                "7   \\/___/  \\'  '\\  /  7\n" +
                "7            \\'__'\\/   7\n" +
                "7                      7\n" +
                "777777777777777777777777");
    }

    public String getPlayerName() {
        playerName = casinoConsole.getStringInput("What is your name?");
        return playerName;
    }

    public Player getPlayer(){
        String name = getPlayerName();
        return new Player(100, name);
    }

    public void printGameIntro(String playerName) {
        casinoConsole.println("Welcome, %s. We have four games you can play.\n" +
                "Black Jack and Craps require bets. Chuck-A-Luck and Go Fish do not.\n" +
                "We've given you $100 to play in the betting games.\n" +
                "\n", playerName);
    }

    public GameType getGameSelection(){
        String gameSelection = casinoConsole.getStringInput("Which game do you want to play?\n" +
                "Press 1 for BlackJack\n" +
                "Press 2 for Chuck-A-Luck\n" +
                "Press 3 for Craps\n" +
                "Press 4 for Go Fish");

        GameType selection = null;

        switch(gameSelection) {
            case "1":
                selection = GameType.BlackJack;
            break;
            case "2":
                selection = GameType.ChuckALuck;
            break;
            case "3":
                selection = GameType.Crapes;
            break;
            case "4":
                selection = GameType.GoFish;
            break;
            //TODO the casino or game factory may need to handle restarting the game selection with since this will return null
            //see invalidEntryMessage method below
        }
        return selection;
        }


    public void printPlayerAccount(Integer balance) {
        casinoConsole.println("\nYour current balance for betting games is $%d", balance);
    }

    public boolean askPlayAgain() {
        String playAgain = casinoConsole.getStringInput("Do you want to play another game?\n" +
                "Enter Y for Yes, or N for No.");

        return playAgain.compareToIgnoreCase("Y") == 0;
    }

    public void goodbye(String name) {
        casinoConsole.println("Thanks for playing, %s. Goodbye!", name);
    }

    public void invalidEntryMessage() {
        casinoConsole.println("I'm sorry I didn't understand your selection. Please try again.");
    }
}
