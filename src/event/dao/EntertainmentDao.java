package event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.Entertainments;


public class EntertainmentDao {

	// entertainment
	private static final String INSERT_entertainments_SQL = "INSERT INTO entertainments"
			+ " ( resourcename,typeofentertainment,WorkingDays,Location,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_entertainments_BY_ID = "select id,resourcename,typeofentertainment,WorkingDays,Location from entertainments where id =?";
	private static final String SELECT_ALL_entertainments = "select * from entertainments";
	private static final String DELETE_entertainments_SQL = "delete from entertainments where id = ?;";
	private static final String UPDATE_entertainments_SQL = "update entertainments set   resourcename = ?,typeofentertainment = ?,WorkingDays = ?,Location = ?  where id = ?;";

	public EntertainmentDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert entertainment
	public void insertentertainments(Entertainments entertainment) throws SQLException {
		System.out.println(INSERT_entertainments_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_entertainments_SQL)) {
			preparedStatement.setString(1, entertainment.getresourcename());
			preparedStatement.setString(2, entertainment.gettypeofentertainment());
			preparedStatement.setString(3, entertainment.getWorkingdays());
			preparedStatement.setString(4, entertainment.getLocation());
			preparedStatement.setString(5, entertainment.getFilename());
			preparedStatement.setString(6, entertainment.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select entertainment
	public Entertainments selectEntertainment(int id) {
		Entertainments entertainment = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_entertainments_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String resourcename = rs.getString("resourcename");

				String typeofentertainment = rs.getString("typeofentertainment");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");

				entertainment = new Entertainments(id, resourcename, typeofentertainment, workingdays, location);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entertainment;
	}

	// select All entertainment
	public List<Entertainments> selectAllentertainments() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Entertainments> entertainments = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_entertainments);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String resourcename = rs.getString("resourcename");
				String typeofentertainment = rs.getString("typeofentertainment");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				entertainments.add(new Entertainments(id, resourcename, typeofentertainment, workingdays, location, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return entertainments;
	}

	// Delete entertainment
	public boolean deleteentertainment(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_entertainments_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update entertainment
	public boolean updateentertainments(Entertainments entertainment) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_entertainments_SQL);) {
			statement.setString(1, entertainment.getresourcename());
			statement.setString(2, entertainment.gettypeofentertainment());
			statement.setString(3, entertainment.getWorkingdays());
			statement.setString(4, entertainment.getLocation());
			statement.setInt(5, entertainment.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}