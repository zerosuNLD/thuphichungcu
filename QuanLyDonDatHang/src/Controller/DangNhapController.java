package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DangNhapController implements Initializable {
	@FXML
	private TextField account;

	@FXML
	private ChoiceBox<String> choose_box;

	@FXML
	private AnchorPane login;

	@FXML
	private Button exit_btn;

	@FXML
	private Button login_btn;

	@FXML
	private PasswordField password;

	private int Choice = -1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] choices = { "Quản lý", "Người dùng"};

		// Đưa danh sách các lựa chọn vào ChoiceBox
		choose_box.getItems().addAll(choices);

		login_btn.setOnAction(event -> onLogin());
		exit_btn.setOnAction(event -> onExit());
		choose_box.setOnAction(event -> onChoiceBox());
	}

	private void onLogin() {
		switch (Choice) {

		case 0 -> {
			Stage stage = (Stage) login_btn.getScene().getWindow();
			Model.getInstance().getViewFactory().showScreenAdmin();
			Model.getInstance().getViewFactory().closeStage(stage);
			
		}

		case 1 -> {
			Stage stage = (Stage) login_btn.getScene().getWindow();
			Model.getInstance().getViewFactory().showDVBHScreen();
			Model.getInstance().getViewFactory().closeStage(stage);
		}

		case -1 -> {
			Model.getInstance().getViewFactory().showThongBao();
		}
		
		}
	}

	private void onExit() {
		Stage stage = (Stage) login_btn.getScene().getWindow();
		Model.getInstance().getViewFactory().closeStage(stage);
	}

	private void onChoiceBox() {
		String selectedChoice = choose_box.getValue();
		System.out.println("Selected choice: " + selectedChoice);

		if (selectedChoice.equals("Quản lý")) {
			Choice = 0;
		} else if (selectedChoice.equals("Người dùng")) {
			Choice = 1;
		} 
	}

	@FXML
	private void onChooseButtonClicked() {
		// Hiển thị ChoiceBox khi nút choose_btn được nhấn
		choose_box.show();
	}
}
