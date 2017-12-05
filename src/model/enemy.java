package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public  class enemy extends Entity implements IRenderable {
	private int hp;
	private int speed;
	protected int maxHp;
	private String direction;
	private boolean isLocked = false;

	public enemy(int hp, int speed,int X,int Y) {
		super();
		this.hp = hp;
		this.maxHp = hp;
		this.speed = speed;
		this.posX = X*40;
		this.posY = Y*40 ;
		this.direction = "d";
	}
	public enemy(enemy enemy) {
		// TODO Auto-generated constructor stub
		this.hp = enemy.hp;
		this.maxHp = enemy.hp;
		this.speed = enemy.speed;
		this.posX = enemy.posX;
		this.posY = enemy.posY ;
		//return this;
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
	public String getDirection() {
		return this.direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
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
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
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
		gc.strokeRect(posX, posY, 40, 5);
		if(this.isLocked)gc.setFill(Color.GREY);
		else gc.setFill(Color.CRIMSON);
		
		//System.out.println();
		gc.fillRect(posX, posY,((double)(this.getHp())/(double)this.maxHp)*40, 5);
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
