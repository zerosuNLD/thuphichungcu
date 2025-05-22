package Model;

import java.sql.Date;

public class MonthlyRoomPaymentInfo {
    private String phong;
    private int thang;
    private int nam;
    private double soTienCanDong;
    private String trangThai;
    private Date ngayDong;

    public MonthlyRoomPaymentInfo(String phong, int thang, int nam, double soTienCanDong, String trangThai, Date ngayDong) {
        this.phong = phong;
        this.thang = thang;
        this.nam = nam;
        this.soTienCanDong = soTienCanDong;
        this.trangThai = trangThai;
        this.ngayDong = ngayDong;
    }

    // Getter
    public String getPhong() { return phong; }
    public int getThang() { return thang; }
    public int getNam() { return nam; }
    public double getSoTienCanDong() { return soTienCanDong; }
    public String getTrangThai() { return trangThai; }
    public Date getNgayDong() { return ngayDong; }
}
