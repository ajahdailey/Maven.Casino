package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.BlackJack.*;
import io.zipcoder.casino.cardgames.CardUtilities.Deck;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;
import io.zipcoder.casino.cardgames.CardUtilities.CardPlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.cardgames.GoFish.GoFish;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackTests {
    @Test
    public void playTestDealerWins() {

        int[] deckValues = {11,2,1,12};
        BlackJackDeck deck = new DummyDeckForBlackJackTest(deckValues);
        IOBlackJackConsole console = new DummyIOForBlackJackTest("Aswathy", "hit");

        BlackJack game = new BlackJack(new BlackJackPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        //game.printResults();
        boolean didwin =  game.didWin();
        Assert.assertFalse(didwin);
    }

    @Test
    public void playTestPlayerWins() {

        int[] deckValues = {11,1,1,2};
        BlackJackDeck deck = new DummyDeckForBlackJackTest(deckValues);
        IOBlackJackConsole console = new DummyIOForBlackJackTest("Aswathy", "stand");

        BlackJack game = new BlackJack(new BlackJackPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        //game.printResults();
        boolean didwin =  game.didWin();
        Assert.assertTrue(didwin);
    }
    @Test
    public void playTestPlayerHitWins() {

        int[] deckValues = {8,1,1,9,2,1};
        BlackJackDeck deck = new DummyDeckForBlackJackTest(deckValues);
        IOBlackJackConsole console = new DummyIOForBlackJackTest("Aswathy", "hit");

        BlackJack game = new BlackJack(new BlackJackPlayer(new Player(100, "Aswathy")), console, deck);
        game.play();
        //game.printResults();
        boolean didwin =  game.didWin();
        Assert.assertTrue(didwin);
    }
    @Test
    public void distributeCardsTest() {
        BlackJack game = new BlackJack(new BlackJackPlayer(
                new Player(100,"Gamer")), new IOBlackJackConsole("gamer"));
        int noOfCards = game.getPlayer().getHandCards().size();
        Assert.assertEquals(noOfCards,0);
        game.distributeCards();
        noOfCards = game.getPlayer().getHandCards().size();
        Assert.assertEquals(noOfCards,2);

    }

    @Test
    public void getDealerTest() {
        BlackJack game = new BlackJack(new BlackJackPlayer(
                new Player(100,"Gamer")), new IOBlackJackConsole("gamer"));
        CardPlayer player = game.getDealer();

        Assert.assertEquals(player.getName() ,"Dealer");

    }
    @Test
    public void getPlayerTest() {
        BlackJack game = new BlackJack(new BlackJackPlayer(
                new Player(100,"Gamer")), new IOBlackJackConsole("gamer"));
        CardPlayer player = game.getPlayer();

        Assert.assertEquals(player.getName() ,"Gamer");

    }
    @Test
    public void giveMoneyTest() {
        BlackJack game = new BlackJack(new BlackJackPlayer(
                new Player(100,"Gamer")), new IOBlackJackConsole("gamer"));

        game.giveMoney();
        int playerMoney = game.getPlayer().getMoney();

        Assert.assertEquals(100 , playerMoney);

    }
    @Test
    public void betTest() {
        BlackJack game = new BlackJack(new BlackJackPlayer(
                new Player(100,"Gamer")), new IOBlackJackConsole("gamer"));

        game.bet();
        int playerMoney = game.getPlayer().getMoney();

        Assert.assertEquals(85 , playerMoney);

    }
    @Test
    public void valueOfAllCardsInHandAceTest() {
        BlackJackPlayer player = new BlackJackPlayer(
                new Player(100,"Gamer"));
        player.addCardToHand(new BlackJackCard(1, SignType.Clover));
        player.addCardToHand(new BlackJackCard(10, SignType.Clover));
        BlackJack game = new BlackJack(player, new IOBlackJackConsole("gamer"));

        int retrievedValue = game.valueOfAllCardsInHand(player);
        Assert.assertEquals(21 , retrievedValue);
    }

    @Test
    public void valueOfAllCardsInHandKingTest() {
        BlackJackPlayer player = new BlackJackPlayer(
                new Player(100,"Gamer"));
        player.addCardToHand(new BlackJackCard(2, SignType.Clover));
        player.addCardToHand(new BlackJackCard(11, SignType.Clover));
        BlackJack game = new BlackJack(player, new IOBlackJackConsole("gamer"));

        int retrievedValue = game.valueOfAllCardsInHand(player);
        Assert.assertEquals(12 , retrievedValue);
    }

    @Test
    public void hitUserTest() {
        BlackJackPlayer player = new BlackJackPlayer(
                new Player(100,"Gamer"));
        player.addCardToHand(new BlackJackCard(2, SignType.Clover));
        player.addCardToHand(new BlackJackCard(11, SignType.Clover));
        BlackJack game = new BlackJack(player, new IOBlackJackConsole("gamer"));
        game.hitUser();
        int retrievedValue = player.getNumberOfCardsInHand();
        Assert.assertEquals(3 , retrievedValue);
    }

    @Test
    public void hitDealerTest() {
        BlackJackPlayer player = new BlackJackPlayer(
                new Player(100,"Gamer"));
        BlackJack game = new BlackJack(player, new IOBlackJackConsole("gamer"));
        CardPlayer dealer = game.getDealer();
        dealer.addCardToHand(new BlackJackCard(2, SignType.Clover));
        dealer.addCardToHand(new BlackJackCard(11, SignType.Clover));
        game.hitDealer();
        int retrievedValue = dealer.getNumberOfCardsInHand();
        Assert.assertEquals(3 , retrievedValue);

    }

    @Test
    public void bustOr21Test() {
        BlackJackPlayer player = new BlackJackPlayer(
                new Player(100,"Gamer"));
        player.addCardToHand(new BlackJackCard(10, SignType.Clover));
        player.addCardToHand(new BlackJackCard(8, SignType.Clover));
        player.addCardToHand(new BlackJackCard(3, SignType.Clover));
        BlackJack game = new BlackJack(player, new IOBlackJackConsole("gamer"));
        CardPlayer dealer = game.getDealer();
        dealer.addCardToHand(new BlackJackCard(2, SignType.Clover));
        dealer.addCardToHand(new BlackJackCard(11, SignType.Clover));
        game.bustOr21();
        boolean retrievedValue = game.isPlayerWin();
        Assert.assertTrue(retrievedValue);

    }

    @Test
    public void bustOr21DealerWinsTest() {
        BlackJackPlayer player = new BlackJackPlayer(
                new Player(100,"Gamer"));
        player.addCardToHand(new BlackJackCard(10, SignType.Clover));
        player.addCardToHand(new BlackJackCard(7, SignType.Clover));
        player.addCardToHand(new BlackJackCard(3, SignType.Clover));
        BlackJack game = new BlackJack(player, new IOBlackJackConsole("gamer"));
        CardPlayer dealer = game.getDealer();
        dealer.addCardToHand(new BlackJackCard(12, SignType.Clover));
        dealer.addCardToHand(new BlackJackCard(11, SignType.Clover));
        dealer.addCardToHand(new BlackJackCard(1, SignType.Clover));
        game.bustOr21();
        boolean retrievedValue = game.isDealerWin();
        Assert.assertTrue(retrievedValue);

    }

}
