package FXMLFile.admin.QLTaiKhoan;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Model.Model;
import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class QLTaiKhoanController implements Initializable{

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		int column = 0;
		int row = 1;
		List<User> users = Model.getInstance().getAllUsers();

		for (int i = 1; i < users.size(); i++) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			User current_userUser = users.get(i);
			fxmlLoader.setLocation(getClass().getResource("/FXMLFile/admin/QLTaiKhoan/taiKhoan.fxml"));
			AnchorPane anchorPane;
			try {
				anchorPane = fxmlLoader.load();
				taiKhoanController taiKhoanController = fxmlLoader.getController();
				taiKhoanController.setData(current_userUser);
				
//				taiKhoanController taiKhoanController = fxmlLoader.getController();
//				taiKhoanController.setData(i);
//
//				anchorPane.setOnMouseClicked(event -> {
////					System.out.println("Đã click vào tháng " + thang);
//					// Gọi hàm mở giao diện chi tiết tháng
//					Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("ChiTietThang");
//				});

				if (column == 1) {
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

				GridPane.setMargin(anchorPane, new Insets(15));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}