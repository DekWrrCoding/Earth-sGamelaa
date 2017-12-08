package view;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.EarthGameModel;
import model.IRenderable;
import model.InGameLogic;


public class GameScreen extends Canvas {
	private InGameLogic logic ;

	
	public GameScreen(double width, double height,InGameLogic logic) {
		super(width, height);
		this.setVisible(true);
		this.logic=logic;
	}


	public synchronized void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		for (int i=0 ;i<InGameLogic.listEntities.size();i++) {
			InGameLogic.listEntities.get(i).draw(gc);
		}
		gc.setFill(Color.BLACK);
		gc.fillText("Hp : "+logic.getLife() +"   SP : "+logic.getSP(), 25,50);

	}

}
