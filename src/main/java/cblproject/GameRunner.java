package cblproject;
import java.util.Scanner;

import cblproject.PokerGame;

public class GameRunner {
    public static void main(String[] args) {
        int amountOfPlayers = 2;
        int moneyPerPlayer = 100;
        int[][] playerCards = new int[amountOfPlayers][2];


        PokerGame theGame = new PokerGame(amountOfPlayers, moneyPerPlayer);

        for (int i = 0; i < playerCards.length; i++) {
            playerCards[i] = theGame.showCards(i);
            System.out.println(playerCards[i][0]);
            System.out.println(playerCards[i][1]);
        }

        int[] playerBetAmount = new int[amountOfPlayers];
        int highetsBettingPlayer = 0;
        int betTurn = 0;

        Scanner scanner = new Scanner(System.in);
        while (betTurn < amountOfPlayers) {
            int bet = scanner.nextInt();
            if (bet + playerBetAmount[betTurn] == playerBetAmount[highetsBettingPlayer])
            
            betTurn += 1;
        }

    }
    
}
