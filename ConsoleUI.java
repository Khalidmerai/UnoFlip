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

    public void close() {
        scanner.close();
    }


}