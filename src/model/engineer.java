package model;

import javafx.scene.paint.Color;

public class engineer extends character implements atkable{



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
		if(frame % this.atkspeed == 0) {
				for( enemy i: lockOnEnemy) {
				this.attack(i);
				}
				
		}
		return false;
	}
	
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
				enemy temp = (enemy)otherentity;
				double disX = (double)this.posX/40.0 - (double)temp.posX/40.0;
				double disY = (double)this.posY/40.0 - (double)temp.posY/40.0;
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
