package view;

import java.util.ArrayList;
import java.util.List;

import Character.Character;
import MyException.MyException;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ButtonAtHome;
import model.EarthGameModel;


public class EarthGameView {
	private static final Font TEXT_FONT = new Font("Merkur", 20);
	private static final int EARTH_WIDTH = 480;
	private static final int EARTH_HEIGHT = 640;
	private static EarthGameModel model;
	private static Stage primaryStage;
	private static List<Image> home;
	private static List<Image> summon;
	private static Image endImg ;
	public static Thread music;
	private static AudioClip bclick = new AudioClip(ClassLoader.getSystemResource("fire.wav").toString());
	private static AudioClip bgm = new AudioClip(ClassLoader.getSystemResource("finalBgm.mp3").toString());
	private static AudioClip fin = new AudioClip(ClassLoader.getSystemResource("fin.mp3").toString());
	private static AudioClip fail = new AudioClip(ClassLoader.getSystemResource("fail.mp3").toString());
	static int i=0;
	static int frame =0;
	
	public EarthGameView(EarthGameModel model,Stage primaryStage) {
	EarthGameView.model = model;
	EarthGameView.primaryStage = primaryStage;
	EarthGameView.home = new ArrayList<>();
	EarthGameView.summon = new ArrayList<>();
	EarthGameView.endImg = new Image("clear.png",960,720,false,false);
	
	for(int i=1;i<=23;i++) {
		String temp = ""+i;
		if(i<10)temp="0"+i;
		EarthGameView.home.add(new Image("Home/frame_apngframe"+temp+".png"));
	}
	for(int i=1;i<=62;i++) {
		String temp = ""+i;
		if(i<10)temp="0"+i;
		EarthGameView.summon.add(new Image("Summon/frame_apngframe"+temp+".png",480,640,false,false));
	}
		
	}
	public static void createCharButton(Button temp,Character i) {
		temp.setStyle("-fx-min-height: 60px;\n" + 
				"    -fx-min-width: 60px;"
				+ "-fx-background-color:"+i.getLocol()+";"
				+ "-fx-background-image: url("+i.getLogoUrl()+");"
						+ "-fx-text-color:white;");
		temp.setOnMouseEntered(event ->{
			temp.setStyle("-fx-min-height: 60px;\n" + 
					"    -fx-min-width: 60px;"
					+ "-fx-background-color:"+"gray"+";");
		});
		temp.setOnMouseExited(value ->{
			temp.setStyle("-fx-min-height: 60px;\n" + 
					"    -fx-min-width: 60px;"
					+ "-fx-background-color:"+i.getLocol()+";"
					+ "-fx-background-image: url("+i.getLogoUrl()+");"
							+ "-fx-text-color:white;");
		});
		
	}
	public static void drawCharSelection() {
		StackPane home = new StackPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		BorderPane charselection = new BorderPane();
		GridPane innerPane = new GridPane();
		HBox menubar =new HBox();
		drawBackground(gc);
		ButtonAtHome goback = new ButtonAtHome("<==");
		int k=0;
		for(Character i : model.getMyhero()) {
			ButtonAtHome temp = new ButtonAtHome(i.getID()+"");//(i.getName()+"( * "+i.getStar()+")");
			createCharButton(temp,i);
			temp.setOnAction((event)->
			{
				bclick.play();
				drawHero(i);
			});
	        temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        innerPane.add(temp, k % 8, k / 8, 1, 1);
	        k++;
		}
		goback.setOnAction((event)->{
			bclick.play();
			drawHome();
		});
		menubar.getChildren().add(goback);
		charselection.setTop(menubar);
		charselection.setCenter(innerPane);
		home.getChildren().addAll(chome,charselection);
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
	}
	private static void drawBackground(GraphicsContext gc) {
		// TODO Auto-generated method stub
		String image_path = "homepage.jpeg";
		Image bg = new Image(image_path);
		gc.drawImage(bg,0,0);
		
	}
	public static void makeCharInfo(GraphicsContext dc,Character i) {
		Image de = new Image("detail.png",250,150,false,false);
		dc.drawImage(de, 0, 0);
		dc.setFont(TEXT_FONT);
		dc.setFill(Color.ALICEBLUE);
		dc.fillText("LV :"+i.getLv()+"  Exp : "+i.getExp()+"/"+Character.getMaxexplv()[i.getLv()]+"\n"
				+ "ATK : "+i.getAttack()+"\n"
						+ "ATK Range : "+i.getAtkspeed()+"\n"
								+ "ATK Speed : "+i.getAtkspeed(), 40, 50);
	}
	private static void drawHero(Character i) {
		// TODO Auto-generated method stub
		StackPane home = new StackPane();
		BorderPane hero = new BorderPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		Canvas detail = new Canvas(250,150);
		GraphicsContext dc = detail.getGraphicsContext2D();
		GraphicsContext gc = chome.getGraphicsContext2D();
		ButtonAtHome goback = new ButtonAtHome("<==");
		ButtonAtHome up = new ButtonAtHome("Upgrade");	
		HBox hbx = new HBox();
		hbx.setAlignment(Pos.BOTTOM_CENTER);
		
		
		makeCharInfo(dc, i);
		
		
		Image img = new Image(i.getImgUrl());
		gc.drawImage(img, 0, 0);

	

		goback.setOnAction((event)->{
			bclick.play();
			drawCharSelection();
		});
		up.setOnAction((event)->{
			bclick.play();
			drawSacrifice(i);
		});
		
		hbx.getChildren().add(goback);
		hbx.getChildren().add(detail);
		hbx.getChildren().add(up);
		home.getChildren().add(chome);
		hero.setBottom(hbx);
		home.getChildren().add(hero);
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
	}

