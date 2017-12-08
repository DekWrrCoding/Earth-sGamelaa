package model;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class troopE extends enemy {
	private int count =0;
	private String[] imgUrl= {"troopE1.png","troopE2.png","troopE3.png","troopE4.png"};
	private int frame = 0;
	public troopE(int x,int y) {
		super(1000, 4,x,y);
		// TODO Auto-generated constructor stub
		
		for(String i : imgUrl) {
			Image temp = new Image(i,50*1.5,50*1.5,false,false);
			this.img.add(temp);
		}
	}
	public troopE(enemy enemy) {
		// TODO Auto-generated constructor stub
		super(enemy.getHp(), enemy.getSpeed(), enemy.getPosX()/40, enemy.getPosY()/40);
		this.img = enemy.img;
	}
	public void draw(GraphicsContext gc) {
		if (frame%5==0) {
			this.count++;
		}
		frame++;
		
		gc.drawImage(img.get(count%5), getPosX()*1.5, getPosY()*1.5);
		if (count==3 && getHp()!=0) count=0;
		this.drawHpBar(gc);
		
	}

}
