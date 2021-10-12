package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.EntertainmentBooking;

public class EntertainmentBookingDao {


	private static final String INSERT_EntertainmentSQL = "INSERT INTO EntertainmentBooking"
			+ " (resourcename,typeOfEntertainment,days,location,bookingdate,additionalneeds,advancedpayment) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from EntertainmentBooking where User=? ";
	private static final String SELECT_entbooking_BY_ID = "select 	id,resourcename,typeOfEntertainment,days,location,bookingdate,additionalneeds,advancedpayment from cateringsbooking where id =?";
	private static final String SELECT_ALL_entbooking = "select * from EntertainmentBooking";
	private static final String INSERT_entbooking_SQL = null;
	
	public EntertainmentBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert CateringsBooking
	public void insertEntertainmentBook(EntertainmentBooking entbook) throws SQLException {
		System.out.println(INSERT_entbooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_entbooking_SQL)) {
			preparedStatement.setString(1, entbook.getresourcename());
			preparedStatement.setString(2, entbook.gettypeOfEntertainment());
			preparedStatement.setInt(3, entbook.getdays());
			preparedStatement.setString(4, entbook.getlocation());
			preparedStatement.setString(5, entbook.getBookingdate());
			preparedStatement.setString(6, entbook.getAdditionalneeds());
			preparedStatement.setInt(8, entbook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select CateringBooking
	public EntertainmentBooking selectEntertainmentBooking(int id) {
		EntertainmentBooking entbook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_entbooking_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String resourcename = rs.getString("resourcename");
				String typeOfEntertainment = rs.getString("typeOfEntertainment");
				int days = rs.getInt("days");
				String location = rs.getString("location");
				String bookingdate = rs.getString("bookingdate");
				String additionalneeds = rs.getString("additionalneeds");
				int advancedpayment = rs.getInt("advancedpayment");

				entbook = new EntertainmentBooking(id,resourcename, typeOfEntertainment, days, location, bookingdate, additionalneeds,
						advancedpayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entbook;
	}
	// select All CateringBokings
	public List<EntertainmentBooking> selectAllEntertainmentBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<EntertainmentBooking> entbook = new ArrayList<>();
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
				String resourcename = rs.getString("resourcename");
				String typeOfEntertainment = rs.getString("typeOfEntertainment");
				int days = rs.getInt("days");
				String location = rs.getString("location");
				String bookingdate = rs.getString("bookingdate");
				String additionalneeds = rs.getString("additionalneeds");
				int advancedpayment = rs.getInt("advancedpayment");
				entbook.add(new EntertainmentBooking(id, resourcename, typeOfEntertainment, days, location, bookingdate, additionalneeds, 
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entbook;
	}
	// select All CateringBokings
	public List<EntertainmentBooking> selectAllEntertainmentBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<EntertainmentBooking> entbook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_entbooking);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String resourcename = rs.getString("resourcename");
				String typeOfEntertainment = rs.getString("typeOfEntertainment");
				int days = rs.getInt("days");
				String location = rs.getString("location");
				String bookingdate = rs.getString("bookingdate");
				String additionalneeds = rs.getString("additionalneeds");
				int advancedpayment = rs.getInt("advancedpayment");
				entbook.add(new EntertainmentBooking(id, resourcename, typeOfEntertainment, days, location, bookingdate, additionalneeds, 
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entbook;
	}

    public EntertainmentBooking selectCateringBooking(int id) {
        return null;
    }
	

}