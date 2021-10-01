package event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.Venues;


public class VenuesDao {

	// Venues
	private static final String INSERT_venues_SQL = "INSERT INTO venues"
			+ " ( resourcename,TypeOfVenue,WorkingDays,Location,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_venues_BY_ID = "select id,resourcename,TypeOfVenue,WorkingDays,Location from venues where id =?";
	private static final String SELECT_ALL_venues = "select * from venues";
	private static final String DELETE_venues_SQL = "delete from venues where id = ?;";
	private static final String UPDATE_venues_SQL = "update venues set   resourcename = ?,TypeOfVenue = ?,WorkingDays = ?,Location = ?  where id = ?;";

	public VenuesDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Venues
	public void insertVenues(Venues venue) throws SQLException {
		System.out.println(INSERT_venues_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_venues_SQL)) {
			preparedStatement.setString(1, venue.getResourcename());
			preparedStatement.setString(2, venue.getTypeofvenue());
			preparedStatement.setString(3, venue.getWorkingdays());
			preparedStatement.setString(4, venue.getLocation());
			preparedStatement.setString(5, venue.getFilename());
			preparedStatement.setString(6, venue.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Venue
	public Venues selectVenue(int id) {
		Venues venue = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_venues_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String resourcename = rs.getString("resourcename");

				String typeofvenue = rs.getString("TypeOfVenue");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");

				venue = new Venues(id, resourcename, typeofvenue, workingdays, location);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venue;
	}

	// select All Venue
	public List<Venues> selectAllVenues() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Venues> venues = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_venues);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String resourcename = rs.getString("resourcename");
				String typeofvenue = rs.getString("TypeOfVenue");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				venues.add(new Venues(id, resourcename, typeofvenue, workingdays, location, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return venues;
	}

	// Delete venue
	public boolean deleteVenue(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_venues_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Venue
	public boolean updateVenues(Venues venue) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_venues_SQL);) {
			statement.setString(1, venue.getResourcename());
			statement.setString(2, venue.getTypeofvenue());
			statement.setString(3, venue.getWorkingdays());
			statement.setString(4, venue.getLocation());
			statement.setInt(5, venue.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}