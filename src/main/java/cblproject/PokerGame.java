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
    Player[] players;
    int potMoney = 0;
    int cardFlopOne = 0;
    int cardFlopTwo = 0;
    int cardFlopThree = 0;
    int cardTurn = 0;
    int cardRiver = 0;

    int roundcounter = 0;

    
    public PokerGame(int amountOfPlayers, int moneyPerPlayer) {
        for(int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = i + 1;
        }
        players = new Player[amountOfPlayers];
        for(int i = 0; i < players.length; i++) {
            int cardOne = DrawCard();
            int cardTwo = DrawCard();
            players[i] = new Player();
            players[i].PlayerDrawCards(cardOne, cardTwo);
            players[i].SetPlayerMoney(moneyPerPlayer);
        }
        this.cardFlopOne = DrawCard();
        this.cardFlopTwo = DrawCard();
        this.cardFlopThree = DrawCard();
        
        this.roundcounter = 1;
    }

    public void HandValue(int cardOne, int cardTwo) {

    }

    public int PlayerBet(Player player, int money) {
        int error = player.ChangePlayerMoney(money);
        if (error == 0) {
            this.potMoney += money;
            return 0;
        } else {
            return 1;
        }
    }

    public void WinningPlayer(Player player) {
        player.ChangePlayerMoney(-potMoney);
        this.potMoney = 0;
        this.cardFlopOne = 0;
        this.cardFlopTwo = 0;
        this.cardFlopThree = 0;
        this.cardTurn = 0;
        this.cardRiver = 0;
        this.roundcounter += 1;
    }

    public int DrawCard() {
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

    public int[] ShowCards(int player) {
        int[] cards = new int[2];
        cards = players[player - 1].ShowCards();
        return cards;
    }
}
