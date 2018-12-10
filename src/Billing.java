
public class Billing {
	int billingID;
	String cardNumber;
	String address;
	String city;
	String state;
	int zip;
	int guestID;
	
	public Billing() {
		
	}
	
	public Billing(int billingID, String cardNumber, String address, String city, String state, int zip, int guestID) {
		super();
		this.billingID = billingID;
		this.cardNumber = cardNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.guestID = guestID;
	}
	public int getBillingID() {
		return billingID;
	}
	public void setBillingID(int billingID) {
		this.billingID = billingID;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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
	public int getGuestID() {
		return guestID;
	}
	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}

	@Override
	public String toString() {
		return "Billing [billingID=" + billingID + ", cardNumber=" + cardNumber + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", guestID=" + guestID + "]";
	}
	
	
}
