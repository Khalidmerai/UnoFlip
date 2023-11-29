package SRC.GUI.models;

import SRC.cards.Card;
import SRC.cards.DoubleSidedCard;

import java.util.ArrayList;

/**
 * A Console.Model.Player with a name, score, and hand of cards
 */
public class Player {

    private final String name;
    private int score;
    private ArrayList<DoubleSidedCard> hand;
    private boolean isAI;

    /**
     * Create a Console.Model.Player with a given name and hand of cards
     *
     * @param name The name of the Console.Model.Player
     * @param hand The Console.Model.Player's hand of cards
     * @param isAI Whether the player is an AI
     */
    public Player(String name, ArrayList<DoubleSidedCard> hand, boolean isAI) throws IllegalArgumentException {
        this.name = name;
        this.hand = hand;
        this.isAI = isAI;

        score = 0;
    }

    /**
     * @return The Console.Model.Player's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The Console.Model.Player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return The Console.Model.Player's status as
     */
    public boolean getIsAI() { return isAI; }

    /**
     * Increment the Console.Model.Player's score by a given amount
     *
     * @param score The score increment
     */
    public void incrementScore(int score) {
        this.score += score;
    }

    /**
     * @return The Console.Model.Player's hand
     */
    public ArrayList<DoubleSidedCard> getHand() {
        return hand;
    }

    /**
     * @return The Console.Model.Player's active hand
     */
    public ArrayList<Card> getActiveHand() {
        ArrayList<Card> activeHand = new ArrayList<>();
        for(DoubleSidedCard card: hand){
            activeHand.add(card.getActiveSide());
        }
        return activeHand;
    }

    /**
     * Deal a card to the Console.Model.Player
     *
     * @param card The dealt card
     */
    public void dealCard(DoubleSidedCard card) {
        hand.add(card);
    }

    /**
     * Return and remove a card from the Players hand given its index
     *
     * @param index The index of the card to be played from the players hand
     * @return The card at index
     */
    public DoubleSidedCard playCard(int index) throws IllegalArgumentException {
        if(index < 0 || index > hand.size() - 1) {
            throw new IllegalArgumentException("You must play a card between 0 and " + hand.size());
        }
        DoubleSidedCard card = hand.get(index);
        hand.remove(index);
        return card;
    }

    /**
     * Play a given card by the AI player and remove it from their hand
     *
     * @param index The index of the card to play from the AI player's hand
     * @return The card played by the AI player
     */
    public DoubleSidedCard playAICard(int index) throws IllegalArgumentException {
        if (index < 0 || index > hand.size() - 1) {
            throw new IllegalArgumentException("Invalid index. Please select a card between 0 and " + (hand.size() - 1));
        }

        DoubleSidedCard card = hand.get(index);
        hand.remove(index);

        return card;
    }


    /**
     * Clear the hand of a player in the current UNO game
     *
     * @return the temporary hand
     */
    public void clearHand(){
        hand.clear();
    }
    public void flip(){
        for (DoubleSidedCard card:hand){
            card.flip();
        }
    }
}
