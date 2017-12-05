package model;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;



public class map extends Entity implements IRenderable{
	private String name;
	private String imgUrl;
	private int[][] mapInfo;
	private int[] nEnemy;
	private List<enemy> listEnemy = new ArrayList<>();
	private int stX,stY,edX,edY;
	private int[][] locationTower;
	private int nTower;
	private character[] tower;
	private int moneyFromMap;
	
	public map(String name, String imgUrl, int[][] mapInfo, int[] nEnemy, int stX, int stY, int edX, int edY,int nTower,int moneyFromMap,int[][] locationTower) {
		super();
		this.name = name;
		this.imgUrl = imgUrl;
		this.mapInfo = mapInfo;
		this.nEnemy = nEnemy;
		this.stX = stX;
		this.stY = stY;
		this.edX = edX;
		this.edY = edY;
		this.locationTower=locationTower;
		this.moneyFromMap=moneyFromMap;
		this.nTower = nTower;
		tower = new character[this.nTower];
		for(int i=0;i<nEnemy[0];i++) {
			enemy type0 = new troopE(this.stX,this.stY);
			listEnemy.add(type0);
		}
		for(int i=0;i<nEnemy[1];i++) {
			enemy type0 = new tank(this.stX,this.stY);
			listEnemy.add(type0);
		}
		
		
	}
//	public int[] getDirection(int posX,int posY,enemy e) {
//		int nowX =(int)(posX /40) ; 
//		int nowY = (int)(posY /40);
//		int n=0;
//		if(this.mapInfo[posX+1][posY-1] == 0 && this.mapInfo[posX+1][posY] == 1 && this.mapInfo[posX+1][posY+1] == 0 ) {
//			n++;
//		}
//		e.setSpeed(n);
//		return {posX+n,posY};
//	}
	
	public int[][] getLocationTower() {
		return locationTower;
	}


	public int getMoneyFromMap() {
		return moneyFromMap;
	}


	public int getnTower() {
		return nTower;
	}

	public character[] getTower() {
		return tower;
	}

	public String getName() {
		return name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public int[][] getMapInfo() {
		return mapInfo;
	}

	public int[] getnEnemy() {
		return nEnemy;
	}

	public List<enemy> getListEnemy() {
		return listEnemy;
	}

	public int getStX() {
		return stX;
	}

	public int getStY() {
		return stY;
	}

	public int getEdX() {
		return edX;
	}

	public int getEdY() {
		return edY;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		//System.out.println(imgUrl);
		Image img = new Image(this.imgUrl);
		gc.drawImage(img, 0, 0);
		for(int i=0;i<this.locationTower.length;i++) {
			gc.setFill(Color.AQUA);
			gc.fillRect(this.locationTower[i][0]*40, this.locationTower[i][1]*40, 40, 40);
			gc.setFill(Color.YELLOW);
			
			gc.fillText(""+(i+1),this.locationTower[i][0]*40, this.locationTower[i][1]*40+10);
		}
		
		
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
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	public int[] calculatePos(enemy entity) {
		// TODO Auto-generated method stub
		int[] pos = {0,0};
		int x = entity.getPosX()/40;
		int y = entity.getPosY()/40;
		if(x>15 || y >11 || x<0 || y<0)return pos;
		//1=-> 2= ^ 3=v 4 = ^orv 5 =< 6 =<||>
		if(this.mapInfo[y][x]==1) {
			pos[0] = 1;
			pos[1] = 0;
		}
		else if(this.mapInfo[y][x]==2) {
			pos[0] = 0;
			pos[1] = -1;
		}
		else if(this.mapInfo[y][x]==3) {
			pos[0] = 0;
			pos[1] = 1;
		}
		else if(this.mapInfo[y][x]==4) {
			Random rand = new Random();
			int temp = rand.nextInt()%2;
			if(temp == 0)pos[1]=1;
			else pos[1]=-1;
			pos[0] = 0;
			
		}
//		else if(this.mapInfo[y][x]==1) {
//			pos[0] = 1;
//			pos[1] = 0;
//		}
		return pos;
	}

	
}
