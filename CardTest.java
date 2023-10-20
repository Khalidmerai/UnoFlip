import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testCardConstructor() {
        Card card = new Card(Card.Color.BLUE, Card.Type.NUMBER, 5);
        assertEquals(Card.Color.BLUE, card.getColor());
        assertEquals(Card.Type.NUMBER, card.getType());
        assertEquals(5, card.getValue());
    }

    @Test
    public void testCanPlayOnMatchingColor() {
        Card card1 = new Card(Card.Color.BLUE, Card.Type.NUMBER, 5);
        Card card2 = new Card(Card.Color.BLUE, Card.Type.NUMBER, 7);
        assertTrue(card1.canPlayOn(card2));
    }

    @Test
    public void testCanPlayOnMatchingType() {
        Card card1 = new Card(Card.Color.RED, Card.Type.REVERSE, -1);
        Card card2 = new Card(Card.Color.GREEN, Card.Type.REVERSE, -1);
        assertTrue(card1.canPlayOn(card2));
    }

    @Test
    public void testCanPlayOnMatchingValue() {
        Card card1 = new Card(Card.Color.YELLOW, Card.Type.NUMBER, 3);
        Card card2 = new Card(Card.Color.YELLOW, Card.Type.NUMBER, 3);
        assertTrue(card1.canPlayOn(card2));
    }

    @Test
    public void testCanPlayOnWildCard() {
        Card card1 = new Card(Card.Color.RED, Card.Type.SKIP, -1);
        Card card2 = new Card(Card.Color.WILD, Card.Type.WILD, -1);
        assertTrue(card1.canPlayOn(card2));
    }

    @Test
    public void testSetWildColor() {
        Card card = new Card(Card.Color.WILD, Card.Type.WILD, -1);
        card.setWildColor(Card.Color.BLUE);
        assertEquals(Card.Color.BLUE, card.getWildColor());
    }

    @Test
    public void testPerformActionReverse() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Charlie");
        ArrayList<Player> list = new ArrayList<Player>();
        list.add(player1);
        list.add(player2);
        UnoGame unoGame = new UnoGame(list, new Deck());

        Card card = new Card(unoGame.getCurrentColor(), Card.Type.REVERSE, -1);
        card.performAction(player1, unoGame);

        assertTrue(unoGame.isReverseDirection());
    }

    @Test
    public void testEqualsMethod() {
        Card card1 = new Card(Card.Color.BLUE, Card.Type.NUMBER, 5);
        Card card2 = new Card(Card.Color.BLUE, Card.Type.NUMBER, 5);
        Card card3 = new Card(Card.Color.RED, Card.Type.REVERSE, -1);

        assertTrue(card1.equals(card2));
        assertFalse(card1.equals(card3));
    }
}
