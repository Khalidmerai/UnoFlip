package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import SRC.Card;
import SRC.Deck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit test class for the SRC.Deck class.
 */
class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        // Initialize a new deck before each test.
        deck = new Deck();
    }

    /**
     * Test drawing a card from the deck.
     */
    @Test
    void drawCard() {
        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard);
        assertFalse(deck.isEmpty());
    }

    /**
     * Test if the deck is empty.
     */
    @Test
    void isEmpty() {
        assertFalse(deck.isEmpty());
        for (int i = 0; i < 108; i++) {
            deck.drawCard();
        }
        assertTrue(deck.isEmpty());
    }

    /**
     * Test shuffling the deck.
     */
    @Test
    void shuffle() {
        Deck originalDeck = new Deck();
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
        assertNotEquals(originalDeck.getCards(), shuffledDeck.getCards());
    }

    /**
     * Test drawing a random card.
     */
    @Test
    void drawRandomCard() {
        Card drawnCard1 = deck.drawRandomCard();
        assertNotNull(drawnCard1);
        assertFalse(deck.isEmpty());

        Card drawnCard2 = deck.drawRandomCard();
        assertNotNull(drawnCard2);
        assertFalse(deck.isEmpty());

        assertNotEquals(drawnCard1, drawnCard2);
    }

    /**
     * Test drawing a card from the deck. Verifies that a card is drawn and is not null.
     */
    @Test
    public void testDrawCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        assertNotNull(card);
    }

    /**
     * Test checking if the deck is empty. Verifies that the deck is initially not empty,
     * and becomes empty after drawing all cards.
     */
    @Test
    public void testIsEmpty() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty());
        for (int i = 0; i < 108; i++) {
            deck.drawCard();
        }
        assertTrue(deck.isEmpty());
    }

    /**
     * Test shuffling the deck. Verifies that the order of cards has changed after shuffling,
     * and that all the same cards are present in the shuffled deck.
     */
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
}
