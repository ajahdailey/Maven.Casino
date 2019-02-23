package io.zipcoder.casino.dicegames;

import java.util.Random;

public class Dice {
    int numberOfDice;
    private Random random;

    public Dice(){
        random = new Random();
    }

    public Dice(Random random){
        this.random = random;
    }

    public int tossAndSum() {
        return 0;

    }

    public int roll(){
        return random.nextInt(6) + 1;
    }

    public Integer[] getResults() {
        return null;
    }



}


//    ----- Kate's code from the Dice Lab -----
//    private static Integer numberOfDice;
//
//    public Dice(Integer numberOfDice) {
//        this.numberOfDice = numberOfDice;
//    }
//
//    public static Integer tossAndSum(Integer numberOfDice) {
//        Integer sum = 0;
//        for (int i = 1; i <= numberOfDice; i++) {
//            sum = sum + (int) Dice.randomDieToss();
//        }
//        return sum;
//    }
//
//    public static double randomDieToss() {
//        return Math.floor((Math.random() * 60)/10) + 1;
//    }


