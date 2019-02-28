package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.dicegames.ChuckALuck.IOChuckALuckConsole;
import io.zipcoder.casino.utilities.Console;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class IOChuckALuckConsoleTest {

    ByteArrayOutputStream outputStream;

    @Test
    public void getGuesses() {

        String input = "4\n2\n5\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        IOChuckALuckConsole console = createConsole(inputStream);

        List<Integer> actual = console.getGuesses();

        Assert.assertEquals(Integer.valueOf(4), actual.get(0));
        Assert.assertEquals(Integer.valueOf(2), actual.get(1));
        Assert.assertEquals(Integer.valueOf(5), actual.get(2));
    }


    @Test
    public void testGuess(){
        Integer badGuess = 8;
        Integer goodGuess = 6;
        String input = badGuess + "\n" + goodGuess + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        IOChuckALuckConsole console = createConsole(inputStream);

        Integer actual = console.getGuess("first");

        Assert.assertEquals(goodGuess, actual);
    }

    @Test
    public void printDiceResult() {
        IOChuckALuckConsole console = createConsole();
        String expected = "The number is 4\n";

        console.printDiceResult(4);

        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printResult() {
        String expected = "You have 3 matches\n";
        IOChuckALuckConsole console = createConsole();

        console.printResult(3);

        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);
    }

    private IOChuckALuckConsole createConsole() {
        return createConsole(new ByteArrayInputStream("".getBytes()));
    }
    private IOChuckALuckConsole createConsole(ByteArrayInputStream inputStream) {
        outputStream = new ByteArrayOutputStream();

        Console c = new Console(inputStream, new PrintStream(outputStream));
        IOChuckALuckConsole console = new IOChuckALuckConsole(c);
        return console;
    }
}