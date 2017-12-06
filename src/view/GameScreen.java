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
	private int frame = 0;
	
	public GameScreen(double width, double height,InGameLogic logic) {
		super(width, height);
		this.setVisible(true);
		addListerner();
		this.logic=logic;
	}







	public void addListerner() {
	}

	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		for (IRenderable entity : InGameLogic.listEntities) {
			// System.out.println(InGameLogic.listEntities.size());
		//if (entity.isVisible() && !entity.isDestroyed()) {
			    entity.draw(gc);
			//}
		}
		//if(logic.getLife()==0)gc.fillText("Hp : 0", 25,50);
		gc.setFill(Color.BLACK);
		gc.fillText("Hp : "+logic.getLife() +"   SP : "+logic.getSP(), 25,50);
		

		// System.out.println("===============");
		// System.out.println("===============");
		frame++;
	}

}
