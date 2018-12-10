
public class Hotel {
	int hotelID;
	String name;
	String phone;
	String address;
	String city;
	String state;
	int zip;
	public Hotel(int hotelID, String name, String phone, String address, String city, String state, int zip) {
		super();
		this.hotelID = hotelID;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	
}
