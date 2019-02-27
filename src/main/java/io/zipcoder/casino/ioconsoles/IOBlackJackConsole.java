package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.SignType;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.Dealer;
import io.zipcoder.casino.utilities.Console;

import java.util.List;

public class IOBlackJackConsole extends IOConsole {
    Console blackJackConsole;
    String name;
    String results;

    public IOBlackJackConsole(String name) {
        this.name = name;
        this.blackJackConsole = new Console(System.in, System.out);

    }

    public void printPlayerHand(CardPlayer player) {
        List<Card> hand = player.getHandCards();
        blackJackConsole.println("\n" + player.getName() + "'s cards: ");
        displayCurrentHand(hand);
    }

    public void printResults() {
        System.out.println(this.results);
    }

    public void printBalance(BlackJackPlayer player) {
        blackJackConsole.println("After your initial bet, your money balance is $" + player.getMoney());
    }

    public String printHitOrStand() {
        return blackJackConsole.getStringInput("\nWould you like to hit or stand?");
    }


    public void dealtCardMessage() {
        blackJackConsole.println("The dealer has dealt the cards.");
    }

    private String getDisplayString(Card card, String initalString) {
        String value = initalString;
        if (card.getValue() == 1) {
            value += "A";
        } else if (card.getValue() == 2) {
            value += "2";
        } else if (card.getValue() == 3) {
            value += "3";
        } else if (card.getValue() == 4) {
            value += "4";
        } else if (card.getValue() == 5) {
            value += "5";
        } else if (card.getValue() == 6) {
            value += "6";
        } else if (card.getValue() == 7) {
            value += "7";
        } else if (card.getValue() == 8) {
            value += "8";
        } else if (card.getValue() == 9) {
            value += "9";
        } else if (card.getValue() == 10) {
            value += "10";
        } else if (card.getValue() == 11) {
            value += "J";
        } else if (card.getValue() == 12) {
            value += "Q";
        } else if (card.getValue() == 13) {
            value += "K";
        }
        return value;
    }

    public void displayCurrentHand(List<Card> hand) {
        if (hand == null) {
            blackJackConsole.println("You don't have any cards in your hand.");
        } else {
            for (int i = 0; i < hand.size(); i++) {
                blackJackConsole.print("┌─────────┐ ");
            }
            blackJackConsole.print("\n");
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getValue() == 10) {
                    blackJackConsole.print("│" + getDisplayString(hand.get(i), "") + "       │ ");
                } else {
                    blackJackConsole.print("│" + getDisplayString(hand.get(i), "") + "        │ ");
                }
            }
            blackJackConsole.print("\n");
            for (int i = 0; i < hand.size(); i++) {
                blackJackConsole.print("│         │ ");
            }
            blackJackConsole.print("\n");
            for (int i = 0; i < hand.size(); i++) {
                blackJackConsole.print("│    " + getDisplaySymbol(hand.get(i), "") + "    │ ");
            }
            blackJackConsole.print("\n");
            for (int i = 0; i < hand.size(); i++) {
                blackJackConsole.print("│         │ ");
            }
            blackJackConsole.print("\n");
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getValue() == 10) {
                    blackJackConsole.print("│       " + getDisplayString(hand.get(i), "") + "│ ");
                } else {
                    blackJackConsole.print("│       " + getDisplayString(hand.get(i), "") + " │ ");
                }
            }
            blackJackConsole.print("\n");
            for (int i = 0; i < hand.size(); i++) {
                blackJackConsole.print("└─────────┘ ");
            }

            blackJackConsole.print("\n");

        }

    }

    private String getDisplaySymbol(Card card, String initalString){
        String value = initalString;
        if(card.getSign() == SignType.Spade) {value += "♠";}
        else if(card.getSign() == SignType.Clover) {value += "♣";}
        else if(card.getSign() == SignType.Diamond) {value += "♦";}
        else if(card.getSign() == SignType.Heart) {value += "♥";}

        return value;
    }

    public void dealerHiddenHand(List<Card> hand) {
        int value = hand.get(0).getValue();
        blackJackConsole.print("┌─────────┐ ┌─────────┐");
        blackJackConsole.print("\n");
        if(value ==10) {blackJackConsole.print("│" + getDisplayString(hand.get(0), "") + "       │ │░░░░░░░░░│");}
        else {blackJackConsole.print("│" + getDisplayString(hand.get(0), "") + "        │ │░░░░░░░░░│");}
        blackJackConsole.print("\n");
        blackJackConsole.print("│         │ │░░░░░░░░░│");
        blackJackConsole.print("\n");
        blackJackConsole.print("│    " + getDisplaySymbol(hand.get(0), "") + "    │ │░░░░░░░░░│");
        blackJackConsole.print("\n");
        blackJackConsole.print("│         │ │░░░░░░░░░│");
        blackJackConsole.print("\n");
        if(value ==10) {blackJackConsole.print("│      " + getDisplayString(hand.get(0), "") + " │ │░░░░░░░░░│");}
        else {blackJackConsole.print("│       " + getDisplayString(hand.get(0), "") + " │ │░░░░░░░░░│");}
        blackJackConsole.print("\n");
        blackJackConsole.print("└─────────┘ └─────────┘");
    }

    public void printDealerHandHidden(Dealer dealer) {
        List<Card> hand = dealer.getHandCards();
        blackJackConsole.println("\n" + dealer.getName() + "'s cards: ");
        dealerHiddenHand(hand);
    }


    public void printDealerHand(Dealer dealer) {
        List<Card> hand = dealer.getHandCards();
        blackJackConsole.println("\n" + dealer.getName() + "'s cards: ");
        displayCurrentHand(hand);

    }

    public String printGameStart() {
        String prompt = "\n\n\n:::====  :::      :::====  :::===== :::  ===          ::: :::====  :::===== :::  ===\n" +
                " :::  === :::      :::  === :::      ::: ===           ::: :::  === :::      ::: === \n" +
                " =======  ===      ======== ===      ======            === ======== ===      ======  \n" +
                " ===  === ===      ===  === ===      === ===       ==  === ===  === ===      === === \n" +
                " =======  ======== ===  ===  ======= ===  ===      ======  ===  ===  ======= ===  ===\n\n" +
                "'q' to quit                                                              'p' to play";

        return blackJackConsole.getStringInput(prompt);
    }

    public void printDealerIsDealingMessage() {
        blackJackConsole.println("\n\n\nDealer is dealing...\n\n\n");
    }

    public void printExitGameMessage() {
        blackJackConsole.println("\n\n\nThanks for playing Black Jack!\n\n\n");
    }

    public void setResults(String results) {
        this.results = results;
    }
}
