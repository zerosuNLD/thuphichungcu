package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TaskBarController implements Initializable {

	@FXML
	private Button DongPhi_btn;

	@FXML
	private Button Hoso_btn;

	@FXML
	private Button LichSu_btn;

	@FXML
	private Button Phi_btn;

	@FXML
	private Button logout_btn1;

	private List<Button> allButtons;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Danh sách các nút để reset style khi nhấn
		allButtons = List.of(DongPhi_btn, Hoso_btn, LichSu_btn, Phi_btn, logout_btn1);

		DongPhi_btn.setOnAction(event -> onDongPhi());
		Hoso_btn.setOnAction(event -> onHoso());
		LichSu_btn.setOnAction(event -> onLichSu());
		Phi_btn.setOnAction(event -> onPhi());
		logout_btn1.setOnAction(event -> onLogout());

		DongPhi_btn.setOnMousePressed(event -> applyStyle(DongPhi_btn));
		Hoso_btn.setOnMousePressed(event -> applyStyle(Hoso_btn));
		LichSu_btn.setOnMousePressed(event -> applyStyle(LichSu_btn));
		Phi_btn.setOnMousePressed(event -> applyStyle(Phi_btn));
		logout_btn1.setOnMousePressed(event -> applyStyle(logout_btn1));
	}

	private void applyStyle(Button activeButton) {
		for (Button btn : allButtons) {
			if (btn == activeButton) {
				btn.setStyle(
						"-fx-background-color: #d1d1d1; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 3, 0, 2, 0);");
			} else {
				btn.setStyle("-fx-background-color: #f2f2f2; -fx-effect: none;");
			}
		}
	}

	private void onDongPhi() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("DongPhi");
	}

	private void onHoso() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("HoSo");
	}

	private void onLichSu() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("LichSu");
	}

	private void onPhi() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("Phi");
	}

	private void onLogout() {
		Model.getInstance().getViewFactory().showDangNhap();
		Stage currentStage = (Stage) logout_btn1.getScene().getWindow();
		currentStage.close();
	}
}
