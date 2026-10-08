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
    
    public int HandValue(int cardOne, int cardTwo) {

    }

    public int DrawCard() {
        randomGenerator = new Random(Math.random());
        int drawnCard = 0;
        int randomNumber;
        while(drawnCard == 0) {
            randomNumber = randomGenerator.nextInt(52);
            drawnCard = deckOfCards[randomNumber];
            deckOfCards[randomNumber] = 0;
        }
        return drawnCard;
    }

    public int StartGame(int amountOfPlayers, int moneyPerPlayer) {
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
    }
}
