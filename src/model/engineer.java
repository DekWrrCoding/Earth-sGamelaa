package model;

import javafx.scene.paint.Color;

public class engineer extends character implements atkable{



	public engineer(String name, int star, int attack, int atkspeed, int atkrange, String imgUrl,String logoUrl) {
		super(name, star, attack, atkspeed, atkrange, imgUrl,logoUrl);
		// TODO Auto-generated constructor stub
		this.numLockEnemy =5;
		//this.logoUrl="engineerlogo.png";
		this.locol = "CRIMSON";
	}

	public engineer(engineer engineer) {
		// TODO Auto-generated constructor stub
		super(engineer);
		//this.logoUrl="engineerlogo.png";
		this.numLockEnemy = 5;
		this.locol= "CRIMSON";
	}
	@Override
	public boolean action(int frame) {
		// TODO Auto-generated method stub
		return super.action(frame);
	}
	@Override
	public boolean attackEnemy(IRenderable otherentity) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				enemy temp = (enemy)otherentity; 
				//System.out.println((this.posX-temp.posX)*(this.posX-temp.posX) + (this.posY-temp.posY)*(this.posY-temp.posY) );
				int posEnemyXinTable = temp.getPosX()/40;
				int posEnemyYinTable = temp.getPosY()/40;
				double disX = (double)this.posX/40.0 - (double)temp.posX/40.0;
				double disY = (double)this.posY/40.0 - (double)temp.posY/40.0;
				//System.out.println(disX +"<-x y->"+disY+"\n");
				if(Math.sqrt( disX*disX +disY*disY) <=this.atkrange) {
					//System.out.println("engineer lock size ="+this.lockOnEnemy.size()+"\n");
					if(this.lockOnEnemy.size()<this.numLockEnemy && this.lockOnEnemy.contains(temp) == false) {
						this.lockOnEnemy.add(temp);
						temp.setIsLocked(true);
					}
					
				}
				return false;
		
	}


}
