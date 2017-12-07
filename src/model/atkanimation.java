package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class atkanimation extends Entity implements IRenderable {
	private int fStart;
	private  int fEnd = 10;
	protected Entity e ;
	public int i =0;
	protected String[] nukeAtkAnimation = {"nuke1.png","nuke2.png","nuke3.png","nuke4.png","nuke5.png",};
	private String[] sniperAtkAnimation = {"sniperAtk.png"};
	private String[] engineerAtkAnimation = {};
	private String[] assaultAtkAnimation = {"sword1.png","sword1.png","sword2.png","sword2.png","sword3.png","sword3.png"};
	public atkanimation(Entity e,int frame) {
		super();
		this.e = e;
		this.fStart = frame;
		this.setVisible(true);
		this.setDestroyed(false);
		//System.out.println("create "+e+" "+fStart+" ");
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

	public String[] getNukeAtkAnimation() {
		return nukeAtkAnimation;
	}

	public String[] getSniperAtkAnimation() {
		return sniperAtkAnimation;
	}

	public String[] getEngineerAtkAnimation() {
		return engineerAtkAnimation;
	}

	public String[] getAssaultAtkAnimation() {
		return assaultAtkAnimation;
	}

	public void update(int frame) {
		//System.out.println(""+this.fStart+"  "+frame+" "+this.fEnd);
		if(frame-this.fStart >= fEnd) {
			//System.out.println("delete");
			this.setVisible(false);
			this.setDestroyed(true);
		}
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
		System.out.println("fuckthismannn");
		
	}

}
