package atkAnimation;

import Inteface.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import model.Entity;

public class engineerAtkAnimation extends atkanimation implements IRenderable {
	private static AudioClip atkSound = new AudioClip(ClassLoader.getSystemResource("fire.wav").toString());
	public engineerAtkAnimation(Entity e, int frame) {
		super(e, frame);
		// TODO Auto-generated constructor stub
		this.setfEnd(1);
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
		gc.drawImage(img,this.e.getPosX()*1.5-30, this.e.getPosY()*1.5-30);
		this.i+=1;

	}

}
