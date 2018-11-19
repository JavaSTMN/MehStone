package core;

import java.awt.Image;

public class Hero {
	
	private String name;
	private int hp;
	private Image img;
	public static int _NB_MAX_HP = 20;
	
	public Hero(String name, Image img) {
		this.name = name;
		this.hp = _NB_MAX_HP;
		this.img = img;
	}
	
	public Image getImage() {
		return img;
	}
	
	public void die() {
		// TODO
	}
	
	public void gainHp(int hp) {
		this.hp += hp;
	}
	
	public void loseHp(int hp) {
		this.hp -= hp;
	}
	
}
