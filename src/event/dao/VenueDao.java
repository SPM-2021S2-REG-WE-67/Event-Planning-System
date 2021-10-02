package event.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Decoder.BASE64Encoder;
import event.dbconnection.DbConnection;
import event.model.Venue;

public class VenueDao {

	// venue
	private static final String INSERT_venue_SQL = "INSERT INTO venue"
			+ " ( ResourceName,TypeOfVenue,Location,WorkingDays,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_venue_BY_ID = "select id,ResourceName,TypeOfVenue,Location,WorkingDays from venue where id =?";
	private static final String SELECT_ALL_venue = "select * from venue";
	private static final String DELETE_venue_SQL = "delete from venue where id = ?;";
	private static final String UPDATE_venue_SQL = "update venue set   ResourceName = ?,TypeOfVenue = ?,Location = ?,WorkingDays = ?  where id = ?;";

	public VenueDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Venue
	public void insertVenue(Venue venue) throws SQLException {
		System.out.println(INSERT_venue_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_venue_SQL)) {
			preparedStatement.setString(1, venue.getResourceName());
			preparedStatement.setString(2, venue.getTypeOfVenue());
			preparedStatement.setString(3, venue.getLocation());
			preparedStatement.setString(4, venue.getWorkingDays());
			preparedStatement.setString(5, venue.getFilename());
			preparedStatement.setString(6, venue.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Venue
	public Venue selectVenue(int id) {
		Venue venue = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_venue_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String resourcename = rs.getString("resourcename");

				String typeofvenue = rs.getString("typeofvenue");
				String location = rs.getString("location");
				String workingdays = rs.getString("workingdays");

				venue = new Venue(id, resourcename, typeofvenue, location, workingdays);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venue;
	}

	// select All Venue
	public List<Venue> selectAllVenue() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Venue> venue = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_venue);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String resourcename = rs.getString("ResourceName");
				String typeofvenue = rs.getString("TypeOfVenue");
				String location = rs.getString("Location");
				String workingdays = rs.getString("WorkingDays");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				venue.add(new Venue(id, resourcename, typeofvenue, location, workingdays, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venue;
	}

	// Delete venue
	public boolean deleteVenue(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_venue_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Venue
	public boolean updateVenue(Venue venue) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_venue_SQL);) {
			statement.setString(1, venue.getResourceName());
			statement.setString(2, venue.getTypeOfVenue());
			statement.setString(3, venue.getLocation());
			statement.setString(4, venue.getWorkingDays());
			statement.setInt(5, venue.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}