package Controller;

import Items.CanHo;
import Items.Items;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemController {
	
	@FXML
	private Label thang;

	@FXML
	private Label tien;

	@FXML
	private Label time;

	@FXML
	private Label trangThai;

    private Items items;
	
	public void setData(Items items) {
		this.items = items;
		thang.setText("Thang " + items.getThang());
		tien.setText(items.getTien() + "VND");
		trangThai.setText(items.getTrangThai());
		time.setText(String.valueOf(items.getTime()));
	}
}