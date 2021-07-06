package View;

import Model.BasketballGame;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BasketballView extends MatchView {

	public BasketballView(String name1, String name2) {
		super();
		viewType = eView.BasketballView;
		title.setText("Basketball Game");
		participant1 = new Label(name1);
		participant1.setLayoutX(20);
		participant1.setLayoutY(150);
		participant2 = new Label(name2);
		participant2.setLayoutX(20);
		participant2.setLayoutY(250);
		score1 = new TextField[BasketballGame.QUARTERS];
		score2 = new TextField[BasketballGame.QUARTERS];
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
