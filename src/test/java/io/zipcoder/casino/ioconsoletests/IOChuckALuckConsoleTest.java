package io.zipcoder.casino.ioconsoletests;

import io.zipcoder.casino.ioconsoles.IOChuckALuckConsole;
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
        //Testing to see if a list was created using the inputs from the user
        //simulating the user input as 4,2,5
        String input = "4\n2\n5\n";
        //create a new input stream with the fake input from above. ByteArrayInputStream is similar to system.in
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        //create console based on the fake user input
        IOChuckALuckConsole console = createConsole(inputStream);

        //When
        List<Integer> actual = console.getGuesses();

        //Then
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