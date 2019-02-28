package io.zipcoder.casino;


import io.zipcoder.casino.cardgames.BlackJack;
import io.zipcoder.casino.dicegames.Craps;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;
import io.zipcoder.casino.utilities.Game;

import java.util.List;

public class Casino {

    public static void main(String[] args) {
       new Casino().enterLobby();
    }

    private IOConsole casinoConsole;
    private Player player;

    public void enterLobby() {
        casinoConsole = new IOConsole();
        casinoConsole.casinoSign();
        createPlayerAccount();
        casinoConsole.printGameIntro(this.player.getName());
        selectGame(this.player);
    }

        public void createPlayerAccount() {
            String playerName = casinoConsole.getPlayerName();
            Integer startingMoney = casinoConsole.getStartingMoney();
            this.player = new Player(startingMoney, playerName);
        }


    public void selectGame(Player player) {
        Integer gameSelection = casinoConsole.getGameSelection(player);
        GameType gameSelected = gameValidation(gameSelection, this.player);
        playGame(gameSelected);
    }

        public GameType gameValidation(Integer gameSelection, Player player) {
            GameType gameSelected = GameType.ChuckALuck;
            switch (gameSelection) {
                case 1:
                    if(validateBlackJack(player)) {
                        gameSelected = GameType.BlackJack;
                    }
                    break;
                case 2:
                    gameSelected = GameType.ChuckALuck;
                    break;
                case 3:
                    if(validateCraps(player)) {
                        gameSelected = GameType.Crapes;
                    }
                    break;
                case 4:
                    gameSelected = GameType.GoFish;
                    break;
                default:
                    casinoConsole.invalidEntryMessage();
                    selectGame(player);
                    break;
            }
            return gameSelected;
        }

        public boolean validateBlackJack(Player player) {
            boolean canPlay = false;
            if (player.getMoney() < BlackJackPlayer.getBlackJackBetAmount()) {
                casinoConsole.notEnoughMoneyMessage(player);
                selectGame(player);
            } else canPlay = true;
            return canPlay;
        }

        public boolean validateCraps(Player player) {
            boolean canPlay = false;
            if (player.getMoney() < CrapsPlayer.getCrapsBetAmount()) {
                casinoConsole.notEnoughMoneyMessage(player);
                selectGame(player);
            } else canPlay = true;
            return canPlay;
        }


    public void playGame(GameType gameSelected) {
        IOConsole gameConsole = IOConsoleFactory.CreateIOConsole(gameSelected, this.player);
        Game gameObject = GameFactory.CreateGameObject(this.player, gameSelected, gameConsole);
        gameObject.play();
        gameObject.printResults();

        if (gameObject instanceof GamblingGame) {
            GamblingGame gamblingGame = (GamblingGame) gameObject;
            gamblingGame.giveMoney();
        }
        returnToLobby();
    }


    public void returnToLobby() {
        casinoConsole.printPlayerAccount(this.player.getMoney());
        if (casinoConsole.askPlayAgain()) {
            selectGame(this.player);
        } else exitCasino();
    }


    public void exitCasino() {
        casinoConsole.goodbye(player.getName());
    }

}
