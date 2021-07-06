package Controller;

import Model.Championship;
import Model.TennisGame;
import View.MainView;
import View.TennisView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TennisController extends MatchController {

	public TennisController(TennisGame m, TennisView v, Championship model, MainView view, int buttonIndex) {
		super(m, v);

		EventHandler<ActionEvent> done = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (emptyFields() || fieldsEmpty())
					return;
				for (int i = 0; i < theView.getScore1().length; i++) {
					if (!theView.getScore1()[i].getText().isEmpty() && !theView.getScore2()[i].getText().isEmpty())
						((TennisGame) theModel).setTennisSet(Integer.parseInt(theView.getScore1()[i].getText()),
								Integer.parseInt(theView.getScore2()[i].getText()));
				}
				if (theModel.getWinner() == null) {
					theView.showError();
					((TennisGame) theModel).clear();
					return;
				} else {
					model.addWinner(theModel.getWinner(), buttonIndex);
				}
				update(model, view);
				theView.close();
			}
		};
		theView.getDone().setOnAction(done);
	}

	private boolean emptyFields() {
		for (int i = 0; i < theView.getScore1().length - 2; i++) {
			if (theView.getScore1()[i].getText().isEmpty() || theView.getScore2()[i].getText().isEmpty())
				return true;
		}
		return false;
	}

	private boolean fieldsEmpty() {
		for (int i = 3; i < theView.getScore1().length; i++) {
			if (theView.getScore1()[i].getText().isEmpty() && !theView.getScore2()[i].getText().isEmpty())
				return true;
			if (!theView.getScore1()[i].getText().isEmpty() && theView.getScore2()[i].getText().isEmpty())
				return true;
		}
		return false;
	}

}
