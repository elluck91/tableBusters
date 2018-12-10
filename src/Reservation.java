import java.sql.Date;

public class Reservation {
	int hotelID;
	int roomID;
	int roomNumber;
	double price;
	String hotelName;
	String hotelPhone;
	String address;
	String city;
	String state;
	int zip;
	Date startDate;
	Date endDate;
	int reservationID;
	int guestID;
	
	public Reservation(int hotelID, int roomID, int roomNumber, double price, String hotelName, String hotelPhone,
			String address, String city, String state, int zip, Date startDate, Date endDate, int reservationID, int guestID) {
		super();
		this.hotelID = hotelID;
		this.roomID = roomID;
		this.roomNumber = roomNumber;
		this.price = price;
		this.hotelName = hotelName;
		this.hotelPhone = hotelPhone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reservationID = reservationID;
		this.guestID = guestID;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelPhone() {
		return hotelPhone;
	}
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public int getGuestID() {
		return guestID;
	}
	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}
}
