import java.io.Console;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class DatabaseApp {
	//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/tableBustersDB?autoReconnect=true&useSSL=false";

	//  Database credentials
	static String USER = "";
	static String PASS = "";

	static Connection conn = null;
	static Statement stmt = null;
	static Scanner in = null;
	static int guestID;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		Console console = System.console();

		System.out.print("MYSQL DB username: ");
		USER = in.nextLine();
		char[] pw = console.readPassword("MYSQL DB password: ");
		PASS = String.valueOf(pw);

		String welcome = 	"\n+-+-+-+-+-+-+-+-+-+-+-+-+\n" + 
				"|T|a|b|l|e|B|u|s|t|e|r|s|\n" + 
				"+-+-+-+-+-+-+-+-+-+-+-+-+";
		System.out.println(welcome);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			login();
			welcome();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		in.close();
	}

	@SuppressWarnings("unused")
	private static ArrayList<Integer> getRoomIDs() {
		ArrayList<Integer> rooms = new ArrayList<Integer>();
		try {
			stmt = conn.createStatement();
			String sql = "Select distinct roomID from room;";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				rooms.add(rs.getInt("roomID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rooms;
	}

	private static void login() {
		String input = "-1";

		while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
			System.out.println("0. Exit");
			System.out.println("1. Sign In");
			System.out.println("2. Sign Up");
			System.out.print("\nChoose number: ");
			input = in.nextLine();

			String username = "";
			String password = "";
			Console console = System.console();

			switch (input) {
			case "0":
				System.out.println("See you soon!");
				System.exit(0);
			case "1":
				System.out.print("Email: ");
				username = in.nextLine();
				char[] pw = console.readPassword("Password: ");
				password = String.valueOf(pw);

				if (loginInvalid(username, password)) {
					System.out.println("\n*****Login invalid.*****\n");
					login();
				}
				break;
			case "2":
				System.out.print("Name: ");
				username = in.nextLine();
				System.out.print("Email: ");
				String email = in.nextLine();
				pw = console.readPassword("MYSQL DB password: ");
				password = String.valueOf(pw);		
				//				password = new String(console.readPassword("Please enter your password: "));
				if(!signUp(username, email, password)) {
					System.out.println("Email already in use.");
					login();
				}
				break;
			default:
				System.out.println("Wrong input. Try again.");
				break;
			}
		}
	}

	private static boolean signUp(String username, String email, String password) {
		try {
			stmt = conn.createStatement();
			String sql = "insert into guest(name, email, password) values('" + username + "', '" + email + "', '" + password + "');";
			stmt.executeUpdate(sql);

			loginInvalid(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	private static boolean loginInvalid(String username, String password) {
		try {
			stmt = conn.createStatement();
			String sql = "Select guestID from guest where email='" + username + "' and password='" + password + "';";
			ResultSet rs = stmt.executeQuery(sql);

			if (!rs.next()) {
				return true;
			}
			else {
				guestID = rs.getInt("guestID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	private static void welcome() {
		String input = "-1";

		while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
			System.out.println("\nWhat type of task would you like to perform?");
			System.out.println("0. Exit");
			System.out.println("1. Administration");
			System.out.println("2. Reservation");
			System.out.println("3. Reporting");
			System.out.print("\nEnter number: ");

			input = in.nextLine();

			switch (input) {
			case "0":
				System.out.println("See you soon!");
				System.exit(0);
			case "1":
				System.out.println("Proceeding to administration.");
				administration();
				break;
			case "2":
				System.out.println("Proceeding to reservation.");
				reservation();
				break;
			case "3":
				System.out.println("Proceeding to reporting.");
				reporting();
				break;
			default:
				System.out.println("Wrong input. Try again.");
				break;
			}
		}
	}

	private static void reporting() {
		System.out.println("1. View all reservations.");
		System.out.println("2. View reservation by hotel.");
		System.out.println("3. Main menu");
		System.out.print("\nSelect option: ");
		String option = in.nextLine();
		ArrayList<Reservation> reservations = null;
		ArrayList<Hotel> hotels = null;
		int row;
		int counter;

		switch(Integer.parseInt(option)) {
		case 1:
			reservations = getReservations("all", 0);
			showMyReservations(reservations);
			reporting();
			break;
		case 2:
			hotels = getHotels(true);			
			counter = 1;
			for (Hotel hotel : hotels) {
				System.out.println("#" + counter + ": " + hotel.getName() + ", " + hotel.getCity());
				counter++;
			}

			System.out.print("Select hotel: ");
			row = Integer.parseInt(in.nextLine());
			while (row < 0 || row > hotels.size()) {
				System.out.println("Invalid selection.");
				System.out.print("Select hotel: ");
				row = Integer.parseInt(in.nextLine());
			}
			reservations = getReservations("hotel", hotels.get(row-1).getHotelID());
			showMyReservations(reservations);
			reporting();
			break;
		case 3:
			welcome();
			break;
		default:
			reporting();
			break;
		}
	}

	private static ArrayList<Hotel> getHotels(boolean getAll) {
		ArrayList<Hotel> hotels = null;
		try {
			stmt = conn.createStatement();
			String sql = null;

			if (getAll) {
				sql = "select distinct hotelID, name, phone, address, city, state, zip from hotel;";
			}
			else {
			}
			ResultSet rs = stmt.executeQuery(sql);

			hotels = new ArrayList<Hotel>();

			while(rs.next()) {
				hotels.add(new Hotel(
						rs.getInt("hotelID"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zip")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotels;
	}

	private static void reservation() {

		System.out.println("1. Search rooms by date.");
		System.out.println("2. Search rooms by price.");
		System.out.println("3. Search rooms by location.");
		System.out.println("4. Make reservation.");
		System.out.println("5. Cancel reservation.");
		System.out.println("6. Main menu");

		System.out.print("\nSelect option: ");

		ArrayList<Room> rooms = null;
		Date myStartDate= null;
		Date myEndDate = null;
		int row;
		String option = in.nextLine();
		switch(Integer.parseInt(option)) {
		case 1:
			System.out.print("Enter start date (YYYY-MM-DD): ");
			myStartDate = java.sql.Date.valueOf(in.nextLine());
			System.out.print("Enter end date (YYYY-MM-DD): ");
			myEndDate = java.sql.Date.valueOf(in.nextLine());
			rooms = getAvailableRooms(myStartDate, myEndDate);
			showRooms(rooms);
			reservation();
			break;
		case 2:
			System.out.print("Min: ");
			double minPrice = Double.parseDouble(in.nextLine());
			System.out.print("Max: ");
			double maxPrice = Double.parseDouble(in.nextLine());
			rooms = getRoomsByPrice(minPrice, maxPrice);
			showRooms(rooms);
			reservation();
			break;
		case 3:
			System.out.print("City: ");
			String city = in.nextLine();
			rooms = getRoomsByCity(city);
			showRooms(rooms);
			reservation();
			break;
		case 4:
			System.out.print("Enter start date (YYYY-MM-DD): ");
			myStartDate = java.sql.Date.valueOf(in.nextLine());
			System.out.print("Enter end date (YYYY-MM-DD): ");
			myEndDate = java.sql.Date.valueOf(in.nextLine());
			rooms = getAvailableRooms(myStartDate, myEndDate);
			showRooms(rooms);
			System.out.print("\n\tEnter row # to make a reservation: ");
			String input = in.nextLine();
			row = Integer.parseInt(input);
			makeReservation(myStartDate, myEndDate, rooms.get(row-1).getRoomID(), guestID);
			reservation();
		case 5:
			ArrayList<Reservation> myReservations = getReservations("guest", guestID);

			showMyReservations(myReservations);
			System.out.print("\n\tEnter row # to cancel reservation: ");
			option = in.nextLine();
			row = Integer.parseInt(option);

			if (myReservations.size() != 0 && row <= myReservations.size() && row > 0) {
				Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				if (myReservations.get(row-1).getStartDate().compareTo(now) < 0) {
					System.out.println("***Sorry, you can't cancel past reservations.");
				}
				else
					deleteReservation(myReservations.get(row-1).getReservationID());
			}
			reservation();
		case 6:
			welcome();
			break;
		}
	}

	private static void deleteReservation(int reservationID) {
		String sql = "delete from reservation where reservationID=" + reservationID + ";";
		try {
			stmt.executeUpdate(sql);
			System.out.println("Reservation cancelled.");
			welcome();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void showMyReservations(ArrayList<Reservation> myReservations) {
		int row = 1;

		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%15s %15s %15s %30s %30s %15s %15s %15s %13s", "Row #", "Start Date", "End Date", "Hotel Name", "Address", "City", "State", "Room #", "Price");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Reservation reservation: myReservations){
			System.out.format("%15d %15s %15s %30s %30s %15s %15s %15d %13.2f", row,
					reservation.getStartDate(), reservation.getEndDate(),
					reservation.getHotelName(), reservation.getAddress(), reservation.getCity(),
					reservation.getState(), reservation.getRoomNumber(), reservation.getPrice());
			System.out.println();
			row++;
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	private static ArrayList<Reservation> getReservations(String table, int id) {
		ArrayList<Reservation> reservations = null;
		try {
			stmt = conn.createStatement();
			String sql = null;

			switch(table) {
			case "guest":
				sql = "select * from reservation join room " +
						"using(roomID) join hotel using(hotelID) where guestID=" +
						id + ";";
				break;
			case "hotel":
				sql = "select * from reservation join room " +
						"using(roomID) join hotel using(hotelID) where hotelID=" +
						id + " order by endDate;";
				break;
			case "all":
				sql = "select * from reservation join room " +
						"using(roomID) join hotel using(hotelID);";
				break;
			default:
				break;
			}

			ResultSet rs = stmt.executeQuery(sql);

			reservations = new ArrayList<Reservation>();

			while(rs.next()) {
				reservations.add(new Reservation(rs.getInt("hotelID"),
						rs.getInt("roomID"),
						rs.getInt("roomNumber"),
						rs.getDouble("rate"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zip"),
						rs.getDate("startDate"),
						rs.getDate("endDate"),
						rs.getInt("reservationID"),
						rs.getInt("guestID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	private static void makeReservation(Date myStartDate, Date myEndDate, int roomID, int guestID) {

		String sql = "insert into reservation(startDate, endDate, roomID, guestID) values('" + myStartDate + "', '" + myEndDate + "', " + roomID + ", " + guestID + ");";
		try {
			stmt.executeUpdate(sql);
			System.out.println("Reservation complete.");
			reservation();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<Room> getRoomsByCity(String city) {
		ArrayList<Room> rooms = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from room join hotel using(hotelID)" + 
					" where room.roomID NOT IN (select" +
					" roomID from reservation where" +
					" city = '" + city + "'" +
					" ORDER BY name, rate;";
			ResultSet rs = stmt.executeQuery(sql);

			rooms = new ArrayList<Room>();

			while(rs.next()) {
				rooms.add(new Room(rs.getInt("hotelID"),
						rs.getInt("roomID"),
						rs.getInt("roomNumber"),
						rs.getDouble("rate"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zip")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	private static ArrayList<Room> getRoomsByPrice(double minPrice, double maxPrice) {
		ArrayList<Room> rooms = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from room join hotel using(hotelID)" + 
					" where room.roomID NOT IN (select" +
					" roomID from reservation where" +
					" rate >= " + minPrice + " and " + 
					maxPrice + " >= rate)" +
					"ORDER BY name, rate;";
			ResultSet rs = stmt.executeQuery(sql);

			rooms = new ArrayList<Room>();

			while(rs.next()) {
				rooms.add(new Room(rs.getInt("hotelID"),
						rs.getInt("roomID"),
						rs.getInt("roomNumber"),
						rs.getDouble("rate"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zip")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	private static void showRooms(ArrayList<Room> rooms) {
		int row = 1;

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%15s %30s %30s %15s %15s %15s %13s", "Row #", "Hotel Name", "Address", "City", "State", "Room #", "Price");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Room room: rooms){
			System.out.format("%15d %30s %30s %15s %15s %15d %13.2f", row,
					room.getHotelName(), room.getAddress(), room.getCity(),
					room.getState(), room.getRoomNumber(), room.getPrice());
			System.out.println();
			row++;
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	private static ArrayList<Room> getAvailableRooms(Date myStartDate, Date myEndDate) {
		ArrayList<Room> rooms = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from room join hotel using(hotelID)" + 
					" where room.roomID NOT IN (select" +
					" roomID from reservation where" +
					" startDate <= " + myEndDate + " and " + 
					myStartDate + " <= endDate)" +
					"ORDER BY name, rate;";
			ResultSet rs = stmt.executeQuery(sql);

			rooms = new ArrayList<Room>();

			while(rs.next()) {

				rooms.add(new Room(rs.getInt("hotelID"),
						rs.getInt("roomID"),
						rs.getInt("roomNumber"),
						rs.getDouble("rate"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zip")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}
	/*
	 * select * from room join hotel using(hotelID) where roomID NOT in ( select roomID from reservation where startDate <= "2020-01-01" and "2010-01-01" <= endDate) ORDER BY rate
	 */

	private static void administration() {
		System.out.println("\n1. View my billing information.");
		System.out.println("2. Edit my billing information.");
		System.out.println("3. Add new billing information.");
		System.out.println("4. Main menu.");
		System.out.print("\nSelect option: ");
		String input = in.nextLine();
		int option = Integer.parseInt(input);
		ArrayList<Billing> billingInfo;
		String cardNumber;
		String address;
		String city;
		String state;
		String tmp;

		switch(option) {
		case 1:
			billingInfo = getBillingInfo();
			showBillingInfo(billingInfo);
			administration();
			break;
		case 2:
			billingInfo = getBillingInfo();
			showBillingInfo(billingInfo);

			if (billingInfo.size() == 0) {
				administration();
			}

			System.out.print("Which billing information record would you like to edit: ");
			input = in.nextLine();
			int row = Integer.parseInt(input);

			System.out.print("New card number (blank for same as before): ");
			cardNumber = in.nextLine();

			if (cardNumber.length() != 0)
				billingInfo.get(row-1).setCardNumber(cardNumber);

			System.out.print("New address (blank for same as before): ");
			address = in.nextLine();

			if (address.length() != 0)
				billingInfo.get(row-1).setAddress(address);

			System.out.print("New city (blank for same as before): ");
			city = in.nextLine();

			if (city.length() != 0)
				billingInfo.get(row-1).setCity(city);

			System.out.print("New state (blank for same as before): ");
			state = in.nextLine();

			if (state.length() != 0)
				billingInfo.get(row-1).setState(state);

			System.out.print("New ZIP (blank for same as before): ");
			tmp = in.nextLine();

			if (tmp.length() != 0)
				billingInfo.get(row-1).setZip(Integer.parseInt(tmp));

			updateBilling(billingInfo.get(row-1));
			break;
		case 3:
			Billing newBilling = new Billing();

			System.out.print("New card number: ");
			cardNumber = in.nextLine();

			while (cardNumber.length() != 16) {
				System.out.println("Card number must be 16 digits.");
				System.out.print("New card number: ");
				cardNumber = in.nextLine();
			}
			newBilling.setCardNumber(cardNumber);


			System.out.print("New address: ");
			address = in.nextLine();

			while (address.length() == 0) {
				System.out.println("Address invalid.");
				System.out.print("New address: ");
				address = in.nextLine();
			}
			newBilling.setAddress(address);

			System.out.print("New city: ");
			city = in.nextLine();

			while (city.length() == 0) {
				System.out.println("City invalid.");
				System.out.print("New city: ");
				city = in.nextLine();
			}
			newBilling.setCity(city);

			System.out.print("New state (2 chars): ");
			state = in.nextLine();

			while (state.length() != 2) {
				System.out.println("State invalid.");
				System.out.print("New state (2 chars): ");
				state = in.nextLine();
			}
			newBilling.setState(state);

			System.out.print("New ZIP (5 digits): ");
			tmp = in.nextLine();

			while (tmp.length() != 5) {
				System.out.println("ZIP invalid.");
				System.out.print("New ZIP (5 digits): ");
				tmp = in.nextLine();
			}
			newBilling.setZip(Integer.parseInt(tmp));

			addNewBilling(newBilling);
			break;
		case 4:
			welcome();
			break;

		}
	}



	private static void addNewBilling(Billing newBilling) {
		String sql = "insert into billing(cardNumber, address, city, state, zip, guestID) " +
				"values('" + newBilling.getCardNumber() + "', " +
				"'" + newBilling.getAddress() + "', " +
				"'" + newBilling.getCity() + "', " +
				"'" + newBilling.getState() + "', " +
				"" + newBilling.getZip() + ", " +
				"" + guestID + ");";
		try {
			stmt.executeUpdate(sql);
			System.out.println("Billing info added.");
			administration();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateBilling(Billing billingInfo) {
		String sql = "update billing set cardNumber='" + billingInfo.getCardNumber() + "' ," +
				"address='" + billingInfo.getAddress() + "', " +
				"city='" + billingInfo.getCity() + "', " +
				"state='" + billingInfo.getState() + "', " +
				"zip=" + billingInfo.getZip() + " " +
				"where billingID=" + billingInfo.getBillingID() + ";";
		System.out.println(sql);

		try {
			stmt.executeUpdate(sql);
			System.out.println("Billing info updated.");
			administration();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void showBillingInfo(ArrayList<Billing> billingInfo) {
		int row = 1;

		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%15s %30s %30s %15s %15s", "Row #", "Card number", "Address", "City", "State");
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		for(Billing billing: billingInfo){
			System.out.format("%15d %30s %30s %15s %15s", row,
					billing.getCardNumber(), billing.getAddress(), billing.getCity(),
					billing.getState());
			System.out.println();
			row++;
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
	}

	private static ArrayList<Billing> getBillingInfo() {
		ArrayList<Billing> billingInfo = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from billing where guestID=" + guestID + ";";
			ResultSet rs = stmt.executeQuery(sql);

			billingInfo = new ArrayList<Billing>();

			while(rs.next()) {
				billingInfo.add(new Billing(rs.getInt("billingID"),
						rs.getString("cardNumber"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zip"),
						rs.getInt("guestID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billingInfo;
	}
}