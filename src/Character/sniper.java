package Character;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.sniperAnimation;
import enemy.enemy;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class sniper extends character implements atkable{
	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("sniper.mp3").toString());
	public sniper(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl,logoUrl);
		// TODO Auto-generated constructor stub
		this.numLockEnemy =1;

		this.locol = "GREENYELLOW";
	}

	
	public sniper(sniper sniper) {
		// TODO Auto-generated constructor stub
		super(sniper);
		this.numLockEnemy =1;
		this.locol = "GREENYELLOW";
		
	}

	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		if(super.action(frame)) {
			atksound.play();
			for(enemy i :this.lockOnEnemy) {
				sniperAnimation sniperAtk = new sniperAnimation(i,frame);
				InGameLogic.getListEntities().add(sniperAtk);
			}
			
		}
		this.clearLockedEnemy();
		return false;
	}
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
				enemy temp = (enemy)otherentity; 
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
