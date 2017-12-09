package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Character.assault;
import Character.character;
import Character.engineer;
import Character.nuker;
import Character.sniper;

public class EarthGameModel {
	private  List<map> listmaps = new ArrayList<>();
	private  List<character> hero = new ArrayList<>();
	private static int[] typesummon = {10,99};
	private  List<character> myhero = new ArrayList<>();
	private static int money = 10000;
	public static int tempexp =0;
	
	public EarthGameModel(){
		this.setDefaultCharacter();
		this.setDefaultMap();
		
	}
	private void setDefaultMap() {
		// TODO Auto-generated method stub 1=-> 2= ^ 3=v 4 = ^orv
		int[][] chap1 = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						 {0,0,1,1,3,0,0,0,0,0,0,0,0,0,0,0},
						 {0,0,2,0,3,0,9,0,0,0,0,0,0,0,0,0},
						 {0,0,2,9,3,0,1,1,1,1,1,1,3,0,0,0},
						 {1,1,2,0,3,0,2,0,0,0,0,0,3,0,0,0},
						 {0,0,0,0,3,9,2,0,0,0,9,0,1,1,1,1},
						 {0,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,1,1,2,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						 };
		int[][] pt1= {{3,4},{5,6},{6,3},{10,6},{5,10}};
		int[] e1= {30,10,0};
		map stage1 = new map("chapter1","stage1.jpg",chap1, e1, 0, 5, 7, 3,5,500,pt1);
		listmaps.add(stage1);
		int[][] chap2 = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,1,1,1,1,1,1,1,1,1,1,1,3,0,0},
				 		{0,0,2,0,0,0,0,0,0,0,0,0,0,3,0,0},
				 		{0,0,2,0,0,0,0,0,0,0,0,0,0,3,0,0},
				 		{0,0,2,0,9,0,0,0,0,0,0,9,0,3,0,0},
				 		{0,0,2,0,0,0,0,0,0,0,0,0,0,3,0,0},
				 		{1,1,4,0,0,0,0,0,0,0,0,0,0,1,1,1},
				 		{0,0,3,0,0,0,0,0,0,0,0,0,0,2,0,0},
				 		{0,0,3,0,9,0,0,0,0,0,0,9,0,2,0,0},
				 		{0,0,3,0,0,0,0,0,0,0,0,0,0,2,0,0},
				 		{0,0,1,1,1,1,1,1,1,1,1,1,1,2,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 	};
		int[][]  pt2 = {{4,4},{4,8},{11,4},{11,8}};
		int[] e2= {10,10,0};
		map stage2 = new map("chapter2","stage2.png",chap2,e2 , 0, 6, 7, 3,4,1000,pt2);
		listmaps.add(stage2);//stub 1=-> 2= ^ 3=v 4 = ^orv 5 <> 6 <-
		int[][] chap3 = {{1,1,1,1,1,1,1,1,3,0,0,0,0,0,0,0},
 						{2,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
 						{2,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
 						{2,6,6,6,5,1,1,1,3,0,0,0,0,0,0,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,1,1,1,1},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,2,0,0,0},
		 				{0,0,0,9,2,0,0,0,3,0,0,0,2,0,0,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,2,9,0,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,2,0,0,0},
		 				{1,1,1,1,2,0,0,0,3,0,9,0,2,0,0,0},
		 				{0,0,0,0,0,0,0,0,1,1,1,1,2,0,0,0},
		 				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 	};
		int[][]  pt3 = {{2,2},{3,6},{7,3},{10,9},{13,7}};
		int[] e3= {20,20,1};
		map stage3 = new map("chapter3","stage3.png",chap3,e3 , 0, 9, 7, 3,5,10000,pt3);
		listmaps.add(stage3);
		System.out.println(listmaps.size()+" fuckkkkkkkkkk");
	}
	public void setDefaultCharacter() {
		sniper pang = new sniper("pang",5,1500,20,7,"aquapang.png","sniperlogo.png");
		nuker toei = new nuker("toei",5,1000,100,3,"oneshottoei.png","nukerlogo.png");
		engineer earth = new engineer("earth",5,50,10,4,"Earthbreak.png","engineerlogo.png");
		assault pai = new assault("pai",5,100,7,5,"paiwind.png","assualtlogo.png");

		hero.add(pang);
		hero.add(toei);
		hero.add(earth);
		hero.add(pai);
		for(int i=0;i<20;i++)hero.add(new assault("soldier "+i,1,100,10,3,"NoobChic.png","sniperlogo.png"));
		myhero.add(earth);
	}
	public  List<character> getHero() {
		return hero;
	}
	public  List<character> getMyhero() {
		return myhero;
	}
	public static int getMoney() {
		return money;
	}
	public static int[] getTypesummon() {
		return typesummon;
	}
	public character randomchar(int type) {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		x = x % hero.size();
		if(type == 1)x=x%5;
		character gethero = null;
		if (hero.get(x) instanceof nuker) {
			gethero = new nuker((nuker)hero.get(x));
		}
		else if (hero.get(x) instanceof sniper) {
			gethero = new sniper((sniper)hero.get(x));
		}
		else if (hero.get(x) instanceof engineer) {
			gethero = new engineer((engineer)hero.get(x));
		}
		else {
			gethero = new assault((assault)hero.get(x));
		}
		return gethero;
		
	}
	public void decreaseMoney(int i) {
		// TODO Auto-generated method stub
		EarthGameModel.money-=i;
		
	}
	public  List<map> getListmaps() {
		return listmaps;
	}
	public static int getTempexp() {
		return tempexp;
	}
	
}
