package Test;

import org.junit.jupiter.api.Test;
import SRC.Card;
import SRC.Player;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /**
     * Test the isSkipped() method.
     * Verifies that a player is not initially skipped.
     */
    @Test
    void isSkipped() {
        Player player = new Player("Alice");
        assertFalse(player.isSkipped());
    }

    /**
     * Test the skip() method.
     * Verifies that a player can be marked as skipped.
     */
    @Test
    void skip() {
        Player player = new Player("Bob");
        player.skip();
        assertTrue(player.isSkipped());
    }

    /**
     * Test the unskip() method.
     * Verifies that a player can be unmarked as skipped.
     */
    @Test
    void unskip() {
        Player player = new Player("Charlie");
        player.skip();
        player.unskip();
        assertFalse(player.isSkipped());
    }
    /**
     * Test the increaseScore() method.
     * Verifies that a player's score is increased by the specified value.
     */
    @Test
    void increaseScore() {
        Player player = new Player("Frank");
        player.increaseScore(10);
        assertEquals(10, player.getScore());
    }
    /**
     * Test player initialization.
     * Verifies that a player is correctly initialized with the provided name,
     * no cards, and a score of zero. Also checks if the player has not won.
     */
    @Test
    public void testPlayerInitialization() {
        Player player = new Player("Alice");
        assertNotNull(player);
        assertEquals("Alice", player.toString());
        assertEquals(0, player.getNumCards());
        assertEquals(0, player.getScore());
        player.pickCard(new Card(Card.Color.BLUE, Card.Type.NUMBER, 7));
        assertFalse(player.hasWon());
    }

    /**
     * Test adding and removing cards from a player's hand.
     * Verifies that a card can be added and removed from the player's hand successfully.
     */
    @Test
    public void testAddAndRemoveCard() {
        Player player = new Player("Bob");
        Card card = new Card(Card.Color.RED, Card.Type.NUMBER, 5);
        player.pickCard(card);
        assertEquals(1, player.getNumCards());

        player.removeCard(0);
        assertEquals(0, player.getNumCards());
    }
    /**
     * Test increasing and decreasing a player's score.
     * Verifies that a player's score can be increased and decreased correctly.
     */
    @Test
    public void testIncreaseAndDecreaseScore() {
        Player player = new Player("Charlie");
        player.increaseScore(10);
        assertEquals(10, player.getScore());

        player.decreaseScore(5);
        assertEquals(5, player.getScore());
    }
    /**
     * Test saying "Uno" by a player.
     * Verifies that a player correctly says "Uno" when having one card left in hand.
     */
    @Test
    public void testSayUno() {
        Player player = new Player("Dave");
        player.pickCard(new Card(Card.Color.BLUE, Card.Type.NUMBER, 7));
        player.pickCard(new Card(Card.Color.YELLOW, Card.Type.NUMBER, 3));
        player.sayUno(); // Should not print "Uno" since the player has more than one card.

        player.pickCard(new Card(Card.Color.RED, Card.Type.NUMBER, 2));
        player.sayUno(); // Should print "Uno" since the player now has only one card.
    }
    /**
     * Test checking if a player has won.
     * Verifies that a player is considered to have won when their hand is empty.
     */
    @Test
    public void testHasWon() {
        Player player = new Player("Eve");
        player.pickCard(new Card(Card.Color.BLUE, Card.Type.NUMBER, 5));

        assertFalse(player.hasWon());

        // Remove cards from the player's hand to simulate winning the game
        player.removeCard(0);
        assertTrue(player.hasWon());

    }
}