package atkAnimation;

import Inteface.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import model.Entity;

public class assaultAtkAnimation extends atkanimation implements IRenderable {
	private static AudioClip atkSound = new AudioClip(ClassLoader.getSystemResource("fire.wav").toString());
	public assaultAtkAnimation(Entity e, int frame) {
		super(e, frame);
		// TODO Auto-generated constructor stub
		this.setfEnd(5);
		for(String i : assaultAtk) {
			Image img = new Image(i,60*1.5,120*1.5,false,false);
			assaultAtkAnimation.add(img);
		}
	}
	@Override
	public void draw(GraphicsContext gc) {
		;
		// TODO Auto-generated method stub
		Image img =  assaultAtkAnimation.get(i%3);
		gc.drawImage(img,(this.e.getPosX()-10)*1.5, (this.e.getPosY()-70)*1.5);
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


	

}
