package Test;

import SRC.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UnoGame.
 */
class UnoGameTest {

    private UnoGame game;
    private ArrayList<Player> players;
    private Deck deck;
    private ConsoleUI ui;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        deck = new Deck();
        game = new UnoGame(players, deck);
        ui = new ConsoleUI();
    }

    /**
     * Test the startGame method to ensure that the game initializes properly.
     */
    @Test
    void testStartGame() {
        assertNotNull(game.getTopCard());
        for (Player player : players) {
            assertEquals(7, player.getNumCards()); // As each player should have 7 cards initially.
        }
    }

    /**
     * Test the hasGameEnded method to check if the game ends correctly.
     */
    @Test
    void testHasGameEnded() {
        assertFalse(game.hasGameEnded());
        int initialSize = players.get(0).getCards().size();
        for (int i = 0; i < initialSize; i++) {
            players.get(0).removeCard(0);  // Since every time we remove a card, the next card shifts to index 0
        }
        assertTrue(game.hasGameEnded());
    }

    /**
     * Test the playCard method to ensure that cards can be played correctly.
     */
    @Test
    void testPlayCard() {
        Player currentPlayer = game.getCurrentPlayer();
        Card card = currentPlayer.getCards().get(0);
        game.playCard(currentPlayer, card, ui);
        assertEquals(card, game.getTopCard());
    }

    /**
     * Test the dealInitialCards method to check if players receive the correct number of initial cards.
     */
    @Test
    void testDealInitialCards() {
        for (Player player : players) {
            assertEquals(7, player.getCards().size());
        }
    }

    /**
     * Test the drawCard method to verify that drawing a card modifies the hand size correctly.
     */
    @Test
    void testDrawCard() {
        Player currentPlayer = game.getCurrentPlayer();
        int initialHandSize = currentPlayer.getCards().size();
        game.drawCard(currentPlayer);
        assertEquals(initialHandSize + 1, currentPlayer.getCards().size());
    }

    /**
     * Test the isValidPlay method to check if card plays are validated properly.
     */
    @Test
    void testIsValidPlay() {
        Player currentPlayer = game.getCurrentPlayer();
        Card validCard = new Card(game.getCurrentColor(), Card.Type.NUMBER, 5);
        assertTrue(game.isValidPlay(currentPlayer, validCard));

        Card invalidCard = new Card(Card.Color.GREEN, Card.Type.NUMBER, 5); // assuming currentColor is not GREEN
        assertFalse(game.isValidPlay(currentPlayer, invalidCard));
    }

    /**
     * Test the reverseDirection method to ensure that the game direction is reversed correctly.
     */
    @Test
    void testReverseDirection() {
        boolean initialDirection = game.isReverseDirection();
        game.reverseDirection();
        assertNotEquals(initialDirection, game.isReverseDirection());
    }

    /**
     * Test the nextPlayer method to verify that the next player is set correctly.
     */
    @Test
    void testNextPlayer() {
        Player currentPlayer = game.getCurrentPlayer();
        game.nextPlayer();
        assertNotEquals(currentPlayer, game.getCurrentPlayer());
    }

    /**
     * Test the setInitialCard method to ensure the initial card is set correctly.
     */
    @Test
    void testSetInitialCard() {
        assertNotNull(game.getTopCard());
    }

    /**
     * Test the getWinner method to check if the winner is correctly identified.
     */
    @Test
    void testGetWinner() {
        int initialSize = players.get(0).getCards().size();
        for (int i = 0; i < initialSize; i++) {
            players.get(0).removeCard(0);  // Since every time we remove a card, the next card shifts to index 0
        }
        assertEquals(players.get(0), game.getWinner());
    }

    /**
     * Test the endGame method to ensure that the game ends and players' scores are adjusted correctly.
     */
    @Test
    void testEndGame() {
        int initialSize = players.get(0).getCards().size();
        for (int i = 0; i < initialSize; i++) {
            players.get(0).removeCard(0);  // Since every time we remove a card, the next card shifts to index 0
        }
        game.endGame();
        for (Player player : players) {
            assertTrue(player.getScore() <= 0);  // as scores are decremented for unplayed cards
        }
    }
}
