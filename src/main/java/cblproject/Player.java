/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cblproject;

/**
 *
 * @author TB
 */
public class Player {
    String playerName = null;
    int money = 0;
    int cardOne = null;
    int cardTwo = null;

    Public PlayerDrawCards() {
        this.cardOne = PokerGame.drawnCard;
        this.cardTwo = PokerGame.drawnCard;
    }

    Public SetPlayerMoney(int money) {
        this.money = money;
    }
}
