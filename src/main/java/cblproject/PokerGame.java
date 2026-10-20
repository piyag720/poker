package cblproject;

import java.util.*;

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
    int[] startingMoney;
    Player[] players;
    int potMoney = 0;
    int cardFlopOne = 0;
    int cardFlopTwo = 0;
    int cardFlopThree = 0;
    int cardTurn = 0;
    int cardRiver = 0;

    boolean forceCall = false;
    int roundCounter = 0;

    
    public PokerGame(int amountOfPlayers, int moneyPerPlayer) {
        for(int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = i + 1;
        }
        players = new Player[amountOfPlayers];
        for(int i = 0; i < players.length; i++) {
            int cardOne = drawCard();
            int cardTwo = drawCard();
            players[i] = new Player();
            players[i].playerDrawCards(cardOne, cardTwo);
            players[i].setPlayerMoney(moneyPerPlayer);
        }
        this.cardFlopOne = drawCard();
        this.cardFlopTwo = drawCard();
        this.cardFlopThree = drawCard();
        
        this.roundCounter = 1;
    }

    public void dealAgain() {
        for(int i = 0; i < players.length; i++) {
            int cardOne = drawCard();
            int cardTwo = drawCard();
            players[i].playerDrawCards(cardOne, cardTwo);
        }
        this.cardFlopOne = drawCard();
        this.cardFlopTwo = drawCard();
        this.cardFlopThree = drawCard();
    }

    public void forceCall(Player player) {
        playerBet(player, player.money);
    }

    public int playerBet(Player player, int money) {
        int error = player.changePlayerMoney(-money);
        if (error == 0) {
            this.potMoney += money;
            return 0;
        } else {
            return 1;
        }
    }

    public void winningPlayer(Player player) {
        player.changePlayerMoney(this.potMoney);
        this.potMoney = 0;
        this.cardFlopOne = 0;
        this.cardFlopTwo = 0;
        this.cardFlopThree = 0;
        this.cardTurn = 0;
        this.cardRiver = 0;
        for(int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = i + 1;
        }
        this.roundCounter += 1;
    }

    public int drawCard() {
        Random randomGenerator;
        randomGenerator = new Random();
        int drawnCard = 0;
        int randomNumber;
        while (drawnCard == 0) {
            randomNumber = randomGenerator.nextInt(52);
            drawnCard = deckOfCards[randomNumber];
            deckOfCards[randomNumber] = 0;
        }
        return drawnCard;
    }

    public int[] showCards(int player) {
        int[] cards = new int[2];
        cards = players[player].showCards();
        return cards;
    }
    
    public void drawTurn() {
        this.cardTurn = drawCard();
    }

    public void drawRiver() {
        this.cardRiver = drawCard();
    }

    public int[] showTable() {
        int[] table = new int[5];
        table[0] = this.cardFlopOne;
        table[1] = this.cardFlopTwo;
        table[2] = this.cardFlopThree;
        table[3] = this.cardTurn;
        table[4] = this.cardRiver;
        return table;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void printCardDeck() {
        for(int i = 0; i < deckOfCards.length; i++) {
            System.out.println(deckOfCards[i]);
        }
    }
}
