package View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class MatchView {
	public enum eView {
		FootballView, BasketballView, TennisView
	};

	protected Group root;
	protected Stage stage;
	protected Label title, participant1, participant2;
	protected TextField[] score1, score2;
	protected Scene scene;
	protected Button done;
	protected int s1, s2;
	protected eView viewType;

	public MatchView() {
		stage = new Stage();
		root = new Group();
		title = new Label();
		title.setFont(new Font(30));
		title.setLayoutX(90);
		title.setLayoutY(45);
		done = new Button("Done");
		done.setLayoutX(180);
		done.setLayoutY(350);
		root.getChildren().add(done);
		scene = new Scene(root, 400, 400);
		stage.setScene(scene);
	}

	public Button getDone() {
		return done;
	}

	public TextField[] getScore1() {
		return score1;
	}

	public int getS1() {
		return s1++;
	}

	public TextField[] getScore2() {
		return score2;
	}

	public int getS2() {
		return s2++;
	}

	public void close() {
		stage.close();
	}

	public void setTFLayoutXY(TextField tf, int x, int y) {
		tf.setLayoutX(x);
		tf.setLayoutY(y);
	}

	public void showError() {
		Alert error = new Alert(AlertType.ERROR, "Invalid Result! Type Again.");
		error.show();
	}

	public String getViewType() {
		return viewType.name();
	}

}
