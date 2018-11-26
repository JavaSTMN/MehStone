package core;

import java.awt.Image;

public abstract class Card {
	private String name;
	private int mana;
	private Image image;
	private String effect;
	private boolean attack = false;
	
	
	
	public Card(String name, int mana, Image image, String effect) {
		this.name = name;
		this.mana = mana;
		this.image = image;
		this.effect = effect;
		
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
	return this.name;
	}
	
	private boolean canAttack() {
		return attack;
	}
	
	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMana() {
		return this.mana;
	}
	public void action() {
		System.out.println("DO SOMETHING");
	}
	/**
	 * @return
	 */
	public Image getImg() {
		return this.image;
	}
	/**
	 * 
	 * @param imgPath
	 */
	public void setImg(Image image) {
		this.image = image;
	}

	public Card getCard() {
		return this;
	}

}
