package Items;

public class Items {
	private int thang;
	private int tien;
	private String trangThai;
	private String time;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}
	
	public Items(int thang, int tien, String trangThai, String time) {
		this.thang = thang;
		this.tien = tien;
		this.trangThai = trangThai;
		this.time = time;
	}
	
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getTien() {
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
}