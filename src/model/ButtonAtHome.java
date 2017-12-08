package model;

import javafx.scene.control.Button;

public class ButtonAtHome extends Button {
		public ButtonAtHome(String name) {
			super(name);
			this.setStyle("-fx-min-height: 40px;\n" + 
			"    -fx-min-width: 100px;"
			+ "-fx-background-image: url(button1.png);"
					+ "-fx-text-color:white;");
		}

}
