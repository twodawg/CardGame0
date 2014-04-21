package com.github.mrcsabatoth.core.board;

public class Card {
	  private final CardSuit suit; 
	   
	  private final CardValue value;
	   
	   public Card() {
	      suit = CardSuit.SUIT_INVALID;
	      value = CardValue.VALUE_INVALID;
	   }

	   public Card(CardValue theValue, CardSuit theSuit) {
	      value = theValue;
	      suit = theSuit;
	   }

	   public CardSuit getSuit() {
	      return suit;
	   }
	   
	   public CardValue getValue() {
	      return value;
	   }
	   
	   public String getSuitAsString() {
	      switch ( suit ) {
	      case SUIT_SPADE:   return "Spades";
	      case SUIT_HEART:   return "Hearts";
	      case SUIT_DIAMOND: return "Diamonds";
	      case SUIT_CLUB:    return "Clubs";
	      default:       return "Joker";
	      }
	   }
	   
	   public String getValueAsString() {

	         switch ( value ) {
		         case VALUE_A:   return "Ace";
		         case VALUE_2:   return "2";
		         case VALUE_3:   return "3";
		         case VALUE_4:   return "4";
		         case VALUE_5:   return "5";
		         case VALUE_6:   return "6";
		         case VALUE_7:   return "7";
		         case VALUE_8:   return "8";
		         case VALUE_9:   return "9";
		         case VALUE_10:  return "10";
		         case VALUE_J:  return "Jack";
		         case VALUE_Q:  return "Queen";
		         default:  return "King";
	         }
	   }
	   
	   public String toString() {
	         return getValueAsString() + " of " + getSuitAsString();
	   }
	   
}