package core;

import java.awt.Image;

public abstract class Card {
	private String name;
	private int mana;
	private Image image;
	private String effect;
	private boolean attack;
	
	
	
	public Card(String name, int mana, Image image, String effect) {
		this.name = name;
		this.mana = mana;
		this.image = image;
		this.effect = effect;
		attack = false;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
	return this.name;
	}
	
	
	public boolean isAttack() {
		return attack;
	}
	public void setAttack(boolean a) {
		this.attack = a;
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
