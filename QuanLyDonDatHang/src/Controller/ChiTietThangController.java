package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Model.Model;
import Model.MonthlyRoomPaymentInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class ChiTietThangController implements Initializable {
	@FXML
	private GridPane grid;

	@FXML
	private ScrollPane scroll;
	
    @FXML
    private Label title;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int column = 0;
		int row = 1;
		int selectedMonth = Model.getInstance().getSelectedMonth(); // Lấy tháng đã chọn
	    List<MonthlyRoomPaymentInfo> paymentList = Model.getInstance().getMonthlyRoomPaymentList(selectedMonth, 2024);
	    title.setText("Danh sách đóng thuế từng căn hộ tháng " + String.valueOf(selectedMonth));
		
	    for (int i = 0; i < paymentList.size(); i++) {
	    	MonthlyRoomPaymentInfo room = paymentList.get(i); // Lấy dữ liệu

	    	FXMLLoader fxmlLoader = new FXMLLoader();
	    	fxmlLoader.setLocation(getClass().getResource("/FXMLFile/admin/QLThuPhi/thueCanHo.fxml"));
	    	AnchorPane anchorPane;
	    	try {
	    		anchorPane = fxmlLoader.load();

	    		// Gọi controller và truyền dữ liệu
	    		ThueCanHoController thueCanHoController = fxmlLoader.getController();
	    		thueCanHoController.setData(room); // Truyền đối tượng dữ liệu
	    		thueCanHoController.loadData();    // Gọi hàm cập nhật giao diện

	    		anchorPane.setOnMouseClicked(event -> {
	    			Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("ChiTietCanHo");
	    		});

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

	    		GridPane.setMargin(anchorPane, new Insets(10));

	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }

	}

}