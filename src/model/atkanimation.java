package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class atkanimation extends Entity implements IRenderable {
	private int fStart;
	private static int fEnd = 50;
	private Entity e ;
	int i =0;
	private String[] nukeAtkAnimation = {"nuke1.png","nuke2.png","nuke3.png","nuke4.png","nuke5.png",};
	public atkanimation(Entity e,int frame) {
		super();
		this.e = e;
		this.fStart = frame;
		this.setVisible(true);
		this.setDestroyed(false);
		System.out.println("create "+e+" "+fStart+" ");
	}
	public void update(int frame) {
		System.out.println(""+this.fStart+"  "+frame);
		if(frame-this.fStart >= fEnd) {
			System.out.println("delete");
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
	public void draw(GraphicsContext gc) {

		Image img = new Image(this.nukeAtkAnimation[i%5]);
		System.out.println("booommmm");
		gc.drawImage(img,this.e.posX, this.e.posY);
		i++;
		
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

}
