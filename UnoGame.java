import java.util.ArrayList;
import java.util.Collections;

public class UnoGame {
    private ArrayList<Player> players;
    private Deck deck;
    private ArrayList<Card> discardPile;
    private int currentPlayerIndex;
    private boolean reverseDirection;
    private Card.Color currentColor;

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

    public void startGame() {
        setInitialCard(); // Set the initial card
        displayTopCard();
    }
    public boolean hasGameEnded() {
        for (Player player : players) {
            if (player.hasWon()) {
                return true;
            }
        }
        return false;
    }


    public void playCard(Player player, Card card) {
        if (isValidPlay(player, card)) {
            player.removeCard(card.getValue());
            discardPile.add(card);
            currentColor = card.getColor();
            handleSpecialCard(card, player);
            nextPlayer();
        } else {
            System.out.println("Invalid move. Please try again.");
        }
    }

    public void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                Card randomCard = deck.drawRandomCard(); // Modify the Deck class to add a drawRandomCard method
                player.pickCard(randomCard);
            }
        }
        discardPile.add(deck.drawCard());
    }


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

    public boolean isValidPlay(Player player, Card card) {
        Card topCard = getTopCard();
        return card.getColor() == currentColor || card.getValue() == topCard.getValue() ||
                card.getColor() == Card.Color.WILD || topCard.getColor() == Card.Color.WILD;
    }

    public boolean canPlayCard(Player player) {
        for (Card card : player.getCards()) {
            if (isValidPlay(player, card)) {
                return true;
            }
        }
        return false;
    }

    public void handleSpecialCard(Card card, Player currentPlayer) {
        if (card.getType() == Card.Type.REVERSE) {
            reverseDirection();
        } else if (card.getType() == Card.Type.SKIP) {
            skipNextPlayer();
        } else if (card.getType() == Card.Type.WILD_DRAW_TWO) {
            drawTwoNextPlayer();
        } else if (card.getType() == Card.Type.WILD) {
            // Handle Wild card actions
            setWildColor(currentPlayer, Card.Color.BLUE); // Example: Set Wild card color to BLUE
        }
    }

    public void reverseDirection() {
        reverseDirection = !reverseDirection;
    }
    public boolean isReverseDirection() {return reverseDirection;}

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

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * Make the next player draw two cards.
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

    public Card getTopCard() {
        return discardPile.get(discardPile.size() - 1);
    }
    public Card.Color getCurrentColor() {return currentColor;}

    public void displayTopCard() {
        Card topCard = getTopCard();
        System.out.println("Top card: " + topCard.toString());
    }
    public void setInitialCard() {
        // Draw a random card from the deck and set it as the initial card
        Card initialCard = deck.drawRandomCard();
        if (initialCard != null) {
            discardPile.add(initialCard);
            currentColor = initialCard.getColor();
        }
    }
    public Player getWinner() {
        for (Player player : players) {
            if (player.hasWon()) {
                return player;
            }
        }
        return null; // No winner yet
    }


}
