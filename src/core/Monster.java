package core;
import java.awt.Image;
import java.util.ArrayList;

public class Monster extends Card implements ICard, IAttackingCard{


	private int hp;
	private int damage;
	
	public Monster(String name, int mana, Image image, String effect, int damage, int hp) {
		super(name, mana, image, effect);
		this.setHp(hp);
		this.damage = damage;
	}

	public void action(Monster target) {
		target.removeHP(this.damage);
	}
	
	public void action(Hero hero) {
		hero.loseHp(this.damage);
	}
	
	@Override
	public boolean isSummonable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canAttack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void attack(Card card) {
		// TODO Auto-generated method stub
		
	}
	
	public void removeHP(int number) {
		this.setHp(this.getHp() - number);
	}
	
	public void addHP(int number) {
		this.setHp(this.getHp() + number);
	}
		
	public void removeAttack(int number) {
		this.damage -= number;
	}

	public void addAttack(int number) {
		this.damage += number;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;;
	}
	
	

}

