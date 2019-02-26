package io.zipcoder.casino.cardgames;


import io.zipcoder.casino.Facilitator;
import io.zipcoder.casino.ioconsoles.IOConsole;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.ioconsoles.IOGoFishConsole;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;


import java.util.ArrayList;
import java.util.List;

public class GoFish extends CardGame {
    private final int noOfCardsToBeDistributed = 5;
    //Todo : add the new to constructor
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
        facilitator = new Facilitator(playerList, deck, noOfCardsToBeDistributed);


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
        facilitator = new Facilitator(playerList, deck, noOfCardsToBeDistributed);
    }


    public void play() {
          //List<CardPlayer> players;

        console.goFishWelcomeMessage();
        facilitator.distributeCards();
        console.distributeCardMessage();
        List<Card> hand = player.getHandCards();
        console.displayCurrentHand(hand);
        int numberofCards = hand.size();
        facilitator.discardMatchedCards();
        hand = player.getHandCards();

        if(numberofCards != hand.size()){
            console.doesHaveCardMessage();
            console.displayCurrentHand(hand);
        }


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

    public void exit() {

    }

    @Override
    public void printResults() {


    }
    public void takeTurn() {
        facilitator.facilitateTurn(console);

    }
}
