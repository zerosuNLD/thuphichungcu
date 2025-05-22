package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import View.ViewFactory;

public class Model {
	private final ViewFactory viewFactory;
	private static Model model;
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/apartment_management?useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASS = "1234";
	private int user_id;
	private int selectedMonth = -1;

	public void setSelectedMonth(int month) {
	    this.selectedMonth = month;
	}

	public int getSelectedMonth() {
	    return this.selectedMonth;
	}

	public void setUserId (int user_id) {
		this.user_id = user_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	private Model() {
		this.viewFactory = new ViewFactory();

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized Model getInstance() {
		if (model == null) {
			model = new Model();
		}
		return model;
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public boolean login(String username, String passwordHash, String type) {
	    String sql = "SELECT user_id FROM users WHERE username = ? AND password_hash = ? AND role = ?";
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, username);
	        stmt.setString(2, passwordHash);
	        stmt.setString(3, type);

	        ResultSet rs = stmt.executeQuery();

	        // Trả về user_id nếu tìm thấy
	        if (rs.next()) {
	        	int userId = rs.getInt("user_id");
	            setUserId(userId); 
	            return true;
	        } else {
	            return false; // Không tìm thấy tài khoản
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // Trả về -1 nếu có lỗi
	    }
	}
	
	public double getMandatoryMonthlyFee() {
	    String sql = """
	        SELECT a.area 
	        FROM apartments a
	        JOIN apartment_rentals ar ON a.apartment_id = ar.apartment_id
	        JOIN households h ON ar.household_id = h.household_id
	        JOIN users u ON h.household_id = u.household_id
	        WHERE u.user_id = ?
	        """;
	    
	    double serviceFeeRate = 16500; // Mức cao nhất cho phí dịch vụ
	    double managementFeeRate = 7000; // Phí quản lý cố định cho BlueMoon

	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, this.user_id);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            double area = rs.getDouble("area");
	            double serviceFee = area * serviceFeeRate;
	            double managementFee = area * managementFeeRate;
	            return serviceFee + managementFee;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0.0;
	}
	
	public PaymentInfo getMonthlyPaymentInfo(int month, int year) {
	    String sql = """
	        SELECT 
	            SUM(p.total_amount) AS total_amount,
	            MAX(p.payment_date) AS last_payment_date,
	            CASE 
	                WHEN COUNT(*) = COUNT(CASE WHEN p.status = 'Đã đóng' THEN 1 END) THEN 'Đã đóng'
	                ELSE 'Chưa đóng'
	            END AS status
	        FROM payments p
	        JOIN households h ON p.household_id = h.household_id
	        JOIN users u ON h.household_id = u.household_id
	        WHERE u.user_id = ? AND p.month = ? AND p.year = ?
	        """;
	    
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, this.user_id);
	        stmt.setInt(2, month);
	        stmt.setInt(3, year);
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            double totalAmount = rs.getDouble("total_amount");
	            Date paymentDate = rs.getDate("last_payment_date");
	            String status = rs.getString("status");

	            // Trả về PaymentInfo với tổng tiền và trạng thái
	            return new PaymentInfo(totalAmount, status, paymentDate);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public List<MonthlyRoomPaymentInfo> getMonthlyRoomPaymentList(int month, int year) {
	    String sql = """
	        SELECT 
	            a.apartment_number AS phong,
	            p.month AS thang,
	            p.year AS nam,
	            p.total_amount AS so_tien_can_dong,
	            p.status AS trang_thai,
	            p.payment_date AS ngay_dong
	        FROM 
	            payments p
	        JOIN 
	            households h ON p.household_id = h.household_id
	        JOIN 
	            apartment_rentals ar ON h.household_id = ar.household_id
	        JOIN 
	            apartments a ON ar.apartment_id = a.apartment_id
	        WHERE 
	            p.month = ? AND p.year = ?
	        ORDER BY 
	            a.apartment_number
	        """;

	    List<MonthlyRoomPaymentInfo> paymentList = new ArrayList<>();

	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, month);
	        stmt.setInt(2, year);

	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            String phong = rs.getString("phong");
	            int thang = rs.getInt("thang");
	            int nam = rs.getInt("nam");
	            double soTien = rs.getDouble("so_tien_can_dong");
	            String trangThai = rs.getString("trang_thai");
	            Date ngayDong = rs.getDate("ngay_dong");

	            MonthlyRoomPaymentInfo info = new MonthlyRoomPaymentInfo(phong, thang, nam, soTien, trangThai, ngayDong);
	            paymentList.add(info);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return paymentList;
	}
	
	public List<User> getAllUsers() {
	    List<User> userList = new ArrayList<>();
	    String sql = "SELECT user_id, username, password_hash FROM users";

	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            int userId = rs.getInt("user_id");
	            String username = rs.getString("username");
	            String passwordHash = rs.getString("password_hash");

	            userList.add(new User(userId, username, passwordHash));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userList;
	}
	
}
