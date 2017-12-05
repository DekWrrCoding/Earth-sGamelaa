package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.ButtonAtHome;
import model.EarthGameModel;
import model.character;

public class EarthGameView {
	private static final Font TEXT_FONT = new Font("Monospace", 40);
	private static final int EARTH_WIDTH = 480;
	private static final int EARTH_HEIGHT = 640;
	private static EarthGameModel model;
	private static Stage primaryStage;
	
	
	public EarthGameView(EarthGameModel model,Stage primaryStage) {
	this.model = model;
	this.primaryStage = primaryStage;
	}
	
	public static void drawCharSelection() {
		StackPane home = new StackPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		drawBackground(gc);
		BorderPane charselection = new BorderPane();
		GridPane innerPane = new GridPane();
		int k=0;
		for(character i : model.getMyhero()) {
			//Image logo = new Image(i.getLogoUrl());
			System.out.println(""+i.getID()+" "+i.getName()+" "+i.getLogoUrl()+" "+i.getLocol());
			ButtonAtHome temp = new ButtonAtHome(i.getID()+"");//(i.getName()+"( * "+i.getStar()+")");
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
				drawHero(i);
			});
	        temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        innerPane.add(temp, k % 8, k / 8, 1, 1);
	        //GridPane.setHgrow(temp, Priority.ALWAYS);

