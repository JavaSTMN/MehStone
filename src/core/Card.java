package core;

public abstract class Card {
	private String name;
	private String description;
	private int mana;
	private String imgPath;
	private int hp;
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
	return this.name;
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
	
	/**
	 * 
	 * @return
	 */
	public int getHp() {
		return this.hp;
	}
	
	
	public Card getCard() {
		return this;
	}

}
