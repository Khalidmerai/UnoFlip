import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public int getNumberOfPlayers() {
        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > 4) {
            System.out.print("Enter the number of players (2-4): ");
            numPlayers = scanner.nextInt();
            if (numPlayers < 2 || numPlayers > 4) {
                System.out.println("Invalid number of players. Please enter 2, 3, or 4.");
            }
        }
        return numPlayers;
    }

    public String[] getPlayerNames(int numPlayers) {
        String[] playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name for Player " + (i + 1) + ": ");
            playerNames[i] = scanner.next();
        }
        return playerNames;
    }

    public int getPlayOrDrawChoice() {
        int choice;
        do {
            System.out.println("Enter 0 to draw a card or 1 to play a card: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter 0 to draw a card or 1 to play a card: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 0 || choice > 1);
        return choice;
    }

    public int getCardToPlay(Player currentPlayer) {
        int cardIndex;
        do {
            System.out.println("Enter the index of the card you want to play: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter the index of the card you want to play: ");
                scanner.next();
            }
            cardIndex = scanner.nextInt();
        } while (cardIndex < 0 || cardIndex >= currentPlayer.getCards().size());
        return cardIndex;
    }

    public Card selectCardToPlay(Player currentPlayer) {
        int cardIndex = getCardToPlay(currentPlayer);
        return currentPlayer.getCards().get(cardIndex);
    }

    public void displayPlayerHand(Player player) {
        System.out.println(player.toString() + "'s Hand:");
        ArrayList<Card> cards = player.getCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i).toString());
        }
    }

    public void close() {
        scanner.close();
    }
}