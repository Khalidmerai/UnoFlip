package Test;
import SRC.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CardTest {
    /**
     * Test for the getColor method.
     */
    @Test
    void getColor() {
        // Test getColor method for a card with a specific color.
        Card card = new Card(Card.Color.RED, Card.Type.NUMBER, 5);
        assertEquals(Card.Color.RED, card.getColor());
    }

    /**
     * Test for the getWildColor and setWildColor methods.
     */
    @Test
    void getWildColor() {
        // Test getWildColor and setWildColor methods for a WILD card.
        Card card = new Card(Card.Color.WILD, Card.Type.WILD, 0);
        card.setWildColor(Card.Color.BLUE);
        assertEquals(Card.Color.BLUE, card.getWildColor());
    }
    /**
     * Test for the getType method.
     */
    @Test
    void getType() {
        // Test getType method for a card with a specific type.
        Card card = new Card(Card.Color.BLUE, Card.Type.SKIP, 0);
        assertEquals(Card.Type.SKIP, card.getType());
    }

    /**
     * Test for the getValue method.
     */
    @Test
    void getValue() {
        // Test getValue method for a card with a specific value.
        Card card = new Card(Card.Color.GREEN, Card.Type.NUMBER, 3);
        assertEquals(3, card.getValue());
    }

    /**
     * Test for the canPlayOn method.
     */
    @Test
    void canPlayOn() {
        // Test the canPlayOn method to check if one card can be played on another.
        Card card1 = new Card(Card.Color.RED, Card.Type.NUMBER, 5);
        Card card2 = new Card(Card.Color.RED, Card.Type.REVERSE, 0);
        assertTrue(card1.canPlayOn(card2));
    }

    /**
     * Test for the setWildColor method.
     */
    @Test
    void setWildColor() {
        // Test setWildColor method for a WILD card.
        Card card = new Card(Card.Color.WILD, Card.Type.WILD, 0);
        card.setWildColor(Card.Color.GREEN);
        assertEquals(Card.Color.GREEN, card.getWildColor());
    }

    /**
     * Test for the toString method.
     */
    @Test
    void testToString() {
        // Test toString method for a card with a specific color and value.
        Card card = new Card(Card.Color.YELLOW, Card.Type.NUMBER, 2);
        assertEquals("YELLOW 2", card.toString());
    }

    /**
     * Test for the contains method.
     */
    @Test
    void contains() {
        // Test the contains method for color existence.
        assertTrue(Card.contains("RED"));
        assertFalse(Card.contains("PURPLE"));
    }
    /**
     * Test for the equals method.
     */
    @Test
    void testEquals() {
        // Test the equals method to check if two cards are equal.
        Card card1 = new Card(Card.Color.RED, Card.Type.NUMBER, 2);
        Card card2 = new Card(Card.Color.RED, Card.Type.NUMBER, 2);
        Card card3 = new Card(Card.Color.BLUE, Card.Type.SKIP, 0);
        assertTrue(card1.equals(card2));
        assertFalse(card1.equals(card3));
    }

    /**
     * Test for the SRC.Card constructor.
     */
    @Test
    public void testCardConstructor() {
        // Test the SRC.Card constructor for correctness.
        Card card = new Card(Card.Color.BLUE, Card.Type.NUMBER, 5);
        assertEquals(Card.Color.BLUE, card.getColor());
        assertEquals(Card.Type.NUMBER, card.getType());
        assertEquals(5, card.getValue());
    }

    /**
     * Test for the canPlayOn method with matching color.
     */
    @Test
    public void testCanPlayOnMatchingColor() {
        // Test if a card with matching color can be played on another card.
        Card card1 = new Card(Card.Color.BLUE, Card.Type.NUMBER, 5);
        Card card2 = new Card(Card.Color.BLUE, Card.Type.NUMBER, 7);
        assertTrue(card1.canPlayOn(card2));
    }
    /**
     * Test for the canPlayOn method with matching type.
     */
    @Test
    public void testCanPlayOnMatchingType() {
        // Test if a card with matching type can be played on another card.
        Card card1 = new Card(Card.Color.RED, Card.Type.REVERSE, -1);
        Card card2 = new Card(Card.Color.GREEN, Card.Type.REVERSE, -1);
        assertTrue(card1.canPlayOn(card2));
    }

    /**
     * Test for the canPlayOn method with matching value.
     */
    @Test
    public void testCanPlayOnMatchingValue() {
        // Test if a card with matching value can be played on another card.
        Card card1 = new Card(Card.Color.YELLOW, Card.Type.NUMBER, 3);
        Card card2 = new Card(Card.Color.YELLOW, Card.Type.NUMBER, 3);
        assertTrue(card1.canPlayOn(card2));
    }

    /**
     * Test for the canPlayOn method with a matching wild card.
     */
    @Test
    public void testCanPlayOnWildCard() {
        // Test if a regular card can be played on a WILD card.
        Card card1 = new Card(Card.Color.RED, Card.Type.SKIP, -1);
        Card card2 = new Card(Card.Color.WILD, Card.Type.WILD, -1);
        assertTrue(card1.canPlayOn(card2));
    }

    /**
     * Test for the setWildColor method.
     */
    @Test
    public void testSetWildColor() {
        // Test the setWildColor method for a WILD card.
        Card card = new Card(Card.Color.WILD, Card.Type.WILD, -1);
        card.setWildColor(Card.Color.BLUE);
        assertEquals(Card.Color.BLUE, card.getWildColor());
    }

    /**
     * Test for the hashCode method.
     */
    @Test
    void testHashCode() {
        // Test the hashCode method for two equal cards.
        Card card1 = new Card(Card.Color.GREEN, Card.Type.NUMBER, 7);
        Card card2 = new Card(Card.Color.GREEN, Card.Type.NUMBER, 7);
        assertEquals(card1.hashCode(), card2.hashCode());
    }
}