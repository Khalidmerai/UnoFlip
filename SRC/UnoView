package SRC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnoView extends JFrame {
    private JLabel players;
    private JTextField numOfPlayers;
    private JButton startButton;
    private ArrayList<String> playerNames;

    public UnoView() {
        // Create a JFrame
        super("UNO");


        setLayout(new BorderLayout());

        // Create a panel for collecting player information
        JPanel playerInfoPanel = new JPanel();
        players = new JLabel("Enter the number of players (2-4):");
        numOfPlayers = new JTextField(2);
        startButton = new JButton("Start Game");
        playerInfoPanel.add(players);
        playerInfoPanel.add(numOfPlayers);
        playerInfoPanel.add(startButton);


        add(playerInfoPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add action listeners
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the start game action
                startGame();
            }
        });

        // Initializing the playerNames ArrayList
        playerNames = new ArrayList<>();
        pack();
        setVisible(true);
    }

    private void startGame() {
        try {
            int numPlayers = Integer.parseInt(numOfPlayers.getText());

            if (numPlayers >= 2 && numPlayers <= 4) {
                // Create a list of Player objects
                ArrayList<Player> players = new ArrayList<>();
                for (int i = 0; i < numPlayers; i++) {
                    String playerName = JOptionPane.showInputDialog("Enter the name for Player " + (i + 1) + ":");
                    if (playerName != null && !playerName.isEmpty()) {
                        players.add(new Player(playerName)); // Create a Player object for each player
                    } else {
                        JOptionPane.showMessageDialog(this, "Please enter a valid player name.");
                        return;  // Exit if player name is not provided
                    }
                }

                // Create a Deck for the game
                Deck deck = new Deck();
                deck.shuffle();

                // start the game
                new UnoGame(players, deck); // Initializing  game with players and deck
                dispose(); // Close the setup GUI
            } else {
                JOptionPane.showMessageDialog(this, "Invalid number of players. Please enter 2, 3, or 4.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter an integer (2-4).");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UnoView();
        });
    }
}
