package SRC.cards;

import SRC.GUI.models.Game;
public class NormalCard extends Card {
    /**
     * Creates a numbered Uno card with the specified color and number.
     *
     * @param colour The color of the card.
     * @param symbol The number of the card.
     * @throws IllegalArgumentException if an invalid color is provided.
     */
    public NormalCard(Card.Colour colour, Card.Symbol symbol) throws IllegalArgumentException{
        super(colour, symbol, Card.getSideFromColour(colour));
    }
    @Override
    public boolean cardAction(Game game) {
        return false;
    }
}