	private static void drawSacrifice( Character hero) {
		StackPane home = new StackPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		drawBackground(gc);
		BorderPane charselection = new BorderPane();
		GridPane innerPane = new GridPane();
		int k=0;
		for(Character i : model.getMyhero()) {
			if (i.getID() != hero.getID()) {
				ButtonAtHome temp = new ButtonAtHome(i.getID()+"");
				createCharButton(temp, i);
				temp.setOnAction((event) -> {
					bclick.play();
					System.out.println(i.getName() + i.isMaterail() + "");
					if (i.isMaterail() == false) {
						EarthGameModel.tempexp += i.getExp()+Character.getMaxexplv()[i.getLv()-1];
						temp.setText("" + (i.getExp()+Character.getMaxexplv()[i.getLv()]-1));
					} else {
						EarthGameModel.tempexp -= i.getExp()+Character.getMaxexplv()[i.getLv()-1];
						temp.setText(i.getName());
					}
					i.toggleMat();

				});
				temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				innerPane.add(temp, k %8,
						k / 8, 1, 1);
			
				k++;
			}
		}
		HBox menubar =new HBox();
		ButtonAtHome confirm =new ButtonAtHome("confirm");
		confirm.setOnAction(event -> {
			bclick.play();
			hero.gainExp(EarthGameModel.tempexp);
			EarthGameModel.tempexp=0;
			for(int j=model.getMyhero().size()-1;j>=0;j--) {
				if(model.getMyhero().get(j).isMaterail() == true) {
					model.getMyhero().remove(j);
				}
			}
			drawHero( hero);
		});
		ButtonAtHome goback = new ButtonAtHome("<==");
		goback.setOnAction((event)->{
			bclick.play();
			for(Character i: model.getMyhero()) {
				i.setMaterail(false);
			}
			drawHero( hero);
		});
		menubar.getChildren().addAll(goback,confirm);
		charselection.setTop(menubar);
		charselection.setCenter(innerPane);
		home.getChildren().addAll(chome,charselection);
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		
	}
	

	public static void drawHome() {
		bgm.play();
		StackPane home = new StackPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		HBox menubar = new HBox();
		menubar.setPadding(new Insets(50));
		menubar.setAlignment(Pos.BOTTOM_CENTER);
		menubar.setSpacing(20);
		
		Thread aniHome = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			
						while (true) {
							gc.drawImage(EarthGameView.home.get(i%23), 0, 0);
							i++;
							try {
								Thread.sleep(90);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				
				
			});
		aniHome.setDaemon(true);
		aniHome.start();


		ButtonAtHome Character = new ButtonAtHome("Army");
		Character.setOnAction((event) ->{
			bclick.play();
			aniHome.stop();
			drawCharSelection();
		});
		ButtonAtHome Play = new ButtonAtHome("Play");
		Play.setOnAction(event -> {
			bclick.play();
			aniHome.stop();
			EarthGameView.bgm.stop();
			InGame game = new InGame(primaryStage,model);
		});
		ButtonAtHome Shop = new ButtonAtHome("Shop");
		Shop.setOnAction((event) ->{
			bclick.play();
			aniHome.stop();
			drawCharPage();
		});
		menubar.getChildren().addAll(Character,Play,Shop);
		home.getChildren().addAll(chome,menubar);

		
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
	}
	

