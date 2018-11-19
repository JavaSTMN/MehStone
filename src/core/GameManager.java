package core;

public class GameManager {
	
	private Player playerOne;
	private Player playerTwo;
	
	public GameManager(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	
	public void startGame() {
		System.out.println(playerOne.toString());
		System.out.println(playerTwo.toString());
	}
	
	public void endGame() {
		//TODO
	}
	
	public void endRound() {
		//TODO
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

}
