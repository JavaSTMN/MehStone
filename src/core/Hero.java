package core;

import java.awt.Image;

public class Hero {
	
	private String name;
	private int hp;
	private Image img;
	public static int _NB_MAX_HP = 30;
	private boolean death = false;
	
	public Hero(String name, Image img) {
		this.setName(name);
		this.setHp(_NB_MAX_HP);
		this.img = img;
	}
	
	public Hero(Hero h) {
		this.setName(h.getName());
		this.setHp(_NB_MAX_HP);
		this.img = h.getImage();
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
	
	public void heal(int hp) {
		this.hp = (this.hp + hp > _NB_MAX_HP)?this.hp:this.hp+hp;
	}
	
}
