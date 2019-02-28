package io.zipcoder.casino;

import io.zipcoder.casino.utilities.GameType;
import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;

public class CasinoConsole {

    protected GameType gameType;
    private String playerName;
    private Console casinoConsole;
    private Integer startingMoney;

    public CasinoConsole() {
        this.casinoConsole = new Console(System.in, System.out);
    }

    // this constructor used only for testing
    public CasinoConsole(InputStream in) {
        this.casinoConsole = new Console(in, System.out);
    }


    public void casinoSign() {
        casinoConsole.println("" +
                "                                      ,`--.' |                    \n" +
                "  .--.--.                              |   :  :                    \n" +
                " /  /    '.                            |   |  '                    \n" +
                "|  :  /`. /                            '   :  |                    \n" +
                ";  |  |--`                 .---.       ;   |.'.--.--.              \n" +
                "|  :  ;_       ,---.     /.  ./|  ,---.'---' /  /    '             \n" +
                " \\  \\    `.   /     \\  .-' . ' | /     \\    |  :  /`./             \n" +
                "  `----.   \\ /    /  |/___/ \\: |/    /  |   |  :  ;_               \n" +
                "  __ \\  \\  |.    ' / |.   \\  ' .    ' / |    \\  \\    `.            \n" +
                " /  /`--'  /'   ;   /| \\   \\   '   ;   /|     `----.   \\           \n" +
                "'--'.     / '   |  / |  \\   \\  '   |  / |    /  /`--'  /           \n" +
                "  `--'---'  |   :    |   \\   \\ |   :    |   '--'.     /            \n" +
                "             \\   \\  /     '---\" \\   \\  /      `--'---'             \n" +
                "  ,----..     `----'             `----'                            \n" +
                " /   /   \\                           ,--,                          \n" +
                "|   :     :                        ,--.'|         ,---,    ,---.   \n" +
                ".   |  ;. /              .--.--.   |  |,      ,-+-. /  |  '   ,'\\  \n" +
                ".   ; /--`   ,--.--.    /  /    '  `--'_     ,--.'|'   | /   /   | \n" +
                ";   | ;     /       \\  |  :  /`./  ,' ,'|   |   |  ,\"' |.   ; ,. : \n" +
                "|   : |    .--.  .-. | |  :  ;_    '  | |   |   | /  | |'   | |: : \n" +
                ".   | '___  \\__\\/: . .  \\  \\    `. |  | :   |   | |  | |'   | .; : \n" +
                "'   ; : .'| ,\" .--.; |   `----.   \\'  : |__ |   | |  |/ |   :    | \n" +
                "'   | '/  :/  /  ,.  |  /  /`--'  /|  | '.'||   | |--'   \\   \\  /  \n" +
                "|   :    /;  :   .'   \\'--'.     / ;  :    ;|   |/        `----'   \n" +
                " \\   \\ .' |  ,     .-./  `--'---'  |  ,   / '---'                  \n" +
                "  `---`    `--`---'                 ---`-'                         \n\n\n");
    }

    public String getPlayerName() {
        playerName = casinoConsole.getStringInput("Welcome to our casino.\nWhat is your name?");
        return playerName;
    }

    public Integer getStartingMoney() {
        startingMoney = casinoConsole.getIntegerInput("How much money would you like to start with, %s?", playerName);
        return startingMoney;
    }

    public void printGameIntro(String playerName) {
        casinoConsole.println("\nWe have four games you can play, %s.\n\n" +
                "Black Jack and Craps require bets.\n\n" +
                "Chuck-A-Luck and Go Fish do not require bets.\n", playerName);
    }

    public Integer getGameSelection(Player player) {
        Integer gameSelection = casinoConsole.getIntegerInput("Which game do you want to play?\n" +
                "-------------------------------\n" +
                "Press 1 for BlackJack\n" +
                "Press 2 for Chuck-A-Luck\n" +
                "Press 3 for Craps\n" +
                "Press 4 for Go Fish");
        return gameSelection;
    }

    public void printPlayerAccount(Integer balance) {
        casinoConsole.println("\n" +
                "------------------------------------------------------\n" +
                "Your current balance for betting games is $%d\n" +
                "------------------------------------------------------\n", balance);
    }

    public boolean askPlayAgain() {
        String playAgain = casinoConsole.getStringInput("Do you want to play another game?\n" +
                "Enter Y for Yes, or N for No.");

        return playAgain.compareToIgnoreCase("Y") == 0;
    }

    public void goodbye(String name) {
        casinoConsole.println("" +
                " _____\n" +
                "|A .  | _____\n" +
                "| /.\\ ||A ^  | _____\n" +
                "|(_._)|| / \\ ||A _  | _____\n" +
                "|  |  || \\ / || ( ) ||A_ _ |\n" +
                "|____V||  .  ||(_'_)||( v )|\n" +
                "       |____V||  |  || \\ / |\n" +
                "Thanks        |____V||  .  |\n" +
                "for playing!         |____V|\n" +
                "Goodbye, %s!\n", name);
    }

    public void invalidEntryMessage( ) {
        casinoConsole.println("I'm sorry I didn't understand your selection. Please try again.");
    }

    public void notEnoughMoneyMessage(Player player) {
        String addMoney = casinoConsole.getStringInput("You don't have enough money to bet in this game.\n" +
                "Enter Y to add more money.\n" +
                "Enter N to play a different game.");
        if(addMoney.compareToIgnoreCase("Y") == 0) {
            addMoneyMessage(player);
        }
    }

    public void addMoneyMessage(Player player) {
        Integer money = casinoConsole.getIntegerInput("How much would you like to add?");
        player.addMoney(money);
        casinoConsole.println("Your new balance is $%d.\n", player.getMoney());
    }

}

