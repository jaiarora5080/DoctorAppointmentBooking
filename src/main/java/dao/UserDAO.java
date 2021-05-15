package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import controller.UserServlet;
import model.User;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
* 
 * 
 */
public class UserDAO {
	static final Logger LOGGER = Logger.getLogger(UserDAO.class);
	private String jdbcURL = "jdbc:mysql://localhost:3306/customer";
	private String jdbcUsername = "root";
	private String jdbcPassword = "srishti";

	private static final String INSERT_USERS_SQL = "INSERT INTO users"
			+ "  (apdate, aptime, phoneno, gender, username, disease) VALUES " + " (?,?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id,apdate,aptime,phoneno,gender,username,disease from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set apdate = ?,aptime= ?, phoneno =?,gender =?,username =?,disease =? where id = ?;";

	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;             
	}

	public int insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		int rowsUpdateCount = 0;
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			LOGGER.info("data inserted");
			preparedStatement.setString(1, user.getApdate());
			preparedStatement.setString(2, user.getAptime());
			preparedStatement.setString(3, user.getPhoneno());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getDisease());
			System.out.println(preparedStatement);
			rowsUpdateCount = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Data not inserted");
			printSQLException(e);
		}
		return rowsUpdateCount;
	}
	
	
	

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			LOGGER.info("selecting user by id");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String apdate = rs.getString("apdate");
				String aptime = rs.getString("aptime");
				String phoneno = rs.getString("phoneno");
				String gender = rs.getString("gender");
				String username = rs.getString("username");
				String disease = rs.getString("disease");
				user = new User(id, apdate, aptime, phoneno, gender, username, disease);
				
			}
		} catch (SQLException e) {
			LOGGER.error("Data not selected by id");
			printSQLException(e);
		}
		return user;

	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			LOGGER.info("showing data");
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String apdate = rs.getString("apdate");
				String aptime = rs.getString("aptime");
				String phoneno = rs.getString("phoneno");
				String gender = rs.getString("gender");
				String username = rs.getString("username");
				String disease = rs.getString("disease");
				users.add(new User(id, apdate, aptime, phoneno, gender, username, disease));
			}
		} catch (SQLException e) {
			LOGGER.error("Data not visible");
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			LOGGER.info("Deleting data");
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			LOGGER.info("updating data");
			statement.setString(1, user.getApdate());
			statement.setString(2, user.getAptime());
			statement.setString(3, user.getPhoneno());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getDisease());
			statement.setInt(7, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
