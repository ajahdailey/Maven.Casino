package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.DicePlayer;
import io.zipcoder.casino.ioconsoles.IOCrapsConsole;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.Arrays;

public class Craps extends DiceGame implements GamblingGame {

    private CrapsPlayer player;
    private IOCrapsConsole console;
    private int setPoint;
    private boolean passChoice;


    public void giveMoney() {

        if(didWin)
            player.addMoney(10);
    }
    int turnNumber = 1;

    public Craps(DicePlayer player, IOConsole console){

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


    public void evaluateGame(){
        if(didWin){
            player.winMoney();
        }
        console.printResult(didWin);
    }

    public void play() {

        boolean isDone = false;
        bet();
        console.crapsWelcome();
        passChoice = console.passOrNotPass();

        do{
            console.promptRollDice();
            roll();
            int result = dice.getSum();
            console.printTossOutcome(result);
            isDone = evaluateTurn(turnNumber, result);

            if(!isDone ) {
                console.printContinueMessage();
                turnNumber++;
            }

        }while(!isDone);
    }

    private boolean evaluateTurn(int turnNumber, int result){
        boolean isDone = false;
        if(passChoice){
            if(turnNumber == 1 ) {
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
        }
        else{
            isDone = true;
            if(isInDoNotPassList(result)){
                didWin = true;
            }
        }
        return isDone;
    }

    private boolean isInPassList(int result){
        final int [] passList = {4,5,6,8,9,10};
        int isPresent = Arrays.binarySearch(passList,result);
        return isPresent >= 0;
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

    public static void main(String[] args) {
        Craps craps = new Craps(null, new IOCrapsConsole("Aswathy"));
        craps.play();
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
