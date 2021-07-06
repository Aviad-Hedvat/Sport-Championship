package View;

import Model.Championship;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.InnerShadow;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainView {
	private Group root, gStart, gQuarter, gSemi, gFinal;
	private RadioButton rbFootball, rbBasketball, rbTennis;
	private TextField tf;
	private Button addParticipant, start, play;
	private Button[] games, games1;
	private Text title, winner;
	private Label[][] participants;
	private Label l1;
	private Polyline[] polys, polys1, polys2;
	private ToggleGroup tg;

	public MainView(Stage stage) {
		root = new Group();
		gStart = new Group();
		gQuarter = new Group();
		gSemi = new Group();
		gFinal = new Group();
		title = new Text("Championship");
		setTextXYF(title, 350, 75);

		l1 = new Label("Participant Name:");
		setLabelLayoutXY(l1, 300, 250);

		tf = new TextField();
		tf.setLayoutX(450);
		tf.setLayoutY(250);

		addParticipant = new Button("Add Participant");
		setButtonLayoutXY(addParticipant, 300, 350);
		start = new Button("Start Championship");
		setButtonLayoutXY(start, 450, 350);
		start.setDisable(true);

		tg = new ToggleGroup();
		rbFootball = new RadioButton("Football");
		setRadioButtonLayoutXY(rbFootball, 800, 250);
		rbFootball.setToggleGroup(tg);
		rbBasketball = new RadioButton("Basketball");
		setRadioButtonLayoutXY(rbBasketball, 800, 290);
		rbBasketball.setToggleGroup(tg);
		rbTennis = new RadioButton("Tennis");
		setRadioButtonLayoutXY(rbTennis, 800, 330);
		rbTennis.setToggleGroup(tg);

		participants = new Label[4][];
		participants[0] = new Label[8];
		participants[1] = new Label[4];
		participants[2] = new Label[2];
		participants[3] = new Label[1];

		for (int i = 0; i < participants[0].length; i++) {
			participants[0][i] = new Label("Participant " + (i + 1));
			setSafe(participants[0][i], 18);
			setLabelLayoutXY(participants[0][i], 55, (150 + (i * 50)));
			participants[0][i].setPrefWidth(100);
			root.getChildren().add(participants[0][i]);
			participants[0][i].setVisible(false);
		}

		polys = new Polyline[8];
		for (int i = 0; i < polys.length; i += 2) {
			polys[i] = new Polyline(-40, -50, -10, -50, -10, -25, 100, -25);
			setPolylineLayoutXY(polys[i], 200, (215 + (i * 50)));
			polys[i + 1] = new Polyline(-40, -50, -10, -50, -10, -75, 100, -75);
			setPolylineLayoutXY(polys[i + 1], 200, (215 + ((i + 1) * 50)));
			gQuarter.getChildren().addAll(polys[i], polys[i + 1]);
		}

		games = new Button[4];
		for (int i = 0; i < games.length; i++) {
			games[i] = new Button("Play a Game");
			setButtonLayoutXY(games[i], 175, (175 + (i * 100)));
			games[i].setId(i + "");
			participants[1][i] = new Label("Quarter " + (i + 1));
			setSafe(participants[1][i], 18);
			setLabelLayoutXY(participants[1][i], 300, (175 + (i * 100)));
			participants[1][i].setPrefWidth(100);
			gQuarter.getChildren().add(games[i]);
			root.getChildren().add(participants[1][i]);
			participants[1][i].setVisible(false);
		}

		polys1 = new Polyline[4];
		for (int i = 0; i < polys1.length; i += 2) {
			polys1[i] = new Polyline(-20, -50, 10, -50, 10, 0, 100, 0);
			setPolylineLayoutXY(polys1[i], 420, (240 + (i * 100)));
			polys1[i + 1] = new Polyline(-20, -50, 10, -50, 10, -100, 100, -100);
			setPolylineLayoutXY(polys1[i + 1], 420, (240 + ((i + 1) * 100)));
			gSemi.getChildren().addAll(polys1[i], polys1[i + 1]);
		}

		games1 = new Button[2];
		games1[0] = new Button("Play a Game");
		games1[0].setId("4");
		setButtonLayoutXY(games1[0], 395, 225);
		games1[1] = new Button("Play a Game");
		games1[1].setId("5");
		setButtonLayoutXY(games1[1], 395, 425);
		gSemi.getChildren().addAll(games1[0], games1[1]);

		participants[2][0] = new Label("Semi 1");
		participants[2][1] = new Label("Semi 2");
		setLabelLayoutXY(participants[2][0], 520, 225);
		setLabelLayoutXY(participants[2][1], 520, 425);
		setSafe(participants[2][0], 18);
		setSafe(participants[2][1], 18);
		participants[2][0].setPrefWidth(100);
		participants[2][1].setPrefWidth(100);
		participants[2][0].setVisible(false);
		participants[2][1].setVisible(false);

		polys2 = new Polyline[2];
		polys2[0] = new Polyline(5, -50, 30, -50, 30, 50, 100, 50);
		setPolylineLayoutXY(polys2[0], 615, 290);
		polys2[1] = new Polyline(5, -50, 30, -50, 30, -150, 100, -150);
		setPolylineLayoutXY(polys2[1], 615, 490);

		play = new Button("Play a Game");
		setButtonLayoutXY(play, 590, 325);
		play.setId("6");

		winner = new Text();
		setTextXYF(winner, 150, 75);

		participants[3][0] = new Label("Winner");
		setSafe(participants[3][0], 18);
		participants[3][0].setPrefWidth(100);
		setLabelLayoutXY(participants[3][0], 715, 325);
		participants[3][0].setVisible(false);

		gQuarter.setVisible(false);
		gSemi.setVisible(false);
		gFinal.getChildren().addAll(polys2[0], polys2[1], play, winner);
		gFinal.setVisible(false);
		gStart.getChildren().addAll(title, l1, tf, addParticipant, start, rbFootball, rbBasketball, rbTennis);
		root.getChildren().addAll(participants[2][0], participants[2][1], participants[3][0], gFinal, gSemi, gQuarter,
				gStart);
		Scene scene = new Scene(root, 1000, 600);
		stage.setScene(scene);
		stage.show();

	}

	public void addToggleType(ChangeListener<Toggle> listner) {
		tg.selectedToggleProperty().addListener(listner);
	}

	public Button getAddParticipant() {
		return addParticipant;
	}

	public TextField getTextField() {
		return tf;
	}

	public Group getGStart() {
		return gStart;
	}

	public Group getGQuarter() {
		return gQuarter;
	}

	public Group getGSemi() {
		return gSemi;
	}

	public Group getGFinal() {
		return gFinal;
	}

	public void update(Championship ch) {
		for (int i = 0; i < ch.getParticipants().length; i++) {
			for (int j = 0; j < ch.getParticipants()[i].length; j++) {
				if (ch.getParticipants()[i][j] != null) {
					participants[i][j].setText(ch.getParticipants()[i][j].getName());
					participants[i][j].setVisible(true);
				}
			}
		}
	}

	public void setWinnerName(String winnerName) {
		winner.setText("Championship winner is: " + winnerName);
	}

	public Button getStartButton() {
		return start;
	}

	public Button getPlayButton() {
		return play;
	}

	public Polyline[] getPolys() {
		return polys;
	}

	public Button[] getGames() {
		return games;
	}

	public Button[] getGames1() {
		return games1;
	}

	public Label getL1() {
		return l1;
	}

	public RadioButton getFootballButton() {
		return rbFootball;
	}

	public RadioButton getBasketballButton() {
		return rbBasketball;
	}

	public RadioButton getTennisButton() {
		return rbTennis;
	}

	public void setSafe(Label l, int fontSize) {
		l.setStyle("-fx-background-color: white");
		l.setAlignment(Pos.CENTER);
		l.setFont(new Font(fontSize));
		l.setEffect(new InnerShadow());
	}

	public void setLabelLayoutXY(Label l, int x, int y) {
		l.setLayoutX(x);
		l.setLayoutY(y);
	}

	public void setButtonLayoutXY(Button b, int x, int y) {
		b.setLayoutX(x);
		b.setLayoutY(y);
	}

	public void setPolylineLayoutXY(Polyline p, int x, int y) {
		p.setLayoutX(x);
		p.setLayoutY(y);
	}

	public void setRadioButtonLayoutXY(RadioButton rb, int x, int y) {
		rb.setLayoutX(x);
		rb.setLayoutY(y);
	}

	public void setTextXYF(Text t, int x, int y) {
		t.setFont(new Font(48));
		t.setLayoutX(x);
		t.setLayoutY(y);
	}

}
