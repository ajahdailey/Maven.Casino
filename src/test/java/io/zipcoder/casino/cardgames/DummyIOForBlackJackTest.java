package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.BlackJack.IOBlackJackConsole;

public class DummyIOForBlackJackTest extends IOBlackJackConsole {
    private String inputHit;
    boolean firstTime = true;
    public DummyIOForBlackJackTest(String name, String inputHit) {
        super(name);
        this.inputHit = inputHit;
    }
    public String printHitOrStand(){
        return inputHit;
    }
    public String printGameStart() {
        if(firstTime) {
            firstTime = false;
            return "p";
        }
        return "q";
    }
}
