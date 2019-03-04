package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.GoFish.IOGoFishConsole;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;

import java.util.List;

public class Facilitator {

    private final IOGoFishConsole console;
    private int numberOfCardsToBeDistributed;
    private List<CardPlayer> playerList;

    private CardPlayer currentPlayer = null;
    private CardPlayer opponentPlayer = null;
    private CardPlayer winner;
    private Deck deck;
    private final int playerIdx = 1;
    private final int dealerIdx = 0;
    private boolean isQuit = false;


    public CardPlayer getWinner() {
        return winner;
    }

    public boolean isQuit() {
        return isQuit;
    }

    public Facilitator(List<CardPlayer> playerList, Deck deck, int numberOfCardsToBeDistributed, IOGoFishConsole console) {
        this.playerList = playerList;
        this.deck = deck;
        this.numberOfCardsToBeDistributed = numberOfCardsToBeDistributed;
        this.console = console;
        currentPlayer = playerList.get(playerIdx);
        opponentPlayer = playerList.get(dealerIdx);
    }

    public boolean evaluateTurn() {

        boolean isGameOver = false;
        if(isQuit){
            return true;
        }
        for(CardPlayer player : playerList) {

            if(player.getNumberOfCardsInHand() == 0)
             {
                winner = player;
                isGameOver = true;
                break;
             }
        }
        if(deck.getNumberOfCards() == 0 && !anyCommonCardsAmongPlayers())
            isGameOver = true;

        return isGameOver;

    }

    public boolean anyCommonCardsAmongPlayers() {
        List<Card> dealerCards = playerList.get(0).getHandCards();
        List<Card> playerCards = playerList.get(1).getHandCards();
        for(Card card : dealerCards){
            if(playerCards.contains(card))
                return true;
        }
        return false;
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
        console.distributeCardMessage();
    }

    public void discardMatchedCards() {
        for (CardPlayer player : playerList) {
            player.discardMatchedCards();

        }
    }


    public void facilitateTurn() {

        Card cardChosen = initialiseTurnAndSelectCard();

        if(cardChosen != null) {
            evaluateCard(cardChosen);
            List<Card> hand = playerList.get(playerIdx).getHandCards();
            console.displayCurrentHand(hand);
            setNextTurnPlayer();
        }
        else
            isQuit = true;
    }

    private void setNextTurnPlayer(){
        if (isCurrentPlayerDealer()) {
            currentPlayer = playerList.get(playerIdx);
            opponentPlayer = playerList.get(dealerIdx);
        } else {
            currentPlayer = playerList.get(dealerIdx);
            opponentPlayer = playerList.get(playerIdx);
        }
    }

    private void evaluateCard(Card cardChosen){
        if (opponentPlayer.hasCard(cardChosen)) {
            console.doesHaveCardMessage(cardChosen);
            opponentPlayer.removeCardFromHand(cardChosen);
            currentPlayer.removeCardFromHand(cardChosen);
        } else {
            console.doesNotHaveCardMessage(cardChosen);
            Card newCard = deck.draw();
            console.cardDrawnMessage(newCard);

            currentPlayer.addCardToHand(newCard);
            if (currentPlayer.discardMatchedCards())
                console.doesHaveCardMessage();
        }
    }

    private Card initialiseTurnAndSelectCard(){
        Card cardChosen = null;
        console.setPlayerName(currentPlayer.getName());
        console.displayTurnMessage();
        if(isCurrentPlayerDealer()) {
            List<Card> hand = currentPlayer.getHandCards();
            cardChosen = currentPlayer.getRandomCardFromHand();
            console.cardToAskForMessage(cardChosen);

        }else {
            opponentPlayer = playerList.get(dealerIdx);
            List<Card> hand = currentPlayer.getHandCards();
            cardChosen = console.pickACardForPlayerMessage(hand);
        }
        return cardChosen;
    }

    private boolean isCurrentPlayerDealer(){
        return currentPlayer == playerList.get(dealerIdx) ? true : false;
    }
}
