package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class troopE extends enemy {
	private int count =0;
	private String[] imgUrl= {"troopE1.png","troopE2.png","troopE3.png","troopE4.png"};
	private int frame = 0;
	public Image img;
	public troopE(int x,int y) {
		super(1000, 4,x,y);
		// TODO Auto-generated constructor stub
	}
	public troopE(enemy enemy) {
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
			//gc.setFill(Color.ANTIQUEWHITE);
			//gc.fillRect(getPosX(), getPosY(), 20, 20);
		
	}

}
