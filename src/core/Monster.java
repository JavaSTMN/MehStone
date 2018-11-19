package core;

import java.awt.Image;

public class Monster extends Card implements ICard, IAttackingCard{

	private int hp;
	private int damage;
	
	public Monster(String name, int mana, Image image, String effect, int damage, int hp) {
		super(name, mana, image, effect);
		this.hp = hp;
		this.damage = damage;
	}

	public void action() {
		System.out.println("Monster does smth");
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
	
	
	

}
