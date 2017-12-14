package view;


import java.util.ArrayList;
import java.util.List;

import Character.Dummy;
import MyException.MyException;
import Character.Character;
import atkAnimation.atkanimation;
import atkAnimation.skillAnimation;
import enemy.Enemy;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import model.ButtonAtHome;
import model.EarthGameModel;
import model.InGameLogic;
import model.Map;




public class InGame {
	private static AudioClip bgm = new AudioClip(ClassLoader.getSystemResource("fight.mp3").toString());
	private static AudioClip skillsound = new AudioClip(ClassLoader.getSystemResource("skill.wav").toString());
	private double mx=0,my=0;
	private Stage primaryStage;
	private EarthGameModel model;
	private Canvas game;
	private String command ="";
	private InGameLogic logic;
	private Character adhero= null;
	int heronow =0;
	int k=0;
	//public static AllPhoto pic ;
	int frame=1;
	
	public InGame(Stage primaryStage,EarthGameModel model) {
		this.model=model;
		bgm.setVolume(0.2);
		Thread music = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("BGM");
				while(bgm.isPlaying() == false)bgm.play();
				
			}
		});
		music.setDaemon(true);
		music.start();
		Canvas c = new Canvas(640,480);
		//this.pic = new AllPhoto();
		this.primaryStage=primaryStage;
		BorderPane root =new BorderPane();
		List<Character> selectedHero = new ArrayList<>();
		VBox vbx = new VBox();
		ButtonAtHome end = new ButtonAtHome("goback");
		Button stage1 = new Button("Stage 1 need "+model.getListmaps().get(0).getnTower()+" heros");
		stage1.setOnAction(event-> {
			System.out.println(model.getListmaps().size());
			if(selectedHero.size() == model.getListmaps().get(0).getnTower())
				drawPreGame(model.getListmaps().get(0),selectedHero);
			else {
				try {
					throw new MyException("Number of Hero don't match with the map");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Button stage2 = new Button("Stage 2 need "+model.getListmaps().get(1).getnTower()+" heros");
		stage2.setOnAction(event-> {
			System.out.println(selectedHero.size());
			if(selectedHero.size() == model.getListmaps().get(1).getnTower()) {
				System.out.println("earth");
				drawPreGame(model.getListmaps().get(1),selectedHero);
			}
			else {
				try {
					throw new MyException("Number of Hero don't match with the map");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//startGame(primaryStage, model.getListmaps().get(1), selectedHero);
		});
		Button stage3 = new Button("Stage 3 need "+model.getListmaps().get(2).getnTower()+" heros");
		stage3.setOnAction(event-> {
			System.out.println(selectedHero.size());
			if(selectedHero.size() == model.getListmaps().get(2).getnTower())
				drawPreGame(model.getListmaps().get(2),selectedHero);
			else {
				try {
					throw new MyException("Number of Hero don't match with the map");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		end.setOnAction(event -> {
			bgm.stop();
			music.stop();
			EarthGameView.drawHome();
			
		});
		vbx.getChildren().addAll(stage1,stage2,stage3,end);
		root.setLeft(vbx);


		
		//char sle
		
		StackPane home = new StackPane();
		Text nHero =new Text("selected hero : "+this.heronow);
		
		Canvas chome = new Canvas(520,680);
		GraphicsContext gc = chome.getGraphicsContext2D();
		Image img = new Image("homepage.jpeg");
		gc.drawImage(img, 0, 0);
		BorderPane charselection = new BorderPane();
		GridPane innerPane = new GridPane();
		int k=0;
		for(Character i : model.getMyhero()) {
			Button temp = new Button(i.getID()+"");
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
			temp.setOnAction((event)->
			{
				if(!selectedHero.contains(i)) {
					selectedHero.add(i);
					temp.setText("X");
					heronow++;
					nHero.setText("selected hero : "+this.heronow);
				}
				else {
					temp.setText(i.getID()+"");
					selectedHero.remove(i);
					heronow--;
					nHero.setText("selected hero : "+this.heronow);
				}
				
			});
	        temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        innerPane.add(temp, k % 8, k /8, 1, 1);
	       
	        k++;
		}
		charselection.setCenter(innerPane);
		home.getChildren().addAll(chome,charselection);
		
		root.setRight(nHero);
		root.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
		root.setCenter(home);
		Scene scene = new Scene(root);
		this.primaryStage.setScene(scene);
		
	}
	private void drawPreGame(Map Map, List<Character> selectedHero) {
		// TODO Auto-generated method stub
		List<Character> Hero = new ArrayList<>();
		Character addHero = null;
		BorderPane bdpane = new BorderPane();
		StackPane base = new StackPane();
		//GridPane grid = new GridPane();
		Canvas c = new Canvas(960,720);
		
		
		bdpane.setCenter(base);
		base.getChildren().addAll(c);
		GraphicsContext gc = c.getGraphicsContext2D();
		Map.draw(gc);
		Map.drawadd(gc);
		c.setOnMouseMoved(value->{
			this.mx = value.getX();
			this.my = value.getY();
			System.out.println((int)(this.mx/60)+" "+(int)(this.my/60));
		});
		c.setOnMouseClicked(value->{
			int X=(int)(this.mx/60);
			int Y =(int)(this.my/60);
			if(Map.getMapInfo()[Y][X] == 9) {
			
			this.adhero.setPosX(X);
			this.adhero.setPosY(Y);
			Image img = new Image(this.adhero.getLogoUrl(),60,60,false,false);
			gc.drawImage(img,X*60 , Y*60);
			System.out.println(this.adhero.getName()+"  is located at : "+(int)(this.mx/40)+" , "+(int)(this.my/40));
			}
		});
		
		Button start = new Button("StartGame");
		start.setOnAction(event ->{
			startGame(this.primaryStage,Map, selectedHero);
		});
		HBox hb = new HBox();
		hb.getChildren().add(start);
		for(Character i : selectedHero) {
			Button temp = new Button(i.getName());
			temp.setOnAction((event)->
			{
				adhero = i;
			});
			hb.getChildren().add(temp);
		}
		bdpane.setTop(hb);
		Scene scene = new Scene(bdpane);
		c.requestFocus();
		this.primaryStage.setScene(scene);
		
	}
	public void startGame(Stage stage,Map curStage,List<Character> usehero) {
		System.out.println("1");
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		
		stage.setTitle("Earth Game laaa");
		
		logic = new InGameLogic(curStage,usehero);
		GameScreen gameScreen = new GameScreen(920.0, 720.0,logic);
		addListener(gameScreen);
		root.getChildren().add(gameScreen);
		stage.setScene(scene);
		gameScreen.requestFocus();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				
				//System.out.println(""+logic.getLife()+"  "+logic.isNoEnemy()+"  "+logic.getTempE());
				if(logic.getLife() == 0 ) {
					this.stop();
					logic.newGame();
					//model.decreaseMoney(-1*(curStage.getMoneyFromMap()));
					//System.out.println(model.getMoney());
					bgm.stop();
	                alertFail();
	                EarthGameView.drawClearGame("Fail");
	                	
					
				}
				else if(  logic.isNoEnemy() && logic.getTempE().size()==0) {
					this.stop();
					logic.newGame();
					model.decreaseMoney(-1*(curStage.getMoneyFromMap()));
					System.out.println(model.getMoney());
					bgm.stop();
	                alert();
	                EarthGameView.drawClearGame("Clear");
	                	
				}
				
				logic.update(frame,gameScreen);
				if(command.contains("k"))System.out.println("killall");
				frame++;

				try {
					Thread.sleep(32);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			
		
		};
		animation.start();
	
		System.out.println(1234567);
		
		}
	public void alertFail() {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.ERROR,"Mission Fail !\nYou NOOB",ButtonType.OK);
        alert.setTitle("Fail");
      
        alert.setHeaderText("");
        alert.show();
		
	}
	public void alert() {
		Alert alert = new Alert(AlertType.CONFIRMATION,"Clear Mission !\nYou curent Money is "+model.getMoney(), ButtonType.OK);
        alert.setTitle("Clear");
      
        alert.setHeaderText("");
        alert.show();
	}
	private void addListener(GameScreen gameScreen) {
		// TODO Auto-generated method stub
		gameScreen.setOnMouseMoved(value -> {
			
			this.mx = value.getX();
			this.my = value.getY();
			System.out.println(this.mx +"  "+this.my);
		});
		gameScreen.setOnKeyPressed(event -> {
			
			if(event.getCode() == KeyCode.K) {
			System.out.println("mouse @ : "+this.mx+" "+this.my);
			if(logic.getSP()-10>=0) {
				skillsound.play();
				logic.lockedskill(this.mx,this.my);
				logic.setSP(logic.getSP()-10);
				Dummy temp = new Dummy(this.mx,this.my);
				atkanimation skillAtk = new skillAnimation(temp,frame);
				
				InGameLogic.getListEntities().add(skillAtk);
			}
			}
			if(event.getCode()==KeyCode.Q) {
				logic.setLife(0);
			}
		});
		gameScreen.setOnKeyReleased(event ->{
			if(event.getText() == "k") {
				command.replaceAll("k", "");
			}
		});
	}
	

}
