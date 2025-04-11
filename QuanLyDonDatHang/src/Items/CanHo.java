package Items;

public class CanHo {
	private int id;
	private int floor;
	private String apartmentNumber;
	private String type;
	private String status;
	private int area;
	private int fee_monthly;
	
	public CanHo() {
		
	}
	
	public CanHo(int id, int floor, String apartmentNumber, String type, String status, int area, int fee_monthly) {
		this.id = id;
		this.floor = floor;
		this.apartmentNumber = apartmentNumber;
		this.type = type;
		this.status = status;
		this.area = area;
		this.fee_monthly = fee_monthly;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getFee_monthly() {
		return fee_monthly;
	}
	public void setFee_monthly(int fee_monthly) {
		this.fee_monthly = fee_monthly;
	}
	
}