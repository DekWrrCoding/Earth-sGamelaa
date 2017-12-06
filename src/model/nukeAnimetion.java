package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class nukeAnimetion extends atkanimation {

	public nukeAnimetion(Entity e, int frame) {
		super(e, frame);
		System.out.println("nukeanitmate crate");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image img = new Image(this.getNukeAtkAnimation()[i%5]);
		System.out.println("booommmm at "+this.e.posX+" "+this.e.posY);
		gc.drawImage(img,this.e.posX-100, this.e.posY-100);
		this.i+=1;
		System.out.println("nukedraw");

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
