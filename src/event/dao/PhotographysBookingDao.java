package event.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.PhotographyBooking;

public class PhotographysBookingDao {


	// PhotographysBooking
	private static final String INSERT_phobooking_SQL = "INSERT INTO photographysbooking"
			+ " (User,nic,mobile,email,bookingdate,studioname,packagename,advancedpayment) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from photographysbooking where User=? ";
	private static final String SELECT_phobooking_BY_ID = "select 	id,User,nic,mobile,email,bookingdate,studioname,packagename,advancedpayment from photographysbooking where id =?";
	private static final String SELECT_ALL_phobooking = "select * from photographysbooking";
	
	public PhotographysBookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

	// insert PhotographysBooking
	public void insertPhotographysBook(PhotographyBooking phobook) throws SQLException {
		System.out.println(INSERT_phobooking_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_phobooking_SQL)) {
			preparedStatement.setString(1, phobook.getUser());
			preparedStatement.setString(2, phobook.getNic());
			preparedStatement.setInt(3, phobook.getMobile());
			preparedStatement.setString(4, phobook.getEmail());
			preparedStatement.setString(5, phobook.getBookingdate());
			preparedStatement.setString(6, phobook.getStudioname());
			preparedStatement.setString(7, phobook.getPackagename());
			preparedStatement.setInt(8, phobook.getAdvancedPayment());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select PhotographyBooking
	public PhotographyBooking selectPhotographyBooking(int id) {
		PhotographyBooking phobook = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_phobooking_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String user = rs.getString("User");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String studioname = rs.getString("studioname");
				String packagename = rs.getString("packagename");
				int advancedpayment = rs.getInt("advancedpayment");

				phobook = new PhotographyBooking(id,user, nic, mobile, email, bookingdate, studioname, packagename,
						advancedpayment);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return phobook;
	}
	// select All PhotographyBokings
	public List<PhotographyBooking> selectAllPhotographyBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PhotographyBooking> phobook = new ArrayList<>();
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
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String studioname = rs.getString("studioname");
				String packagename = rs.getString("packagename");
				int advancedpayment = rs.getInt("advancedpayment");
				phobook.add(new PhotographyBooking(id, user, nic, mobile, email, bookingdate, studioname, packagename,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return phobook;
	}
	// select All CateringBokings
	public List<PhotographyBooking> selectAllPhotographyBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PhotographyBooking> phobook = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_phobooking);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("User");
				String nic = rs.getString("nic");
				int mobile = rs.getInt("mobile");
				String email = rs.getString("email");
				String bookingdate = rs.getString("bookingdate");
				String studioname = rs.getString("studioname");
				String packagename = rs.getString("packagename");
				int advancedpayment = rs.getInt("advancedpayment");
				phobook.add(new PhotographyBooking(id, user, nic, mobile, email, bookingdate, studioname, packagename,
						advancedpayment));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return phobook;
	}
	

}