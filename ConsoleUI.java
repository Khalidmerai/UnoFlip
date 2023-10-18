import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

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

    public void close() {
        scanner.close();
    }
}