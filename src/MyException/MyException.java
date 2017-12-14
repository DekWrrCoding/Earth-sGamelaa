package MyException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class MyException extends Exception {
	public MyException(String s) {
		Alert alert = new Alert(AlertType.ERROR,s, ButtonType.OK);
        alert.setTitle("ERROR");
      
        alert.setHeaderText("");
        alert.show();
	}
}
