package SRC;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AiPlayer extends Player {

    private Random random;

    public AiPlayer(String playerName) {
        super(playerName);
        random = new Random();
    }

    public AiPlayer(Deck deck){
        super(deck);
        random = new Random();
    }

    public void playCard(ArrayList<Card> validCards, Card.Color validColor){
        if (validCards.isEmpty()){
            return;
        }

        Card selectedCard = validCards.get(random.nextInt(validCards.size()));
        System.out.println(getName() + " plays " + selectedCard);
        removeCard(selectedCard.getValue());
    }

    public void pickCard(Card card){
        System.out.println(getName() + " picked a card");
        super.pickCard(card);
    }

    public void skip(){
        System.out.println(getName() + " skipped a turn");
        super.skip();
    }
}
