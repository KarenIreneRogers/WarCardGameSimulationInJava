// This is the final coding project for the first 6 weeks.  
// It is an automated game of War, the card game.
// Written by:  Karen Rogers
// Date:  Jan 21 - 25, 2025

/* 2. Create a class called App with a main method.

a.      Instantiate a Deck and two Players, call the shuffle method on the deck.

b.     Using a traditional for loop, iterate 52 times calling the Draw method on the other player each iteration using the Deck you instantiated.

c.      Using a traditional for loop, iterate 26 times and call the flip method for each player.

Compare the value of each card returned by the two player’s flip methods. Call the incrementScore method on the player whose card has the higher value.  Print a message to say which player received a point.
Note:  If the values are equal (it is a tie), print a message saying that no point was awarded.
d.      After the loop, compare the final score from each player.

e.      Print the final score of each player and either “Player 1”, “Player 2”, or “Draw” depending on which score is higher or if they are both the same.  

*/





package FinalCodingProject_War;

public class App {
	
	public static final String ANSI_RESET = "\u001B[0m";   // From the website:https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
	public static final String ANSI_CYAN = "\u001B[36m"; 
	public static final String ANSI_BLACK= "\u001B[30m"; 
	public static final String ANSI_GREEN = "\u001B[32m"; 
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; 
	
	
	
	public static void main(String[] args) {
		
		boolean printExtra = true ;    // Flag used for development process to print extra information to be able to check for proper operation
										// Change to false to only see game play.
		
		// Instantiate the deck and two players
		Deck cards = new Deck();
		Player player1 = new Player();
		Player player2 = new Player();
		
		player1.setName("Player 1");
		player2.setName("Player 2");
		

		
		if(printExtra) {
		
			cards.describeDeck();
	
			sleep(2000);		// Pause execution so the console can be read (Use milliseconds as argument)
								// Found at: https://www.javaprogramto.com/2020/08/how-to-make-delay-in-java-thread-sleep.html
			System.out.println("******************** Deck desc above, deck shuffle next********************");
		}
		// Shuffle the deck
		cards.shuffle();
		
		
		if(printExtra) {
			cards.describeDeck();
		
			System.out.println("************** End of shuffle, Draw next **********************");
		}
		/*
		 * . Using a traditional for loop, iterate 52 times calling the Draw method on
		 * the other player each iteration using the Deck you instantiated.
		 * 
		 */	
		for (int i=0; i< 52; i++) {
				
			if ( (i % 2) == 0) {   // Draw for player 1	
				player1.drawCardIntoHand(cards);
				
			}
		 	else { 				// Draw for player 2
			
		 		player2.drawCardIntoHand(cards);		
			
		 	}
		}
		
		if(printExtra) {
			System.out.println("****************** End of drawing hands  ***********************************");
			player1.describe();
			player2.describe();
			sleep(2000);
			System.out.println("******************End of describing players  ***********************************");
		}
		
		
		// Play the game!
		for (int i=0; i<26; i++) {
			Card card1 = new Card();
			Card card2 = new Card();
		
			card1 = player1.flip();
			card2 = player2.flip();
		
			System.out.println("\n\nRound: " + (i+1)  );
			
			System.out.print(player1.name + "'s card: " );
			card1.describe();
			System.out.print(player2.name + "'s card: ");
			card2.describe();
		// Determine winner and increment scores
			if (card1.value > card2.value) {
				player1.incrementScore();
				System.out.println(ANSI_CYAN + player1.getName() + " won this round. " + ANSI_RESET);
			} else if (card2.value > card1.value) {
				player2.incrementScore();
				System.out.println(ANSI_GREEN + player2.getName ()+ " won this round. " + ANSI_RESET);
			} else {
				System.out.println("This round was a tie.  No points scored. ");
			}
		
		// Print score with leader's score highlighted in their color
			if(player1.getScore() > player2.getScore() ) {
				System.out.println("Current Score: " + ANSI_CYAN + player1.getName () + ":  " + player1.getScore () + ANSI_RESET +  "         " + player2.getName() + ": " + player2.getScore() );
			} else if (player2.getScore() > player1.getScore() ) {
				System.out.println("Current Score: " + player1.getName () + ":  " + player1.getScore ()+ "         " + ANSI_GREEN +  player2.getName() + ": " + player2.getScore() + ANSI_RESET );
			} else {
				System.out.println("Current Score: " + player1.getName () + ":  " + player1.getScore ()+ "         " + player2.getName() + ": " + player2.getScore() );
			}
				
		}
		
		// End of game, announce overall winner
		if (player1.getScore() > player2.getScore() ) {
			System.out.println(ANSI_CYAN + "\n\nCongratulations " + player1.getName() + ", you have won the game!" + ANSI_RESET);
		}  else 
		if (player2.getScore() > player1.getScore() ) {
			System.out.println(ANSI_GREEN + "\n\nCongratulations " + player2.getName() + ", you have won the game!" + ANSI_RESET);
		}   else  {
			System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "\n\nGame ends in a tie!!!" + ANSI_RESET);
		}
		
	}



	private static void sleep(long millies) {  // Method for sleep routine which pauses the display output.  Found at https://www.javaprogramto.com/2020/08/how-to-make-delay-in-java-thread-sleep.html
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
			Thread.currentThread().interrupt();
		}
	}
}
