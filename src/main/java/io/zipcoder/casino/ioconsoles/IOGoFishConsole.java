package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.utilities.Console;

import java.util.List;



public class IOGoFishConsole extends IOConsole {
    Console goFishConsole;
    String name;


    public void setPlayerName(String playername) {
        this.name = playername;
    }

    public IOGoFishConsole(String name) {
        this.name = name;
        this.goFishConsole = new Console(System.in, System.out);

    }

    public void goFishWelcomeMessage() {
        goFishConsole.println("Welcome " + name + ", to the Go Fish room");
    }

    public void distributeCardMessage() {
        goFishConsole.println("The dealer has distributed the cards.");
    }


    public void displayCurrentHand(List<Card> hand) {

    }

    public Card pickACardForPlayerMessage(List<Card> hand) {
        //Display hand()
        //Which number will you pick?
        //return hand.get(i-1)
        goFishConsole.println("What card would the player like to choose?");
        return hand.get(1);
    }

    public void cardToAskForMessage( Card card) {
        goFishConsole.println(name + " has chosen the number " + card + ".");
    }

    public void doesNotHaveCardMessage(Card card) {
        goFishConsole.println("Dealer does not have the card you requested. Go Fish!");
    }

    public void doesHaveCardMessage(Card number) {
        goFishConsole.println(name + " have taken the number " + number + " from the dealer. You have a match.");
    }


    public void winningMessage() {
        goFishConsole.println("You have won! Would you like to play again?");
    }

    public void losingMessage() {
        goFishConsole.println("You Lose. Would you like to try again?");
    }

    public void result(boolean gameReuslt) {
        if(gameReuslt = true) {
            winningMessage();
        } else if (gameReuslt = false) {
            losingMessage();
        }
    }

    public void displayTurnMessage() {

    }


    public void doesHaveCardMessage() {
    }
}

