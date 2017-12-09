package enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends enemy {
	private int count =0;
	private String[] imgUrl= {"boss1.png","boss2.png","boss3.png"};
	private int frame = 0;
	public Boss(int x,int y) {
		super(100000, 1,x,y);
		// TODO Auto-generated constructor stub
		
		for(String i : imgUrl) {
			Image temp = new Image(i,100*1.5,100*1.5,false,false);
			this.img.add(temp);
		}
	}
	public Boss(enemy enemy) {
		// TODO Auto-generated constructor stub
		super(enemy.getHp(), enemy.getSpeed(), enemy.getPosX()/40, enemy.getPosY()/40);
		this.img = enemy.img;
	}
	public void draw(GraphicsContext gc) {
		if (frame%5==0) {
			this.count++;
		}
		frame++;
		
		gc.drawImage(img.get(count%3), (getPosX()-50)*1.5, (getPosY()-50)*1.5);
		this.drawHpBar(gc);
		
		
	}
}
