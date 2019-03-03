package io.zipcoder.casino.cardgames.BlackJack;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.CardGame;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;
import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.Facilitator;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlackJack extends CardGame implements GamblingGame {
    private BlackJackPlayer player;
    private IOBlackJackConsole console;
    private BlackJackDeck deck;
    private Dealer dealer;
    private Facilitator facilitator;
    private boolean continueFlagMain;
    private boolean gameOver;

    //Used only by Test
    public BlackJack(BlackJackPlayer player, IOBlackJackConsole console, BlackJackDeck deck) {
        super();
        this.player = player;

        dealer = new Dealer(new Player(0, "Dealer"));

        this.console = console;
        this.deck = deck;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }

    public boolean isDealerWin() {
        return dealerWin;
    }

    private boolean playerWin;
    private boolean dealerWin;
    private int dealerPoints;
    private int playerPoints;


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
        deck = new BlackJackDeck(52);


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
                this.hiddenHands();
                this.bustOr21();

                while (!this.gameOver) {

                    String hitOrStandResponse = console.printHitOrStand().toLowerCase();
                    if (hitOrStandResponse.equals("hit")) {
                        this.hitUser();
                        this.hitDealer();
                        this.bustOr21();
                    } else {
                        this.gameOver = true;
                    }
                    this.showHands();
                }

                if(dealerPoints > playerPoints && dealerPoints <= 21){
                    this.dealerWin = true;

                }
                else if(dealerPoints < playerPoints && playerPoints <= 21){
                    this.playerWin = true;

                }

                this.whoWon();
                this.printResults();
                giveMoney();
                player.clearCardsInHand();
                dealer.clearCardsInHand();

            } else {
                this.continueFlagMain = false;
            }
        }
        console.printExitGameMessage();
    }

    private void whoWon() {
        if(playerWin == true && dealerWin == true ){
            console.setResults("Its a tie! \n\tyour score : " + playerPoints + "\n\tdealer score : " + dealerPoints);


        }else if(playerWin == true){
           console.setResults("Congrats, you won! \n\tyour score : " + playerPoints + "\n\tdealer score : " + dealerPoints);


        }else if(playerWin == false){
            console.setResults("Game Over, you lost \n\tyour score : " + playerPoints + "\n\tasdealer score : " + dealerPoints);
        }
    }

    private void initBooleans(){
        this.gameOver = false;
         this.playerWin = false;
        this.dealerWin = false;
    }

    public void bustOr21() {
        playerPoints = this.valueOfAllCardsInHand(player);
        dealerPoints = this.valueOfAllCardsInHand(dealer);
        if( playerPoints== 21){
            this.playerWin = true;
            this.gameOver = true;
        }
        else if(dealerPoints == 21){
            this.dealerWin = true;
            this.gameOver = true;
        }
        else if(playerPoints > 21 ){
            this.playerWin = false;
            this.gameOver = true;
        }
        else if(dealerPoints > 21){
            this.dealerWin = false;
            this.gameOver = true;
        }
    }

    public void hitDealer() {
        // Give the dealer one more card
        if((21 - this.valueOfAllCardsInHand(dealer)) > 5) {
            dealer.addCardToHand(deck.draw());
        }
    }


    public void hitUser() {
        // Give the user one more card
        player.addCardToHand(deck.draw());
    }

    private void showHands() {
        // Should just print out the users hand and the dealers hand to the console
        console.printPlayerHand(player);
        console.printDealerHand(dealer);
    }

    private void hiddenHands() {
        // Should just print out the users hand and the dealers hand to the console
        console.printPlayerHand(player);
        console.printDealerHandHidden(dealer);
    }

    public int valueOfAllCardsInHand(CardPlayer player){
        List<Card> hand = player.getHandCards();
        int sumOfValue = 0;
        // Find the summ of all other than Ace
        for(Card card : hand){
            if(card.getValue() != 1)
                sumOfValue += ((BlackJackCard)card).getBlackJackValue();
        }

        // Now add Ace
        if(hand.contains(new Card(1))) {
            for(Card card : hand){
                if(card.getValue() == 1)
                    if(sumOfValue + 11 > 21)
                        sumOfValue += 1;
                    else
                        sumOfValue += 11;
            }
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
        if(playerWin) {
            didWin = true;
            player.winMoney();
            playerWin = false;
        }
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

    public BlackJackPlayer getPlayer() {
        return  player;
    }

    public CardPlayer getDealer() {
        return  dealer;
    }
}
