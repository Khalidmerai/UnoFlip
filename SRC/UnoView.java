package SRC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.awt.BorderLayout.*;

public class UnoView extends JFrame {
    private JLabel players;
    private JTextField numOfPlayers;
    private JButton startButton;
    private ArrayList<String> playerNames;

    private ArrayList<JButton> cardButtons = new ArrayList<JButton>();
    private UnoGame unoGame;



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


        add(playerInfoPanel, CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add action listeners
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the start game action
                startGame();

                //creating a JFrame background
                JFrame frame = new JFrame("Uno Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.setSize(600,400);
                frame.setVisible(true);

                //Writing the player name
                // Create a JLabel with text
                JLabel playerName = new JLabel("Player1");


                frame.add(playerName, BorderLayout.NORTH);



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
    /**
    public void setButtonIcon(){
        String listString = unoGame.getPlayers(unoGame.getCurrentPlayer()).stream().map(Objects::toString).collect(Collectors.joining(","));
        String[] cardNames = listString.split(",");
        ArrayList<String> cardId = new ArrayList<>(Arrays.asList(cardNames));
        //card for the players hand
        for(int i = 0; i<cardId.size(); i++){
           // cardButtons.get(i).setIcon(//we need to add the pictures of the card);
        }
        //if they dont have the card
        for(int i = cardId.size(); i<cardButtons.size();i++){
            cardButtons.get(i).setIcon(null);
        }
    }
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UnoView();
        });
    }
}
