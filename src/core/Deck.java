package core;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import tool.ImagePaths;

public class Deck {

	private Hero hero;
	private final int _NB_MAX_CARD = 9 ;
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	public Deck(int test) {
		cards = new ArrayList<Card>();
		if(test == 1) {
			ImageIcon imageIcon = new ImageIcon(ImagePaths._HERO_GLORIA); 
			Image imgGloria = imageIcon.getImage();
			hero = new Hero("Gloria", imgGloria);
		} else {
			ImageIcon imageIcon = new ImageIcon(ImagePaths._HERO_LSD); 
			Image imgLsd = imageIcon.getImage();
			hero = new Hero("Lsd", imgLsd);
		}
		
		Image sbire_slime = new ImageIcon(ImagePaths._SLIME_3).getImage();
		Image spell_katon = new ImageIcon(ImagePaths._SPELL_KATON).getImage();
		cards.add(new Monster("slime",1, sbire_slime,"Slurp",1,3));
		cards.add(new Monster("slime",1, sbire_slime,"Slurp",1,3));
		cards.add(new Monster("slime",1, sbire_slime,"Slurp",1,3));
		cards.add(new Monster("slime",1, sbire_slime,"Slurp",1,3));
		cards.add(new Monster("slime",1, sbire_slime,"Slurp",1,3));
		cards.add(new Spell("katon",2, spell_katon,"Inflige 2 point(s) de dégats", 2));
		cards.add(new Spell("katon",2, spell_katon,"Inflige 2 point(s) de dégats", 2));
		cards.add(new Spell("katon",2, spell_katon,"Inflige 2 point(s) de dégats", 2));
		cards.add(new Spell("katon",2, spell_katon,"Inflige 2 point(s) de dégats", 2));
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
