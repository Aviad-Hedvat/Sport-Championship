package Model;

public class Result {
	private int firstTeamPoints, secondTeamPoints;

	public Result(int firstPoints, int secondPoints) {
		firstTeamPoints = firstPoints;
		secondTeamPoints = secondPoints;
	}

	public Result(Result first, Result second) {
		addingResult(first, second);
	}

	public void addingResult(Result first, Result second) {
		firstTeamPoints = first.firstTeamPoints + second.firstTeamPoints;
		secondTeamPoints = first.secondTeamPoints + second.secondTeamPoints;
	}

	public int checkResult() {
		if (firstTeamPoints > secondTeamPoints)
			return 1;
		if (secondTeamPoints > firstTeamPoints)
			return 2;
		else
			return 0;
	}
}
