package core;

public class Player {

	private String userName;
	private Hand hand;
	private int crystals;
	private Deck deck;
	private Hero hero;
	public static int _NB_MAX_CRYSTAL;
	
	public Player(String username, Hand hand) {
		this.userName = username;
		this.hand = hand;
		this.crystals = _NB_MAX_CRYSTAL;
	}

	public void addCrystals() {
		// TODO c'est ça non?
		this.setCrystals(this.getCrystals() + 1);
	}

	public void removeCrystal() {
		// TODO j'sais pas ce que ça fait
	}

	public void getRemainingCrystals() {
		// TODO C'est de la merde, on return just crystals
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

	public int getCrystals() {
		return crystals;
	}

	public void setCrystals(int crystals) {
		this.crystals = crystals;
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
