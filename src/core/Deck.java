package core;

import java.util.ArrayList;

public class Deck {

	private String label;
	private String heroType;
	private int nb;
	private ArrayList<Card> cards;
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
	/**
	 * @param deck
	 * @param card
	 */
	public void addCardToDeck(Card card) {
		this.cards.add(card);
	}
	
	
	public void removeCardFromDeck(Card card) {
		this.cards.remove(card);
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getHeroType() {
		return heroType;
	}
	public void setHeroType(String heroType) {
		this.heroType = heroType;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	
}
