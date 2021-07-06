package Model;

public class FootBallGame extends Game {
	final public static int HALFS = 2;
	final public static int RESULTS = 3;

	public FootBallGame(Participant firstT, Participant secondT) {
		super(firstT, secondT);
		results = new Result[RESULTS];
	}

	public void setHalf(int firstTGoals, int secondTGoals) {
		results[counter] = new Result(firstTGoals, secondTGoals);
		if (counter == HALFS - 1) {
			counter++;
			results[counter] = new Result(results[0], results[1]);
			setWinner(gameResult());
		}
		counter++;
	}

	public void setThirdHalf(int firstTGoals, int secondTGoals) {
		Result thirdHalf = new Result(firstTGoals, secondTGoals);
		results[2].addingResult(results[2], thirdHalf);
		setWinner(gameResult());
	}

	public void setPenalty(int firtsTPenalty, int secontTPenalty) {
		setThirdHalf(firtsTPenalty, secontTPenalty);
	}

	public Participant gameResult() {
		if (results[2].checkResult() == 1)
			return participant1;
		else if (results[2].checkResult() == 2)
			return participant2;
		else
			return null;
	}

}
