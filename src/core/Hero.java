package core;

public class Hero {
	
	private String name;
	private int hp;
	private String imgPath;
	private int type;
	
	
	public void die() {
		// TODO
	}
	
	public void gainHp(int hp) {
		this.hp += hp;
	}

	
	public void loseHp(int hp) {
		this.hp -= hp;
	}
	
	
	public boolean isCardAvailable() {
		
		//TODO
		return false;
	}
}
