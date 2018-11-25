package core;

import java.awt.Image;

public class Hero {
	
	private String name;
	private int hp;
	private Image img;
	public static int _NB_MAX_HP = 20;
	private boolean death = false;
	
	public Hero(String name, Image img) {
		this.setName(name);
		this.setHp(_NB_MAX_HP);
		this.img = img;
	}
	
	public Image getImage() {
		return img;
	}
	
	public void die() {
	}
	
	public void gainHp(int hp) {
		this.setHp(this.getHp() + hp);
	}
	
	public void loseHp(int hp) {
		if(this.getHp() - hp <= 0)
			death = true;
		this.setHp(this.getHp() - hp);
	}
	
	public boolean isDeath() {
		return death;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
}
