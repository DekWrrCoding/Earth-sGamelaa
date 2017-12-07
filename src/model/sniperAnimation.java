package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class sniperAnimation extends atkanimation implements IRenderable {

	public sniperAnimation(Entity e, int frame) {
		super(e, frame);
		this.setfEnd(5);
		//System.out.println("sniper create");
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image img = new Image(this.getSniperAtkAnimation()[0],40,40,false,false);
		//System.out.println("booommmm at "+this.e.posX+" "+this.e.posY);
		gc.drawImage(img,this.e.posX, this.e.posY);
		this.i+=1;
		//System.out.println("sniperattackdraw");
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
}
