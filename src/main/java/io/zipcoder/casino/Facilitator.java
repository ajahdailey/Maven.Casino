package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Deck;
import io.zipcoder.casino.ioconsoles.IOGoFishConsole;
import io.zipcoder.casino.player.CardPlayer;

import java.util.List;

public class Facilitator {

    private int numberOfCardsToBeDistributed;
    private List<CardPlayer > playerList;
    private final int playerIdx = 1;
    private final int dealerIdx = 0;

    public CardPlayer getWinner() {
        return winner;
    }

    public int currentPlayerIdx = 1;
    private CardPlayer winner;
    Deck deck;


    public Facilitator(List<CardPlayer> playerList, Deck deck, int numberOfCardsToBeDistributed) {
        this.playerList = playerList;
        this.deck = deck;
        this.numberOfCardsToBeDistributed = numberOfCardsToBeDistributed;
    }

    public boolean evaluateTurn() {

        boolean isGameOver = false;
        for(CardPlayer player : playerList) {

            if(player.getNumberOfCardsInHand() == 0)
                {
                winner = player;
                isGameOver = true;
                break;
            } }


        return isGameOver;

    }

    public void distributeCards() {

        for (int cardNo = 0; cardNo < numberOfCardsToBeDistributed; cardNo++) {
            for (CardPlayer player : playerList) {
                Card card = deck.draw();
                if(card!=null) {
                    player.addCardToHand(card);
                }
            }
        }
    }


    public void discardMatchedCards() {
        for(CardPlayer player : playerList){
            player.discardMatchedCards();
        }
    }

    public void facilitateTurn(IOGoFishConsole console) {

        CardPlayer currentPlayer = playerList.get(currentPlayerIdx);
        CardPlayer opponentPlayer = null;
        Card cardChosen;
        console.setPlayerName(currentPlayer.getName());
        console.displayTurnMessage();
        if(isCurrentPlayerDealer()) {
            List<Card> hand = currentPlayer.getHandCards();
            console.displayCurrentHand(hand);
            opponentPlayer = playerList.get(playerIdx);
            cardChosen = currentPlayer.getRandomCardFromHand();
            console.cardToAskForMessage(cardChosen);

        }else {
            opponentPlayer = playerList.get(dealerIdx);
            List<Card> hand = currentPlayer.getHandCards();
            cardChosen = console.pickACardForPlayerMessage(hand);
        }

        if(opponentPlayer.hasCard(cardChosen)) {
            console.doesHaveCardMessage(cardChosen);
            opponentPlayer.removeCardFromHand(cardChosen);
            currentPlayer.removeCardFromHand(cardChosen);
        }else {
            console.doesNotHaveCardMessage(cardChosen);
            Card newCard = deck.draw();
            //Add a drawn message

            currentPlayer.addCardToHand(newCard);
            if(currentPlayer.discardMatchedCards());
                console.doesHaveCardMessage();
        }
        List<Card> hand = playerList.get(playerIdx).getHandCards();
        console.displayCurrentHand(hand);

        if(isCurrentPlayerDealer()){
            currentPlayerIdx = playerIdx;
        }else{
            currentPlayerIdx = dealerIdx;
        }

    }

    private boolean isCurrentPlayerDealer(){
        return currentPlayerIdx == dealerIdx ? true : false;
    }
}
