package SRC.cards;

import SRC.GUI.models.Game;

/**
 * A skip everyone card in a game of UNO Flip.
 */
public class SkipEveryoneCard extends Card {
    /**
     * Creates a draw 5 card with the specified color.
     *
     * @param colour The color of the card.
     * @throws IllegalArgumentException if an invalid color is provided.
     */
    public SkipEveryoneCard(Card.Colour colour) throws IllegalArgumentException{
        super(colour, Symbol.SKIP_EVERYONE, Card.getSideFromColour(colour));
    }
    @Override
    public boolean cardAction(Game game) {
        game.setSkipEveryone();

        return false;
    }
}
