package atkAnimation;

import java.util.ArrayList;
import java.util.List;

import Inteface.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Entity;

public class atkanimation extends Entity implements IRenderable {
	private int fStart;
	private  int fEnd = 10;
	protected Entity e ;
	public int i =0;
	protected static String[] nukeAtk = {"nuke1.png","nuke2.png","nuke3.png","nuke4.png","nuke5.png",};
	protected static String[] sniperAtk= {"sniperAtk.png"};
	protected static String[] engineerAtk = {"engineer.png"};
	protected static String[] assaultAtk = {"sword1.png","sword1.png","sword2.png","sword2.png","sword3.png","sword3.png"};
	protected static String[] skillAtk = {"skill/1.png","skill/2.png","skill/3.png","skill/4.png","skill/5.png","skill/6.png","skill/7.png","skill/8.png","skill/9.png"};
	public  List<Image> nukeAtkAnimation,sniperAtkAnimation,engineerAtkAnimation,assaultAtkAnimation,skillAtkAnimation;
	
	public atkanimation(Entity e,int frame) {
		super();
		this.e = e;
		this.fStart = frame;
		this.setVisible(true);
		this.setDestroyed(false);
		nukeAtkAnimation = new ArrayList<>();
		sniperAtkAnimation = new ArrayList<>();
		assaultAtkAnimation = new ArrayList<>();
		engineerAtkAnimation = new ArrayList<>();
		skillAtkAnimation = new ArrayList<>();
		
		}
	
	public void setfEnd(int fEnd) {
		this.fEnd = fEnd;
	}
	public int getfStart() {
		return fStart;
	}

	public int getfEnd() {
		return fEnd;
	}

	public Entity getE() {
		return e;
	}

	public int getI() {
		return i;
	}

	

	public void update(int frame) {
		if(frame-this.fStart >= fEnd) {
			this.setVisible(false);
			this.setDestroyed(true);
		}
	}



	

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return this.isDestroyed;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return this.isVisible;
	}

	@Override
	public void draw(GraphicsContext gc) {

		
	}

}
