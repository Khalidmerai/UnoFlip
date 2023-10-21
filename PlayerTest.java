import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

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

    @Test
    public void testAddAndRemoveCard() {
        Player player = new Player("Bob");
        Card card = new Card(Card.Color.RED, Card.Type.NUMBER, 5);
        player.pickCard(card);
        assertEquals(1, player.getNumCards());

        player.removeCard(0);
        assertEquals(0, player.getNumCards());
    }

    @Test
    public void testIncreaseAndDecreaseScore() {
        Player player = new Player("Charlie");
        player.increaseScore(10);
        assertEquals(10, player.getScore());

        player.decreaseScore(5);
        assertEquals(5, player.getScore());
    }

    @Test
    public void testSayUno() {
        Player player = new Player("Dave");
        player.pickCard(new Card(Card.Color.BLUE, Card.Type.NUMBER, 7));
        player.pickCard(new Card(Card.Color.YELLOW, Card.Type.NUMBER, 3));
        player.sayUno(); // Should not print "Uno" since the player has more than one card.

        player.pickCard(new Card(Card.Color.RED, Card.Type.NUMBER, 2));
        player.sayUno(); // Should print "Uno" since the player now has only one card.
    }

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
