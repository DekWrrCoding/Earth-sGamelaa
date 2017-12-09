package atkAnimation;

import Inteface.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import model.Entity;

public class sniperAnimation extends atkanimation implements IRenderable {
	private static AudioClip atkSound = new AudioClip(ClassLoader.getSystemResource("fire.wav").toString());
	public sniperAnimation(Entity e, int frame) {
		super(e, frame);
		this.setfEnd(5);
		for(String i : this.sniperAtk) {
			Image img = new Image(i,40*1.5,40*1.5,false,false);
			sniperAtkAnimation.add(img);
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(GraphicsContext gc) {
		
		// TODO Auto-generated method stub
		Image img =  sniperAtkAnimation.get(0);
		gc.drawImage(img,this.e.getPosX()*1.5, this.e.getPosY()*1.5);
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
