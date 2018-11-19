package core;

import java.awt.Image;

public abstract class Card {
	private String name;
	private String description;
	private int mana;
	private Image image;
	private String effect;
	
	
	
	public Card(String name, String description, int mana, Image image, String effect) {
		this.name = name;
		this.description = description;
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
	
	public String getEffect() {
		return this.effect;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return this.description;
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
	public Image getImgPath() {
		return this.image;
	}
	/**
	 * 
	 * @param imgPath
	 */
	public void setImgPath(Image image) {
		this.image = image;
	}

	public Card getCard() {
		return this;
	}

}
