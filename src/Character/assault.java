package Character;


import java.util.ArrayList;
import java.util.List;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.assaultAtkAnimation;
import enemy.enemy;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class assault extends character implements atkable{
	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("assault.mp3").toString());
	public assault(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl ,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl, logoUrl);		// TODO Auto-generated constructor stub
		this.numLockEnemy = 3;
		this.locol = "black";
	}
	public assault(assault assault) {
		// TODO Auto-generated constructor stub
		super(assault);
		this.numLockEnemy = 3;
		this.locol = "black";
		
	
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		if(super.action(frame)) {
			atksound.play();
			for(enemy i :this.lockOnEnemy) {
				
				assaultAtkAnimation assaultAtk = new assaultAtkAnimation(i, frame);
				InGameLogic.listEntities.add(assaultAtk);
			}
			clearLockedEnemy();
		}
		return false;
	}
	public boolean attackEnemy(IRenderable otherentity) {
		// TODO Auto-generated method stub
		enemy temp = (enemy)otherentity; 
		double disX = (double)this.getPosX()/40.0 - (double)temp.getPosX()/40.0;
		double disY = (double)this.getPosY()/40.0 - (double)temp.getPosY()/40.0;
		if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
			if(this.lockOnEnemy.size()<this.numLockEnemy  && this.lockOnEnemy.contains(temp) == false) {
				this.lockOnEnemy.add(temp);
				temp.setIsLocked(true);
			}
		}
		return false;
	}



	
	
}
