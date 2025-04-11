package Controller;

import Items.CanHo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CanHoController {

    @FXML
    private Label soPhong;
    
    private CanHo canHo;
    
    public void setData(CanHo canHo) {
    	this.canHo = canHo;
    	soPhong.setText(canHo.getApartmentNumber());
    }
}