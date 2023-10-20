import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private Card.Color wildCardColor;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public int getNumberOfPlayers() {
        int numPlayers = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the number of players (2-4): ");
            if (scanner.hasNextInt()) {
                numPlayers = scanner.nextInt();
                if (numPlayers >= 2 && numPlayers <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Invalid number of players. Please enter 2, 3, or 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer (2-4).");
                scanner.next();
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
            System.out.println("Enter 0 to draw a card or the index of the card to play: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter 0 to draw a card or the index of the card to play: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 0);
        return choice;
    }

    public void displayPlayerHand(Player player) {
        System.out.println(player.toString() + "'s Hand:");
        ArrayList<Card> cards = player.getCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ": " + cards.get(i).toString());
        }
    }
    public Card.Color chooseWildColor() {
        Card.Color wildCardColor = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose a color for the Wild card (BLUE, GREEN, YELLOW, RED): ");
        String colorInput = scanner.next().toUpperCase();

        switch (colorInput) {
            case "BLUE":
                wildCardColor = Card.Color.BLUE;
                break;
            case "GREEN":
                wildCardColor = Card.Color.GREEN;
                break;
            case "YELLOW":
                wildCardColor = Card.Color.YELLOW;
                break;
            case "RED":
                wildCardColor = Card.Color.RED;
                break;
            default:
                System.out.println("Invalid color choice. Please choose from BLUE, GREEN, YELLOW, or RED.");
                wildCardColor = chooseWildColor(); // Recursively prompt for a valid color
        }

        return wildCardColor;
    }
    public void displayGameState(Player currentPlayer, Card topCard) {
        System.out.println("Top card: " + topCard.toString());
        System.out.println(currentPlayer.getName() + "'s Hand:");
        ArrayList<Card> playerCards = currentPlayer.getCards();
        for (int i = 0; i < playerCards.size(); i++) {
            System.out.println((i + 1) + ": " + playerCards.get(i).toString());
        }
    }
    public void close() {
        scanner.close();
    }

    public void displayPlayerScores(ArrayList<Player> players) {
        System.out.println("Game over! Scores:");
        for (Player player : players) {
            System.out.println(player.toString() + ": " + player.getScore());
        }
    }



}