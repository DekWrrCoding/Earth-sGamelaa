package model;

import Inteface.IRenderable;

public abstract class Entity implements IRenderable{
	protected double posX;
	protected double posY;
	protected boolean isVisible =true;
	protected boolean isDestroyed =false;
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double d) {
		this.posX = d;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setPosX(int x) {
		// TODO Auto-generated method stub
		
	}

}
