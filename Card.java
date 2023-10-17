import java.util.Objects;

/**
 * Represents an Uno card with color, type, and value.
 */
public class Card {
    private Color color;
    private Type type;
    private int value;

    /**
     * Enumeration for card colors.
     */
    public enum Color { BLUE, GREEN, YELLOW, RED, WILD }

    /**
     * Enumeration for card types.
     */
    public enum Type { NUMBER, REVERSE, SKIP, WILD, WILD_DRAW_TWO }

    /**
     * Creates a new Uno card.
     *
     * @param color The color of the card.
     * @param type The type of the card.
     * @param value The numerical value of the card.
     */
    public Card(Color color, Type type, int value) {
        this.color = color;
        this.type = type;
        this.value = value;
    }

    /**
     * Get the color of the card.
     *
     * @return The color of the card.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Get the type of the card.
     *
     * @return The type of the card.
     */
    public Type getType() {
        return type;
    }

    /**
     * Get the numerical value of the card.
     *
     * @return The numerical value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Checks if this card can be played on top of another card.
     *
     * @param otherCard The card to be played on.
     * @return True if the card can be played, false otherwise.
     */
    public boolean canPlayOn(Card otherCard) {
        // Implement rules for playing this card on top of another card
        if (color == Color.WILD || otherCard.getColor() == Color.WILD) {
            return true; // Wild cards can be played on any card
        }
        return color == otherCard.getColor() || type == otherCard.getType() || value == otherCard.getValue();
    }

    /**
     * Performs special card actions associated with this card.
     *
     * @param currentPlayer The current player.
     * @param unoGame The Uno game instance.
     */
    public void performAction(Player currentPlayer, UnoGame unoGame) {
        // Implement special card actions here
        if (type == Type.REVERSE) {
            unoGame.reverseDirection();
        } else if (type == Type.SKIP) {
            unoGame.skipNextPlayer();
        } else if (type == Type.WILD_DRAW_TWO) {
            unoGame.drawTwoNextPlayer();
        } else if (type == Type.WILD) {
            // Implement logic for Wild card
        }
    }


    /**
     * Sets the color for a played Wild card.
     *
     * @param wildColor The color to set for the played Wild card.
     */
    public void setWildColor(Color wildColor) {
        if (color == Color.WILD) {
            // Set the color for the played Wild card
            color = wildColor;
        }
    }

    /**
     * Returns a human-readable representation of the card.
     *
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        // Return a readable representation of the card
        if (color == Color.WILD) {
            return "Wild";
        } else if (type == Type.NUMBER) {
            return color + " " + value;
        } else {
            return color + " " + type;
        }
    }

    /**
     * Checks if this card is equal to another object.
     *
     * @param obj The object to compare to this card.
     * @return True if the cards are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value == card.value && color == card.color && type == card.type;
    }

    /**
     * Generates a hash code for this card.
     *
     * @return The hash code for the card.
     */
    @Override
    public int hashCode() {
        return Objects.hash(color, type, value);
    }
}

