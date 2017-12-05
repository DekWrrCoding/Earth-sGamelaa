package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.EarthGameModel;
import view.EarthGameView;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		EarthGameModel model = new EarthGameModel();
		EarthGameView view = new EarthGameView(model,primaryStage);
		view.drawHome();
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
