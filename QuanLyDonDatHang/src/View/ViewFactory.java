package View;

import java.io.IOException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewFactory {
	private final StringProperty DVBHScreenSelectedMenuItemProperty;
	private AnchorPane PhiView;
	private AnchorPane DongPhiView;
	private AnchorPane LichSuView;
	private AnchorPane HoSoView;
	private AnchorPane QLThuPhiView;
	private AnchorPane chiTietThangView;
	private AnchorPane traCuuCanHoView;
	private AnchorPane chiTietCanHoView;
	private AnchorPane qlTaiKhoanView;
	
	public ViewFactory() {
		this.DVBHScreenSelectedMenuItemProperty = new SimpleStringProperty("");
	}

	public StringProperty getDVBHScreenSelectedMenuItemProperty() {
		return DVBHScreenSelectedMenuItemProperty;
	}

	public AnchorPane getQlTaiKhoanView() {
		if(qlTaiKhoanView == null) {
			try {
				qlTaiKhoanView= new FXMLLoader(
						getClass().getResource("/FXMLFile/admin/QLTaiKhoan/QLTaiKhoan.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return qlTaiKhoanView;
	}
	
	public AnchorPane getChiTietCanHoView() {
		if(chiTietCanHoView == null) {
			try {
				chiTietCanHoView= new FXMLLoader(
						getClass().getResource("/FXMLFile/admin/TraCuuCanHo/chiTietCanHo.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return chiTietCanHoView;
	}
	
	public AnchorPane getTraCuuCanHoView() {
		if(traCuuCanHoView == null) {
			try {
				traCuuCanHoView= new FXMLLoader(
						getClass().getResource("/FXMLFile/admin/TraCuuCanHo/TraCuuCanHo.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return traCuuCanHoView;
	}
	
	public AnchorPane getChiTietThangView() {
		if(chiTietThangView == null) {
			try {
				chiTietThangView = new FXMLLoader(
						getClass().getResource("/FXMLFile/admin/QLThuPhi/ChiTietThang.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return chiTietThangView;
	}
	
	public AnchorPane getQLThuPhiView() {
		if(QLThuPhiView == null) {
			try {
				QLThuPhiView = new FXMLLoader(
						getClass().getResource("/FXMLFile/admin/QLThuPhi/QLThuPhi.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return QLThuPhiView;
	}
	
	public AnchorPane getPhiView() {
		if (PhiView == null) {
			try {
				PhiView = new FXMLLoader(
						getClass().getResource("/FXMLFile/BoPhanBanHang/DSMHSiteKinhDoanh/Phi.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return PhiView;
	}

	public void refreshPhiView() {
		try {
			PhiView = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanBanHang/DSMHSiteKinhDoanh/Phi.fxml"))
					.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AnchorPane getLichSuView() {
		if (LichSuView == null) {
			try {
				LichSuView = new FXMLLoader(
						getClass().getResource("/FXMLFile/User/LichSu/LichSu.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return LichSuView;
	}

	public void refreshLichSuView() {
		try {
			LichSuView = new FXMLLoader(getClass().getResource("/FXMLFile/User/LichSu/LichSu.fxml"))
					.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AnchorPane getDongPhiView() {
		if (DongPhiView == null) {
			try {
				DongPhiView = new FXMLLoader(
						getClass().getResource("/FXMLFile/User/DongPhi/DongPhi.fxml")).load();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return DongPhiView;
	}

	public void refreshDongPhiView() {
		try {
			DongPhiView = new FXMLLoader(
					getClass().getResource("/FXMLFile/User/DongPhi/DongPhi.fxml")).load();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public AnchorPane getHoSoView() {
		try {
			HoSoView = new FXMLLoader(
					getClass().getResource("/FXMLFile/User/HoSo/HoSo.fxml")).load();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return HoSoView;
	}

	public void showLoginScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/Login/Login.fxml"));

		createStage(loader);
	}

	public void showDVBHScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanBanHang/DVBHScreen.fxml"));

		createStage(loader);
	}

	public void showScreenAdmin() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanBanHang/ScreenAdmin.fxml"));
		
		createStage(loader);
	}
	
	public Stage showThemMHScreen() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/FXMLFile/BoPhanBanHang/TaoDonHangMoi/ThemMH.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			return stage; // Trả về Stage
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void showDanhSachDHScreen() {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/FXMLFile/BoPhanBanHang/DSDonHangDaTao/DanhSachDH.fxml"));

		createStage(loader);
	}

	public void showBPDHQuocTeScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanDatHangQuocTe/BPDHQuocTe.fxml"));

		createStage(loader);
	}

	public void showBPQLKhoScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanQuanLyKho/BPQLKho.fxml"));

		createStage(loader);
	}

	public void showSiteNhapKhauScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanSiteNhauKhau/SiteNhapKhau.fxml"));

		createStage(loader);
	}

	public void showThongBao() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/Login/LoginError.fxml"));

		createStage(loader);
	}
	
	public void showTrangChu() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/Login/TrangChu.fxml"));
		
		createStage(loader);
	}

	public void showDangNhap() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/Login/DangNhap.fxml"));
		
		createStage(loader);
	}
	
	public void showPhi() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/BoPhanBanHang/DSMHSiteKinhDoanh/Phi.fxml"));
		
		createStage(loader);
	}
	
	private void createStage(FXMLLoader loader) {
		Scene scene = null;
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}

		scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);

		moveStage(stage);

		stage.show();
	}

	public void closeStage(Stage stage) {
		stage.close();
	}

	private void moveStage(Stage stage) {
		final DoubleProperty xOffset = new SimpleDoubleProperty(0);
		final DoubleProperty yOffset = new SimpleDoubleProperty(0);

		stage.initStyle(StageStyle.UNDECORATED);

		stage.getScene().getRoot().setOnMousePressed((MouseEvent event) -> {
			xOffset.set(event.getSceneX());
			yOffset.set(event.getSceneY());
		});

		stage.getScene().getRoot().setOnMouseDragged((MouseEvent event) -> {
			stage.setX(event.getScreenX() - xOffset.get());
			stage.setY(event.getScreenY() - yOffset.get());
		});
	}

}