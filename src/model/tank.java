package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class tank extends enemy {
	private int count =0;
	private String[] imgUrl= {"tank1.png","tank2.png","tank3.png","tank4.png"};
	public int frame = 0;
	public Image img;
	public tank(int X, int Y) {
		super(2500, 1, X, Y);
		// TODO Auto-generated constructor stub
		
	}
	public tank(enemy enemy) {
		// TODO Auto-generated constructor stub
		super(enemy.getHp(), enemy.getSpeed(), enemy.getPosX()/40, enemy.getPosY()/40);
	}
	public void draw(GraphicsContext gc) {
		if (getHp()<50) img = new Image(imgUrl[3],40,40,false,false);
		else if (frame%5==0) {
			img = new Image(imgUrl[count],40,40,false,false);
			this.count++;
		}
		frame++;

		gc.drawImage(img, getPosX(), getPosY());
		if (count==3 && getHp()!=0) count=0;
		this.drawHpBar(gc);
	}
}
