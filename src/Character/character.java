 package Character;

import java.util.ArrayList;
import java.util.List;

import Inteface.IRenderable;
import enemy.enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Entity;

public  class character extends Entity {
	protected List<enemy> lockOnEnemy = new ArrayList<>();
	protected int numLockEnemy ;
	static int IDcount = 0;
	static final int[] maxExpLv = {0,10,20,50,100,150,250,400,600,900};
	int exp=5;
	int lv = 1;
	String locol ;
	String logoUrl;
	String name;
	int ID ;
	int star;
	int attack;
	int atkspeed;
	int atkrange;
	String imgUrl;
	boolean isMaterail=false;
	public String getLocol() {
		return locol;
	}
	public boolean action(int frame) {
		boolean bool = false;
		if(frame % this.atkspeed == 0) {
				for( enemy i: lockOnEnemy) {
				
				this.attack(i);
				}
				bool = true;
		}
			
		return bool;
		
	}
	public void clearLockedEnemy() {
		this.lockOnEnemy = null;
		this.lockOnEnemy = new ArrayList<>();
	}
	public void attack(enemy i) {
		// TODO Auto-generated method stub
		((enemy)i).takeDamage(this.attack);
		
		
	}
	public boolean isMaterail() {
		return isMaterail;
	}
	character(character other) {
		super();
	
		this.name = other.name;
		this.star = other.star;
		this.attack = other.attack;
		this.atkspeed = other.atkspeed;
		this.atkrange = other.atkrange;
		this.imgUrl=other.imgUrl;
		this.logoUrl = other.logoUrl;
		this.ID = IDcount;
		IDcount++;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	
	public void setMaterail(boolean isMaterail) {
		this.isMaterail = isMaterail;
	}
	public character(String name, int star, int attack, int atkspeed, int atkrange,String imgUrl,String logoUrl) {
		super();
		this.name = name;
		this.star = star;
		this.attack = attack;
		this.atkspeed = atkspeed;
		this.atkrange = atkrange;
		this.imgUrl=imgUrl;
		this.ID = IDcount;
		this.logoUrl = logoUrl;
		
		IDcount++;
	}
	public int getID() {
		return ID;
	}
	public void gainExp(int gexp) {
		this.exp+=gexp;
		while(this.exp>=character.maxExpLv[this.lv]) {
			levelup();
		}
	}
	private void levelup() {
		// TODO Auto-generated method stub
		exp-=character.maxExpLv[this.lv];
		lv++;
		this.attack *=1.2;
		this.atkspeed *=1.2;
		this.atkrange *=1.1;
		
	}
	public void toggleMat() {
		if(this.isMaterail==false)this.isMaterail=true;
		else this.isMaterail=false;
	}
	public static int[] getMaxexplv() {
		return maxExpLv;
	}
	public int getExp() {
		return exp;
	}
	public int getLv() {
		return lv;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public String getName() {
		return name;
	}
	public int getStar() {
		return star;
	}
	public int getAttack() {
		return attack;
	}
	public int getAtkspeed() {
		return atkspeed;
	}
	public int getAtkrange() {
		return atkrange;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image img = new Image("tower.png",60,60,false,false);
		gc.drawImage(img, this.posX*1.5, this.posY*1.5);
		gc.fillText(this.getName(), this.posX*1.5, this.posY*1.5);
	}
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean attackEnemy(IRenderable otherentity) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	@Override
	public void setPosX(int x) {
		this.posX = x*40;
	}
	@Override
	public void setPosY(int x) {
		this.posY = x*40;
	}

}
