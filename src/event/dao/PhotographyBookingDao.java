package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.PhotographyBooking;

public class PhotographyBookingDao {


	// Photography Booking
	private static final String INSERT_Photographybooking_SQL = "INSERT INTO photographybooking"
			+ " ( 	user,nic,mobile,email,bookingdate,studioname,packagename,AdvancedPayment) VALUES "
			+ " (?, ?, ?,?,?,?, ?, ?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from photographybooking where user=? ";
	private static final String SELECT_Photographybooking_BY_ID = "select 	id,user,nic,mobile,email,bookingdate,studioname,packagename,AdvancedPayment from photographybooking where id =?";
	private static final String SELECT_ALL_Photographybooking = "select * from photographybooking";
	
	public PhotographyBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert PhotographyBooking
	public void insertPhotographyBook(PhotographyBooking photographybook) throws SQLException {
		System.out.println(INSERT_Photographybooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Photographybooking_SQL)) {
			preparedStatement.setString(1, photographybook.getUser());
			preparedStatement.setString(2, photographybook.getNic());
			preparedStatement.setInt(3, photographybook.getMobile());
			preparedStatement.setString(4, photographybook.getEmail());
			preparedStatement.setString(5, photographybook.getBookingdate());
			preparedStatement.setString(6, photographybook.getStudioName());
			preparedStatement.setString(7, photographybook.getPackageName());
			preparedStatement.setInt(9, photographybook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select PhotographyBooking
	public PhotographyBooking selectPhotographyBooking(int id) {
		PhotographyBooking photographybook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Photographybooking_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String user = rs.getString("user");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String studioname = rs.getString("studioname");
				String packagename = rs.getString("packagename");
				int advancedPayment = rs.getInt("AdvancedPayment");

				photographybook = new PhotographyBooking(id,user, nic, mobile, email, bookingdate, studioname, packagename,
						advancedPayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photographybook;
	}
	// select All PhotographyBooking
	public List<PhotographyBooking> selectAllPhotographyBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PhotographyBooking> photographybook = new ArrayList<>();
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
				String user = rs.getString("user");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String studioname = rs.getString("studioname");
				String packagename = rs.getString("packagename");
				int advancedPayment = rs.getInt("AdvancedPayment");
				photographybook.add(new PhotographyBooking(id, user, nic, mobile, email, bookingdate, studioname, packagename,
						advancedPayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photographybook;
	}
	// select All PhotographyBooking
	public List<PhotographyBooking> selectAllPhotographyBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PhotographyBooking> photographybook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Photographybooking);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("user");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String studioname = rs.getString("studioname");
				String packagename = rs.getString("packagename");
				int advancedPayment = rs.getInt("AdvancedPayment");
				photographybook.add(new PhotographyBooking(id, user, nic, mobile, email, bookingdate, studioname, packagename,
						advancedPayment));;
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photographybook;
	}
	

}