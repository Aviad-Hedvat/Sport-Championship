import Controller.MainController;
import Model.Championship;
import View.MainView;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Championship theModel=new Championship();
//		View theView = new View();
		MainView theView=new MainView(primaryStage);
		MainController theController=new MainController(theModel, theView);
		
	}

}
