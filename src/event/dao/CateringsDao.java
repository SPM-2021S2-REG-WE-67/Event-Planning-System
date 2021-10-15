package event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.Caterings;


public class CateringsDao {

	// Catering
	private static final String INSERT_caterings_SQL = "INSERT INTO caterings"
			+ " ( cateringname,CateringMenuDetails,WorkingDays,Location,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_caterings_BY_ID = "select id,cateringname,CateringMenuDetails,WorkingDays,Location from caterings where id =?";
	private static final String SELECT_ALL_caterings = "select * from caterings";
	private static final String DELETE_caterings_SQL = "delete from caterings where id = ?;";
	private static final String UPDATE_caterings_SQL = "update caterings set   cateringname = ?,CateringMenuDetails = ?,WorkingDays = ?,Location = ?  where id = ?;";

	public CateringsDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Catering
	public void insertCaterings(Caterings catering) throws SQLException {
		System.out.println(INSERT_caterings_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_caterings_SQL)) {
			preparedStatement.setString(1, catering.getCateringname());
			preparedStatement.setString(2, catering.getCateringmenudetails());
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
	public Caterings selectCatering(int id) {
		Caterings catering = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_caterings_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String cateringname = rs.getString("cateringname");

				String cateringmenudetails = rs.getString("CateringMenuDetails");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");

				catering = new Caterings(id, cateringname, cateringmenudetails, workingdays, location);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return catering;
	}

	// select All Catering
	public List<Caterings> selectAllCaterings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Caterings> caterings = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_caterings);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String cateringname = rs.getString("cateringname");
				String cateringmenudetails = rs.getString("CateringMenuDetails");
				String workingdays = rs.getString("WorkingDays");
				String location = rs.getString("Location");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				caterings.add(new Caterings(id, cateringname, cateringmenudetails, workingdays, location, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return caterings;
	}

	// Delete catering
	public boolean deleteCatering(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_caterings_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Catering
	public boolean updateCaterings(Caterings catering) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_caterings_SQL);) {
			statement.setString(1, catering.getCateringname());
			statement.setString(2, catering.getCateringmenudetails());
			statement.setString(3, catering.getWorkingdays());
			statement.setString(4, catering.getLocation());
			statement.setInt(5, catering.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}