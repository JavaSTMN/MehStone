package core;

import java.awt.Image;
import java.util.ArrayList;

public class Spell extends Card implements ICard, IAttackingCard {
	private int damage;
	

	
	public Spell(String name, int mana, Image image, String effect, int damage) {
		super(name, mana, image, effect);
		this.damage = damage;
	}

	public void action(Monster card) {
		card.removeHP(this.damage);
	}
	
	public int getDamage() {
		return this.damage;
	}

	public void action(ArrayList<Monster> cards) {
		for (Monster monster : cards) {
			monster.removeHP(this.damage);
		}
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
}
