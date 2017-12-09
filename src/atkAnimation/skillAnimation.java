package atkAnimation;

import Inteface.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Entity;

public class skillAnimation extends atkanimation implements IRenderable {

	public skillAnimation(Entity e, int frame) {
		super(e, frame);
		this.setfEnd(9);
		
		for(String i : this.skillAtk) {
			Image img = new Image(i,300,300,false,false);
			skillAtkAnimation.add(img);
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(GraphicsContext gc) {
		
		// TODO Auto-generated method stub
		Image img =  skillAtkAnimation.get((i%9));
		gc.drawImage(img,this.e.getPosX()-150, this.e.getPosY()-150);
		this.i+=1;
	}
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed ;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
		// TODO Auto-generated method stub
	
	}
		
		// TODO Auto-generated constructor stub
	
}
