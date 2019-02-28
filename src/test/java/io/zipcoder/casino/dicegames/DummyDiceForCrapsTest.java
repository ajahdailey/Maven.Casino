package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.dicegames.DiceUtilities.Dice;

public class DummyDiceForCrapsTest extends Dice {
    int tossNumber = 0;
    private Integer[] possibleToss1;
    private Integer[] possibleToss2;
    public DummyDiceForCrapsTest(Integer[] possibleToss1, Integer[] possibleToss2) {
        super(2);
        this.possibleToss1 = possibleToss1;
        this.possibleToss2 = possibleToss2;
    }

   @Override
    public void toss() {

        tossResults.clear();
        if(tossNumber <= possibleToss2.length) {
            tossResults.add(possibleToss1[tossNumber]);
            tossResults.add(possibleToss2[tossNumber]);
            tossNumber++;
        }
    }
}
