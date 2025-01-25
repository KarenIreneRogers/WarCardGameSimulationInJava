package FinalCodingProject_War;

import java.util.ArrayList;
import java.util.List;



public class Player extends Card  {
	
	
	public List<Card> hand = new ArrayList<Card> ();
	public int score = 0;
	public String name = new String();
	
	public Player() {
	}
	
	public Player(ArrayList<Card> hand, int score, String name) {
		this.hand = hand;
		this.score = score;
		this.name = name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// describe prints out info about the player and displays the cards in the hand
	public void describe() {
		System.out.println("Player's name:  " + this.name);
		System.out.println("Player's score: " + this.score);
		System.out.println("Player's hand:  ");
		
		for (Card card: this.hand) {
			card.describe ();
		}	
	}
	
	
	// flip (removes and returns the top card of the Hand)
			
	public Card flip() {
		return this.hand.remove(0);
	
	}

    //   draw (takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field)
	public void drawCardIntoHand(Deck cards) {
//		Card tempCard = cards.draw();
		
//		tempCard.describe();
		
		this.hand.add(cards.draw() );

		
	}
   //  incrementScore (adds 1 to the Player’s score field)
	public void incrementScore() {
		this.score ++;
	}
}
