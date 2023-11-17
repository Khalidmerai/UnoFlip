package SRC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnoController {
    private UnoGame model;
    private UnoGUI view;

    public UnoController(UnoGame model, UnoGUI view) {
        this.model = model;
        this.view = view;

        //we need to initialize event listeners here
    }

    //start the Uno game
    public void startGame() {
        model.startGame();
        //we need to have the game loop here
    }

    //player chooses to draw a card
    public void drawCard() {
        Player currentPlayer = model.getCurrentPlayer();
        model.drawCard(currentPlayer);
        updateView(); //updating the gui with new model changes
    }

    //player plays a card from their hand
    public void playCard(Card card) {
        Player currentPlayer = model.getCurrentPlayer();
        //model.playCard(currentPlayer, card);
        updateView();
    }

    //update the view with current game state
    private void updateView() {
        //this method should update the gui displayed
    }

    //end current player turn and switch to next player
    public void endTurn() {
        model.nextPlayer();
        updateView();
    }

    //handle special cards like wild cards
    public void handleSpecialCard(Card card) {
        //here we should have special card handling logic
    }

    //we probably need other methods, and we need to add listeners

    //end of the game
    private void endGame() {
        //end game logic
    }
}