package game.backend;

public abstract class GameState {
	
	private long score = 0;
	private int moves = 0;
	private int specialElementsRemoved = 0;
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}
	
	public void addMove() {
		moves++;
	}
	
	public int getMoves() {
		return moves;
	}

	public String getCurrentState(){
		return "";
	}

	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

	public int getSpecialElementsRemoved() {
		return specialElementsRemoved;
	}

	public void addSpecialElementRemoved() {
		specialElementsRemoved++;
	}
}
