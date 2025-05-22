package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Items.Items;
import Model.Model;
import Model.PaymentInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class LichSuController implements Initializable{

	@FXML
	private GridPane grid;

	@FXML
	private ScrollPane scroll;


	private List<Items> items = new ArrayList<>();

	private List<Items> getData() {
		List<Items> items = new ArrayList<>();
		Items item;

		for (int i = 1; i < 13; i++) {
			PaymentInfo paymentInfo = Model.getInstance().getMonthlyPaymentInfo(i, 2024);
			item = new Items(i,paymentInfo.getAmount(), paymentInfo.getStatus(), paymentInfo.getPaymentDate());
			items.add(item);
		}

		return items;
	}

	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		items.addAll(getData());
		int column = 0;
		int row = 1;

		for (int i = 0; i < items.size(); i++) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/FXMLFile/User/LichSu/item.fxml"));
			AnchorPane anchorPane;
			try {
				anchorPane = fxmlLoader.load();

				ItemController itemController = fxmlLoader.getController();
				itemController.setData(items.get(i));

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}