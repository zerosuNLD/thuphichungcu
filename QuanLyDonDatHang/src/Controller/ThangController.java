package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThangController {
	@FXML
	private Label thang;

	public void setData(int i) {
		thang.setText("Thang " + i);
	}
}