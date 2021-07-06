package Model;

public class BasketballGame extends Game {
	final public static int QUARTERS = 4;
	final public static int RESULTS = 7;

	public BasketballGame(Participant firstT, Participant secondT) {
		super(firstT, secondT);
		results = new Result[RESULTS];
	}

	public void setQuarter(int firstTPoints, int secondTPoints) {
		results[counter] = new Result(firstTPoints, secondTPoints);
		if (counter == QUARTERS - 1) {
			counter++;
			results[counter++] = new Result(results[0], results[1]);
			results[counter++] = new Result(results[2], results[3]);
			results[counter] = new Result(results[4], results[5]);
			setWinner(gameResult());
		}
		counter++;
	}

	public Participant gameResult() {
		int result = results[6].checkResult();
		if (result == 1)
			return participant1;
		else if (result == 2)
			return participant2;
		else
			return null;
	}

}
