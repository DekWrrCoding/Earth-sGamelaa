package Character;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.atkanimation;
import atkAnimation.nukeAnimation;
import enemy.Enemy;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class Nuker extends Character implements atkable{

	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("bomb.wav").toString());
	public Nuker(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl, logoUrl);
		// TODO Auto-generated constructor stub
		this.numLockEnemy=100;
		//this.logoUrl="engineerlogo.png";
		//this.logoUrl="nukerlogo.png";
		this.locol = "AZURE";
		this.img = new Image(this.logoUrl,60,60,false,false);
	}
	public Nuker(Nuker Nuker) {
		// TODO Auto-generated constructor stub
		super(Nuker);
		this.locol = "AZURE";
		//this.logoUrl="nukerlogo.png";
		this.numLockEnemy=100;
		this.img = new Image(this.logoUrl,60,60,false,false);
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		boolean bool = false;
		if(super.action(frame)) {
			atksound.play();
			atkanimation nukeAtk = new nukeAnimation(this,frame);

			InGameLogic.getListEntities().add(nukeAtk);
		System.out.println(this.posX+"<-X Y->"+this.posY);

		
	
		bool = true;
		}
		this.clearLockedEnemy();
		return bool;
	}
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Enemy temp = (Enemy)otherentity; 
				double disX = (double)this.posX/40.0 - (double)temp.getPosX()/40.0;
				double disY = (double)this.posY/40.0 - (double)temp.getPosY()/40.0;
				if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
					if(this.lockOnEnemy.size()<this.numLockEnemy  && this.lockOnEnemy.contains(temp) == false) {
						this.lockOnEnemy.add(temp);
					}
					
				}
				return false;
		
	}

}
