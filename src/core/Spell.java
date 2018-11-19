package core;

import java.awt.Image;

public class Spell extends Card implements ICard, IAttackingCard {

	public Spell(String name, int mana, Image image, String effect) {
		super(name, mana, image, effect);
		// TODO Auto-generated constructor stub
	}

	public void action() {
		System.out.println("Spell does smth");
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
