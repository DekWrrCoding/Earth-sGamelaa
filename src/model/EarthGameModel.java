package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Character.Assault;
import Character.Character;
import Character.Engineer;
import Character.Nuker;
import Character.Sniper;

public class EarthGameModel {
	private  List<Map> listmaps = new ArrayList<>();
	private  List<Character> hero = new ArrayList<>();
	private static int[] typesummon = {10,99};
	private  List<Character> myhero = new ArrayList<>();
	private static int money = 500;
	public static int tempexp =0;
	
	public EarthGameModel(){
		this.setDefaultCharacter();
		this.setDefaultMap();
		
	}
	private void setDefaultMap() {
		// TODO Auto-generated method stub 1=-> 2= ^ 3=v 4 = ^orv
		int[][] chap1 = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						 {0,0,1,1,3,0,0,0,0,0,0,0,0,0,0,0},
						 {0,0,2,0,3,0,0,0,0,0,0,0,0,0,0,0},
						 {0,0,2,0,3,0,1,1,1,1,1,1,3,0,0,0},
						 {0,0,2,9,3,0,2,0,0,0,0,0,3,0,0,0},
						 {1,1,2,0,3,0,2,0,9,0,9,0,3,0,0,0},
						 {0,0,0,0,3,0,2,0,0,0,0,0,1,1,1,1},
						 {0,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,3,9,2,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,1,1,2,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						 };
		int[][] pt1= {{3,4},{5,6},{8,5},{10,5}};
		int[] e1= {30,10,10};
		Map stage1 = new Map("chapter1","stage2real.png",chap1, e1, 0, 5, 7, 3,4,500,pt1);
		listmaps.add(stage1);
		int[][] chap2 = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,9,0,0,0,0,0,0,9,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,9,0,0,0,0,0,0,9,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 	};
		int[][]  pt2 = {{4,4},{4,8},{11,4},{11,8}};
		int[] e2= {10,10,0};
		Map stage2 = new Map("chapter2","stage2.png",chap2,e2 , 0, 6, 7, 3,4,1000,pt2);
		listmaps.add(stage2);//stub 1=-> 2= ^ 3=v 4 = ^orv 5 <> 6 <-
		int[][] chap3 = {{1,1,1,1,1,1,1,1,3,0,0,0,0,0,0,0},
 						{2,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
 						{2,0,9,0,0,0,0,9,3,0,0,0,0,0,0,0},
 						{2,6,6,6,5,1,1,1,3,0,0,0,0,0,0,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,1,1,1,1},
		 				{0,0,0,9,2,0,0,0,3,0,9,0,2,0,0,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,2,0,9,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,2,0,0,0},
		 				{0,0,0,0,2,0,0,0,3,0,0,0,2,0,0,0},
		 				{1,1,1,1,2,0,0,0,3,0,0,0,2,0,0,0},
		 				{0,0,0,0,0,0,0,0,1,1,1,1,2,0,0,0},
		 				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 	};
		int[][]  pt3 = {{2,2},{3,5},{7,2},{10,5},{14,6}};
		int[] e3= {20,20,1};
		Map stage3 = new Map("chapter3","stage3.png",chap3,e3 , 0, 9, 7, 3,5,10000,pt3);
		listmaps.add(stage3);
		System.out.println(listmaps.size()+" fuckkkkkkkkkk");
	}
	public void setDefaultCharacter() {
		Sniper pang = new Sniper("pang",5,1500,50,10,"aquapang.png","sniperlogo.png");
		Nuker toei = new Nuker("toei",5,1000,200,3,"oneshottoei.png","nukerlogo.png");
		Engineer earth = new Engineer("earth",5,50,10,4,"Earthbreak.png","engineerlogo.png");
		Assault pai = new Assault("pai",5,100,7,5,"paiwind.png","assualtlogo.png");
//		sniper pang = new sniper("pang",5,0,300,10,"aquapang.png","sniperlogo.png");
//		nuker toei = new nuker("toei",5,0,100,3,"oneshottoei.png","nukerlogo.png");
//		engineer earth = new engineer("earth",5,0,10,4,"Earthbreak.png","engineerlogo.png");
//		assault pai = new assault("pai",5,0,7,5,"paiwind.png","assualtlogo.png");
		hero.add(pang);
		hero.add(toei);
		hero.add(earth);
		hero.add(pai);
		
		for(int i=0;i<20;i++)hero.add(new Assault("soldier "+i,1,100,10,3,"NoobChic.png","sniperlogo.png"));
		myhero.add(earth);
	}
	public  List<Character> getHero() {
		return hero;
	}
	public  List<Character> getMyhero() {
		return myhero;
	}
	public static int getMoney() {
		return money;
	}
	public static int[] getTypesummon() {
		return typesummon;
	}
	public Character randomchar(int type) {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		x = x % hero.size();
		if(type == 1)x=x%5;
		Character gethero = null;
		if (hero.get(x) instanceof Nuker) {
			gethero = new Nuker((Nuker)hero.get(x));
		}
		else if (hero.get(x) instanceof Sniper) {
			gethero = new Sniper((Sniper)hero.get(x));
		}
		else if (hero.get(x) instanceof Engineer) {
			gethero = new Engineer((Engineer)hero.get(x));
		}
		else {
			gethero = new Assault((Assault)hero.get(x));
		}
		return gethero;
		
	}
	public void decreaseMoney(int i) {
		// TODO Auto-generated method stub
		EarthGameModel.money-=i;
		
	}
	public  List<Map> getListmaps() {
		return listmaps;
	}
	public static int getTempexp() {
		return tempexp;
	}
	
}
