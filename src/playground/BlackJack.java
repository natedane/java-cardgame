package playground;

import java.io.IOException;
import java.util.*;

import playground.Deck.Card;

public class BlackJack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Deck myDeck = new Deck();
//		System.out.println("Deck size starts "+ myDeck.getDeckSize());
//		Card firstCard = myDeck.dealCard();
//		System.out.println("the first card is "+firstCard.toString());
//		System.out.println("Deck size is now "+ myDeck.getDeckSize());
//		
//		ArrayList<Card> hand = myDeck.getCards(5);
//		
//		for(Card item: hand) {
//			System.out.println("my hand has "+item.toString());
//		}
//		
//		Collections.sort(hand);
//		for(Card item: hand) {
//			System.out.println("my hand has sorted "+item.toString());
//		}
//		System.out.println(hand.size()+" in my hand. "+ myDeck.getDeckSize()+" left in the deck");
		
		System.out.println("Welcome to Black Jack. Get as close to 21 without going over. Hit or Stay, your choice.");
		while(true) {
			System.out.println("Play? Yes or No.");
			Scanner in = new Scanner(System.in);
			String choice = in.nextLine();
			if(choice.toLowerCase().trim().equals("yes")|| choice.toLowerCase().trim().equals("y")) {
				System.out.println("Lets play");
				playGame();
			}else {
				System.out.println("Bye Bye");
				break;
			}
		}
	

	}
	
	public static void playGame() {
		Deck myDeck = new Deck();
		Scanner in = new Scanner(System.in);

		ArrayList<Card> hand = myDeck.getCards(2);
		int points = getSum(hand);
		System.out.println("your total is "+ points);		
		
		ArrayList<Card> dealerHand = myDeck.getCards(2);
		System.out.println("Dealer is showing "+dealerHand.get(0).toString());
		
		String choice;
		while(true) {
			System.out.println("Hit or Stay");
			choice = in.nextLine();
			if(choice.toUpperCase().trim().equals("HIT")) {

				Card nextCard = myDeck.dealCard();
				hand.add(nextCard);
				points= getSum(hand);
				
				System.out.println("Your next card is "+ nextCard.toString());
				System.out.println("your total is "+ points);
				
				if(points> 21)
					break;
			}else {			
				break;
			}
		}
		endGame(hand, dealerHand);		

		
		
	}

	public static void endGame(ArrayList<Card> hand, ArrayList<Card> dealerHand) {
		int points = getSum(hand);
		int dealerPoints = getSum(dealerHand);
		
		if(points> 21)
			System.out.println("You busted! " + points+ " is too much");
		else{
			System.out.println("Dealer has " + dealerPoints);
	
			if(dealerPoints >= points)
				System.out.println("Dealer wins with " + dealerPoints);
			else
				System.out.println("You win with " + points);	
		}
	}
	
	public static int getSum(ArrayList<Card> hand) {
		int points = 0;
		for(Card one: hand) {
			points+= one.getValue();
		}
		return points;
	}

}
