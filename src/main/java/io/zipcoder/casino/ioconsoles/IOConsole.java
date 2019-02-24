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
        System.out.println("777777777777777777777777\n" +
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

    // TODO should the player be created by the IO Console or by the casino?? -kb
    public Player getPlayer(){
        return new Player(200, "Aswathy");
    }

    public void printGameIntro(String playerName) {
        casinoConsole.println("Welcome, %s. We have four games you can play. Black Jack and Craps require bets. Chuck-A-Luck and Go Fish do not. We've given you $100 to play in the betting games.", playerName);
    }

    public GameType getGameSelection(){
//        System.out.println("Which Game you would like to play ? ");
//        return GameType.ChuckALuck;
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
        }
        return selection;
        }




    public void printPlayerAccount(Player player) {

    }

    public boolean askPlayAgain() {
        return false;
    }

    public void invalidEntryMessage() {
        casinoConsole.println("I'm sorry I didn't understand your selection. Please try again.");
    }
}