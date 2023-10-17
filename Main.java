import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();

        int numPlayers = ui.getNumberOfPlayers();
        String[] playerNames = ui.getPlayerNames(numPlayers);

        // Create players and initialize the Uno game
        ArrayList<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }

        UnoGame unoGame = new UnoGame(players);

        // Implement the game loop
        while (!unoGame.hasGameEnded()) {
            Player currentPlayer = unoGame.getCurrentPlayer();
            ui.displayPlayerHand(currentPlayer);

            int choice = ui.getPlayOrDrawChoice();
            if (choice == 0) {
                unoGame.drawCard(currentPlayer);
            } else if (choice == 1) {
                Card cardToPlay = ui.selectCardToPlay(currentPlayer);
                unoGame.playCard(currentPlayer, cardToPlay);
            }
        }

        // Display the winner and other game stats
        Player winner = unoGame.getWinner();
        System.out.println("Game over! The winner is: " + winner);

        ui.close();
    }
}
