# UnoFlip
# AUTHORS AND ACKNOWLEDGEMENT

This program reproduces a simplified version of the card game UNO Flip. This program was made for the SYSC 3110 team project, by group 15, which consists of Khalid Merai, Scharara Islam, Marina Latif and Abdulrahman Aldayel.

# How to Play UNO:
1. Run the Class SRC.UnoGUI.java
2. Enter the number of Players : (2-4)
3. Enter the name of Players
4. The game will display the top card on the discard pile, and each player's initial hand.
5. Players use their mouse to interact with the game and choosing either to draw the cards or play the cards,
   -> if you choose to draw a card, the game will simulate drawing a card from the deck and add it to your hand.
   -> If you choose to play a card, the selected card from your hand will be played. After playing the card, the game will update the top 
      card on the discard pile, and it will be the next player's turn.
6. Repeat step 5 for each player's turn. The game will continue until a player wins by emptying their hand.


Game Rules
---------------------------------------

Uno has a few simple rules:
1. The game starts with a specified number of players (2-4).
2. Each player is dealt 7 cards from the Uno deck.
3. The top card of the discard pile is shown.
4. Players take turns playing cards or drawing cards.
5. Players can only play cards that match the color or value of the top card on the discard pile.
6. Special action cards (Reverse, Skip, Draw Two, Wild..) have unique effects and are implemented.
7. The game continues until one player has no cards left or the deck is empty.


##Project Structure

1.Game.java
A light side UNO Flip game that has players, cards, and contains the logic required to play a game of light side UNO Flip.
2.WildView.java
Represents the view for selecting the new color when a Wild card is played in UNO. Displays a dialog with color options and allows the user to choose a color. Extends JDialog and implements an ActionListener to handle color selection.
3.GameRunner.java
Initializes and runs an UNO game. Manages the creation of UNO card decks, shuffling, dealing cards, and initiating game rounds. Includes a createDoubleSidedDeck method to generate a deck of DoubleSidedCard. Contains the main method to start the UNO game.
4.AiHelper.java
A utility class to assist AI players in making decisions during the game. Helps AI players choose cards based on the current game state and the cards in their hands.
5.HandController.java
The controller for the portion of the UNO interface that displays the current player's hand and available actions. Manages playing cards, drawing cards, and advancing turns.
6.WildController.java
The controller to control the portion of the UNO interface that pops up if a Wild card is played. Works with the WildView to get the new color selection from the user and updates the game accordingly.
7.Player.java
Represents a player in the UNO game. Contains information about the player's name, score, hand of cards, and whether the player is controlled by AI. Provides methods to access and manipulate the player's information, such as getting the name, score, and active hand. Includes methods to increment the player's score, deal a card, play a card, and manage the player's hand.

BREAK DOWN OF TASKS FOR MILESTONE 1
---------------------------------------

Khalid Merai - SRC.UnoGame.java, added a few methods in card.java and SRC.ConsoleUI.java and helped with the junit testing and did the data structure document

Scharara Islam - SRC.Player.java, SRC.Deck.java

Marina Latif - SRC.Card.java, UML diagram, Sequence diagram, ReadMe file 

Abdulrahman Aldayel - SRC.Main.java, SRC.ConsoleUI.java, did the junits for milestone1 and did the data structure document

BREAK DOWN OF TASKS FOR MILESTONE 2
---------------------------------------

Khalid Merai - SRC.UnoGame.java, SRC.Card.java, SRC.UnoGUI.java, updated JUnit testing and helped in unocontroller

Scharara Islam - SRC.UnoGUI.java, edited SRC.UnoGame.java, updated ReadMe file and diagrams

Marina Latif - SRC.UnoGUI.java SRC.Card.java, UML diagram, Sequence diagram, ReadMe file 

Abdulrahman Aldayel - SRC.Controller.java

BREAK DOWN OF TASKS FOR MILESTONE 3
---------------------------------------

Khalid Merai - edited the GUI frame 

Scharara Islam - updated ReadMe file and diagrams

Marina Latif - Edited the GUI Frame 

Abdulrahman Aldayel - 





