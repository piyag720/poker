package cblproject;

import java.util.HashMap; 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author piyus
 */
public class Cards {
    
    HashMap<Integer, String> cardList = new HashMap<>();

    
  public Cards() {
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
 
        int number = 1;
        for (int s = 0; s < suits.length; s++) {
            for (int r = 0; r < ranks.length; r++) {
                cardList.put(number, ranks[r] + suits[s]);
                number++;
            }
        }
    }
 
    public String NumtoCard(int[] a) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            String card = cardList.get(a[i]);
            if (card == null) {
                continue;
            }
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(card);
        }
        return result.toString();
    }
    
    
}
