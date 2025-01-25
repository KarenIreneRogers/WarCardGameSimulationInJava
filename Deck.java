package FinalCodingProject_War;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import FinalCodingProject_War.Card;

public class Deck {

	
	public List<Card> cards = new ArrayList<Card>();
	
	
	Deck() {
	
			String[] suits = new String[]	{"Clubs", "Diamonds","Hearts","Spades"};
			String[] names = new String[] {"Two","Three", "Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
			Integer[] values = new Integer[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		
			
			for (int i=0; i< 4; i++) {
				for (int j=0; j<13;j++) {
			
					Card tempCard = new Card();
					
					tempCard.setName(names[j] + " of " + suits[i]);
					tempCard.setValue(values[j]);
	//				tempCard.describe();
					cards.add(tempCard);
					
				}
			} 

		}  
	
	public void describeDeck() {
		for (Card card: cards) {
			card.describe();
		}
	}
	public void shuffle() {
		
		Collections.shuffle(cards);
		
	}
	public Card draw() {

		return this.cards.remove(0);
	}
		
}
