package View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class View {
	final public static int CURRENT_YEAR = 2020;
	private ComboBox<Integer> startMonths, startYears;
	private ComboBox<Integer> finalMonths, finalYears;
	private CheckBox participants;
	private Stage stage;
	private Group root;

	public View() {
		startMonths = new ComboBox<Integer>();
		startYears = new ComboBox<Integer>();
		finalMonths = new ComboBox<Integer>();
		finalYears = new ComboBox<Integer>();
		for (int i = 1; i < 13; i++) {
			startMonths.getItems().add(i);
			finalMonths.getItems().add(i);
		}
		for (int i = CURRENT_YEAR; i >= 1900; i--) {
			startYears.getItems().add(i);
			finalYears.getItems().add(i);
		}
		setComboBox(startMonths, 80, 100, 50);
		setComboBox(startYears, 120, 200, 50);
		setComboBox(finalMonths, 80, 100, 150);
		setComboBox(finalYears, 120, 200, 150);
		participants = new CheckBox("Aviad");
		participants.setLayoutX(100);
		participants.setLayoutY(250);
		
		
		root = new Group();
		root.getChildren().addAll(startMonths, startYears, finalMonths, finalYears, participants);
		participants.setText("Liel");
		Scene scene = new Scene(root, 500, 500);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

	public void setComboBox(ComboBox<Integer> cmb, int w, int x, int y) {
		cmb.setPrefWidth(w);
		cmb.setLayoutX(x);
		cmb.setLayoutY(y);
		cmb.getSelectionModel().selectFirst();
	}
	
	public boolean isPossible() {
		if (startYears.getValue() > finalYears.getValue())
			return false;
		else if (startYears.getValue() == finalYears.getValue()) {
			if (startMonths.getValue() > finalMonths.getValue())
				return false;
			else
				return true;
		}
		return true;
	}
	

}
