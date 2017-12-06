package view;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.EarthGameModel;
import model.InGameLogic;
import model.atkanimation;
import model.character;
import model.enemy;
import model.map;




public class InGame {
	private Stage primaryStage;
	private EarthGameModel model;
	private Canvas game;
	private String command ="";
	int frame=1;
	public InGame(Stage primaryStage,EarthGameModel model) {
		this.model=model;
		this.primaryStage=primaryStage;
		BorderPane root =new BorderPane();
		List<character> selectedHero = new ArrayList<>();
		HBox hbx = new HBox();
		Button end = new Button("goback");
		Button stage1 = new Button("Stage 1 need "+model.getListmaps().get(0).getnTower()+" heros");
		stage1.setOnAction(event-> {
			if(selectedHero.size() == model.getListmaps().get(0).getnTower())
				drawPreGame(model.getListmaps().get(0),selectedHero);
		});
		Button stage2 = new Button("Stage 2 need "+model.getListmaps().get(1).getnTower()+" heros");
		stage2.setOnAction(event-> {
			if(selectedHero.size() == model.getListmaps().get(1).getnTower())
				drawPreGame(model.getListmaps().get(1),selectedHero);
			//startGame(primaryStage, model.getListmaps().get(1), selectedHero);
		});
//		Button stage3 = new Button("Stage 3 need "+model.getListmaps().get(2).getnTower()+" heros");
//		stage3.setOnAction(event-> {
//			if(selectedHero.size() == model.getListmaps().get(2).getnTower())
//			startGame(primaryStage, model.getListmaps().get(2), selectedHero);
//		});
		end.setOnAction(event -> {
			EarthGameView.drawHome();
			
		});
		hbx.getChildren().addAll(stage1,stage2,end);
		root.setTop(hbx);


		
		//char sle
		StackPane home = new StackPane();
		Canvas chome = new Canvas(480,640);
		GraphicsContext gc = chome.getGraphicsContext2D();
		
		BorderPane charselection = new BorderPane();
		GridPane innerPane = new GridPane();
		int k=0;
		for(character i : model.getMyhero()) {
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
				selectedHero.add(i);
				temp.setText("X");
			});
	        temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        innerPane.add(temp, k % 8, k /8, 1, 1);
	       
	        k++;
		}
		charselection.setCenter(innerPane);
		home.getChildren().addAll(chome,charselection);
		root.setCenter(home);
		Scene scene = new Scene(root);
		this.primaryStage.setScene(scene);
		
	}
	private void drawPreGame(map map, List<character> selectedHero) {
		// TODO Auto-generated method stub
		List<character> Hero = new ArrayList<>();
		BorderPane bdpane = new BorderPane();
		StackPane base = new StackPane();
		GridPane grid = new GridPane();
		Canvas c = new Canvas(640,480);
		bdpane.setCenter(base);
		base.getChildren().addAll(c,grid);
		GraphicsContext gc = c.getGraphicsContext2D();
		map.draw(gc);
		Button start = new Button("StartGame");
		start.setOnAction(event ->{
			startGame(this.primaryStage,map, Hero);
		});
		HBox hb = new HBox();
		hb.getChildren().add(start);
		for(character i : selectedHero) {
			Button temp = new Button(i.getName());
			temp.setOnAction((event)->
			{	if(!Hero.contains(i)) {
				Hero.add(i);
				temp.setText((Hero.size())+"");
				}
			});
			hb.getChildren().add(temp);
		}
		bdpane.setTop(hb);
		Scene scene = new Scene(bdpane);
		this.primaryStage.setScene(scene);
		
	}
	public void startGame(Stage stage,map curStage,List<character> usehero) {
		System.out.println("1");
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		
		stage.setTitle("Tank game");
		
		InGameLogic logic = new InGameLogic(curStage,usehero);
		GameScreen gameScreen = new GameScreen(640.0, 480.0,logic);
		addListener(gameScreen);
		root.getChildren().add(gameScreen);
		stage.setScene(scene);
		gameScreen.requestFocus();
//		Thread animation = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(!(logic.isGameEnd() && curStage.getListEnemy().size() == 0 || logic.getLife() == 0 || logic.isNoEnemy() && logic.getTempE().size()==0)) {
//					gameScreen.paintComponent();
//					logic.update(frame);
//					if(command.contains("k"))System.out.println("killall");
//					frame++;
//					try {
//						Thread.sleep(16);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					//model.logicUpdate();
//					//InputUtility.updateInputState();
//				}
//				alert();
//			}
//		});
//		animation.start();
//		//alert();
//		//EarthGameView.drawHome();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				
				//System.out.println(""+logic.getLife()+"  "+logic.isNoEnemy()+"  "+logic.getTempE());
				if( logic.getLife() == 0 || logic.isNoEnemy() && logic.getTempE().size()==0) {
					this.stop();
					logic.newGame();
					model.decreaseMoney(-1*(curStage.getMoneyFromMap()));
					System.out.println(model.getMoney());
					//alert
					//animation.
	                //alert();
	                
					EarthGameView.drawHome();
					
					
					
				}
				
				logic.update(frame,gameScreen);
				if(command.contains("k"))System.out.println("killall");
				frame++;
				
			
			//	model.logicUpdate();
				
			//	InputUtility.updateInputState();
				try {
					Thread.sleep(32);
				} catch (InterruptedException e) {
					e.printStackTrace();
					// TODO Auto-generated catch block
				}
			}
		
		};
		animation.start();
		//animation.stop();
		//EarthGameView.drawHome();
		System.out.println(1234567);
		
	}
	public void alert() {
		Alert alert = new Alert(AlertType.CONFIRMATION,"Clear Mission", ButtonType.OK);
        alert.setTitle("Clear");
      
        alert.setHeaderText("");
        alert.showAndWait();
	}
	private void addListener(GameScreen gameScreen) {
		// TODO Auto-generated method stub
		gameScreen.setOnMouseMoved(value -> {
			System.out.println(value.getX());
		});
		gameScreen.setOnKeyPressed(event -> {
			System.out.println(event.getText());
			if(event.getText()== "k") {
			command += "k";
			}
		});
		gameScreen.setOnKeyReleased(event ->{
			if(event.getText() == "k") {
				command.replaceAll("k", "");
			}
		});
	}
	private void killall() {
		// TODO Auto-generated method stub
		for(int i = InGameLogic.listEntities.size()-1 ;i>=0;i++) {
			if(InGameLogic.listEntities.get(i) instanceof enemy)((enemy)InGameLogic.listEntities.get(i)).setDestroyed(true);
		}
		
	}

}
