package Character;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.atkanimation;
import atkAnimation.nukeAnimation;
import enemy.enemy;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class nuker extends character implements atkable{

	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("bomb.wav").toString());
	public nuker(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl, logoUrl);
		// TODO Auto-generated constructor stub
		this.numLockEnemy=100;
		//this.logoUrl="engineerlogo.png";
		//this.logoUrl="nukerlogo.png";
		this.locol = "AZURE";
	}
	public nuker(nuker nuker) {
		// TODO Auto-generated constructor stub
		super(nuker);
		this.locol = "AZURE";
		//this.logoUrl="nukerlogo.png";
		this.numLockEnemy=100;
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		boolean bool = false;
		if(super.action(frame)) {
			atksound.play();
		System.out.println(this.posX+"<-X Y->"+this.posY);

		atkanimation nukeAtk = new nukeAnimation(this,frame);

		InGameLogic.getListEntities().add(nukeAtk);
	
		bool = true;
		}
		this.clearLockedEnemy();
		return bool;
	}
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				enemy temp = (enemy)otherentity; 
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
