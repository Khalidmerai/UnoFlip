import java.util.ArrayList;
/**
 * The UnoGame class represents a game of Uno, with players, a deck of Uno cards,
 * and game logic for playing and managing the game.
 * @author Khalid Merai 101159203
 */
public class UnoGame {
    private ArrayList<Player> players;
    private Deck deck;
    private ArrayList<Card> discardPile;
    private int currentPlayerIndex;
    private boolean reverseDirection;
    private Card.Color currentColor;
    private Card.Color ui;


    /**
     * Constructs an UnoGame with the given players and deck and initializes the game.
     *
     * @param players The list of players in the game.
     * @param deck    The deck of Uno cards to use for the game.
     */
    public UnoGame(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        this.discardPile = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.reverseDirection = false;
        this.currentColor = null;
        System.out.println("Uno game has started!");

        // Initialize the game by dealing cards to players and starting the discard pile.
        dealInitialCards();
        startGame();
    }

    /**
     * Starts the Uno game by setting the initial card and displaying it.
     */
    public void startGame() {
        setInitialCard();
        displayTopCard();
    }

    /**
     * Checks if the Uno game has ended, i.e., if any player has won.
     *
     * @return True if a player has won, otherwise false.
     */
    public boolean hasGameEnded() {
        for (Player player : players) {
            if (player.hasWon()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Plays a card on the discard pile if it's a valid move.
     *
     * @param player The player making the move.
     * @param card   The card to be played.
     */
    public void playCard(Player player, Card card, ConsoleUI ui) {
        if (isValidPlay(player, card)) {
            player.removeCard(card.getValue());
            discardPile.add(card);
            currentColor = card.getColor();
            handleSpecialCard(card, player,currentColor, ui);
            nextPlayer();
        } else {
            System.out.println("Invalid move. Please try again.");
        }
    }
    /**
     * Deals the initial set of cards to all players at the start of the game.
     */
    public void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                Card randomCard = deck.drawRandomCard();
                player.pickCard(randomCard);
            }
        }
        discardPile.add(deck.drawCard());
    }


    /**
     * Draws a card for the given player and takes appropriate actions based on the drawn card.
     *
     * @param player The player drawing the card.
     */
    public void drawCard(Player player) {
        Card drawnCard = deck.drawCard();
        player.pickCard(drawnCard);
        System.out.println(player.toString() + " drew a card: " + drawnCard.toString());

        if (canPlayCard(player)) {
            System.out.println("You have a playable card now.");
        } else {
            nextPlayer();
        }
    }

    /**
     * Checks if a card can be played by the current player based on the rules of Uno.
     *
     * @param player The player attempting to play a card.
     * @param card   The card to be played.
     * @return True if the card can be played, otherwise false.
     */
    public boolean isValidPlay(Player player, Card card) {
        Card topCard = getTopCard();
        return card.getColor() == currentColor || card.getValue() == topCard.getValue() ||
                card.getColor() == Card.Color.WILD || topCard.getColor() == Card.Color.WILD;
    }

    /**
     * Checks if the current player has any playable cards in their hand.
     *
     * @param player The current player.
     * @return True if the player has a playable card, otherwise false.
     */
    public boolean canPlayCard(Player player) {
        for (Card card : player.getCards()) {
            if (isValidPlay(player, card)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Handles special actions associated with certain Uno cards.
     *
     * @param card   The card being played.
     * @param player The current player.
     * @param ui
     */
    public void handleSpecialCard(Card card, Player player, Card.Color chosenColor, ConsoleUI ui) {
        if (card.getType() == Card.Type.REVERSE) {
            reverseDirection();
        } else if (card.getType() == Card.Type.SKIP) {
            skipNextPlayer();
        } else if (card.getType() == Card.Type.WILD_DRAW_TWO) {
            // Check for stacking Draw Two cards
            if (getTopCard().getType() == Card.Type.WILD_DRAW_TWO) {
                drawTwoNextPlayer(); // Stack the effect
            } else {
                drawTwoNextPlayer(); // Apply the effect
            }
        } else if (card.getType() == Card.Type.WILD) {
            card.setWildColor(chosenColor);
            // Handle Wild card actions, if any
        }
    }








    /**
     * Reverses the direction of play in the game.
     */
    public void reverseDirection() {
        reverseDirection = !reverseDirection;
    }
    public boolean isReverseDirection() {return reverseDirection;}

    /**
     * Skips the next player's turn.
     */
    public void skipNextPlayer() {
        nextPlayer();
    }

    /**
     * Sets the color for a played Wild card.
     *
     * @param currentPlayer The current player.
     * @param wildColor     The color to set for the played Wild card.
     */
    public void setWildColor(Player currentPlayer, Card.Color wildColor) {
        Card topCard = getTopCard();
        if (topCard.getColor() == Card.Color.WILD && currentPlayer.getCards().contains(topCard)) {
            topCard.setWildColor(wildColor);
        }
    }

    /**
     * Gets the current player in the game.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * Gets the current player index.
     *
     * @return The current player index.
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    /**
     * Makes the next player draw two cards.
     */
    public void drawTwoNextPlayer() {
        Player nextPlayer = getNextPlayer();
        if (nextPlayer != null) {
            for (int i = 0; i < 2; i++) {
                Card drawnCard = deck.drawCard();
                nextPlayer.pickCard(drawnCard);
            }
        }
        nextPlayer();
    }

    /**
     * Gets the next player in the game based on the current direction of play.
     *
     * @return The next player.
     */
    public Player getNextPlayer() {
        int nextPlayerIndex = currentPlayerIndex;
        if (reverseDirection) {
            nextPlayerIndex--;
            if (nextPlayerIndex < 0) {
                nextPlayerIndex = players.size() - 1;
            }
        } else {
            nextPlayerIndex++;
            if (nextPlayerIndex >= players.size()) {
                nextPlayerIndex = 0;
            }
        }
        return players.get(nextPlayerIndex);
    }

    /**
     * Moves the game to the next player's turn based on the current direction of play.
     */
    public void nextPlayer() {
        if (reverseDirection) {
            currentPlayerIndex--;
            if (currentPlayerIndex < 0) {
                currentPlayerIndex = players.size() - 1;
            }
        } else {
            currentPlayerIndex++;
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0;
            }
        }
    }

    /**
     * Gets the top card on the discard pile.
     *
     * @return The top card on the discard pile.
     */
    public Card getTopCard() {
        return discardPile.get(discardPile.size() - 1);
    }
    public Card.Color getCurrentColor() {return currentColor;}

    /**
     * Displays the top card on the discard pile.
     */
    public void displayTopCard() {
        Card topCard = getTopCard();
        System.out.println("Top card: " + topCard.toString());
    }

    /**
     * Sets the initial card to start the game.
     */
    public void setInitialCard() {
        // Draw a random card from the deck and set it as the initial card
        Card initialCard = deck.drawRandomCard();
        if (initialCard != null) {
            discardPile.add(initialCard);
            currentColor = initialCard.getColor();
        }
    }

    /**
     * Gets the player who has won the game, if any.
     *
     * @return The winning player, or null if there is no winner yet.
     */
    public Player getWinner() {
        for (Player player : players) {
            if (player.hasWon()) {
                return player;
            }
        }
        return null; // No winner yet
    }
    public void endGame() {
        // Calculate scores at the end of the game
        for (Player player : players) {
            int score = calculateScore(player);
            player.increaseScore(score);
        }
    }

    private int calculateScore(Player player) {
        int score = 0;

        // Add your scoring logic here, e.g., subtract points for unplayed cards
        for (Card card : player.getCards()) {
            score -= card.getValue();
        }

        return score;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
