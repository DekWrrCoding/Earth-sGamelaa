package model;


import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public class assault extends character implements atkable{
	
	public assault(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl ,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl, logoUrl);		// TODO Auto-generated constructor stub
		this.numLockEnemy = 3;
		//this.logoUrl="engineerlogo.png";
		//this.logoUrl="assualtlogo.png";
		this.locol = "black";
	}
	public assault(assault assault) {
		// TODO Auto-generated constructor stub
		super(assault);
		this.numLockEnemy = 3;
		//this.logoUrl="engineerlogo.png";
		//this.logoUrl="assualtlogo.png";
		this.locol = "black";
		
	
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		if(super.action(frame)) {
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
		//System.out.println((this.posX-temp.posX)*(this.posX-temp.posX) + (this.posY-temp.posY)*(this.posY-temp.posY) );
		int posEnemyXinTable = temp.getPosX()/40;
		int posEnemyYinTable = temp.getPosY()/40;
		double disX = (double)this.posX/40.0 - (double)temp.posX/40.0;
		double disY = (double)this.posY/40.0 - (double)temp.posY/40.0;
		//System.out.println(disX +"<-x y->"+disY+"\n");
		if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
			if(this.lockOnEnemy.size()<this.numLockEnemy  && this.lockOnEnemy.contains(temp) == false) {
				this.lockOnEnemy.add(temp);
				temp.setIsLocked(true);
			}
		}
		return false;
	}



	
	
}
