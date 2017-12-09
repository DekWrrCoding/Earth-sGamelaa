package model;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Character.assault;
import Character.character;
import Character.engineer;
import Character.nuker;
import Character.sniper;
import Inteface.IRenderable;
import atkAnimation.atkanimation;
import enemy.Boss;
import enemy.enemy;
import enemy.tank;
import enemy.troopE;
import view.GameScreen;

public class InGameLogic {
	private List<enemy> tempE ;
	private map curStage;
	private List<enemy> bSkillEnemy ;
	private List<character> usedHero;
	private int life = 10;
	private int SP = 0;
	public static List<IRenderable> listEntities = new ArrayList<>();
	public InGameLogic(map curStage,List<character> usehero){
		this.bSkillEnemy = new ArrayList<>();
		this.curStage=curStage;
		this.usedHero=usehero;
		this.tempE = new ArrayList<enemy>();
		for(int i =0;i<this.curStage.getListEnemy().size();i++) {
			tempE.add(this.curStage.getListEnemy().get(i));
			System.out.println("add");
		}
		int k=0;
		for(character i : this.usedHero) {
			i.setPosX(this.curStage.getLocationTower()[k][0]);
			i.setPosY(this.curStage.getLocationTower()[k][1]);
			k++;
		}
		
		listEntities.add(curStage);
		for(int index =0;index<usedHero.size();index++) {
			listEntities.add(usedHero.get(index));
		}
		
	}

	public void setSP(int sP) {
		SP = sP;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public List<enemy> getTempE() {
		return tempE;
	}
	public map getCurStage() {
		return curStage;
	}
	public List<character> getUsedHero() {
		return usedHero;
	}
	public int getSP() {
		return SP;
	}
	public static List<IRenderable> getListEntities() {
		return listEntities;
	}
	public int getLife() {
		return life;
	}

	public  boolean isNoEnemy() {
		for(IRenderable i : InGameLogic.listEntities)if(i instanceof enemy)return false;
		return true;
		
	}
	public  void update(int frame,GameScreen g) {
		spawnEnemy(frame);
		
		heroLockOn();
		updateEntities(frame);
		//System.out.println(frame);
		heroAttack(frame);
		skill();
		clearEntity(g);
	}
	private void skill() {
		// TODO Auto-generated method stub
		//this.SP-=10;
		for(enemy i : this.bSkillEnemy) {
			i.takeDamage(5000);
		}
		this.bSkillEnemy=null;
		this.bSkillEnemy=new ArrayList<>();
		
	}
	private void heroAttack(int frame) {
		// TODO Auto-generated method stub
		for(int i =0; i<InGameLogic.listEntities.size(); i++) {
			if(InGameLogic.listEntities.get(i) instanceof nuker) {
				//System.out.println(((character)entity).name);
				((nuker)InGameLogic.listEntities.get(i)).action(frame);
			}
			if(InGameLogic.listEntities.get(i) instanceof sniper ) {
				//System.out.println(((character)entity).name);
				((sniper)InGameLogic.listEntities.get(i)).action(frame);
			}
			if(InGameLogic.listEntities.get(i) instanceof assault ) {
				//System.out.println(((character)entity).name);
				((assault)InGameLogic.listEntities.get(i)).action(frame);
			}
			if(InGameLogic.listEntities.get(i) instanceof engineer ) {
				//System.out.println(((character)entity).name);
				((engineer)InGameLogic.listEntities.get(i)).action(frame);
			}
		}
		
		
	}
	private void clearEntity(GameScreen g) {
		// TODO Auto-generated method stub
		for(int i = InGameLogic.listEntities.size()-1;i>=0;i--) {
			if(InGameLogic.listEntities.get(i).isDestroyed() || InGameLogic.listEntities.get(i).isVisible()==false ) {
				g.paintComponent();
				if(InGameLogic.listEntities.get(i) instanceof enemy)this.SP+=1;
				InGameLogic.listEntities.remove(i);
			}
		}
		
	}
	private void heroLockOn() {
		// TODO Auto-generated method stub
		for(IRenderable entity : InGameLogic.listEntities) {
			if(entity instanceof character) {
				for(IRenderable otherentity : InGameLogic.listEntities) {
					if(otherentity instanceof enemy) {
						if(entity instanceof nuker)entity =(nuker)entity;
						if(entity instanceof sniper)entity =(sniper)entity;
						if(entity instanceof assault)entity =(assault)entity;
						if(entity instanceof engineer)entity =(engineer)entity;
						((character) entity).attackEnemy(otherentity);
					}
				}
			}
		}
		
	}
	private void updateEntities(int frame) {
		// TODO Auto-generated method stub
		for(IRenderable entity : InGameLogic.listEntities) {
			if(entity instanceof enemy ) {
				int[] pos = curStage.calculatePos((enemy)entity);
				((enemy)entity).updatePos(pos);
				if(((enemy)entity).isReached() && entity.isDestroyed() == false) {
					this.life--;
					((enemy) entity).setDestroyed(true);
					((enemy) entity).setVisible(false);	
				}
			}
			if(entity instanceof atkanimation) {
				//System.out.println("update atkanimation");
				((atkanimation) entity).update(frame);
			}
		}
	}
	private void spawnEnemy(int frame) {
		// TODO Auto-generated method stub
		
		if(frame % 10 == 0 && this.tempE.size() !=0) {
			Random rand = new Random();
			int x = rand.nextInt(this.tempE.size());
			IRenderable temp = null;
			if(this.tempE.get(x) instanceof tank) {
			temp = new tank((this.tempE.get(x)) );
			}
			else if(this.tempE.get(x) instanceof troopE) {
				temp = new troopE(this.tempE.get(x));
			}
			else if(this.tempE.get(x) instanceof Boss) {
				temp = new Boss(this.tempE.get(x));
			}
			InGameLogic.listEntities.add((IRenderable)temp);
			this.tempE.remove(x);
		}
		
	}
	private double Distance (double d,double e ,double x1,double y1) {
		double x2 =(double)d;
		double y2 =(double)e;
		double ans = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return ans;
		
	}
	public void lockedskill(double mx, double my) {
		for(IRenderable entity : this.listEntities) {
			if(entity instanceof enemy && Distance(	((enemy) entity).getPosX(),((enemy) entity).getPosY(),mx,my) <= 300)  {
				this.bSkillEnemy.add((enemy) entity);
			}
		}
		System.out.println(this.bSkillEnemy);
	}
	public boolean isGameEnd() {
		// TODO Auto-generated method stub

		boolean ans = true;
		for(IRenderable entity : InGameLogic.listEntities)if(entity instanceof enemy)ans = false;
		return ans;
	}
	public void newGame() {
		// TODO Auto-generated method stub
		this.life = 10;
		this.tempE = new ArrayList<enemy>(this.curStage.getListEnemy());
		
	}
}
