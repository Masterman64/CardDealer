package jjonesdealingcards;

import java.util.ArrayList;

/**
   Chapter 19, Programming Challenge 6
   CardPlayer Class
*/

public class CardPlayer
{
   // The hand list is the hand of cards
   private ArrayList<Card> hand;
   
   /**
      Constructor
   */
   
   public CardPlayer()
   {
      hand = new ArrayList<Card>();
   }

   /**
      The getCard method gets a card and
      adds it to the hand.
      @param card The card to add to the hand.
   */
   
   public void addCard(Card card)
   {
      hand.add(card);
   }
   
   /**
     * Returns the player's hand to display
     * @return hand - The player's hand
   */
   
   public ArrayList<Card> showCards()
   {
      return hand;
   }
   
    /**
     * Clears the player's hand
     */
    public void clear(){
       hand.clear();
   }
}
