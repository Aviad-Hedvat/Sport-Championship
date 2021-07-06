package Controller;

import Model.BasketballGame;
import Model.Championship;
import Model.FootBallGame;
import Model.Participant;
import Model.TennisGame;
import View.BasketballView;
import View.FootballView;
import View.MainView;
import View.TennisView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;

public class MainController {
	private String type;
	private Championship theModel;
	private MainView theView;

	public MainController(Championship m, MainView v) {
		theModel = m;
		theView = v;

		ChangeListener<Toggle> clSport = new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				theModel.setType(Championship.eType.valueOf(((RadioButton) newValue).getText()));
				type = theModel.getType().name();
				if (theModel.isFull())
					theView.getStartButton().setDisable(false);
			}
		};
		theView.addToggleType(clSport);

		EventHandler<ActionEvent> addParticipant = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theModel.addParticipant(new Participant(theView.getTextField().getText()));
				theView.update(theModel);
				if (theModel.isFull()) {
					((Button) event.getSource()).setVisible(false);
					if (theModel.getType() != null)
						theView.getStartButton().setDisable(false);
				}
			}
		};
		theView.getAddParticipant().setOnAction(addParticipant);

		EventHandler<ActionEvent> startChampionship = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.getGQuarter().setVisible(true);
				theView.getGStart().setVisible(false);
			}
		};
		theView.getStartButton().setOnAction(startChampionship);

		EventHandler<ActionEvent> playGame = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				((Button) event.getSource()).setDisable(true);
				String buttonId = ((Button) event.getSource()).getId();
				int id = Integer.parseInt(buttonId), level = theModel.getLevel() - 1;
				if (type.equals(Championship.eType.Football.name())) {
					FootBallGame fg = new FootBallGame(theModel.getfirstP(level, id), theModel.getSecondP(level, id));
					FootballView fv = new FootballView(theModel.getfirstP(level, id).getName(),
							theModel.getSecondP(level, id).getName());
					FootballController fc = new FootballController(fg, fv, theModel, theView, id);
				} else if (type.equals(Championship.eType.Basketball.name())) {
					BasketballGame bg = new BasketballGame(theModel.getfirstP(level, id),
							theModel.getSecondP(level, id));
					BasketballView bv = new BasketballView(theModel.getfirstP(level, id).getName(),
							theModel.getSecondP(level, id).getName());
					BasketballController bc = new BasketballController(bg, bv, theModel, theView, id);
				} else if (type.equals(Championship.eType.Tennis.name())) {
					TennisGame tg = new TennisGame(theModel.getfirstP(level, id), theModel.getSecondP(level, id));
					TennisView tv = new TennisView(theModel.getfirstP(level, id).getName(),
							theModel.getSecondP(level, id).getName());
					TennisController tc = new TennisController(tg, tv, theModel, theView, id);
				}

			}
		};
		for (int i = 0; i < theView.getGames().length; i++)
			theView.getGames()[i].setOnAction(playGame);
		for (int i = 0; i < theView.getGames1().length; i++)
			theView.getGames1()[i].setOnAction(playGame);
		theView.getPlayButton().setOnAction(playGame);
	}

}
