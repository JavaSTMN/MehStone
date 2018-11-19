package core;

import java.awt.Image;

public class Monster extends Card implements ICard, IAttackingCard{

	
	
	public Monster(String name, String description, int mana, Image image, String effect) {
		super(name, description, mana, image, effect);
		// TODO Auto-generated constructor stub
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
