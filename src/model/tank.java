package model;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class tank extends enemy {
	private int count =0;
	private String[] imgUrl= {"tank1.png","tank2.png","tank3.png","tank4.png"};
	public int frame = 0;

	public tank(int X, int Y) {
		super(2500, 1, X, Y);
		// TODO Auto-generated constructor stub
	
		for(String i : imgUrl) {
			Image temp = new Image(i,60*1.5,80*1.5,false,false);
			this.img.add(temp);
		}
	}
	public tank(enemy enemy) {
		// TODO Auto-generated constructor stub
		super(enemy.getHp(), enemy.getSpeed(), enemy.getPosX()/40, enemy.getPosY()/40);
		this.img = enemy.img;
	}
	public void draw(GraphicsContext gc) {
	
		if (frame%5==0) {
			this.count++;
		}
		frame++;

		gc.drawImage(img.get(count%5), (getPosX()-30)*1.5, (getPosY()-40)*1.5);
		if (count==3 && getHp()!=0) count=0;
		this.drawHpBar(gc);
	}
}
