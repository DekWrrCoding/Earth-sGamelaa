package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class tank extends enemy {
	private int count =0;
	private String[] imgUrl= {"tank1.png","tank2.png"};

	public tank(int X, int Y) {
		super(2500, 1, X, Y);
		// TODO Auto-generated constructor stub
		
	}
	public tank(enemy enemy) {
		// TODO Auto-generated constructor stub
		super(enemy.getHp(), enemy.getSpeed(), enemy.getPosX()/40, enemy.getPosY()/40);
	}
	public void draw(GraphicsContext gc) {
		Image img = new Image(imgUrl[count%2]);
		gc.drawImage(img, getPosX(), getPosY());
		this.count++;
		this.drawHpBar(gc);
	}
}
