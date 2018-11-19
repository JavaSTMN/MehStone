package core;

public class Monster extends Card implements ICard, IAttackingCard{

	
	
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
