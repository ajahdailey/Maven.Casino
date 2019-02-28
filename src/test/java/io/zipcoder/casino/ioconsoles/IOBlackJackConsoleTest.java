package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.cardgames.BlackJack.IOBlackJackConsole;
import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IOBlackJackConsoleTest {

    Console blackJackConsole;

    private PrintStream oldPrintStream;
    ByteArrayOutputStream testOutStream;

    @Before
    public void setup() {
        testOutStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOutStream);
        oldPrintStream = System.out;
        System.setOut(printStream);
    }

    @After
    public void cleanup() {
        System.setOut(oldPrintStream);
    }

    @Test
    public void iOBlackJackConsoleConstructorTest() {
        //Given
        String name = "kate";
        IOBlackJackConsole newConsole = new IOBlackJackConsole(name);

        //Then
        Assert.assertNotNull(newConsole);
    }



}