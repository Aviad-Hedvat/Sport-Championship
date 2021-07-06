package Model;

import View.MainView;

public class Championship {
	final public static int MAX_PARTICIPANTS = 8;

	public enum eType {
		Football, Basketball, Tennis
	};

	private eType type;
	private Participant[][] participants;
	private int level, numOfParticipants;

	public Championship() {
		participants = new Participant[4][];
		participants[0] = new Participant[8];
		participants[1] = new Participant[4];
		participants[2] = new Participant[2];
		participants[3] = new Participant[1];
	}

	public void setType(eType t) {
		type = t;
	}

	public eType getType() {
		return type;
	}

	public boolean addParticipant(Participant p) {
		if (numOfParticipants == MAX_PARTICIPANTS)
			return false;
		participants[level][numOfParticipants++] = p;
		if (numOfParticipants == MAX_PARTICIPANTS) {
			level++;
		}
		return true;
	}

	public Participant[][] getParticipants() {
		return participants;
	}

	public int getLevel() {
		return level;
	}

	public boolean isFull() {
		return numOfParticipants == MAX_PARTICIPANTS;
	}

	public boolean finishQuarter() {
		for (int i = 0; i < participants[1].length; i++) {
			if (participants[1][i] == null || level > 1) {
				return false;
			}
		}
		level++;
		return true;
	}

	public boolean finishSemi() {
		for (int i = 0; i < participants[2].length; i++) {
			if (participants[2][i] == null) {
				return false;
			}
		}
		level++;
		return true;
	}

	public boolean finishFinal() {
		if (participants[3][0] == null)
			return false;
		return true;
	}

	public Participant getfirstP(int level, int index) {
		if (level == 0)
			return participants[level][(index * 2)];
		else if (level == 1)
			return participants[level][((index - 4) * 2)];
		else if (level == 2)
			return participants[level][0];
		else
			return null;
	}

	public Participant getSecondP(int level, int index) {
		if (level == 0)
			return participants[level][((index * 2) + 1)];
		else if (level == 1)
			return participants[level][(((index - 4) * 2) + 1)];
		else if (level == 2)
			return participants[level][1];
		else
			return null;
	}

	public boolean addWinner(Participant winner, int index) {
		if (index < 4) {
			participants[level][index] = winner;
			return true;
		} else if (index >= 4 && index <= 5) {
			participants[level][(index - 4)] = winner;
			return true;
		} else if (index == 6) {
			participants[level][0] = winner;
			return true;
		} else
			return false;
	}

	public void update(MainView mv) {
		if (finishQuarter())
			mv.getGSemi().setVisible(true);
		if (finishSemi())
			mv.getGFinal().setVisible(true);
		if (finishFinal())
			mv.setWinnerName(participants[3][0].getName());
	}

}
