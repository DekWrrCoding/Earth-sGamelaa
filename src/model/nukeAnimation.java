package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class nukeAnimation extends atkanimation {

	public nukeAnimation(Entity e, int frame) {
		super(e, frame);
		this.setfEnd(8);
		//System.out.println("nukeanitmate crate");
		// TODO Auto-generated constructor stub
		for(String i : nukeAtk) {
			Image img = new Image(i,360,360,false,false);
			nukeAtkAnimation.add(img);
		}
	}


	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image img =  this.nukeAtkAnimation.get(i%5);
		//System.out.println(img);

		//System.out.println("booommmm at "+this.e.posX+" "+this.e.posY);
		gc.drawImage(img,(this.e.posX-100)*1.5, (this.e.posY-100)*1.5);
		this.i+=1;
		
		//System.out.println("nukedraw");

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed ;
	}

	@Override
	public boolean isVisible() {
		return isVisible;


	}

}
