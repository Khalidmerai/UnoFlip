import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void testDeckConstructor() {
        Deck deck = new Deck();
        assertNotNull(deck);
    }

    @Test
    public void testDrawRandomCard() {
        Deck deck = new Deck();
        Card card = deck.drawRandomCard();
        assertNotNull(card);
    }

    @Test
    public void testDrawCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        assertNotNull(card);
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        ArrayList<Card> originalCards = new ArrayList<>(deck.getCards());
        deck.shuffle();
        ArrayList<Card> shuffledCards = deck.getCards();

        // Ensure that the order of cards has changed after shuffling
        assertNotEquals(originalCards, shuffledCards);

        // Ensure that the shuffled deck contains all the same cards
        Set<Card> originalSet = new HashSet<>(originalCards);
        Set<Card> shuffledSet = new HashSet<>(shuffledCards);
        assertEquals(originalSet, shuffledSet);
    }

    @Test
    public void testIsEmpty() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty());
        for (int i = 0; i < 108; i++) {
            deck.drawCard();
        }
        assertTrue(deck.isEmpty());
    }
}
