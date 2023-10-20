import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards;
    private String playerName;
    private int score; // Add a score field


    /**
     * Constructor
     */
    public Player(String playerName){
        this.playerName = playerName;
        cards = new ArrayList<Card>();
        score = 0; // Initialize the score

    }

    /**
     * returns the number of card
     * @return
     */
    public int numCard(){
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public void increaseScore(int points) {
        score += points;
    }

    public void decreaseScore(int points) {
        score -= points;
    }

    /**
     * player need to pick a card
     * @param c
     */
    public void pickCard(Card c){
        cards.add(c);
    }

    /**
     * player need to remove a card
     * @param c
     */
    public void removeCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
        } else {
            System.out.println("Invalid index for card removal.");
        }
    }

    /**
     * player says uno if they only have 1 card
     */
    public void sayUno() {

        if (cards.size()==1){
            System.out.println("Uno");
        }
    }

    /**
     * to check if the player won
     * @return
     */
    public boolean hasWon() {
        if(cards.isEmpty()) {
            System.out.println("Winner");
            return true;
        }
        return false;
    }
    /**
     * text representation of player
     */
    public String toString() {
        return this.playerName;
    }

    public int getScore() {
        return score;
    }
}
