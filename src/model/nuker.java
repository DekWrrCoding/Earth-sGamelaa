package model;

import javafx.scene.paint.Color;

public class nuker extends character implements atkable{


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
		if(super.action(frame)) {
		System.out.println(this.posX+"<-X Y->"+this.posY);
		atkanimation nukeAtk = new nukeAnimation(this,frame);
		InGameLogic.getListEntities().add(nukeAtk);
	
		return true;
		}
		return false;
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
					if(this.lockOnEnemy.size()<this.numLockEnemy  && this.lockOnEnemy.contains(temp) == false) {
						this.lockOnEnemy.add(temp);
					}
					
				}
				return false;
		
	}

}
