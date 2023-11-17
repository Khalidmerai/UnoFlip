package SRC;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UnoView extends JPanel {
    private UnoGame unoGame;

    public UnoView(UnoGame unoGame) {
        this.unoGame = unoGame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Create a label for the top card
        Card topCard = unoGame.getTopCard();
        JLabel topCardLabel = new JLabel(getImageIconForCard(topCard));
        add(topCardLabel, BorderLayout.NORTH);

        // Create a panel for the player's cards
        JPanel playerCardsPanel = new JPanel(new FlowLayout());
        add(playerCardsPanel, BorderLayout.CENTER);

        // Display the player cards
        ArrayList<Card> playerCards = unoGame.getCurrentPlayerCards();
        for (Card card : playerCards) {
            JLabel cardLabel = new JLabel(getImageIconForCard(card));
            playerCardsPanel.add(cardLabel);
        }

        // Create a button for drawing a card
        JButton drawButton = new JButton("Draw Card");
        drawButton.addActionListener((e) -> drawCard());
        add(drawButton, BorderLayout.SOUTH);
    }


    private ImageIcon getImageIconForCard(Card card) {


        return new ImageIcon(); // Placeholder, replace with actual implementation
    }

    private void drawCard() {
        // Implement logic for drawing a card
    }
}
