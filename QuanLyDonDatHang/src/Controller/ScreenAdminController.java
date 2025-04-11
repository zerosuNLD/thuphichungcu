package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScreenAdminController implements Initializable{

	@FXML
	private BorderPane ScreenAdmin;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty()
				.addListener((observableValue, oldVal, newVal) -> {
					switch (newVal) {

					case "QLPhi" -> ScreenAdmin.setCenter(Model.getInstance().getViewFactory().getQLThuPhiView());
					
					case "ChiTietThang" -> ScreenAdmin.setCenter(Model.getInstance().getViewFactory().getChiTietThangView());
					
					case "QLTaiKhoan" -> ScreenAdmin.setCenter(Model.getInstance().getViewFactory().getQlTaiKhoanView());

					case "TraCuu" -> ScreenAdmin.setCenter(Model.getInstance().getViewFactory().getTraCuuCanHoView());
					
					case "ChiTietCanHo" ->  ScreenAdmin.setCenter(Model.getInstance().getViewFactory().getChiTietCanHoView());
					
					case "LogOut" -> { 
						Stage stage = (Stage) ScreenAdmin.getScene().getWindow();
						Model.getInstance().getViewFactory().showLoginScreen();
						Model.getInstance().getViewFactory().closeStage(stage);
					}

					default -> ScreenAdmin.setCenter(Model.getInstance().getViewFactory().getPhiView());

					}

				});
	}
	
}