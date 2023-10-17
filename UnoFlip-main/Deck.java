import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>(108);
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; // Regular cards (skip duplicates)
    private int[] specialNumbers = {2, 2, 4, 4}; // Special cards (+2 and +4)
    private ArrayList<Card> decks = new ArrayList<>();


    private void initializeDeck() {
        for(Card.Color color: Card.Color.values()){
            for(Card.Type type:  Card.Type.values()){
                if (type != Card.Type.WILD && type != Card.Type.WILD_DRAW_TWO) {
                    cards.add(new Card(color, type, -1));
                }
            }

        }}
    public Deck() {
        cards = new ArrayList<>(108);
        // Create regular cards (numbers and action cards) for each color
        for (Card.Color color : Card.Color.values()) {
            for (int number : numbers) {
                cards.add(new Card(color, Card.Type.NUMBER, number));
            }
            for (Card.Type type : Card.Type.values()) {
                if (type != Card.Type.NUMBER) {
                    cards.add(new Card(color, type, -1)); // -1 represents special action cards
                }
            }
        }
        // Create special cards (+2 and +4)
        for (int number : specialNumbers) {
            cards.add(new Card(Card.Color.WILD, Card.Type.WILD, -1));
        }
    }

    public Card drawRandomCard() {
        if (!cards.isEmpty()) {
            int randomIndex = new Random().nextInt(cards.size());
            return cards.remove(randomIndex);
        } else {
            // Handle the case when the deck is empty, e.g., by shuffling the discard pile into the deck.
            // You can also create a new deck if needed.
        }
        return null; // Return null if the deck is empty and no cards can be drawn.
    }




    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        } else {
            // You may want to handle this case differently, such as reshuffling the discard pile.
            return null;
        }
    }
}

