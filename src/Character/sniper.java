package Character;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.sniperAnimation;
import enemy.Enemy;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class Sniper extends Character implements atkable{
	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("sniper.mp3").toString());
	public Sniper(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl,logoUrl);
		// TODO Auto-generated constructor stub
		this.numLockEnemy =1;

		this.locol = "GREENYELLOW";
		this.img = new Image(this.logoUrl,60,60,false,false);
	}

	
	public Sniper(Sniper Sniper) {
		// TODO Auto-generated constructor stub
		super(Sniper);
		this.numLockEnemy =1;
		this.locol = "GREENYELLOW";
		this.img = new Image(this.logoUrl,60,60,false,false);
		
	}

	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		if(super.action(frame)) {
			
			for(Enemy i :this.lockOnEnemy) {
				atksound.play();
				sniperAnimation sniperAtk = new sniperAnimation(i,frame);
				InGameLogic.getListEntities().add(sniperAtk);
			}
			
		}
		this.clearLockedEnemy();
		return false;
	}
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
				Enemy temp = (Enemy)otherentity; 
				double disX = (double)this.posX/40.0 - (double)temp.getPosX()/40.0;
				double disY = (double)this.posY/40.0 - (double)temp.getPosY()/40.0;
				if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
					if(this.lockOnEnemy.size()<this.numLockEnemy  && this.lockOnEnemy.contains(temp) == false) {
						this.lockOnEnemy.add(temp);
						temp.setIsLocked(true);
					}
					
				}
				return false;
		
	}



}
