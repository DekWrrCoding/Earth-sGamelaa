package model;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ButtonAtHome extends Button {
		public ButtonAtHome(String name) {
			super(name);
			Color cl = Color.ALICEBLUE;
			
			this.setStyle("-fx-min-height: 40px;\n" + 
			"    -fx-min-width: 100px;"
			+ "-fx-background-image: url(button1.png);"
			);
		}

}
