import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> decks = new ArrayList<Card>(108);
    private int[] numbers = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0}; //regular cards
    private int[] specialNumbers = {2,2,4,4}; //special cards +2, +2, +4 and +4

    /**
     * need to fix more on that part
     */
    public Deck() {
        for (Card.Color c : Card.Color.values()) {
            for (int i : numbers) {
               // decks.add(new Card(c, Card.Type.values(), i));
            }
        }

        for (int j : specialNumbers) {
           // decks.add(new Card(Card.Color.values(), Card.Type.values(), j));
        }
    }

    public boolean isEmpty(){
        if(!decks.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * did research but not sure if theres another way to call the shuffle
     */
    public void shuffle(){
        Collections.shuffle(decks);
    }

    /**
     * getting the card from the top of the deck
     * @return
     */
    public Card topCard(){
        return decks.remove(decks.size()-1);
    }


}
