package View;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TennisView extends MatchView {
	final public static int SETS = 5;

	public TennisView(String name1, String name2) {
		super();
		viewType = eView.TennisView;
		title.setText("Tennis Game");
		participant1 = new Label(name1);
		participant1.setLayoutX(20);
		participant1.setLayoutY(150);
		participant2 = new Label(name2);
		participant2.setLayoutX(20);
		participant2.setLayoutY(250);
		score1 = new TextField[TennisView.SETS];
		score2 = new TextField[TennisView.SETS];
		for (int i = 0; i < score1.length; i++) {
			score1[i] = new TextField();
			score1[i].setPrefWidth(40);
			score1[i].setPrefHeight(25);
			score1[i].setLayoutX(110 + (i * 50));
			score1[i].setLayoutY(150);
			score2[i] = new TextField();
			score2[i].setPrefWidth(40);
			score2[i].setPrefHeight(25);
			score2[i].setLayoutX(110 + (i * 50));
			score2[i].setLayoutY(250);
			root.getChildren().addAll(score1[i], score2[i]);
		}

		root.getChildren().addAll(title, participant1, participant2);
		stage.show();

	}

}
