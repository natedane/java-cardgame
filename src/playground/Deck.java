package playground;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>(52);
		for(int i=1; i<=13; i++) {
			int value = i> 10 ? 10: i;
			deck.add(new Card("Spades", valueToName(i), value, i));
			deck.add(new Card("Clubs", valueToName(i), value, i));
			deck.add(new Card("Diamonds", valueToName(i), value, i));
			deck.add(new Card("Hearts", valueToName(i), value, i));
		}
		Collections.shuffle(deck);
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		Card top = deck.get(0);
		deck.remove(top);
		return top;
	}
	
	public ArrayList<Card> getCards(int count){
		ArrayList<Card> hand = new ArrayList<Card>(deck.subList(0, count));
		deck.removeAll(hand);
		
		return hand;
	}
	
	private static String valueToName(int value) {
		String valueName[] = {"Ace", "Two", "Three", "Four", "Five", "Six","Seven", "Eight", "Nine","Ten",
				"Jack", "Queen", "King"};
		return valueName[value-1];
	}
	
	public class Card implements Comparable{
		private String suit;
		private String name;
		private int value;
		private int weight;
		
		public Card(String suit, String name, int value, int weight) {
			this.suit = suit;
			this.name = name;
			this.value = value;
			this.weight = weight;
		}
		public String getSuit() {
			return this.suit;
		}
		public String getName() {
			return this.name;
		}
		public int getValue() {
			return this.value;
		}
		public int getWeight() {
			return this.weight;
		}
		
		public String toString() {
			return name+ " of " + suit;
		}
		
		@Override
		public int compareTo(Object compare) {
			// TODO Auto-generated method stub
			Card compCard = (Card)compare;
			return this.weight - compCard.weight;
		}
		

		
	}
}
