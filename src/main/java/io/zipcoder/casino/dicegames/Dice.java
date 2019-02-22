package io.zipcoder.casino.dicegames;

public class Dice {

    int numberOfDice;

    public int tossAndSum() {
        return 0;

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


