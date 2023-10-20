import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards;
    private String playerName;
    private int score;

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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void increaseScore(int scoreChange) {
        score += scoreChange;
    }

    public void decreaseScore(int scoreChange) {
        score -= scoreChange;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

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

    public boolean hasWon() {
        if (cards.isEmpty()) {
            System.out.println("Winner: " + playerName);
            return true;
        }
        return false;
    }

    public String getName() {
        return playerName;
    }
    public void pickCard(Card card) {
        addCard(card);
    }

    public int getScore() {
        return score;
    }
    @Override
    public String toString() {
        return playerName;
    }
}
