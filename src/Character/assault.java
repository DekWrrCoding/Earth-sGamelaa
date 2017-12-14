package Character;


import java.util.ArrayList;
import java.util.List;

import Inteface.IRenderable;
import Inteface.atkable;
import atkAnimation.assaultAtkAnimation;
import enemy.Enemy;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.InGameLogic;

public class Assault extends Character implements atkable{
	private static AudioClip atksound = new AudioClip(ClassLoader.getSystemResource("assault.mp3").toString());
	public Assault(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl ,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl, logoUrl);		// TODO Auto-generated constructor stub
		this.numLockEnemy = 3;
		this.locol = "black";
		this.img = new Image(this.logoUrl,60,60,false,false);
	}
	public Assault(Assault Assault) {
		// TODO Auto-generated constructor stub
		super(Assault);
		this.numLockEnemy = 3;
		this.locol = "black";
		this.img = new Image(this.logoUrl,60,60,false,false);
		
	
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		if(super.action(frame)) {
			
			for(Enemy i :this.lockOnEnemy) {
				atksound.play();
				assaultAtkAnimation assaultAtk = new assaultAtkAnimation(i, frame);
				InGameLogic.listEntities.add(assaultAtk);
			}
			clearLockedEnemy();
		}
		return false;
	}
	public boolean attackEnemy(IRenderable otherentity) {
		// TODO Auto-generated method stub
		Enemy temp = (Enemy)otherentity; 
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
