/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cblproject;

/**
 *
 * @author piyus
 */
public class Winner {
    
    public int winnerPlayer = -1;
    public String handName = "";
 
    String[] names = {"", "a high card", "a pair", "two pair", "three of a kind", "a straight", "a flush", "a full house", "four of a kind", "a straight flush", "a royal flush"};
 
    public void check(String[] player1, String[] player2, String[] table) {
        String[] cards1 = new String[7];
        String[] cards2 = new String[7];
 
        for (int i = 0; i < 2; i++) {
            cards1[i] = player1[i];
            cards2[i] = player2[i];
        }
        for (int i = 0; i < 5; i++) {
            cards1[i + 2] = table[i];
            cards2[i + 2] = table[i];
        }
 
        for (int i = 0; i < 7; i++) {
            if (!valid(cards1[i]) || !valid(cards2[i])) {
                winnerPlayer = -2;
                handName = "missing cards";
                return;
            }
        }
 
        int value1 = score(cards1);
        int value2 = score(cards2);
 
        if (value1 > value2) {
            winnerPlayer = 0;
            handName = names[value1 / 100];
        } else if (value2 > value1) {
            winnerPlayer = 1;
            handName = names[value2 / 100];
        } else {
            winnerPlayer = -1;
            handName = names[value1 / 100];
        }
    }
 
    boolean valid(String card) {
        return card != null && card.length() >= 2 && suitOf(card) >= 0;
    }
 
    int rankOf(String card) {
        String text = card.substring(0, card.length() - 1);
        if (text.equals("J")) {
            return 11;
        }
        if (text.equals("Q")) {
            return 12;
        }
        if (text.equals("K")) {
            return 13;
        }
        if (text.equals("A")) {
            return 14;
        }
        return Integer.parseInt(text);
    }
 
    int suitOf(String card) {
        String suits = "♠♥♦♣";
        return suits.indexOf(card.charAt(card.length() - 1));
    }
 
    int straightTop(int[] count) {
        for (int top = 14; top >= 6; top--) {
            boolean found = true;
            for (int r = top; r > top - 5; r--) {
                if (count[r] == 0) {
                    found = false;
                }
            }
            if (found) {
                return top;
            }
        }
        if (count[14] > 0 && count[2] > 0 && count[3] > 0 && count[4] > 0 && count[5] > 0) {
            return 5;
        }
        return 0;
    }
 
    int score(String[] cards) {
        int[] count = new int[15];
        int[] suitCount = new int[4];
        for (int i = 0; i < 7; i++) {
            count[rankOf(cards[i])]++;
            suitCount[suitOf(cards[i])]++;
        }
 
        int flushSuit = -1;
        for (int s = 0; s < 4; s++) {
            if (suitCount[s] >= 5) {
                flushSuit = s;
            }
        }
 
        int flushHigh = 0;
        int straightFlushTop = 0;
        if (flushSuit >= 0) {
            int[] flushCount = new int[15];
            for (int i = 0; i < 7; i++) {
                if (suitOf(cards[i]) == flushSuit) {
                    int rank = rankOf(cards[i]);
                    flushCount[rank]++;
                    if (rank > flushHigh) {
                        flushHigh = rank;
                    }
                }
            }
            straightFlushTop = straightTop(flushCount);
        }
 
        if (straightFlushTop == 14) {
            return 1000 + 14;
        }
        if (straightFlushTop > 0) {
            return 900 + straightFlushTop;
        }
 
        int four = 0;
        int three = 0;
        int pairs = 0;
        int pairHigh = 0;
        int high = 0;
        for (int r = 2; r <= 14; r++) {
            if (count[r] > 0) {
                high = r;
            }
            if (count[r] == 4) {
                four = r;
            }
            if (count[r] == 3) {
                three = r;
            }
            if (count[r] == 2) {
                pairs++;
                pairHigh = r;
            }
        }
 
        if (four > 0) {
            return 800 + four;
        }
 
        int otherPair = 0;
        for (int r = 2; r <= 14; r++) {
            if (count[r] >= 2 && r != three) {
                otherPair = r;
            }
        }
        if (three > 0 && otherPair > 0) {
            return 700 + three;
        }
 
        if (flushSuit >= 0) {
            return 600 + flushHigh;
        }
 
        int straight = straightTop(count);
        if (straight > 0) {
            return 500 + straight;
        }
 
        if (three > 0) {
            return 400 + three;
        }
        if (pairs >= 2) {
            return 300 + pairHigh;
        }
        if (pairs == 1) {
            return 200 + pairHigh;
        }
        return 100 + high;
    }
    
}
