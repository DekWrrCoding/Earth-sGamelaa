package model;

import javafx.scene.control.Button;

public class ButtonAtHome extends Button {
		public ButtonAtHome(String name) {
			super(name);
			this.setStyle("-fx-text-fill:white;"
					+ "-fx-background-color: gray;"
					+ "-fx-bordor-color:black;"
					+ "-fx-bordor-width:2;");
//			this.setStyle("-fx-background-color: \n" + 
//					"        #707070,\n" + 
//					"        linear-gradient(#fcfcfc, #f3f3f3),\n" + 
//					"        linear-gradient(#f2f2f2 0%, #ebebeb 49%, #dddddd 50%, #cfcfcf 100%);\n" + 
//					"    -fx-background-insets: 0,1,2;\n" + 
//					"    -fx-background-radius: 3,2,1;\n" + 
//					"    -fx-padding: 3 30 3 30;\n" +
//					"    -fx-text-fill: black;\n" + 
//					"    -fx-font-size: 14px;");
		}

}
