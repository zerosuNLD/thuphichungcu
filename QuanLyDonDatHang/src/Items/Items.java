package Items;

import java.util.Date;

public class Items {
	private int thang;
	private double tien;
	private String trangThai;
	private Date time;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}
	
	public Items(int thang, double tien, String trangThai, java.util.Date date) {
		this.thang = thang;
		this.tien = tien;
		this.trangThai = trangThai;
		this.time = date;
	}
	
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public double getTien() {
		return tien;
	}
	public void setTien(int tien) {
		this.tien = tien;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
}