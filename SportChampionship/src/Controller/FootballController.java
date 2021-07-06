package Controller;

import Model.Championship;
import Model.FootBallGame;
import View.FootballView;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FootballController extends MatchController {
	private boolean thirdHalf, penalty;

	public FootballController(FootBallGame m, FootballView v, Championship model, MainView view, int buttonIndex) {
		super(m, v);
		thirdHalf = false;
		penalty = false;

		EventHandler<ActionEvent> done = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (isEmpty())
					return;
				for (int i = 0; i < theView.getScore1().length; i++) {
					if (theView.getScore1()[i].getText().isEmpty() || theView.getScore2()[i].getText().isEmpty())
						return;
				}
				for (int i = 0; i < theView.getScore1().length; i++) {
					((FootBallGame) theModel).setHalf(Integer.parseInt(theView.getScore1()[i].getText()),
							Integer.parseInt(theView.getScore2()[i].getText()));
				}
				if (theModel.getWinner() != null) {
					model.addWinner(theModel.getWinner(), buttonIndex);
					update(model, view);
				} else {
					((FootballView) theView).thirdHalf();
					if (!thirdHalf) {
						thirdHalf = true;
						((FootBallGame) theModel).clear();
						return;
					}
					for (int i = 0; i < ((FootballView) theView).getThirdHalf().length; i++) {
						if (((FootballView) theView).getThirdHalf()[i].getText().isEmpty()) {
							((FootBallGame) theModel).clear();
							return;
						}
					}
					((FootBallGame) theModel).setThirdHalf(
							Integer.parseInt(((FootballView) theView).getThirdHalf()[0].getText()),
							Integer.parseInt(((FootballView) theView).getThirdHalf()[1].getText()));
					if (theModel.getWinner() != null) {
						model.addWinner(theModel.getWinner(), buttonIndex);
						update(model, view);
					} else {
						((FootballView) theView).penalty();
						if (!penalty) {
							penalty = true;
							((FootBallGame) theModel).clear();
							return;
						}
						for (int i = 0; i < ((FootballView) theView).getPenalty().length; i++) {
							if (((FootballView) theView).getPenalty()[i].getText().isEmpty()) {
								((FootBallGame) theModel).clear();
								return;
							}
						}
						((FootBallGame) theModel).setPenalty(
								Integer.parseInt(((FootballView) theView).getPenalty()[0].getText()),
								Integer.parseInt(((FootballView) theView).getPenalty()[1].getText()));
						if (theModel.getWinner() == null) {
							((FootBallGame) theModel).clear();
							theView.showError();
							return;
						}
						model.addWinner(theModel.getWinner(), buttonIndex);
						update(model, view);
					}
				}
				theView.close();
			}
		};
		theView.getDone().setOnAction(done);

	}

}
