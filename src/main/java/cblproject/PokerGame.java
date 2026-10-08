package cblproject;

import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TB
 */
public class PokerGame {
    int[] deckOfCards = new int[52];
    Player[] players;
    int potMoney = 0;
    int cardFlopOne = null;
    int cardFlopTwo = null;
    int cardFlopThree = null;
    int cardTurn = null;
    int cardRiver = null;

    int roundcounter = 0;

    public int HandValue(int cardOne, int cardTwo) {

    }

    public int PlayerBet(Player player, int money) {
        int error = player.SetPlayerMoney(money);
        if (error == 0) {
            this.potMoney += money;
            return 0;
        } else {
            return 1;
        }
    }

    public WinningPlayer(Player player) {
        player.ChangePlayerMoney(-potMoney);
        this.potMoney = 0;
    }

    public int DrawCard() {
        randomGenerator = new Random(Math.random());
        int drawnCard = 0;
        int randomNumber;
        while (drawnCard == 0) {
            randomNumber = randomGenerator.nextInt(52);
            drawnCard = deckOfCards[randomNumber];
            deckOfCards[randomNumber] = 0;
        }
        return drawnCard;
    }

    public StartGame(int amountOfPlayers, int moneyPerPlayer) {
        for(int i; i < deckOfCards.length; i++) {
            deckOfCards[i] = i + 1;
        }
        players = new players[amountOfPlayers];
        for(int i; i < player.length; i++) {
            players[i] = new Player();
            players[i].PlayerDrawCards();
            players[i].SetPlayerMoney(moneyPerPlayer);
        }
        this.cardFlopOne = DrawCard();
        this.cardFlopTwo = DrawCard();
        this.cardFlopThree = DrawCard();
        
        roundcounter = 1;
    }

    public ResetGame() {
        potMoney = 0;
        cardFlopOne = null;
        cardFlopTwo = null;
        cardFlopThree = null;
        cardTurn = null;
        cardRiver = null;
        roundcounter += 1;
    }
}
