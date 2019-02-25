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
            if(player.getNumberOfCardsInHand() == 0){
                winner = player;
                isGameOver = true;
                break;
            }
        }

        return isGameOver;

    }

    public void distributeCards() {

        for (int cardNo = 0; cardNo < numberOfCardsToBeDistributed; cardNo++) {
            for (CardPlayer player : playerList) {
                Card card = deck.draw();
                player.addCardToHand(card);
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
        console.displayTurn(currentPlayer);
        console.setPlayerName(currentPlayer.getName());
        if(isCurrentPlayerDealer()) {
            opponentPlayer = playerList.get(playerIdx);
            cardChosen = currentPlayer.getRandomCardFromHand();
            console.cardToAskForMessage(currentPlayer.getName(), cardChosen);

        }else {
            opponentPlayer = playerList.get(dealerIdx);
            List<Card> hand = playerList.get(playerIdx).getHandCards();
            cardChosen = console.pickACardForPlayerMessage(hand);
        }
        if(opponentPlayer.hasCard(card)) {
            console.doesHaveCardMessage(card);
            opponentPlayer.removeCardFromHand(card);
            currentPlayer.removeCardFromHand(card);
        }else {
            console.doesNotHaveCardMessage(card);
            Card newCard = deck.draw();
            currentPlayer.addCardToHand(card);
        }

        if(isCurrentPlayerDealer()){
            currentPlayerIdx = playerIdx;
        }else{
            List<Card> hand = playerList.get(playerIdx).getHandCards();
            console.displayHandCard(hand);
            currentPlayerIdx = dealerIdx;
        }

    }
    private boolean isCurrentPlayerDealer(){
        return true;
    }
}
