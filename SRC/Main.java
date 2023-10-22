package SRC;

import SRC.Card;
import SRC.ConsoleUI;
import SRC.Deck;

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

        UnoGame unoGame = new UnoGame(players, new Deck());

        // Implement the game loop
        while (!unoGame.hasGameEnded()) {
            Player currentPlayer = unoGame.getCurrentPlayer();

            ui.displayPlayerHand(currentPlayer); // Display the player's hand

            int choice = ui.getPlayOrDrawChoice();
            if (choice == 0) {
                unoGame.drawCard(currentPlayer);
                unoGame.displayTopCard();
                //add draw handler (if playable then give option to play card (no draw option) or next turn)
            } else {
                int cardIndex = choice - 1; // Adjust for 1-based indexing

                if (cardIndex >= 0 && cardIndex < currentPlayer.getCards().size()) {
                    Card cardToPlay = currentPlayer.getCards().get(cardIndex);

                    if (cardToPlay.getType() == Card.Type.WILD) {
                        Card.Color chosenColor = ui.chooseWildColor();
                        unoGame.handleSpecialCard(cardToPlay, currentPlayer, chosenColor,ui);
                    } else {
                        unoGame.playCard(currentPlayer, cardToPlay, ui);
                    }

                    // Check if the card is chosen for the reverse, it needs to reverse
                    if (cardToPlay.getType() == Card.Type.REVERSE) {
                        unoGame.reverseDirection();
                    }

                    unoGame.displayTopCard();
                } else {
                    System.out.println("Invalid card index. Please try again.");
                }
            }
        }

        // Game has ended, calculate scores and display them
        unoGame.endGame();
        ui.displayPlayerScores(unoGame.getPlayers());

        ui.close();
    }
}