	private static void drawCharPage() {
		// TODO Auto-generated method stub
		StackPane home = new StackPane();
	
		Canvas cChar = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = cChar.getGraphicsContext2D();
		Image img = new Image("shoppage.png");
		gc.drawImage(img, 0, 0);
	
		HBox menubar = new HBox();
		menubar.setSpacing(15);
		ButtonAtHome normalSummon = new ButtonAtHome("Normol 10G");
		normalSummon.setOnAction(
				(event)->{
					bclick.play();
					Character temp = summon(0);
					if(temp!=null)PreDrawSummon( 0,temp);
				}
				);
		ButtonAtHome epicSummon = new ButtonAtHome("Epic 99G");
		epicSummon.setOnAction(
				(event)->{
					bclick.play();
					Character temp = summon(1);
					if(temp!=null)PreDrawSummon( 1,temp);
				}
				);
		
		
		HBox topbar = new HBox();
		ButtonAtHome gotoHome = new ButtonAtHome("goBack");
		gotoHome.setOnAction((event)->{
			bclick.play();
			drawHome();
		});
		menubar.getChildren().addAll(gotoHome,normalSummon,epicSummon);
		
		Text curMoney = new Text("Money : "+model.getMoney());
		curMoney.setFont(TEXT_FONT);
		curMoney.setFill(Color.GOLD);
		topbar.setSpacing(15);
		topbar.setPadding(new Insets(20));
		topbar.getChildren().addAll(curMoney);
		BorderPane menu = new BorderPane();
		menu.setTop(topbar);
		menu.setBottom(menubar);
		menubar.setPadding(new Insets(20));
		
		home.getChildren().addAll(cChar,menu);
		topbar.setAlignment(Pos.TOP_CENTER);
		menubar.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		
	}

	public static void drawClearGame(String earth) {
	
		StackPane home = new StackPane();
		if(earth.equals("Clear"))fin.play();
		else fail.play();
		Canvas cChar = new Canvas(640*1.5,480*1.5);
		GraphicsContext gc = cChar.getGraphicsContext2D();
		Font font = new Font("Merkur", 60*1.5);
		gc.setFont(font);
		
		Thread ani = new Thread(new Runnable() {
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true){
					gc.drawImage(EarthGameView.endImg, 0, 0);
					gc.setFill(Color.YELLOW);
					gc.fillText(earth, 230*1.5, 250*1.5);
					//clear+=earth
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		home.getChildren().addAll(cChar);
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		ani.setDaemon(true);
		ani.start();
		cChar.setOnMouseClicked(value->{
			bclick.play();
			ani.stop();
			drawHome();
		});
	}
	private static void PreDrawSummon(int type,Character charhero) {
		// TODO Auto-generated method stub
		StackPane home = new StackPane();
		home.setPadding(new Insets(10));
		Canvas cChar = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = cChar.getGraphicsContext2D();
		Thread ani = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				i=0;
				for(int i=1;i<62;i++) {
					gc.drawImage(EarthGameView.summon.get(i), 0, 0);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		home.getChildren().addAll(cChar);
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		ani.start();
		cChar.setOnMouseClicked(value->{
			bclick.play();
			drawSummon(type, charhero);
		});
	}
	private static void drawSummon(int type,Character charhero) {
		// TODO Auto-generated method stub
		StackPane home = new StackPane();
		//home.setPadding(new Insets(10));
		Canvas cChar = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = cChar.getGraphicsContext2D();
		
		Image bg = new Image(charhero.getImgUrl());
		gc.drawImage(bg,0,0);
		HBox menubar = new HBox();
		menubar.setSpacing(15);
		ButtonAtHome again = new ButtonAtHome("Again");
		again.setOnAction((event)->{
			bclick.play();
			Character temp = summon(type);
			drawSummon(type,temp);
		});
		ButtonAtHome confirm = new ButtonAtHome("Confirm");
		confirm.setOnAction((event)->{
			bclick.play();
			drawHome();
		});
		Text cMon = new Text("Money : "+model.getMoney());
		cMon.setFill(Color.GOLD);
		cMon.setFont(TEXT_FONT);
		menubar.getChildren().addAll(again,confirm,cMon);
		menubar.setPadding(new Insets(20));
		HBox topbar = new HBox();
		BorderPane menu = new BorderPane();
		//menu.setTop(topbar);
		menu.setBottom(menubar);
		
		home.getChildren().addAll(cChar,menu);
		topbar.setAlignment(Pos.TOP_CENTER);
		menubar.setAlignment(Pos.BOTTOM_CENTER);
		
	
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		
	}
	
	public static Character summon(int type) {
		if (model.getMoney()-model.getTypesummon()[type] >= 0) {
			Character tempchar = model.randomchar(type);
			model.decreaseMoney(model.getTypesummon()[type]);
			model.getMyhero().add(tempchar);
			String temp = "";
			for (Character i : model.getMyhero()) {
				temp += i.getName() + "\n";
			}
			System.out.println(temp);
			return tempchar;
		}
			else {
				try {
					throw new MyException("Not enought money");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return null;
		}
	
		
		
	}
}
