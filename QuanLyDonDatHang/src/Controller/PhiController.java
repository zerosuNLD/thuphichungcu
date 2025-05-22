package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PhiController implements Initializable {

    @FXML
    private Label PhiBatBuoc;

    @FXML
    private Button XacNhan_btn;

    @FXML
    private TextField quy_bien_dao;

    @FXML
    private TextField quy_cao_tuoi;

    @FXML
    private TextField quy_dinh_gung;

    @FXML
    private TextField quy_khuyen_hoc;

    @FXML
    private TextField quy_nguoi_ngheo;

    @FXML
    private TextField quy_nhan_dao;

    @FXML
    private TextField quy_tinh_nghia;

    @FXML
    private TextField quy_to;

    @FXML
    private TextField quy_tre_tho;

    @FXML
    private Label total;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Hiển thị phí chung cư bắt buộc
        double phiBatBuoc = Model.getInstance().getMandatoryMonthlyFee();
        PhiBatBuoc.setText("Phí chung cư: " + phiBatBuoc + " VND");

        // Thiết lập tổng ban đầu
        total.setText("Tổng: " + phiBatBuoc + " VND");

        // Danh sách tất cả các textField cho các quỹ
        TextField[] quyFields = {
            quy_bien_dao, quy_cao_tuoi, quy_dinh_gung, quy_khuyen_hoc,
            quy_nguoi_ngheo, quy_nhan_dao, quy_tinh_nghia, quy_to, quy_tre_tho
        };

        // Đặt tất cả các textField về 0 mặc định
        for (TextField field : quyFields) {
            field.setText("0");
        }

        // Lắng nghe sự thay đổi của các textField
        for (TextField field : quyFields) {
            field.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    updateTotal(phiBatBuoc);
                }
            });
        }
        
        XacNhan_btn.setOnAction(event -> onXacNhan());
    }

    // Hàm tính tổng
    private void updateTotal(double phiBatBuoc) {
        try {
            double totalAmount = phiBatBuoc;

            totalAmount += parseDouble(quy_bien_dao.getText());
            totalAmount += parseDouble(quy_cao_tuoi.getText());
            totalAmount += parseDouble(quy_dinh_gung.getText());
            totalAmount += parseDouble(quy_khuyen_hoc.getText());
            totalAmount += parseDouble(quy_nguoi_ngheo.getText());
            totalAmount += parseDouble(quy_nhan_dao.getText());
            totalAmount += parseDouble(quy_tinh_nghia.getText());
            totalAmount += parseDouble(quy_to.getText());
            totalAmount += parseDouble(quy_tre_tho.getText());

            total.setText("" + totalAmount + " VND");
        } catch (NumberFormatException e) {
            total.setText("Lỗi: Chỉ nhập số!");
        }
    }

    // Hàm chuyển từ String sang double, trả về 0 nếu lỗi
    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private void onXacNhan() {
		Model.getInstance().getViewFactory().getDVBHScreenSelectedMenuItemProperty().set("DongPhi");
	}
}
