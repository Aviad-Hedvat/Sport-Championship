package Model;

public class TennisGame extends Game {
	final public static int RESULTS = 5;

	public TennisGame(Participant p1, Participant p2) {
		super(p1, p2);
		results = new Result[RESULTS];
	}

	public void setTennisSet(int p1Sets, int p2Sets) {
		results[counter++] = new Result(p1Sets, p2Sets);
		if (counter == RESULTS - 2 || counter == RESULTS - 1 || counter == RESULTS) {
			if (getWinner() == null)
				setWinner(gameResult(counter));
		}
	}

	public Participant gameResult(int numOfSets) {
		int p1Games = 0, p2Games = 0;
		for (int i = 0; i < numOfSets; i++) {
			if (results[i].checkResult() == 1)
				p1Games++;
			else if (results[i].checkResult() == 2)
				p2Games++;
			else
				return null;
		}
		int result = Math.abs(p1Games - p2Games);
		if (result == 3) {
			if (p1Games > p2Games)
				return participant1;
			else
				return participant2;
		} else if (result == 1 && (p1Games == 3 || p2Games == 3)) {
			if (p1Games > p2Games)
				return participant1;
			else
				return participant2;
		}
		return null;
	}

}
