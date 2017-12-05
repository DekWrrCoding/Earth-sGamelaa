package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class troopE extends enemy {
	private int count =0;
	private String[] imgUrl= {"troopE1.png","troopE2.png"};
	public troopE(int x,int y) {
		super(1000, 4,x,y);
		// TODO Auto-generated constructor stub
	}
	public troopE(enemy enemy) {
		// TODO Auto-generated constructor stub
		super(enemy.getHp(), enemy.getSpeed(), enemy.getPosX()/40, enemy.getPosY()/40);
	}
	public void draw(GraphicsContext gc) {
		Image img = new Image(imgUrl[count%2]);
		gc.drawImage(img, getPosX(), getPosY());
		this.count++;
		this.drawHpBar(gc);
		if(this.isLocked()) {
			//gc.setFill(Color.ANTIQUEWHITE);
			//gc.fillRect(getPosX(), getPosY(), 20, 20);
		}
	}

}
