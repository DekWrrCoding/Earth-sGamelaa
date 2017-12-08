package model;

import javafx.scene.paint.Color;

public class sniper extends character implements atkable{

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
				double disX = (double)this.posX/40.0 - (double)temp.posX/40.0;
				double disY = (double)this.posY/40.0 - (double)temp.posY/40.0;
				if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
					if(this.lockOnEnemy.size()<this.numLockEnemy  && this.lockOnEnemy.contains(temp) == false) {
						this.lockOnEnemy.add(temp);
						temp.setIsLocked(true);
					}
					
				}
				return false;
		
	}



}
