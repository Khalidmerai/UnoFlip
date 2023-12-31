package SRC.GUI.views;

import SRC.GUI.GameViewFrame;
import SRC.GUI.controllers.WildController;
import SRC.GUI.models.Game;
import SRC.GUI.models.Player;
import SRC.cards.Card;
import SRC.cards.DoubleSidedCard;

import javax.swing.*;

/**
 * The portion of the UNO interface that pops up if a Wild card is played and selects the new colour.
 */
public class WildView extends JOptionPane implements GameView {
    private Game game;
    private WildController controller;
    private GameViewFrame superFrame;

    public WildView(GameViewFrame superFrame, Game game){
        this.game = game;
        this.superFrame = superFrame;
        controller = new WildController(game, this);
    }

    /**
     * Displays a custom error message
     *
     * @param message The error message to be displayed
     */
    public void showErrorMessage(String message){
        this.showMessageDialog(superFrame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays the chose colour pop
     *
     * @param strOptions The options for the popup
     */
    public int getColour(String strOptions[]){
        return this.showOptionDialog(superFrame, "Choose one of the buttons below:", "WILD card selection",
                this.DEFAULT_OPTION, this.PLAIN_MESSAGE, null, strOptions, strOptions[0]);
    }

    @Override
    public void setGame(Game game) {

    }

    @Override
    public void handleNewGame() {

    }

    @Override
    public void handleNewTurn(Player player) {

    }

    @Override
    public void handlePlayCard(Card playedCard, String additionalMessage) {
        if (additionalMessage.equals("WILD")){
            controller.requestWildColour();
        }
    }

    @Override
    public void handleDrawCard(Card drawnCard) {

    }

    @Override
    public void handleGetColour() {

    }

    @Override
    public void handleUpdateTurnOrder(boolean turnReversed) {

    }

    @Override
    public void handleAiPlayerTurn(Player currentPlayer, DoubleSidedCard playedCard, Card.Colour currentColour) {

    }

}