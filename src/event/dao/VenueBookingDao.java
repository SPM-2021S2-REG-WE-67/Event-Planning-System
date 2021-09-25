package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.VenueBooking;

public class VenueBookingDao {


	// venuebooking
	private static final String INSERT_venuebooking_SQL = "INSERT INTO venuebooking"
			+ " ( 	User,Mobile,Nic,Email,NumberOfGuests,AdditionalServices,BookingDate,AdvancedPayment) VALUES "
			+ " (?, ?, ?,?,?,?, ?, ?,?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from venuebooking where User=? ";
	private static final String SELECT_venuebooking_BY_ID = "select 	id,User,Mobile,Nic, Email,NumberOfGuests,AdditionalServices,BookingDate,AdvancedPayment from venuebooking where id =?";
	private static final String SELECT_ALL_evenuebooking = "select * from venuebooking";
	
	public VenueBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert VenueBoking
	public void insertVenueBook(VenueBooking venuebook) throws SQLException {
		System.out.println(INSERT_venuebooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_venuebooking_SQL)) {
			preparedStatement.setString(1, venuebook.getUser());
			preparedStatement.setString(2, venuebook.getMobile());
			preparedStatement.setInt(3, venuebook.getNic());
			preparedStatement.setString(4, venuebook.getEmail());
			preparedStatement.setString(5, venuebook.getNumberOfGuests());
			preparedStatement.setString(6, venuebook.getAdditionalServices());
			preparedStatement.setInt(7, venuebook.getBookingDate());
			preparedStatement.setInt(8, venuebook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select VenueBooking
	public VenueBooking selectVenueBooking(int id) {
		VenueBooking venuebook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_venuebooking_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String user = rs.getString("User");
				int mobile = rs.getInt("Mobile");
				String nic = rs.getString("Nic");
				String email = rs.getString("Email");
				int numberofguests = rs.getInt("NumberOfGuests");
				String additionalservices = rs.getString("AdditionalServices");
				String bookingdate = rs.getString("BookingDate");
				int advancedpayment = rs.getInt("AdvancedPayment");

				venuebook = new VenueBooking(id,user, mobile, nic, email, numberofguests, additionalservices, bookingdate,
						advancedpayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venuebook;
	}
	// select All VenueBookings
	public List<VenueBooking> selectAllVenueBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<VenueBooking> venuebook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				
				// Step 2:Create a statement using connection object
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BookingbyUser);) {
			preparedStatement.setString(1, User);
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("User");
				int mobile = rs.getInt("Mobile");
				String nic = rs.getString("Nic");
				String email = rs.getString("Email");
				int numberofguests = rs.getInt("NumberOfGuests");
				String additionalservices = rs.getString("AdditionalServices");
				String bookingdate = rs.getString("BookingDate");
				int advancedpayment = rs.getInt("AdvancedPayment");
				venuebook.add(new VenueBooking(id, user, mobile, nic, email, numberofguests, additionalservices, bookingdate, 
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venuebook;
	}
}