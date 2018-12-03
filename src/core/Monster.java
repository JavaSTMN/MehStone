package core;
import java.awt.Image;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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

	public void effect(ArrayList<Card> listCard,ArrayList<Card> listCardAdversaire, Hero myHero) {
		String name = this.getName();
		if(name == "alazar") {
			String[] tabName = {"nick", "tortank", "meh","enigma", "3k", "lithium","garou", "ivan", "kingsman","lapeyrle", "mamie", "furry"};
			int randomNum =ThreadLocalRandom.current().nextInt(0, tabName.length-1);
			name = tabName[randomNum];
		}
		switch (name) {
		case "nick":
			if(listCard.size() < 4 && listCardAdversaire.size() >= 1) {
				int randomNum =(listCardAdversaire.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCardAdversaire.size()-1);
				listCard.add(listCardAdversaire.remove(randomNum));
			}
			break;
		case "tortank":
			if(listCardAdversaire.size() >= 1) {
				for(int i = listCardAdversaire.size()-1; i>= 0; i--) {
					Card myCard = listCardAdversaire.get(i);
					this.addHP(1);
					((Monster) myCard).removeHP(1);
					if(((Monster) myCard).isDeath()) {
						listCardAdversaire.remove(myCard);
					}
				}
			}
			break;
		case "meh":
			if(listCard.size() == 1) {
				this.addHP(5);
			}
			break;
		case "enigma":
			if(listCardAdversaire.size() >= 1) {
				for(int i = listCardAdversaire.size()-1; i>= 0; i--) {
					Card myCard = listCardAdversaire.get(i);
					((Monster) myCard).removeAttack(1);
					((Monster) myCard).removeHP(1);
					if(((Monster) myCard).isDeath()) {
						listCardAdversaire.remove(myCard);
					}
				}
			}
			break;
		case "3k":
			if(ThreadLocalRandom.current().nextInt(0,1) == 0) {
				if(listCard.size() >= 1) {
					int randomNum =(listCard.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCard.size()-1);
					listCard.remove(randomNum);
				}
			}else {
				if(listCardAdversaire.size() >= 1) {
					int randomNum =(listCardAdversaire.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCardAdversaire.size()-1);
					listCardAdversaire.remove(randomNum);
				}
			}
			if(ThreadLocalRandom.current().nextInt(0,1) == 0) {
				if(listCard.size() >= 1) {
					int randomNum =(listCard.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCard.size()-1);
					listCard.remove(randomNum);
				}
			}else {
				if(listCardAdversaire.size() >= 1) {
					int randomNum =(listCardAdversaire.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCardAdversaire.size()-1);
					listCardAdversaire.remove(randomNum);
				}
			}
			break;
		case "lithium":
			if(listCard.size() < 4) {
				Image sbire_feminin = new ImageIcon(ImagePaths._SBIRE_SBIRE_FEMININ).getImage();
				Monster sbire_femen = new Monster("sbire_femen",1, sbire_feminin,"Sbire de lithium",1,1);
				listCard.add(sbire_femen);
				myHero.heal(2);
			}
			break;
		case "garou":
			if(listCard.size() < 4) {
				Image sbire_feminin2 = new ImageIcon(ImagePaths._SBIRE_SBIRE_FEMININ2).getImage();
				Monster sbire_femen = new Monster("sbire_femen2",1, sbire_feminin2,"Sbire de garou",1,1);
				listCard.add(sbire_femen);
			}
			break;
		case "ivan":
			int randomNum =(listCard.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCard.size()-1);
			((Monster) listCard.get(randomNum)).addHP(2);
			((Monster) listCard.get(randomNum)).addAttack(2);
			break;
		case "kingsman":
			int rd =(listCardAdversaire.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCardAdversaire.size()-1);
			((Monster) listCardAdversaire.get(rd)).removeAttack(2);
			break;
		case "lapeyrle":
			for( Card myCard : listCard) {
				if(myCard != this) {
					((Monster) myCard).removeAttack(1);
				}
			}
			break;
		case "mamie":
			int r =(listCard.size() == 1)?0:ThreadLocalRandom.current().nextInt(0, listCard.size()-1);
			((Monster) listCard.get(r)).removeAttack(1);
			((Monster) listCard.get(r)).addHP(1);
			break;
		case "furry":
			for( Card myCard : listCard) {
				if(myCard != this) {
					((Monster) myCard).addHP(1);
				}
			}
			break;
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
		this.damage = (this.damage == 0 )?0:this.damage-1;
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

