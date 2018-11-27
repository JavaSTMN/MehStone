package core;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import tool.ImagePaths;

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
		this.setHp(hp);
		this.damage = damage;
	}

	public void action(Monster target) {
		target.removeHP(this.damage);
	}
	
	public void action(Hero hero) {
		hero.loseHp(this.damage);
	}
	
	public void effect(ArrayList<Card> listCard) {
		if(this.getName() == "furry") {
			if(listCard.size() < 4) {
				Image sbire_feminin = new ImageIcon(ImagePaths._SBIRE_SBIRE_FEMININ).getImage();
				Monster sbire_femen = new Monster("sbire_femen",1, sbire_feminin,"Sbire de Furry",1,1);
				listCard.add(sbire_femen);
			}
		}else if(this.getName() == "garou") {
			for( Card myCard : listCard) {
				((Monster) myCard).addHP(1);
			}
		}
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
		this.death = (this.getHp() > 0)?false:true;
	}
	
	public void addHP(int number) {
		this.setHp(this.getHp() + number);
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

	
	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;;
	}
	
	

}

