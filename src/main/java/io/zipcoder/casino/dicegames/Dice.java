package io.zipcoder.casino.dicegames;


import java.util.ArrayList;
import java.util.Random;

public class Dice {

    private int numberOfDice;
    Random random ;
    private ArrayList<Integer> tossResults;

    public Dice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
        random = new Random();
        tossResults = new ArrayList<Integer>();
    }

    public Dice(Integer numberOfDice, Random random) {
        this.numberOfDice = numberOfDice;
        this.random = random;
        tossResults = new ArrayList<Integer>();
    }

    public int roll(){
        return random.nextInt(6) + 1;
    }


    public Integer[] getResults() {
        return tossResults.toArray(new Integer[tossResults.size()]);
    }

    public void toss(){
        tossResults.clear();
        for (int i = 1; i <= numberOfDice; i++) {
            tossResults.add(randomDieToss());
        }
    }

    public  Integer getSum() {
        Integer sum = 0;
        for (int result :tossResults) {
            sum = sum + result;
        }
        return sum;
    }

    private  int randomDieToss() {
        return random.nextInt(6) + 1;
    }

}


