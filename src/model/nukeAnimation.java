package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class nukeAnimation extends atkanimation {

	public nukeAnimation(Entity e, int frame) {
		super(e, frame);
		this.setfEnd(5);
		//System.out.println("nukeanitmate crate");
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
<<<<<<< HEAD:src/model/nukeAnimetion.java
		//System.out.println("booommmm at "+this.e.posX+" "+this.e.posY);
		gc.drawImage(img,this.e.posX-100, this.e.posY-100);
||||||| merged common ancestors
		System.out.println("booommmm at "+this.e.posX+" "+this.e.posY);
		gc.drawImage(img,this.e.posX-100, this.e.posY-100);
=======
		System.out.println("booommmm at "+this.e.posX+" "+this.e.posY);
		gc.drawImage(img,this.e.posX, this.e.posY);
>>>>>>> 85ca3d6353df3e3a966db28a6bf3a15b6441e3e7:src/model/nukeAnimation.java
		this.i+=1;
		System.out.println("nukedraw");

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
<<<<<<< HEAD:src/model/nukeAnimetion.java
	
||||||| merged common ancestors
		return false;
=======
		return true;
>>>>>>> 85ca3d6353df3e3a966db28a6bf3a15b6441e3e7:src/model/nukeAnimation.java
	}

}
