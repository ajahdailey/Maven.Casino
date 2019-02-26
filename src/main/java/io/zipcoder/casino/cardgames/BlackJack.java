package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.*;
import io.zipcoder.casino.ioconsoles.IOBlackJackConsole;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.Dealer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlackJack extends CardGame implements GamblingGame {
    private BlackJackPlayer player;
    private IOBlackJackConsole console;
    private Deck deck;
    private Dealer dealer;
    private Facilitator facilitator;
    private boolean continueFlagMain;
    private boolean gameOver;
    private boolean playerBust;
    private boolean dealerBust;
    private boolean playerWin;
    private boolean dealerWin;


    /*
    There should be a way to track:
    1. The User's wager
    2. Current balance
    3. Current cards in hand
    4. Current cards in dealer hand (their number value)
     */
    public BlackJack(BlackJackPlayer player, IOBlackJackConsole console) {

        this.player = player;

        dealer = new Dealer(new Player(0, "Dealer"));

        this.console = console;
        deck = new Deck(52);


    }


    public void play() {
        try {
            mainLoop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mainLoop() throws Exception {
        this.continueFlagMain = true;
        while (this.continueFlagMain) {

            String gameStartResponse = console.printGameStart();


            if (gameStartResponse.equals("p")) {
                console.printDealerIsDealingMessage();
                this.bet();
                this.distributeCards();
                TimeUnit.SECONDS.sleep(5);
                this.initBooleans();
                this.bustOr21();

                while (!this.gameOver) {
                    this.showHands();
                    String hitOrStandResponse = console.printHitOrStand().toLowerCase();
                    if (hitOrStandResponse.equals("hit")) {
                        this.hitUser();
                        this.hitDealer();
                        this.bustOr21();
                    } else {
                        this.gameOver = true;
                    }
                }

                this.whoWon();
                this.printResults();

            } else {
                this.continueFlagMain = false;
            }
        }
        console.printExitGameMessage();
    }

    private void whoWon() {

    }

    private void initBooleans(){
        this.gameOver = false;
        this.playerBust = false;
        this.dealerBust = false;
        this.playerWin = false;
        this.dealerWin = false;
    }

    private void bustOr21() {
        if(this.valueOfAllCardsInHand(player) == 21){
            this.playerWin = true;
            this.gameOver = true;
        }
        if(this.valueOfAllCardsInHand(dealer) == 21){
            this.dealerWin = true;
            this.gameOver = true;
        }
        if(this.valueOfAllCardsInHand(player) > 21 ){
            this.playerBust = true;
            this.playerWin = false;
            this.gameOver = true;
        }
        if(this.valueOfAllCardsInHand(dealer) > 21){
            this.dealerBust = true;
            this.dealerWin = false;
            this.gameOver = true;
        }
    }

    private void hitDealer() {
        // Give the dealer one more card
        if((21 - this.valueOfAllCardsInHand(dealer)) > 5) {
            dealer.addCardToHand(deck.draw());
        }
    }


    private void hitUser() {
        // Give the user one more card
        player.addCardToHand(deck.draw());
    }

    private void showHands() {
        // Should just print out the users hand and the dealers hand to the console
        console.printPlayerHand(player);
        console.printDealerHand(dealer);
    }

    private int valueOfAllCardsInHand(CardPlayer player){
        List<Card> hand = player.getHandCards();
        int sumOfValue = 0;
        for(Card card : hand){
            sumOfValue += card.getValue();
        }
        return sumOfValue;
    }

    public void distributeCards() {
        // This should give the user and the dealer's hand their first two cards
        player.addCardToHand(deck.draw());
        player.addCardToHand(deck.draw());
        dealer.addCardToHand(deck.draw());
        dealer.addCardToHand(deck.draw());
    }

    public void bet() {
        player.betMoney();
        console.printBalance(player);
    }

    public void giveMoney() {
        player.winMoney();
    }


    public void exit() {

    }

    @Override
    public void printResults() {
        console.printResults();
    }

    @Override
    public void takeTurn() {

    }
}
