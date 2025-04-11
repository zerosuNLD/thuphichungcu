package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TaskBarAdminController implements Initializable {

	@FXML
	private Button QLPhi_btn;

	@FXML
	private Button QLTaiKhoan_btn;

	@FXML
	private Button TraCuu_btn;

	@FXML
	private Button logout_btn1;

	private List<Button> allButtons;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Danh sách các nút để reset style khi nhấn
		allButtons = List.of(QLPhi_btn, QLTaiKhoan_btn, TraCuu_btn, logout_btn1);

		// Gán sự kiện click cho các nút
		QLPhi_btn.setOnAction(event -> onQLPhi());
		QLTaiKhoan_btn.setOnAction(event -> onQLTaiKhoan());
		TraCuu_btn.setOnAction(event -> onTraCuu());
		logout_btn1.setOnAction(event -> onLogout());

		// Gán hiệu ứng style khi nhấn nút
		QLPhi_btn.setOnMousePressed(event -> applyStyle(QLPhi_btn));
		QLTaiKhoan_btn.setOnMousePressed(event -> applyStyle(QLTaiKhoan_btn));
		TraCuu_btn.setOnMousePressed(event -> applyStyle(TraCuu_btn));
		logout_btn1.setOnMousePressed(event -> applyStyle(logout_btn1));
	}

	private void applyStyle(Button activeButton) {
		for (Button btn : allButtons) {
			if (btn == activeButton) {
				btn.setStyle("-fx-background-color: #d1d1d1; "
						+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 3, 0, 2, 0);");
			} else {
				btn.setStyle("-fx-background-color: #f2f2f2; -fx-effect: none;");
			}
		}
	}

	private void onQLPhi() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("QLPhi");
	}

	private void onQLTaiKhoan() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("QLTaiKhoan");
	}

	private void onTraCuu() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("TraCuu");
	}

	private void onLogout() {
		Model.getInstance().getViewFactory().showDangNhap();
		Stage currentStage = (Stage) logout_btn1.getScene().getWindow();
		currentStage.close();
	}
}
