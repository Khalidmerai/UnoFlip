import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private ArrayList<Card> cards;
    private String playerName;

    /**
     * Constructor
     */
    public Player(String playerName){
        this.playerName = playerName;
        cards = new ArrayList<Card>();
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
    public void removeCard(int c){
        cards.remove(c);
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

}
