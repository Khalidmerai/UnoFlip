package SRC.cards;

import SRC.GUI.models.Game;

/**
 * A Flip card in a game of UNO Flip.
 */
public class FlipCard extends Card {
    /**
     * Creates a Flip card
     *
     * @param cardSide The side of the card
     * @throws IllegalArgumentException if an invalid color is provided.
     */
    public FlipCard(Card.Colour colour, Card.Side cardSide) throws IllegalArgumentException{
        super(colour, Symbol.FLIP, cardSide);
    }
    @Override
    public boolean cardAction(Game game) {
        game.flip();
        return false;
    }
}