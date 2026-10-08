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

    public PlayerDrawCards() {
        this.cardOne = PokerGame.drawnCard;
        this.cardTwo = PokerGame.drawnCard;
    }

    public SetPlayerMoney(int money) {
        this.money = money;
    }

    public int ChangePlayerMoney(int money){
        if(this.money = money < 0) {
            return 1;
        } else {
            this.money -= money;
            return 0;
        }
    }
}
