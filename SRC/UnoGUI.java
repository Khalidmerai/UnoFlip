package SRC;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UnoGUI extends JFrame {
    private JButton start, mainMenu, draw, addPlayer, undo, endTurn, discardPile;
    private ArrayList<ImageIcon> cardsImages;
    private UnoGame unoGame;
    private JPanel cardPanel;
    private Deck deck;
    private JSpinner numOfPlayersSpinner;
    private Card card;

    public UnoGUI() {
        super("Uno");

        // Initialize deck
        deck = new Deck();


        // Initialize components
        cardsImages = new ArrayList<>();
        start = new JButton("Press to Start a new Game");
        draw = new JButton("Draw Card");
        endTurn = new JButton("End Turn");
        cardPanel = new JPanel(new GridLayout(1, 0));

        // Set up layout
        this.setLayout(new BorderLayout());
        this.add(cardPanel, BorderLayout.CENTER);
        this.add(draw, BorderLayout.SOUTH);
        this.add(endTurn, BorderLayout.EAST);

        // Add action listeners
        start.addActionListener((e) -> startFrame());
        draw.addActionListener((e) -> drawCard());
        endTurn.addActionListener((e) -> endTurn());

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        startFrame();
        UnoGameScreen();
    }

    private ArrayList<Player> createPlayers(int numPlayers) {

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }

        return players;
    }


    private void startFrame() {
        // Create a spinner to get the number of players
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(2, 2, 4, 1);
        numOfPlayersSpinner = new JSpinner(spinnerModel);

        // Create a panel to hold the spinner
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.add(new JLabel("Select the number of players: "));
        spinnerPanel.add(numOfPlayersSpinner);

        // Display a dialog with the spinner to get the number of players
        int result = JOptionPane.showConfirmDialog(
                this,
                spinnerPanel,
                "Number of Players",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            // If User clicks OK, proceed with getting player names
            int numPlayers = (int) numOfPlayersSpinner.getValue();

            ArrayList<String> playerNames = new ArrayList<>();

            JFrame nameFrame = new JFrame("Enter Player Names");
            nameFrame.setLayout(new GridLayout(numPlayers + 1, 2));

            for (int i = 0; i < numPlayers; i++) {
                String playerName = JOptionPane.showInputDialog(nameFrame, "Enter the name for Player " + (i + 1) + ":");
                if (playerName == null || playerName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(nameFrame, "Please enter a valid player name.");
                    nameFrame.dispose();
                    return;
                }
                playerNames.add(playerName.trim());
            }

            nameFrame.dispose();

            unoGame = createUnoGame(playerNames);

            
            JFrame gameFrame = new JFrame("UNO Game");
            UnoView gameView = new UnoView(unoGame);
            gameFrame.add(gameView);
            gameFrame.setSize(800, 600);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setVisible(true);

            // Close the current setup GUI
            dispose();
        }
    }





    private ArrayList<Player> createPlayers(ArrayList<String> playerNames) {
        ArrayList<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        return players;
    }


    private UnoGame createUnoGame(ArrayList<String> playerNames) {
        // Check if the number of players is valid (2 to 4 players)
        if (playerNames.size() < 2 || playerNames.size() > 4) {
            throw new IllegalArgumentException("Invalid number of players. Please enter 2, 3, or 4.");
        }

        // Create an UnoGame instance with players and the deck
        return new UnoGame(createPlayers(playerNames), deck);
    }

    private void UnoGameScreen() {
        // Clear the existing card images from the card panel
        cardPanel.removeAll();

        // Display the top card
        Card topCard = unoGame.getTopCard();
        JLabel topCardLabel = new JLabel(getImageIconForCard(topCard));
        cardPanel.add(topCardLabel);

        // Display the player cards
        ArrayList<Card> playerCards = unoGame.getCurrentPlayerCards();

        for (Card card : playerCards) {
            JLabel cardLabel = new JLabel(getImageIconForCard(card));
            cardPanel.add(cardLabel);
        }

        // Add the draw button
        cardPanel.add(draw);

        // Update the GUI
        revalidate();
        repaint();
    }


    private ImageIcon getImageIconForCard(Card card) {
        // Implement this method to convert a Card object to its corresponding ImageIcon
        // Use the cardsImages list or load images from files
        // ...
        // Create a map of ranks and corresponding image file names
        Map<String, String> cardImageMap = new HashMap<>();

        //we need to find the a way to get all the card images in one folder and just call that
        cardImageMap.put("2", "blue_2.png" ); //we need to find the folder that allows to get the card naming and stuff

        //Retrieve the corresponding image file name based on the card's rank
        String imageFileName = cardImageMap.get(card.getValue());

        // Use the getResource() method to load the image from the classpath
        URL imageUrl = getClass().getResource(imageFileName);

        // Check if the image URL is valid, otherwise return null
        if(imageUrl == null){
            return null;
        }
        // Create and return a new ImageIcon from the image URL
        return new ImageIcon(imageUrl); // Placeholder, replace with actual implementation
    }





    private void drawCard() {

    }

    private void endTurn() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UnoGUI();
        });
    }
}
