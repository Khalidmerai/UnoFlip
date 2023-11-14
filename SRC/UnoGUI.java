package SRC;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UnoGUI extends JFrame {
    private JButton start, draw, endTurn,nextPlayer;
    private ArrayList<ImageIcon> cardsImages;
    private UnoGame unoGame;
    private JPanel cardPanel;
    private Deck deck;
    private JSpinner numOfPlayersSpinner;
    private Card card;
    private JLabel currentPlayerLabel;
    private JLabel topCardLabel;
    private JPanel playerHandPanel;
    private JTextPane messagesTextPane;
    private Player currentPlayer;
    private Card topCard;
    private JPanel topCardPanel;

    public UnoGUI() {

        // Initialize deck
        deck = new Deck();

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
            start = new JButton("Press to Start a new Game");
            draw = new JButton("Draw Card");
            endTurn = new JButton("End Turn");
            cardPanel = new JPanel(new GridLayout(1, 0));

            // Set up layout
            gameFrame.setLayout(new BorderLayout());
            gameFrame.add(cardPanel, BorderLayout.CENTER);
            gameFrame.add(draw, BorderLayout.SOUTH);
            gameFrame.add(endTurn, BorderLayout.EAST);


            // Add action listeners

            draw.addActionListener((e) -> drawCard());
            endTurn.addActionListener((e) -> endTurn());



            if(numPlayers == 2){
            // Create panels for top and bottom player hands
            JPanel topPlayerPanel = new JPanel(new GridLayout(1, 7)); // 7 for the number of cards
            JPanel bottomPlayerPanel = new JPanel(new GridLayout(1, 7));

            // Add placeholder buttons for each player's cards
            for (int i = 0; i < 7; i++) {
                topPlayerPanel.add(new JButton("Card " + (i + 1)));
                bottomPlayerPanel.add(new JButton("Card " + (i + 1)));
            }

            // Add the panels to the game frame
            gameFrame.add(topPlayerPanel, BorderLayout.NORTH);
            gameFrame.add(bottomPlayerPanel, BorderLayout.SOUTH);}

            else if(numPlayers == 3){
            // Create panels for top and bottom player hands
            JPanel topPlayerPanel = new JPanel(new GridLayout(1, 7)); // 7 for the number of cards
            JPanel bottomPlayerPanel = new JPanel(new GridLayout(1, 7));
            JPanel eastPlayerPanel = new JPanel(new GridLayout(1, 7));


            // Add placeholder buttons for each player's cards
            for (int i = 0; i < 7; i++) {
                topPlayerPanel.add(new JButton("Card " + (i + 1)));
                bottomPlayerPanel.add(new JButton("Card " + (i + 1)));
                eastPlayerPanel.add(new JButton("Card " + (i + 1)));
            }
                // Add the panels to the game frame
                gameFrame.add(topPlayerPanel, BorderLayout.NORTH);
                gameFrame.add(bottomPlayerPanel, BorderLayout.SOUTH);
                gameFrame.add(eastPlayerPanel, BorderLayout.EAST);}

            else if(numPlayers == 4){
            // Create panels for top and bottom player hands
            JPanel topPlayerPanel = new JPanel(new GridLayout(1, 7)); // 7 for the number of cards
            JPanel bottomPlayerPanel = new JPanel(new GridLayout(1, 7));
            JPanel eastPlayerPanel = new JPanel(new GridLayout(1, 7));
            JPanel westPlayerPanel = new JPanel(new GridLayout(1, 7));


            // Add placeholder buttons for each player's cards
            for (int i = 0; i < 7; i++) {
                topPlayerPanel.add(new JButton("Card " + (i + 1)));
                bottomPlayerPanel.add(new JButton("Card " + (i + 1)));
                eastPlayerPanel.add(new JButton("Card " + (i + 1)));
                westPlayerPanel.add(new JButton("Card " + (i + 1)));
            }
                // Add the panels to the game frame
                gameFrame.add(topPlayerPanel, BorderLayout.NORTH);
                gameFrame.add(bottomPlayerPanel, BorderLayout.SOUTH);
                gameFrame.add(eastPlayerPanel, BorderLayout.EAST);
                gameFrame.add(westPlayerPanel, BorderLayout.WEST);}





            gameFrame.setSize(1000, 1000);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setVisible(true);




            // Close the current setup GUI
            dispose();
        }
    }

    private void nextPlayer() {
    }
    private void displayPlayerHand(Player currentPlayer) {
        cardPanel.removeAll(); // Clear the panel

        for (Card card : currentPlayer.getCards()) {
            ImageIcon cardIcon = new ImageIcon(card.getImagePath());
            JButton cardButton = new JButton(cardIcon);
            cardButton.addActionListener((e) -> playCard(card));
            cardPanel.add(cardButton);
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }


    private void displayTopCard(Card topCard) {
        topCardPanel.removeAll();

        ImageIcon topCardIcon = new ImageIcon(topCard.getImagePath());
        JLabel topCardLabel = new JLabel(topCardIcon);
        topCardPanel.add(topCardLabel);

        topCardPanel.revalidate();
        topCardPanel.repaint();
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
    private void playCard(Card card) {
        // Implement logic to play the card
        // Refresh GUI after playing a card
    }

    private void UnoGameScreen() {
        // Clear the existing card images from the card panel
        cardPanel.removeAll();

        // Display the top card
        Card topCard = unoGame.getTopCard();
        JLabel topCardLabel = new JLabel(getImageIconForCard(topCard));
        cardPanel.add(topCardLabel);

        // Display the player cards
        ArrayList<Card> playerCards = unoGame.getCurrentPlayerCard();

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
