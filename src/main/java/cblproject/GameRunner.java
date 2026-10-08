import cblproject.PokerGame;

public class GameRunner {
    public static void main(String[] args) {
        PokerGame theGame = new PokerGame();
        int amountOfPlayers = 2;
        int moneyPerPlayer = 100;
        int[] playerOneCards;
        int[] playerTwoCards;
        
        theGame.StartGame(amountOfPlayers, moneyPerPlayer);
        playerOneCards = theGame.player[0].ShowCards();
        playerTwoCards = theGame.player[1].ShowCards();

    }
    
}
