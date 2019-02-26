package io.zipcoder.casino;

import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class GameFactoryTests {

    Player testPlayer = new Player(100, "Kate");

    @Test
    public void createGameObjectTest1() {
        //Given
        GameType game = GameType.Crapes;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);
        IOConsole gameConsole = IOConsoleFactory.CreateIOConsole(game, testPlayer);

        //Then
        Assert.assertNotNull(GameFactory.CreateGameObject(testPlayer, game, gameConsole));
    }

    @Test
    public void createGameObjectTest2() {
        //Given
        GameType game = GameType.ChuckALuck;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);
        IOConsole gameConsole = IOConsoleFactory.CreateIOConsole(game, testPlayer);

        //Then
        Assert.assertNotNull(GameFactory.CreateGameObject(testPlayer, game, gameConsole));
    }

    @Test
    public void createGameObjectTest3() {
        //Given
        GameType game = GameType.BlackJack;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);
        IOConsole gameConsole = IOConsoleFactory.CreateIOConsole(game, testPlayer);

        //Then
        Assert.assertNotNull(GameFactory.CreateGameObject(testPlayer, game, gameConsole));
    }

    @Test
    public void createGameObjectTest4() {
        //Given
        GameType game = GameType.GoFish;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);
        IOConsole gameConsole = IOConsoleFactory.CreateIOConsole(game, testPlayer);

        //Then
        Assert.assertNotNull(GameFactory.CreateGameObject(testPlayer, game, gameConsole));
    }
}
