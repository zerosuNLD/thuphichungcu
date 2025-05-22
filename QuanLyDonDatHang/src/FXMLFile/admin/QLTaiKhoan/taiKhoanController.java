package FXMLFile.admin.QLTaiKhoan;

import java.net.URL;
import java.util.ResourceBundle;

import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class taiKhoanController implements Initializable{

    @FXML
    private Label password;

    @FXML
    private Label user_id;

    @FXML
    private Label username;
    
    private User user;
    
    public void setData(User user) {
    	this.user = user;
    	load_data();

    }
    
    public void load_data() {
    	user_id.setText(String.valueOf(user.getUserId()));
    	username.setText(user.getUsername());
    	password.setText(user.getPasswordHash());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
			}
}