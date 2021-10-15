package event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.Photographys;


public class PhotographysDao {

	// Photography
	private static final String INSERT_photographys_SQL = "INSERT INTO photographys"
			+ " ( studioname,AvailableServices,WorkingDays,Location,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_photographys_BY_ID = "select id,studioname,AvailableServices,WorkingDays,Location from photographys where id =?";
	private static final String SELECT_ALL_photographys = "select * from photographys";
	private static final String DELETE_photographys_SQL = "delete from photographys where id = ?;";
	private static final String UPDATE_photographys_SQL = "update photographys set   studioname = ?,AvailableServices = ?,WorkingDays = ?,Location = ?  where id = ?;";

	public PhotographysDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Photography
	public void insertPhotographys(Photographys photography) throws SQLException {
		System.out.println(INSERT_photographys_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_photographys_SQL)) {
			preparedStatement.setString(1, photography.getStudioname());
			preparedStatement.setString(2, photography.getAvailableservices());
			preparedStatement.setString(3, photography.getWorkingdays());
			preparedStatement.setString(4, photography.getLocation());
			preparedStatement.setString(5, photography.getFilename());
			preparedStatement.setString(6, photography.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Photography
	public Photographys selectPhotography(int id) {
		Photographys photography = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_photographys_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String studioname = rs.getString("studioname");

				String availableservices = rs.getString("AvailableServices");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");

				photography = new Photographys(id, studioname, availableservices, workingdays, location);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photography;
	}

	// select All Photography
	public List<Photographys> selectAllPhotographys() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Photographys> photographys = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_photographys);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String studioname = rs.getString("studioname");
				String availableservices = rs.getString("AvailableServices");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				photographys.add(new Photographys(id, studioname, availableservices, workingdays, location, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return photographys;
	}

	// Delete Photography
	public boolean deletePhotography(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_photographys_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Photography
	public boolean updatePhotographys(Photographys photography) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_photographys_SQL);) {
			statement.setString(1, photography.getStudioname());
			statement.setString(2, photography.getAvailableservices());
			statement.setString(3, photography.getWorkingdays());
			statement.setString(4, photography.getLocation());
			statement.setInt(5, photography.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}