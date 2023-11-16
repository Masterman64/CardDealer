package jjonesdealingcards;

import java.util.ArrayList;
import java.util.Collections;

/**
   Chapter 19, Programming Challenge 6
   Deck Class
*/

public class Deck
{
 	// The cards list is the deck of cards  
	private ArrayList<Card> cards;
   
   /**
      The constructor creates a deck of 52 cards.
   */
   
   public Deck()
   {
      // Instantiate the deck of cards.
      cards = new ArrayList<Card>();
      
      // Populate the ArrayList with 52 Card objects.
      // (We won't use the Joker in this game.)
      for (int suit = Card.HEARTS; suit <= Card.CLUBS; suit++)
      {
         for (int face = Card.ACE; face <= Card.KING; face++)
            cards.add(new Card(face, suit));
      }
      
      // Shuffle the deck of cards.
      shuffle();
   }
   
   /**
      The shuffle method shuffles the deck of cards.
   */
   
   public void shuffle()
   {
      Collections.shuffle(cards);
   }
   
   /**
      The deal method deals a card.
      @return The Card object at the top of the deck, or
              null if no more cards are left in the deck.
   */
   
   public Card deal()
   {
      if (cards.size() > 0)
         return cards.remove(0);
      else
         return null;
   }
   
   /**
    * Adds a card back to the deck
    * @param c - The card to be added
    */
   public void add(Card c){
       cards.add(c);
   }
}