	        //GridPane.setVgrow(temp, Priority.ALWAYS);
	        k++;
		}
		HBox menubar =new HBox();
		ButtonAtHome goback = new ButtonAtHome("<==");
		goback.setOnAction((event)->{
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

	private static void drawHero(character i) {
		// TODO Auto-generated method stub
		StackPane home = new StackPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		HBox hbx = new HBox();
		drawBackground(gc);
		
		hbx.setSpacing(10);
		ButtonAtHome goback = new ButtonAtHome("<==");
		goback.setOnAction((event)->{
			drawCharSelection();
		});
		hbx.getChildren().add(goback);
		//drawBackground(gc);
		home.getChildren().add(chome);
		BorderPane hero = new BorderPane();
		Canvas topbar = new Canvas();
		Text heroInfo = new Text("Lv : "+i.getLv()+"\t"+i.getName()+"\t"+i.getExp()+"/"+i.getMaxexplv()[i.getLv()]+" ( * "+i.getStar()+")");
		heroInfo.setFill(Color.ALICEBLUE);
		hbx.getChildren().add(heroInfo);
		hero.setTop(hbx);
		HBox upgradebar = new HBox();
		upgradebar.setAlignment(Pos.CENTER);
		ButtonAtHome up = new ButtonAtHome("Upgrade");
		up.setOnAction((event)->{
			drawSacrifice(i);
		});
		upgradebar.getChildren().add(up);
		hero.setBottom(upgradebar);

		home.getChildren().add(hero);
		
		hbx.setAlignment(Pos.CENTER);
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
	}

	private static void drawSacrifice( character hero) {
		// TODO Auto-generated method stub
		int expForUpgrade = 0;
		StackPane home = new StackPane();
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		drawBackground(gc);
		BorderPane charselection = new BorderPane();
		GridPane innerPane = new GridPane();
		int k=0;
		for(character i : model.getMyhero()) {
			if (i.getID() != hero.getID()) {
				ButtonAtHome temp = new ButtonAtHome(i.getID()+"");
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
				temp.setOnAction((event) -> {
					System.out.println(i.getName() + i.isMaterail() + "");
					if (i.isMaterail() == false) {
						model.tempexp += i.getExp()+character.getMaxexplv()[i.getLv()-1];
						temp.setText("" + (i.getExp()+character.getMaxexplv()[i.getLv()]-1));
					} else {
						model.tempexp -= i.getExp()+character.getMaxexplv()[i.getLv()-1];
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
			hero.gainExp(model.tempexp);
			model.tempexp=0;
			for(int j=model.getMyhero().size()-1;j>=0;j--) {
				if(model.getMyhero().get(j).isMaterail() == true) {
					model.getMyhero().remove(j);
				}
			}
			drawHero( hero);
		});
		ButtonAtHome goback = new ButtonAtHome("<==");
		goback.setOnAction((event)->{
			for(character i: model.getMyhero()) {
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
		
		StackPane home = new StackPane();
		//home.setSpacing(5);
		home.setPadding(new Insets(10));
		Canvas chome = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = chome.getGraphicsContext2D();
		gc.setFill(Color.AQUA);
		Font f = TEXT_FONT;
		gc.setFont(f);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("Earth's \nGame eiei", chome.getWidth()/2, chome.getHeight()/2);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(0, 0,chome.getWidth(), chome.getHeight());
		
		drawBackground(gc);
		HBox menubar = new HBox();
		menubar.setPadding(new Insets(10));
		menubar.setAlignment(Pos.BOTTOM_CENTER);
		menubar.setSpacing(10);
		ButtonAtHome Character = new ButtonAtHome("Army");
		Character.setOnAction((event) ->{
			drawCharSelection();
		});
		ButtonAtHome Play = new ButtonAtHome("Play");
		Play.setOnAction(event -> {
			InGame game = new InGame(primaryStage,model);
		});
		ButtonAtHome Shop = new ButtonAtHome("Shop");
		Shop.setOnAction((event) ->{
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
		home.setPadding(new Insets(10));
		Canvas cChar = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = cChar.getGraphicsContext2D();
		Image img = new Image("shoppage.png");
		gc.drawImage(img, 0, 0);
	
		HBox menubar = new HBox();
		menubar.setSpacing(15);
		ButtonAtHome normalSummon = new ButtonAtHome("Normol 10G");
		normalSummon.setOnAction(
				(event)->{
					character temp = summon(0);
					drawSummon( 0,temp);
				}
				);
		ButtonAtHome epicSummon = new ButtonAtHome("Epic 99G");
		epicSummon.setOnAction(
				(event)->{
					character temp = summon(1);
					drawSummon( 1,temp);
				}
				);
		menubar.getChildren().addAll(normalSummon,epicSummon);
		
		HBox topbar = new HBox();
		ButtonAtHome gotoHome = new ButtonAtHome("goBack");
		gotoHome.setOnAction((event)->{
			drawHome();
		});
		Text curMoney = new Text("Money : "+model.getMoney());
		topbar.setSpacing(15);
		topbar.getChildren().addAll(gotoHome,curMoney);
		BorderPane menu = new BorderPane();
		menu.setTop(topbar);
		menu.setBottom(menubar);
		
		home.getChildren().addAll(cChar,menu);
		topbar.setAlignment(Pos.TOP_CENTER);
		menubar.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		
	}
	
	private static void drawSummon(int type,character charhero) {
		// TODO Auto-generated method stub
		StackPane home = new StackPane();
		home.setPadding(new Insets(10));
		Canvas cChar = new Canvas(EARTH_WIDTH,EARTH_HEIGHT);
		GraphicsContext gc = cChar.getGraphicsContext2D();
		Image bg = new Image(charhero.getImgUrl());
		gc.drawImage(bg,0,0);
		HBox menubar = new HBox();
		menubar.setSpacing(15);
		ButtonAtHome again = new ButtonAtHome("Again");
		again.setOnAction((event)->{
			character temp = summon(type);
			drawSummon(type,temp);
		});
		ButtonAtHome confirm = new ButtonAtHome("Confirm");
		confirm.setOnAction((event)->{
			drawHome();
		});
		menubar.getChildren().addAll(again,confirm);
		
		HBox topbar = new HBox();
		ButtonAtHome gotoHome = new ButtonAtHome("goBack");
		gotoHome.setOnAction((event)->{
			drawHome();
		});
		Text heroName = new Text(charhero.getName());
		Text G = new Text("Remaing money : "+model.getMoney());
		topbar.setSpacing(15);
		topbar.getChildren().addAll(gotoHome,heroName,G);
		BorderPane menu = new BorderPane();
		menu.setTop(topbar);
		menu.setBottom(menubar);
		
		home.getChildren().addAll(cChar,menu);
		topbar.setAlignment(Pos.TOP_CENTER);
		menubar.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		
		Scene scene = new Scene(home);
		primaryStage.setScene(scene);
		
	}
	
	private static character summon(int type) {
		if (model.getMoney()-model.getTypesummon()[type] >= 0) {
			character tempchar = model.randomchar(type);
			model.decreaseMoney(model.getTypesummon()[type]);
			model.getMyhero().add(tempchar);
			String temp = "";
			for (character i : model.getMyhero()) {
				temp += i.getName() + "\n";
			}
			System.out.println(temp);
			return tempchar;
		}
		return null;
		
		
	}
}
