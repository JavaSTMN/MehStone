package core;

public abstract class Card {
	private String name;
	private String description;
	private int mana;
	private String imgPath;
	private String effect;
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
	 * 
	 * @return
	 */
	public String getImgPath() {
		return this.imgPath;
	}
	/**
	 * 
	 * @param imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Card getCard() {
		return this;
	}

}
