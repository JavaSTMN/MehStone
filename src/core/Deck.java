package core;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Deck {

	private Hero hero;
	private final int _NB_MAX_CARD = 10 ;
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	

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
	
	public Hero getHero() {
		return hero;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public int get_NB_MAX_CARD() {
		return _NB_MAX_CARD;
	}
	
	public int getNbCards() {
		return this.cards.size();
	}
	
	public String getCardsToString() {
		String res = "";
		for( Card myCard : this.cards) {
			res += "  -  "+myCard.getMana()+" | "+ myCard.getName()+"\n";
	    }
		return res;
	}
	

	
}
