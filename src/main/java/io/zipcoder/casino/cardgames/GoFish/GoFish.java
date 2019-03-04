package io.zipcoder.casino.cardgames.GoFish;


import io.zipcoder.casino.cardgames.Facilitator;
import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.CardGame;
import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;
import io.zipcoder.casino.Player;


import java.util.ArrayList;
import java.util.List;

public class GoFish extends CardGame {
    private final int noOfCardsToBeDistributed = 5;
    private CardPlayer player;

    private IOGoFishConsole console;
    private Deck deck;

    private Facilitator facilitator;

    public GoFish(CardPlayer player, IOGoFishConsole console)
    {
        this.player = player;

        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        //Adding the Dealer /House Player
        playerList.add(new CardPlayer(new Player(0, "House")));
        //Add the player
        playerList.add(player);

        this.console = console;
        deck = new Deck(52);
        facilitator = new Facilitator(playerList, deck, noOfCardsToBeDistributed, console);


    }

    public GoFish(CardPlayer player, IOGoFishConsole console, Deck deck) {

        this.player = player;

        List<CardPlayer> playerList = new ArrayList<CardPlayer>();
        //Adding the Dealer /House Player
        playerList.add(new CardPlayer(new Player(0, "House")));
        //Add the player
        playerList.add(player);

        this.console = console;
        this.deck = deck;
        facilitator = new Facilitator(playerList, deck, noOfCardsToBeDistributed, console);
    }


    public void play() {

        console.goFishWelcomeMessage();
        facilitator.distributeCards();

        List<Card> hand = player.getHandCards();
        console.displayCurrentHand(hand);

        checkMatchCardsInHand(hand);

        boolean done = false;
        do{
            takeTurn();
            done = facilitator.evaluateTurn();

        }while(!done);

        if(facilitator.getWinner() == player)
        {
            didWin = true;
        }

   }
    private void checkMatchCardsInHand(List<Card> hand){
        int numberofCards = hand.size();
        facilitator.discardMatchedCards();
        hand = player.getHandCards();

        if(numberofCards != hand.size()){
            console.doesHaveCardMessage();
            console.displayCurrentHand(hand);
        }
    }


    @Override
    public void printResults() {
        if(facilitator.isQuit())
            console.exitMessage();

        else if(facilitator.getWinner() == player){
            console.winningMessage();
        }else {
            console.losingMessage();
        }


    }
    protected void takeTurn() {
        facilitator.facilitateTurn();

    }
    public boolean isQuit(){
        return facilitator.isQuit();
    }
}
