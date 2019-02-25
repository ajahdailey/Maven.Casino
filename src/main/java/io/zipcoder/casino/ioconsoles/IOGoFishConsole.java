package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.SignType;
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
        if(hand == null) {
            goFishConsole.println("You don't have any cards in your hand.");
        } else {
            for(int i = 0; i <hand.size(); i++) {
                String value = "";
                if(hand.get(i).getValue() == 1) {value += "A";}
                else if(hand.get(i).getValue() == 2) {value += "2";}
                else if(hand.get(i).getValue() == 3) {value += "3";}
                else if(hand.get(i).getValue() == 4) {value += "4";}
                else if(hand.get(i).getValue() == 5) {value += "5";}
                else if(hand.get(i).getValue() == 6) {value += "6";}
                else if(hand.get(i).getValue() == 7) {value += "7";}
                else if(hand.get(i).getValue() == 8) {value += "8";}
                else if(hand.get(i).getValue() == 9) {value += "9";}
                else if(hand.get(i).getValue() == 10) {value += "10";}
                else if(hand.get(i).getValue() == 11) {value += "J";}
                else if(hand.get(i).getValue() == 12) {value += "Q";}
                else if (hand.get(i).getValue() == 13) {value += "K";}
                goFishConsole.print("["+value+"]");
            }
            goFishConsole.print("\n");

        }

    }

    public void displayTurnMessage() {
        goFishConsole.println("It is now " + name + " turn.");
    }


    public Card pickACardForPlayerMessage(List<Card> hand) {
        int value =goFishConsole.getIntegerInput("What card would the player like to choose?");
        Card card = new Card(value, SignType.Spade);
        return card;
    }

    public void doesHaveCardMessage() {
        goFishConsole.println("You have one or more matches in your hand.");
    }

    public void cardToAskForMessage( Card card) {
        String value = "";
        if(card.getValue() == 1) {value += "A";}
        else if(card.getValue() == 2) {value += "2";}
        else if(card.getValue() == 3) {value += "3";}
        else if(card.getValue() == 4) {value += "4";}
        else if(card.getValue() == 5) {value += "5";}
        else if(card.getValue() == 6) {value += "6";}
        else if(card.getValue() == 7) {value += "7";}
        else if(card.getValue() == 8) {value += "8";}
        else if(card.getValue() == 9) {value += "9";}
        else if(card.getValue() == 10) {value += "10";}
        else if(card.getValue() == 11) {value += "J";}
        else if (card.getValue() == 12) {value += "Q";}
        else if (card.getValue() == 13) {value += "K";}

        goFishConsole.println(name + " has chosen a ["+ value + "].");
    }

    public void doesNotHaveCardMessage(Card card) {
        String value = "";
        if(card.getValue() == 1) {value += "A";}
        else if(card.getValue() == 2) {value += "2";}
        else if(card.getValue() == 3) {value += "3";}
        else if(card.getValue() == 4) {value += "4";}
        else if(card.getValue() == 5) {value += "5";}
        else if(card.getValue() == 6) {value += "6";}
        else if(card.getValue() == 7) {value += "7";}
        else if(card.getValue() == 8) {value += "8";}
        else if(card.getValue() == 9) {value += "9";}
        else if(card.getValue() == 10) {value += "10";}
        else if(card.getValue() == 11) {value += "J";}
        else if (card.getValue() == 12) {value += "Q";}
        else if (card.getValue() == 13) {value += "K";}

        goFishConsole.println("Dealer does not have a [" +value+"]. Go Fish!");
    }


    public void doesHaveCardMessage(Card card) {
        String value = "";
        if(card.getValue() == 1) {value += "A";}
        else if(card.getValue() == 2) {value += "2";}
        else if(card.getValue() == 3) {value += "3";}
        else if(card.getValue() == 4) {value += "4";}
        else if(card.getValue() == 5) {value += "5";}
        else if(card.getValue() == 6) {value += "6";}
        else if(card.getValue() == 7) {value += "7";}
        else if(card.getValue() == 8) {value += "8";}
        else if(card.getValue() == 9) {value += "9";}
        else if(card.getValue() == 10) {value += "10";}
        else if(card.getValue() == 11) {value += "J";}
        else if (card.getValue() == 12) {value += "Q";}
        else if (card.getValue() == 13) {value += "K";}

        goFishConsole.println(name + " have taken the [" + value + "] from the dealer. You have a match.");
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

}

