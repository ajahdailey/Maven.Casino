package io.zipcoder.casino.ioconsoles;

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
    public void ioChuckALuckConsoleConstructorTest() {
        //Given
        Console console = new Console(System.in, System.out);
        IOChuckALuckConsole newConsole = new IOChuckALuckConsole(console);

        //Then
        Assert.assertNotNull(newConsole);
    }


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
        //test to see if the guess is less than or equal to 6
        //Given
        Integer badGuess = 8;
        Integer goodGuess = 6;
        String input = badGuess + "\n" + goodGuess + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        IOChuckALuckConsole console = createConsole(inputStream);

        //When
        Integer actual = console.getGuess("first");

        //Then
        Assert.assertEquals(goodGuess, actual);
    }

    @Test
    public void printDiceResult() {
        //Given
        IOChuckALuckConsole console = createConsole();
        String expected = "The number is 4\n";

        //When
        console.printDiceResult(4);

        //Then
        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void printResult() {
        //Testing to see if what was printed out was correct
        //Given
        String expected = "You have 3 matches\n";
        IOChuckALuckConsole console = createConsole();

        //When
        console.printResult(3);

        //Then
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