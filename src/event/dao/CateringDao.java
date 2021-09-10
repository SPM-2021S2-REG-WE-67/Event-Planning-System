package event.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.Catering;

public class CateringDao {

	// catering
	private static final String INSERT_catering_SQL = "INSERT INTO catering"
			+ " ( cateringname,CaterinMenuDetails,WorkingDays,Location,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_catering_BY_ID = "select id,cateringname,CaterinMenuDetails,WorkingDays,Location from catering where id =?";
	private static final String SELECT_ALL_catering= "select * from catering";
	private static final String DELETE_catering_SQL = "delete from catering where id = ?;";
	private static final String UPDATE_catering_SQL = "update catering set   cateringname = ?,CaterinMenuDetails = ?,WorkingDays = ?,Location = ?  where id = ?;";

	public CateringDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Catering
	public void insertCatering(Catering catering) throws SQLException {
		System.out.println(INSERT_catering_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_catering_SQL)) {
			preparedStatement.setString(1, catering.getCateringname());
			preparedStatement.setString(2, catering.getCaterinmenudetails());
			preparedStatement.setString(3, catering.getWorkingdays());
			preparedStatement.setString(4, catering.getLocation());
			preparedStatement.setString(5, catering.getFilename());
			preparedStatement.setString(6, catering.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Catering
	public Catering selectCatering(int id) {
		Catering catering = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_catering_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String cateringname = rs.getString("cateringname");

				String caterinmenudetails = rs.getString("CaterinMenuDetails");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");

				catering = new Catering(id, cateringname, caterinmenudetails, workingdays, location);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return catering;
	}

	// select All Catering
	public List<Catering> selectAllCatering() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Catering> catering = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_catering);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String cateringname = rs.getString("cateringname");
				String cateringmenudetails = rs.getString("CaterinMenuDetails");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				catering.add(new Catering(id, cateringname, cateringmenudetails, workingdays, location, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return catering;
	}

	// Delete catering
	public boolean deleteCatering(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_catering_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Catering
	public boolean updateCatering(Catering catering) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_catering_SQL);) {
			statement.setString(1, catering.getCateringname());
			statement.setString(2, catering.getCaterinmenudetails());
			statement.setString(3, catering.getWorkingdays());
			statement.setString(4, catering.getLocation());
			statement.setInt(5, catering.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}