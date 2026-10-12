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
    int cardOne = 0;
    int cardTwo = 0;
    int[] cards;

    public void playerDrawCards(int cardOne, int cardTwo) {
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
    }

    public void setPlayerMoney(int money) {
        this.money = money;
    }

    public int changePlayerMoney(int money){
        if(this.money + money < 0) {
            return 1;
        } else {
            this.money += money;
            return 0;
        }
    }

    public int[] showCards() {
        cards = new int[2];
        cards[0] = this.cardOne;
        cards[1] = this.cardTwo;
        return cards;
    }
}
