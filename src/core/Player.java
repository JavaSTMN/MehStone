package core;

public class Player {

	private String userName;
	private Hand hand;
	private Mana mana;
	private Deck deck;
	private Hero hero;
	
	public Player(String username, Hand hand, Mana mana) {
		this.userName = username;
		this.hand = hand;
		this.mana = mana;
	}

	public Mana getMana() {
		return this.mana;
	}
	
	public void setMana(Mana mana) {
		this.mana = mana;
	}	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
}
