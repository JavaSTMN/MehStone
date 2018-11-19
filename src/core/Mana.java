package core;

public class Mana {
	private int _MAX_CRYSTALS;
	private int manaTurn;
	private int manaMaxByTurn;
	
	public Mana(int init) {
		this._MAX_CRYSTALS = 10;
		this.manaTurn = init;
		this.manaMaxByTurn = init;
	}
	
	//Fonction qui ajoute du mana a chaque tour
		public void addManaTurn(int number) {
			this.manaMaxByTurn = this.manaMaxByTurn + number;
			this.manaMaxByTurn = (this.manaMaxByTurn >= _MAX_CRYSTALS)?_MAX_CRYSTALS:this.manaMaxByTurn;
		}

		//Fonction qui enleve les cristaux
		public void useManaTurn(int number) {
			this.manaTurn = this.manaTurn - number;
			this.manaTurn = (this.manaTurn > 0)?this.manaTurn:0;
		}
		
		//Fonction qui retourne les cristaux du tour en cours
		public int getRemainingMana() {
			return this.manaTurn;
		}
		
		//Fonction qui retourne le nombre de cristaux par tour
		public int getManaMaxByTurn() {
			return manaMaxByTurn;
		}

		//Fonction qui met a jour le nombre de cristaux par tour
		public void setManaTurn(int crystals) {
			this.manaTurn = crystals;
		}
		
		//Fonction qui remet le nombre de manaTurn à manaMaxByTurn
		public void fillManaTurn() {
			this.manaTurn = this.manaMaxByTurn;
		}

}
