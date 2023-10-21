import java.util.ArrayList;

/**
 * A player class that has the player name and their card
 */
public class Player {
    private ArrayList<Card> cards;
    private String playerName;
    private int score;

    /**
     * public constructor
     * @param playerName
     */
    public Player(String playerName) {
        this.playerName = playerName;
        cards = new ArrayList<Card>();
        score = 0;
    }


    private boolean skipped;

    public boolean isSkipped() {
        return skipped;
    }

    public void skip() {
        skipped = true;
    }

    public void unskip() {
        skipped = false;
    }
    public int getNumCards() {
        return cards.size();
    }

    /**
     * getter method for cards
     * @return the card type
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * method to keep track of score everytime a player plays
     * @param scoreChange
     */
    public void increaseScore(int scoreChange) {
        score += scoreChange;
    }

    public void decreaseScore(int scoreChange) {
        score -= scoreChange;
    }

    /**
     * method to add card to the player's hand
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * method to remove card from the player's hand
     * @param index
     */
    public void removeCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index for card removal.");
        }
    }

    public void sayUno() {
        if (cards.size() == 1) {
            System.out.println("Uno");
        }
    }

    /**
     * a method when the player has won the UNO game
     * @return winner of the game
     */
    public boolean hasWon() {
        if (cards.isEmpty()) {
            System.out.println("Winner: " + playerName);
            return true;
        }
        return false;
    }

    /**
     * getter method for the player's name
     * @return the name of the player
     */
    public String getName() {
        return playerName;
    }

    /**
     * method that the player pick a card
     * @param card
     */
    public void pickCard(Card card) {
        addCard(card);
    }

    /**
     * getter method to get the score of the player
     * @return player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * string representation of the player's name
     * @return the player name
     */
    @Override
    public String toString() {
        return playerName;
    }
}
