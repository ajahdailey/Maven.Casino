package io.zipcoder.casino;

import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class IOConsoleFactoryTests {

    Player testPlayer = new Player(100, "Kate");

    @Test
    public void createIOConsoleTest1() {
        //Given
        GameType game = GameType.Crapes;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);

        //Then
        Assert.assertNotNull(newConsole.CreateIOConsole(game, testPlayer));
    }

    @Test
    public void createIOConsoleTest2() {
        //Given
        GameType game = GameType.ChuckALuck;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);

        //Then
        Assert.assertNotNull(newConsole.CreateIOConsole(game, testPlayer));
    }

    @Test
    public void createIOConsoleTest3() {
        //Given
        GameType game = GameType.BlackJack;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);

        //Then
        Assert.assertNotNull(newConsole.CreateIOConsole(game, testPlayer));
    }

    @Test
    public void createIOConsoleTest4() {
        //Given
        GameType game = GameType.GoFish;
        IOConsoleFactory newConsole = new IOConsoleFactory(game);

        //Then
        Assert.assertNotNull(newConsole.CreateIOConsole(game, testPlayer));
    }

}
