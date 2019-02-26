package io.zipcoder.casino.player;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

        @Test
        public void testConstructor(){
            //Given
            Player play = new Player(10, "Bob");

            //When
            GoFishPlayer player = new GoFishPlayer(play);

            //Then
            String actual = player.getName();
            Assert.assertEquals("Bob",actual);
    }
}