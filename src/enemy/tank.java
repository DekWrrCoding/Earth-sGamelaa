package enemy;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank extends Enemy {
	private int count =0;
	private String[] imgUrl= {"tank1.png","tank2.png","tank3.png","tank4.png"};
	public int frame = 0;

	public Tank(int X, int Y) {
		super(2500, 1, X, Y);
		// TODO Auto-generated constructor stub
	
		for(String i : imgUrl) {
			Image temp = new Image(i,60*1.5,80*1.5,false,false);
			this.img.add(temp);
		}
	}
	public Tank(Enemy Enemy) {
		// TODO Auto-generated constructor stub
		super(Enemy.getHp(), Enemy.getSpeed(), Enemy.getPosX()/40, Enemy.getPosY()/40);
		this.img = Enemy.img;
	}
	public void draw(GraphicsContext gc) {
	
		if (frame%5==0) {
			this.count++;
		}
		frame++;

		gc.drawImage(img.get(count%5), (getPosX()-30+20)*1.5, (getPosY()-40+20)*1.5);
		if (count==3 && getHp()!=0) count=0;
		this.drawHpBar(gc);
	}
}
