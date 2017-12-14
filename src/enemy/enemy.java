package enemy;

import java.util.ArrayList;
import java.util.List;

import Inteface.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Entity;

public  class Enemy extends Entity implements IRenderable {
	private int hp;
	private int speed;
	protected int maxHp;
	private boolean isLocked = false;
	protected List<Image> img;

	public Enemy(int hp, int speed,double d,double e) {
		super();
		this.hp = hp;
		this.maxHp = hp;
		this.speed = speed;
		this.posX = d*40;
		this.posY = e*40 ;
		this.img = new ArrayList<>();
	}
	public Enemy(Enemy Enemy) {
		// TODO Auto-generated constructor stub
		this.hp = Enemy.hp;
		this.maxHp = Enemy.hp;
		this.speed = Enemy.speed;
		this.posX = Enemy.posX;
		this.posY = Enemy.posY ;
		this.img = Enemy.img;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setIsLocked(boolean x) {
		this.isLocked = x;
	}
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}



	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.MEDIUMSEAGREEN);
		gc.fillRect(this.posX, this.posY, 30, 30);
		gc.setFill(Color.PAPAYAWHIP);
		gc.fillText(""+this.getHp(), this.posX, this.posY);
	}
	public void updatePos(int[] pos) {
		this.posX += this.speed*pos[0];
		this.posY += this.speed*pos[1];
		//System.out.println(posX+" "+posY);
	}
	public boolean isReached() {
		if(this.posX >=640 || this.posY >=480  )return true;
		else return false;
	}
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return this.isDestroyed;
	}
	public void drawHpBar(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		gc.strokeRect(posX*1.5, posY*1.5, 40*1.5, 5*1.5);
		if(this.isLocked)gc.setFill(Color.GREY);
		else gc.setFill(Color.CRIMSON);
		gc.fillRect(posX*1.5, posY*1.5,((double)(this.getHp())/(double)this.maxHp)*60, 5*1.5);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return this.isVisible;
	}

	public boolean takeDamage(int attack) {
		// TODO Auto-generated method stub
		this.hp-=attack;
		if(this.hp<=0) {
			this.setDestroyed(true);
			return true;
		}
		return false;
	}

}
