package SRC.cards;

import SRC.GUI.models.Game;

/**
 * A Draw One card in a game of UNO Flip.
 */
public class DrawOneCard extends Card {
    /**
     * Creates a new Uno Draw One card with the specified color.
     *
     * @param colour The color of the card.
     * @throws IllegalArgumentException if an invalid color is provided.
     */
    public DrawOneCard(Card.Colour colour) throws IllegalArgumentException{
        super(colour, Card.Symbol.DRAW_ONE, Card.getSideFromColour(colour));
    }
    @Override
    public boolean cardAction(Game game) {
        int nextPlayer = game.nextPlayer();
        // TODO: Replace this with game.drawCard() to avoid errors
        DoubleSidedCard drawnCard = game.getDeck().pop();

        game.getPlayers().get(nextPlayer).dealCard(drawnCard);

        return false;
    }
}