package model;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Character.Assault;
import Character.Character;
import Character.Engineer;
import Character.Nuker;
import Character.Sniper;
import Inteface.IRenderable;
import atkAnimation.atkanimation;
import enemy.Boss;
import enemy.Enemy;
import enemy.Tank;
import enemy.Troop;
import view.GameScreen;

public class InGameLogic {
	private List<Enemy> tempE ;
	private Map curStage;
	private List<Enemy> bSkillEnemy ;
	private List<Character> usedHero;
	private int life = 10;
	private int SP = 0;
	public static List<IRenderable> listEntities = new ArrayList<>();
	public InGameLogic(Map curStage,List<Character> usehero){
		this.bSkillEnemy = new ArrayList<>();
		this.curStage=curStage;
		this.usedHero=usehero;
		this.tempE = new ArrayList<Enemy>();
		for(int i =0;i<this.curStage.getListEnemy().size();i++) {
			tempE.add(this.curStage.getListEnemy().get(i));
			System.out.println("add");
			System.out.println(this.curStage.getListEnemy().get(i).getHp());
		}
		int k=0;
//		for(character i : this.usedHero) {
//			i.setPosX(this.curStage.getLocationTower()[k][0]);
//			i.setPosY(this.curStage.getLocationTower()[k][1]);
//			k++;
//		}
		
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
	public List<Enemy> getTempE() {
		return tempE;
	}
	public Map getCurStage() {
		return curStage;
	}
	public List<Character> getUsedHero() {
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
		for(IRenderable i : InGameLogic.listEntities)if(i instanceof Enemy)return false;
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
		for(Enemy i : this.bSkillEnemy) {
			i.takeDamage(2000);
		}
		this.bSkillEnemy=null;
		this.bSkillEnemy=new ArrayList<>();
		
	}
	private void heroAttack(int frame) {
		// TODO Auto-generated method stub
		for(int i =0; i<InGameLogic.listEntities.size(); i++) {
			if(InGameLogic.listEntities.get(i) instanceof Nuker) {
				//System.out.println(((character)entity).name);
				((Nuker)InGameLogic.listEntities.get(i)).action(frame);
			}
			if(InGameLogic.listEntities.get(i) instanceof Sniper ) {
				//System.out.println(((character)entity).name);
				((Sniper)InGameLogic.listEntities.get(i)).action(frame);
			}
			if(InGameLogic.listEntities.get(i) instanceof Assault ) {
				//System.out.println(((character)entity).name);
				((Assault)InGameLogic.listEntities.get(i)).action(frame);
			}
			if(InGameLogic.listEntities.get(i) instanceof Engineer ) {
				//System.out.println(((character)entity).name);
				((Engineer)InGameLogic.listEntities.get(i)).action(frame);
			}
		}
		
		
	}
	private void clearEntity(GameScreen g) {
		// TODO Auto-generated method stub
		for(int i = InGameLogic.listEntities.size()-1;i>=0;i--) {
			if(InGameLogic.listEntities.get(i).isDestroyed() || InGameLogic.listEntities.get(i).isVisible()==false ) {
				g.paintComponent();
				if(InGameLogic.listEntities.get(i) instanceof Enemy)this.SP+=1;
				InGameLogic.listEntities.remove(i);
			}
		}
		
	}
	private void heroLockOn() {
		// TODO Auto-generated method stub
		for(IRenderable entity : InGameLogic.listEntities) {
			if(entity instanceof Character) {
				for(IRenderable otherentity : InGameLogic.listEntities) {
					if(otherentity instanceof Enemy) {
						if(entity instanceof Nuker)entity =(Nuker)entity;
						if(entity instanceof Sniper)entity =(Sniper)entity;
						if(entity instanceof Assault)entity =(Assault)entity;
						if(entity instanceof Engineer)entity =(Engineer)entity;
						((Character) entity).attackEnemy(otherentity);
					}
				}
			}
		}
		
	}
	private void updateEntities(int frame) {
		// TODO Auto-generated method stub
		for(IRenderable entity : InGameLogic.listEntities) {
			if(entity instanceof Enemy ) {
				int[] pos = curStage.calculatePos((Enemy)entity);
				((Enemy)entity).updatePos(pos);
				if(((Enemy)entity).isReached() && entity.isDestroyed() == false) {
					this.life--;
					((Enemy) entity).setDestroyed(true);
					((Enemy) entity).setVisible(false);	
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
			if(this.tempE.get(x) instanceof Tank) {
			temp = new Tank((this.tempE.get(x)) );
			}
			else if(this.tempE.get(x) instanceof Troop) {
				temp = new Troop(this.tempE.get(x));
			}
			else if(this.tempE.get(x) instanceof Boss) {
				temp = new Boss(this.tempE.get(x));
			}
			InGameLogic.listEntities.add((IRenderable)temp);
			System.out.println(((Enemy)temp).getHp());
			
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
			if(entity instanceof Enemy && Distance(	((Enemy) entity).getPosX(),((Enemy) entity).getPosY(),mx,my) <= 600)  {
				this.bSkillEnemy.add((Enemy) entity);
			}
		}
		System.out.println(this.bSkillEnemy);
	}
	public boolean isGameEnd() {
		// TODO Auto-generated method stub

		boolean ans = true;
		for(IRenderable entity : InGameLogic.listEntities)if(entity instanceof Enemy)ans = false;
		return ans;
	}
	public void newGame() {
		// TODO Auto-generated method stub
		this.life = 10;
		this.tempE = new ArrayList<Enemy>(this.curStage.getListEnemy());
		this.usedHero = null;
		
	}
}
