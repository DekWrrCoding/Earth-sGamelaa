package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class engineerAtkAnimation extends atkanimation implements IRenderable {

	public engineerAtkAnimation(Entity e, int frame) {
		super(e, frame);
		// TODO Auto-generated constructor stub
		this.setfEnd(10);
		for(String i : engineerAtk) {
			Image img = new Image(i,60*1.5,120*1.5,false,false);
			engineerAtkAnimation.add(img);
		}
	}


	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image img = engineerAtkAnimation.get(0);
		//System.out.println(img);
		gc.drawImage(img,this.e.posX*1.5, this.e.posY*1.5);
		this.i+=1;

	}

}
