package Model;

public abstract class Game {
	protected Participant participant1, participant2, winner;
	protected Result[] results;
	protected int counter;

	public Game(Participant p1, Participant p2) {
		participant1 = p1;
		participant2 = p2;
		counter = 0;
	}

	public void setWinner(Participant p) {
		winner = p;
	}

	public Participant getWinner() {
		return winner;
	}

	public Participant getP1() {
		return participant1;
	}

	public Participant getP2() {
		return participant2;
	}
	
	public void clear() {
		for (int i = 0; i < results.length; i++) 
			results[i] = null;
		counter = 0;
	}

}
