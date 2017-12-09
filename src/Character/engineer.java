package Character;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.assaultAtkAnimation;
import atkAnimation.engineerAtkAnimation;
import enemy.enemy;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class engineer extends character implements atkable{

	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("sword.wav").toString());

	public engineer(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl,logoUrl);
		// TODO Auto-generated constructor stub
		this.numLockEnemy =5;
		this.locol = "CRIMSON";
	}

	public engineer(engineer engineer) {
		// TODO Auto-generated constructor stub
		super(engineer);
		this.numLockEnemy = 5;
		this.locol= "CRIMSON";
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		if(super.action(frame)) {
			atksound.play();
			for(enemy i :this.lockOnEnemy) {
				
				engineerAtkAnimation assaultAtk = new engineerAtkAnimation(i, frame);
				InGameLogic.listEntities.add(assaultAtk);
			}
			clearLockedEnemy();
		}
		return false;
	
	}
	
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
				enemy temp = (enemy)otherentity;
				double disX = (double)this.posX/40.0 - (double)temp.getPosX()/40.0;
				double disY = (double)this.posY/40.0 - (double)temp.getPosY()/40.0;
				//System.out.println(disX +"<-x y->"+disY+"\n");
				if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
	
					if(this.lockOnEnemy.size()<this.numLockEnemy && this.lockOnEnemy.contains(temp) == false) {
						this.lockOnEnemy.add(temp);
						temp.setIsLocked(true);
					}
					
				}
				return false;
		
	}


}
