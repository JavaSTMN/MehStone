package core;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private int maxCard;
	private ArrayList<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	public void displayCard(Card card) {
		//TODO Display a card, meh

	}
	
	public void moveCard(Card card) {
		//TODO Move a specific card, meh
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	
	public void removeCard(Card card) {
		this.cards.remove(card);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

}
