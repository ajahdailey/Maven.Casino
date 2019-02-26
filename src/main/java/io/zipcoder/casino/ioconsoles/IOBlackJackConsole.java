package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Hand;
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

    public void printPlayerHand(CardPlayer player){
        List<Card> hand = player.getHandCards();
        blackJackConsole.println("\n" + player.getName() + "'s cards: ");
        for(Card card : hand) {
            blackJackConsole.println(card.getValue() + " of " + card.getSign() + "s");
        }
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
    //This is if we implement a bet method that allows user to input amount
//    public void betMessage() {
//        blackJackConsole.println("How much are you betting?");
//    }
//
//    public void playerBetAmountMessage(String name, int betAmount) {
//        blackJackConsole.println(name + " is betting " + betAmount + " dollars.");
//    }

    public void dealtCardMessage() {
        blackJackConsole.println("The dealer has dealt the cards.");
    }

    public void playerHandMessage(List<Card> hand) {
        blackJackConsole.println("Player: ");
        for(int i = 0; i <hand.size(); i++) {
            String value = "";
            if(hand.get(i).getValue() == 1) {value = "A";}
            else if(hand.get(i).getValue() == 2) {value = "2";}
            else if(hand.get(i).getValue() == 3) {value = "3";}
            else if(hand.get(i).getValue() == 4) {value = "4";}
            else if(hand.get(i).getValue() == 5) {value = "5";}
            else if(hand.get(i).getValue() == 6) {value = "6";}
            else if(hand.get(i).getValue() == 7) {value = "7";}
            else if(hand.get(i).getValue() == 8) {value = "8";}
            else if(hand.get(i).getValue() == 9) {value = "9";}
            else if(hand.get(i).getValue() == 10) {value = "10";}
            else if(hand.get(i).getValue() == 11) {value = "J";}
            else if(hand.get(i).getValue() == 12) {value = "Q";}
            else if (hand.get(i).getValue() == 13) {value = "K";}
            blackJackConsole.print("["+value+"]");
        }
        blackJackConsole.print("\n");

    }

    public void dealerHandMessage(List<Card> hand) {
        blackJackConsole.println("Dealer: ");
        for(int i = 0; i <hand.size(); i++) {
            String value = "";
            if(hand.get(i).getValue() == 1) {value = "A";}
            else if(hand.get(i).getValue() == 2) {value = "2";}
            else if(hand.get(i).getValue() == 3) {value = "3";}
            else if(hand.get(i).getValue() == 4) {value = "4";}
            else if(hand.get(i).getValue() == 5) {value = "5";}
            else if(hand.get(i).getValue() == 6) {value = "6";}
            else if(hand.get(i).getValue() == 7) {value = "7";}
            else if(hand.get(i).getValue() == 8) {value = "8";}
            else if(hand.get(i).getValue() == 9) {value = "9";}
            else if(hand.get(i).getValue() == 10) {value = "10";}
            else if(hand.get(i).getValue() == 11) {value = "J";}
            else if(hand.get(i).getValue() == 12) {value = "Q";}
            else if (hand.get(i).getValue() == 13) {value = "K";}
            blackJackConsole.print("["+value+"]");
        }
        blackJackConsole.print("\n");

    }

    public void printDealerHand(Dealer dealer) {
        List<Card> hand = dealer.getHandCards();
        blackJackConsole.println("\n" + dealer.getName() + "'s cards: ");
        blackJackConsole.println(hand.get(0).getValue() + " of " + hand.get(0).getSign() + "s");
        hand.remove(0);
        for(Card card : hand){
            blackJackConsole.println("Hidden Card");
        }
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

    public void setResults(String results){
        this.results = results;
    }
}
