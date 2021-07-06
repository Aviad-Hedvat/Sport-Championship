package View;

import Model.FootBallGame;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class FootballView extends MatchView {
	private TextField[] thirdHalf, penalty;
	private Label th, pen;

	public FootballView(String name1, String name2) {
		super();
		viewType = eView.FootballView;
		title.setText("Football Game");
		participant1 = new Label(name1);
		participant1.setLayoutX(20);
		participant1.setLayoutY(150);
		participant2 = new Label(name2);
		participant2.setLayoutX(20);
		participant2.setLayoutY(250);
		score1 = new TextField[FootBallGame.HALFS];
		score2 = new TextField[FootBallGame.HALFS];
		for (int i = 0; i < score1.length; i++) {
			score1[i] = new TextField();
			score1[i].setPrefWidth(40);
			score1[i].setPrefHeight(25);
			setTFLayoutXY(score1[i], (110 + (i * 50)), 150);
			score2[i] = new TextField();
			score2[i].setPrefWidth(40);
			score2[i].setPrefHeight(25);
			setTFLayoutXY(score2[i], (110 + (i * 50)), 250);
			root.getChildren().addAll(score1[i], score2[i]);
		}
		thirdHalf = new TextField[2];
		thirdHalf[0] = new TextField();
		thirdHalf[1] = new TextField();
		thirdHalf[0].setPrefWidth(40);
		thirdHalf[1].setPrefWidth(40);
		thirdHalf[0].setPrefHeight(25);
		thirdHalf[1].setPrefHeight(25);
		setTFLayoutXY(thirdHalf[0], 210, 150);
		setTFLayoutXY(thirdHalf[1], 210, 250);
		thirdHalf[0].setVisible(false);
		thirdHalf[1].setVisible(false);

		penalty = new TextField[2];
		penalty[0] = new TextField();
		penalty[1] = new TextField();
		penalty[0].setPrefWidth(40);
		penalty[1].setPrefWidth(40);
		penalty[0].setPrefHeight(25);
		penalty[1].setPrefHeight(25);
		setTFLayoutXY(penalty[0], 260, 150);
		setTFLayoutXY(penalty[1], 260, 250);
		penalty[0].setVisible(false);
		penalty[1].setVisible(false);

		th = new Label("Tie - Third Half");
		th.setFont(new Font(18));
		th.setLayoutX(125);
		th.setLayoutY(100);
		th.setVisible(false);

		pen = new Label("Tie - Penalty Time");
		pen.setFont(new Font(18));
		pen.setLayoutX(125);
		pen.setLayoutY(100);
		pen.setVisible(false);

		root.getChildren().addAll(title, participant1, participant2, thirdHalf[0], thirdHalf[1], penalty[0], penalty[1],
				th, pen);
		stage.show();
	}

	public Label getParticipant1() {
		return participant1;
	}

	public Label getParticipant2() {
		return participant2;
	}

	public void thirdHalf() {
		th.setVisible(true);
		thirdHalf[0].setVisible(true);
		thirdHalf[1].setVisible(true);
	}

	public TextField[] getThirdHalf() {
		return thirdHalf;
	}

	public void penalty() {
		th.setVisible(false);
		pen.setVisible(true);
		penalty[0].setVisible(true);
		penalty[1].setVisible(true);
	}

	public TextField[] getPenalty() {
		return penalty;
	}

}
