package dao;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.log4j.Logger;

import java.sql.ResultSet;

import com.project.jdbc.Utility;

import controller.UserServlet;

import java.sql.SQLException;

import model.Customer;

public class CustomerDao {
	private static Connection connection = null;
	private static Statement statement = null;
	static final Logger LOGGER = Logger.getLogger(CustomerDao.class);


	
	public boolean loginUser(String username, String password) throws ClassNotFoundException, SQLException{
    	boolean exist = false;
    	String currentUserName = "";
		String currentPassword = "";
		ResultSet resultSet = null;
    	try {LOGGER.error("login successfull");
    		connection = Utility.getDbConnection();
    		statement = connection.createStatement();
    		resultSet = statement.executeQuery("select username, password from customers");
    		
    		
    		while(resultSet.next()) {
    			currentUserName = resultSet.getString("username");
    			currentPassword = resultSet.getString("password");
    			
    			if(username.equals(currentUserName) && password.equals(currentPassword)) {
    				exist = true;
    				return exist;
    			}
    		}
    	}catch(ClassNotFoundException|SQLException e)
    	{LOGGER.error("login unsuccessfull");
    		e.printStackTrace();
    	}
    	finally{
            Utility.getDbConnectionClose();
        }
    	return false;
    }
    					
	public int registerCustomer(Customer customers) throws ClassNotFoundException, SQLException {
		try {

			LOGGER.info("Data inserted");
			int rowsUpdateCount = 0;
			String firstName = customers.getFirstName();
			String lastName = customers.getLastName();
			String emailid = customers.getEmailid();
			String phoneno = customers.getPhoneno();
			String date = customers.getDate();
			String gender = customers.getGender();
			String userName = customers.getUsername();
			String password = customers.getPassword();

			String insertData = "insert into customers values" + "('" + firstName + "','" + lastName + "','" + emailid
					+ "','" + phoneno + "','" + date + "','" + gender + "','" + userName + "','" + password + "')";

			connection = Utility.getDbConnection();
			statement = connection.createStatement();

			rowsUpdateCount = statement.executeUpdate(insertData);
			if (rowsUpdateCount > 0) {
				System.out.println("Customer Registered successfully");
			} else {
				System.out.println("Something went wrong. Insertion unsuccessful");
			}

			return rowsUpdateCount;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("Data not inserted");
			// process sql exception
			throw e;
		} finally {
			Utility.getDbConnectionClose();
		}
	}

}
