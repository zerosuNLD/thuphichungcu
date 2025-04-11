package FXMLFile.admin.TraCuuCanHo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class TraCuuCanHoController implements Initializable{
	@FXML
	private GridPane grid;

	@FXML
	private ScrollPane scroll;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int column = 0;
		int row = 1;

		for (int i = 1; i < 13; i++) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/FXMLFile/admin/TraCuuCanHo/canHoPhuHop.fxml"));
			AnchorPane anchorPane;
			try {
				anchorPane = fxmlLoader.load();

//				ThueCanHoController thueCanHoController = fxmlLoader.getController();
//				thueCanHoController.setData(i);
				
				anchorPane.setOnMouseClicked(event -> {
//					System.out.println("Đã click vào tháng " + thang);
					// Gọi hàm mở giao diện chi tiết tháng
					Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("ChiTietCanHo");
				});

				
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

				GridPane.setMargin(anchorPane, new Insets(25));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}