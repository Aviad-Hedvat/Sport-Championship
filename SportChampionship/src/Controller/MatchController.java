package Controller;

import Model.Championship;
import Model.Game;
import View.FootballView;
import View.MainView;
import View.MatchView;
import View.MatchView.eView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public abstract class MatchController {
	protected Game theModel;
	protected MatchView theView;

	public MatchController(Game m, MatchView v) {
		theModel = m;
		theView = v;

		EventHandler<KeyEvent> noInt = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				String nonDigitCharacters = "[\\x20-\\x2f\\x3a-\\x7e]";
				if (event.getCharacter().matches(nonDigitCharacters)) {
					event.consume();
				}
			}
		};
		for (int i = 0; i < theView.getScore1().length; i++) {
			theView.getScore1()[i].setOnKeyTyped(noInt);
			theView.getScore2()[i].setOnKeyTyped(noInt);
			if (theView.getViewType().equals(eView.FootballView)) {
				if (((FootballView) theView).getThirdHalf()[i] != null)
					((FootballView) theView).getThirdHalf()[i].setOnKeyTyped(noInt);
				if (((FootballView) theView).getPenalty()[i] != null)
					((FootballView) theView).getPenalty()[i].setOnKeyTyped(noInt);
			}
		}
	}

	public void update(Championship ch, MainView mv) {
		ch.update(mv);
		mv.update(ch);
	}

	public boolean isEmpty() {
		for (int i = 0; i < theView.getScore1().length; i++) {
			if (theView.getScore1()[i].getText().isEmpty() || theView.getScore2()[i].getText().isEmpty())
				return true;
		}
		return false;
	}

}
