package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.MonthlyRoomPaymentInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ThueCanHoController implements Initializable {

    @FXML
    private Label amount;

    @FXML
    private Label ngaydong;

    @FXML
    private Label phong;

    @FXML
    private Label status;

    private MonthlyRoomPaymentInfo room;

    public void setData(MonthlyRoomPaymentInfo room) {
        this.room = room;
    }

    // Gọi sau khi setData để cập nhật giao diện
    public void loadData() {
        if (room != null) {
            phong.setText(room.getPhong()); // ví dụ: "P101"
            amount.setText(room.getSoTienCanDong() + " VNĐ"); // ví dụ: "500000 VNĐ"
            ngaydong.setText(room.getNgayDong().toString()); // ví dụ: "2025-05-20"
            status.setText(room.getTrangThai());
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Không làm gì tại đây vì dữ liệu sẽ được set sau
    }
}
