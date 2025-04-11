package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Items.CanHo;
import Model.Model;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class TrangChuController implements Initializable {
	@FXML
	private Button exit_btn;

	@FXML
	private GridPane grid;

	@FXML
	private Button login_btn;

	@FXML
	private ScrollPane scroll;

	private List<CanHo> canHo = new ArrayList<>();

	private List<CanHo> getData() {
		List<CanHo> canHos = new ArrayList<>();
		CanHo canHo;

		for (int i = 0; i < 20; i++) {
			canHo = new CanHo(1, 1, "301", "dang_trong", "abc", 30, 100);
			canHos.add(canHo);
		}

		return canHos;
	}

	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		canHo.addAll(getData());
		int column = 0;
		int row = 1;

		for (int i = 0; i < canHo.size(); i++) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/FXMLFile/Login/CanHo.fxml"));
			AnchorPane anchorPane;
			try {
				anchorPane = fxmlLoader.load();

				CanHoController canHoController = fxmlLoader.getController();
				canHoController.setData(canHo.get(i));

				if (column == 3) {
					column = 0;
					row++;
				}

				grid.add(anchorPane, column++, row);

				grid.setMinWidth(Region.USE_COMPUTED_SIZE);
				grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
				grid.setMaxWidth(Region.USE_PREF_SIZE);

				grid.setMinHeight(Region.USE_COMPUTED_SIZE);
				grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
				grid.setMaxHeight(Region.USE_PREF_SIZE);

				GridPane.setMargin(anchorPane, new Insets(10));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		login_btn.setOnAction(event -> onLogin());
		exit_btn.setOnAction(event -> onExit());

	}

	private void onLogin() {
		Model.getInstance().getViewFactory().showDangNhap();
	}

	private void onExit() {
		Stage stage = (Stage) exit_btn.getScene().getWindow();
		Model.getInstance().getViewFactory().closeStage(stage);

	}

}