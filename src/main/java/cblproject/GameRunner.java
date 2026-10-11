import cblproject.PokerGame;

public class GameRunner {
    public static void main(String[] args) {
        int amountOfPlayers = 2;
        int moneyPerPlayer = 100;
        int[] playerOneCards = new int[2];
        int[] playerTwoCards = new int[2];

        PokerGame theGame = new PokerGame(amountOfPlayers, moneyPerPlayer);

        playerOneCards = theGame.ShowCards(1);
        playerTwoCards = theGame.ShowCards(2);

        System.out.println("got there");

    }
    
}
