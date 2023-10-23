package Test;

import SRC.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testStartGame() {
        assertNotNull(game.getTopCard());
        for (Player player : players) {
            assertEquals(7, player.getNumCards()); // As each player should have 7 cards initially.
        }
    }

    @Test
    void testHasGameEnded() {
        assertFalse(game.hasGameEnded());
        int initialSize = players.get(0).getCards().size();
        for (int i = 0; i < initialSize; i++) {
            players.get(0).removeCard(0);  // Since every time we remove a card, the next card shifts to index 0
        }
        assertTrue(game.hasGameEnded());
    }

    @Test
    void testPlayCard() {
        Player currentPlayer = game.getCurrentPlayer();
        Card card = currentPlayer.getCards().get(0);
        game.playCard(currentPlayer, card, ui);
        assertEquals(card, game.getTopCard());
    }

    @Test
    void testDealInitialCards() {
        for (Player player : players) {
            assertEquals(7, player.getCards().size());
        }
    }

    @Test
    void testDrawCard() {
        Player currentPlayer = game.getCurrentPlayer();
        int initialHandSize = currentPlayer.getCards().size();
        game.drawCard(currentPlayer);
        assertEquals(initialHandSize + 1, currentPlayer.getCards().size());
    }

    @Test
    void testIsValidPlay() {
        Player currentPlayer = game.getCurrentPlayer();
        Card validCard = new Card(game.getCurrentColor(), Card.Type.NUMBER, 5);
        assertTrue(game.isValidPlay(currentPlayer, validCard));

        Card invalidCard = new Card(Card.Color.GREEN, Card.Type.NUMBER, 5); // assuming currentColor is not GREEN
        assertFalse(game.isValidPlay(currentPlayer, invalidCard));
    }

    @Test
    void testReverseDirection() {
        boolean initialDirection = game.isReverseDirection();
        game.reverseDirection();
        assertNotEquals(initialDirection, game.isReverseDirection());
    }

    @Test
    void testNextPlayer() {
        Player currentPlayer = game.getCurrentPlayer();
        game.nextPlayer();
        assertNotEquals(currentPlayer, game.getCurrentPlayer());
    }

    @Test
    void testSetInitialCard() {
        assertNotNull(game.getTopCard());
    }

    @Test
    void testGetWinner() {
        int initialSize = players.get(0).getCards().size();
        for (int i = 0; i < initialSize; i++) {
            players.get(0).removeCard(0);  // Since every time we remove a card, the next card shifts to index 0
        }
        assertEquals(players.get(0), game.getWinner());
    }

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