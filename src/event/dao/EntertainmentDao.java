package event.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import event.dbconnection.DbConnection;
import event.model.entertainment;
import event.servlet.entertainment.EntertainmentAddServlet;

public class EntertainmentDao {
	
	// transport
	private static final String INSERT_EntertainmentSQL = "INSERT INTO Entertainment"
			+ " (resourcename,typeOfEntertainment,days,location,filename,path) VALUES " + " (?, ?, ?,?,?,?);";

	private static final String SELECT_EntertainmentBY_ID = "select id,resourcename,typeOfEntertainment,days,location,filename,path from Entertainment where id =?";
	private static final String SELECT_ALL_Entertainment = "select * from Entertainment";
	private static final String DELETE_EntertainmentSQL = "delete from Entertainment where id = ?;";
	private static final String UPDATE_EntertainmentSQL = "update Entertainment                            set resourcename = ? ,typeOfEntertainment= ?,days = ?,location =? where id = ?;";

	public EntertainmentDao() {
	}

	DbConnection dbconnection = new DbConnection();
    
	// insert Transport
	public void insertEntertainment(EntertainmentAddServlet tr) throws SQLException, FileNotFoundException {
		System.out.println(INSERT_EntertainmentSQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EntertainmentSQL)) {

			preparedStatement.setString(1, tr.getresourcename());
			preparedStatement.setString(2, tr.gettypeOfEntertainment());

			preparedStatement.setString(3, tr.getdays());
			preparedStatement.setString(4, tr.getlocation());

			preparedStatement.setString(5, tr.getFilename());
			preparedStatement.setString(6, tr.getPath());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Transport
	public Entertainment selectEntertainment(int id) {
		Entertainment tr = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EntertainmentBY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String resourcename = rs.getString("resourcename");
				String typeOfEntertainment = rs.getString("typeOfEntertainment");
				String days = rs.getString("days");
				String location = rs.getString("location");

				tr = new Entertainment(id, resourcename, typeOfEntertainment, days, location);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return tr;
	}

	// select All Transport
	public List<Entertainment> selectAllEntertainment() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Entertainment> tr = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Entertainment);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println("id" + id);
				String resourcename = rs.getString("resourcename");
				System.out.println("resourcename " + resourcename);
				String typeOfEntertainment = rs.getString("typeOfEntertainment");
				System.out.println("typeOfEntertainment " + typeOfEntertainment);
				String days = rs.getString("days");
				System.out.println("days " + days);
				String location = rs.getString("location");
				System.out.println("location " + location);
				String filename = rs.getString("filename");
				System.out.println("filename " + filename);
				String path = rs.getString("path");
				System.out.println("path " + path);
				tr.add(new Entertainment(id, resourcename, typeOfEntertainment, days, location, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return tr;
	}

	// Delete TRansport
	public boolean deleteEntertainment(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EntertainmentSQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Transport
	public boolean updateEntertainment(Entertainment tr) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EntertainmentSQL);) {
			statement.setString(1, tr.getresourcename());

			statement.setString(2, tr.gettypeOfEntertainment());

			statement.setString(3, tr.getdays());

			statement.setString(4, tr.getlocation());

			statement.setInt(5, tr.getId());

			System.out.println("Update " + statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}