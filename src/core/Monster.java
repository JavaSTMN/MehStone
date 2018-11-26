package core;
import java.awt.Image;
import java.util.ArrayList;

public class Monster extends Card implements ICard, IAttackingCard{


	private int hp;
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	private int damage;
	private boolean death = false;
	
	public Monster(String name, int mana, Image image, String effect, int damage, int hp) {
		super(name, mana, image, effect);
		this.hp = hp;
		this.damage = damage;
	}

	public void action(Monster target) {
		target.removeHP(this.damage);
	}
	
	public void action(Hero hero) {
		hero.loseHp(this.damage);
	}
	
	public int getDamage() {
		return this.damage;
	}

	@Override
	public boolean canAttack() {
		return false;
	}

	@Override
	public void attack(Card card) {
		// TODO Auto-generated method stub
		
	}
	
	public void removeHP(int number) {
		this.hp -= number;
		this.death = (this.hp > 0)?false:true;
	}
	
	public void addHP(int number) {
		this.hp += number;
	}
		
	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	public void removeAttack(int number) {
		this.damage -= number;
	}

	public void addAttack(int number) {
		this.damage += number;
	}

	@Override
	public boolean isSummonable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
