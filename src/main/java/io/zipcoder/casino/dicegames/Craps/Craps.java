package io.zipcoder.casino.dicegames.Craps;

import io.zipcoder.casino.dicegames.DiceUtilities.Dice;
import io.zipcoder.casino.dicegames.DiceUtilities.DiceGame;
import io.zipcoder.casino.CasinoConsole;
import io.zipcoder.casino.dicegames.DiceUtilities.DicePlayer;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.Arrays;

public class Craps extends DiceGame implements GamblingGame {

    private CrapsPlayer player;
    private IOCrapsConsole console;
    private int setPoint;
    private boolean passChoice;
    private int turnNumber = 1;

    public void giveMoney() {
        if(didWin)
            player.winMoney();
    }

    public Craps(DicePlayer player, CasinoConsole console){

        this.player = (CrapsPlayer) player;
        this.console = (IOCrapsConsole) console;
        dice = new Dice(2);
        passChoice = true;

    }


    //Constructor used only by the test
    public Craps(DicePlayer player, IOCrapsConsole console, Dice dice) {
        this.player = (CrapsPlayer) player;
        this.console = console;
        this.dice = dice;
        passChoice = true;
    }

    public void bet() {
        player.betMoney();
    }


    public void play() {

        boolean isDone = false;
        bet();
        console.crapsWelcome();
        passChoice = console.passOrNotPass();

        do{
            try {
                console.promptRollDice();
            } catch (Exception e) {
                e.printStackTrace();
            }
            roll();
            int result = dice.getSum();
            console.printTossOutcome(result);
            isDone = evaluateTurn(turnNumber, result);

            if(!isDone ) {
                if(turnNumber != 1)
                    console.printContinueMessage();
                turnNumber++;
            }

        }while(!isDone);
    }

    private boolean evaluateTurn(int turnNumber, int result){
        boolean isDone = false;
        if(passChoice){
            isDone = evaluatePassBet(turnNumber, result);
        }
        else{
            isDone = evaluateDontPassBet(turnNumber, result);
        }
        return isDone;
    }

    private boolean evaluateDontPassBet(int turnNumber, int result) {
        boolean isDone = true; //Don't pass bet is only one turn
        if(isInDoNotPassList(result)){
            didWin = true;
        }
        return isDone;
    }

    private boolean evaluatePassBet(int turnNumber, int result){
        boolean isDone = false;
        if(turnNumber == 1 ) {//First turn
            if (result == 7 || result == 11) {
                isDone = true;
                didWin = true;
            } else if (isInDoNotPassList(result)){
                isDone = true;
                didWin = false;
            }else{
                setPoint = result;
                console.setPointMessage(setPoint);
            }
        }else{
            if(result == 7){
                isDone = true;
                didWin = false;
            }
            else if(result == setPoint){
                isDone = true;
                didWin = true;
            }
        }
        return isDone;
    }

    private boolean isInDoNotPassList(int result){
        final int [] passList = {2, 3, 12};
        int isPresent = Arrays.binarySearch(passList,result);
        return isPresent >= 0;

    }
    public void exit() {

    }

    @Override
    public void printResults() {
        console.printResult(didWin);
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
