package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class assaultAtkAnimation extends atkanimation implements IRenderable {

	public assaultAtkAnimation(Entity e, int frame) {
		super(e, frame);
		// TODO Auto-generated constructor stub
		this.setfEnd(3);
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image img = new Image(this.getAssaultAtkAnimation()[i%3],60,120,false,false);
	
		gc.drawImage(img,this.e.posX-10, this.e.posY-70);
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
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
