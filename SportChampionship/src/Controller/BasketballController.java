package Controller;

import Model.BasketballGame;
import Model.Championship;
import View.BasketballView;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BasketballController extends MatchController {

	public BasketballController(BasketballGame m, BasketballView v, Championship model, MainView view,
			int buttonIndex) {
		super(m, v);

		EventHandler<ActionEvent> done = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (isEmpty())
					return;
				for (int i = 0; i < theView.getScore1().length; i++) {
					((BasketballGame) theModel).setQuarter(Integer.parseInt(theView.getScore1()[i].getText()),
							Integer.parseInt(theView.getScore2()[i].getText()));
				}
				if (theModel.getWinner() == null) {
					((BasketballGame) theModel).clear();
					theView.showError();
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

}
