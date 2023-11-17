package SRC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnoController {
    private UnoGame model;
    private UnoGUI view;
    private  ConsoleUI ui;


    public UnoController(UnoGame model, UnoGUI view) {
        this.model = model;
        this.view = view;

    }

    // Player chooses to draw a card
    public void drawCard() {
        Player currentPlayer = model.getCurrentPlayer();
        model.drawCard(currentPlayer);
        updateView(); // Updating the GUI with new model changes
    }

    // Player plays a card from their hand
    public void playCard(Card card) {
        Player currentPlayer = model.getCurrentPlayer();
        model.playCard(currentPlayer, card, ui);
        updateView();
    }

    // Update the view with the current game state
    private void updateView() {
        // This method should update the displayed GUI
    }

    // End current player turn and switch to the next player
    public void endTurn() {
        model.nextPlayer();
        updateView();
    }

    // Handle special cards like wild cards
    public void handleSpecialCard(Card card) {
        // Here we should have special card handling logic
    }

    // Listener for drawing a card
    private class DrawCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            drawCard();
        }
    }

    // Listener for playing a card
    private class PlayCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // You need to obtain the selected card from your GUI and pass it to playCard method
            //Card selectedCard = view.getSelectedCard();
            //playCard(selectedCard);
        }
    }

    // Listener for ending the turn
    private class EndTurnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            endTurn();
        }
    }
}
