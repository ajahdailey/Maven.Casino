package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.*;
import io.zipcoder.casino.ioconsoles.IOBlackJackConsole;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Dealer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.GamblingGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack extends CardGame implements GamblingGame {
    private Player player;
    private int score;
    private IOBlackJackConsole console;
    private Deck deck;
    private Dealer dealer;
    private Facilitator facilitator;
    private boolean continueFlagMain;
    private boolean gameOver;

        /*
        There should be a way to track:
        1. The User's wager
        2. Current balance
        3. Current cards in hand
        4. Current cards in dealer hand (their number value)
         */
public BlackJack(Player player,IOBlackJackConsole console )
{
    {
        this.player = player;

        List<Player> playerList = new ArrayList<Player>();
        //Adding the dealer / House player
        playerList.add(new Player(new Player(0, "House")));
        // Add the player
        playerList.add(player);

    this.console = console;
    deck = new Deck(52);


    }
}

    public BlackJack(BlackJackPlayer bjPlayer, IOConsole console) {
       super();
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

            System.out.println(" :::====  :::      :::====  :::===== :::  ===          ::: :::====  :::===== :::  ===\n" +
                    " :::  === :::      :::  === :::      ::: ===           ::: :::  === :::      ::: === \n" +
                    " =======  ===      ======== ===      ======            === ======== ===      ======  \n" +
                    " ===  === ===      ===  === ===      === ===       ==  === ===  === ===      === === \n" +
                    " =======  ======== ===  ===  ======= ===  ===      ======  ===  ===  ======= ===  ===\n\n" +
                    "'q' to quit                                                              'p' to play");


            if (getStringResponse().equals("p")) {
                System.out.println("\n\n\nDealer is dealing...\n\n\n");
                this.bet();
                this.distributeCards();
                TimeUnit.SECONDS.sleep(5);
                this.gameOver = false;

                while (!this.gameOver) {
                    this.showHands();
                    System.out.println("Would you like to hit (1) or stand (2)");
                    if (this.getStringResponse().equals("1")) {
                        this.hitUser();
                        this.hitDealer();
                        this.bustOr21();
                    } else{
                        this.gameOver = true;
                    }
                }


                this.printResults();
                this.giveMoney();

            } else {
                this.continueFlagMain = false;
            }
        }
        System.out.println("\n\n\nThanks for playing Black Jack!\n\n\n");
    }

    private void bustOr21() {
        /*
        This evaluates if the user/dealer busted, if the game is over and who won if anybody

        Order:
        1. See if anybody busted, if so set the gameOver variable to true and evaluate winner
        2. If no body did, check if anybody has 21, if so set the gameOver variable to true and evaluate winner
        3. If nobody did, continue
         */






    }

    private void hitDealer() {
        // Give the dealer one more card
    }


    private void hitUser() {
        // Give the user one more card
    }

    private void showHands() {
        // Should just print out the users hand and the dealers hand to the console
    }

    public void distributeCards() {
        // This should give the user and the dealer's hand their first two cards

    }

    public void bet() {
        // Take money away from user for their bet in the game (I would just make it $15)
    }

    public void giveMoney() {
       // return 0;
    }


    public void exit() { }

    private static String getStringResponse() {
        String ret = "";
        try {
            ret = getInScanner().nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static Scanner getInScanner() throws IOException {
        return new Scanner(System.in);
    }

    @Override
    public void printResults() {

    }

    @Override
    public void takeTurn() {

    }
}
