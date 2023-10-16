public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();

        int numPlayers = ui.getNumberOfPlayers();
        String[] playerNames = ui.getPlayerNames(numPlayers);

        // Initialize UnoGame, Player, Card, and Deck objects and start the game here
        // UnoGame unoGame = new UnoGame(numPlayers, playerNames);

        // Implement the game loop here

        // When the game ends, display the winner and other game stats

        ui.close();
    }
}