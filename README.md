# UnoFlip
#AUTHORS AND ACKNOWLEDGEMENT

This program reproduces a simplified version of the card game UNO Flip. This program was made for the SYSC 3110 team project, by group 15, which consists of Khalid Merai, Scharara Islam, Marina Latif and Abdulrahman Aldayel.

#How to Play UNO using the console interface:
1. Run the Class Main
2. Enter the number of Players : (2-4)
3. Enter the name of Players
4. The game will display the top card on the discard pile, and each player's initial hand.
5. You can choose to draw a card (enter 0) or play a card (enter index of card) when prompted
   -> if you choose to draw a card (enter 0), the game will simulate drawing a card from the deck and add it to your hand.
   -> If you choose to play a card (enter index of card), the selected card from your hand will be played. After playing the card, the game will update the top 
      card on the discard pile, and it will be the next player's turn.
6. Repeat step 5 for each player's turn. The game will continue until a player wins by emptying their hand.



#Game Rules

Uno has a few simple rules:
1. The game starts with a specified number of players (2-4).
2. Each player is dealt 7 cards from the Uno deck.
3. The top card of the discard pile is shown.
4. Players take turns playing cards or drawing cards.
5. Players can only play cards that match the color or value of the top card on the discard pile.
6. Special action cards (Reverse, Skip, Draw Two, Wild..) have unique effects and are implemented.
7. The game continues until one player has no cards left or the deck is empty.


#Project Structure
The project consists of the following Java classes:

UnoGame.java: The main Uno game class that manages the game logic.
Card.java: Represents Uno cards with color, type, and value.
Deck.java: Represents the Uno deck and provides card drawing and shuffling.
Player.java: Represents Uno players and their hand of cards.
ConsoleUI.java: Handles user interaction through the console, including player input and game output.
CardTest.java: Contains unit tests for the Card class to ensure card-related functionality.
Main.java: The entry point of the Uno game. It initializes the game and starts the gameplay.

Contributions:
Khalid Merai - UnoGame.java, added a few methods in card.java and ConsoleUI.java and helped with                the junit testing



