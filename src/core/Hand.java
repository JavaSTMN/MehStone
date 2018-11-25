package core;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private int maxCard;
	private ArrayList<Card> cards;
	
	public Hand(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public void displayCard(Card card) {
		//TODO Display a card, meh

	}
	
	public void moveCard(Card card) {
		//TODO Move a specific card, meh
	}
	public int getMaxCard() {
		return maxCard;
	}
	public void setMaxCard(int maxCard) {
		this.maxCard = maxCard;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

}
