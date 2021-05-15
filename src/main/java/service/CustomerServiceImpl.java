package service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.CustomerDao;
import model.Customer;


public class CustomerServiceImpl {
	static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	public boolean loginUser(String username, String password) throws ClassNotFoundException, SQLException{
		boolean exist = false;
		
		try 
		{
		  LOGGER.info("Calling CustomerServiceImpl methods");
		  CustomerDao ud=new CustomerDao();
		  exist=ud.loginUser(username,password);
		}
		catch(Exception e) 
		{
			LOGGER.error("Customer login failed");
			System.out.println(e);	
		}
		return exist;
		
	}
	
	
	
	public int registerCustomer(Customer customers) throws ClassNotFoundException, SQLException {
	   int rowsUpdateCount=0;
		try 
		{
		  LOGGER.info("Calling CustomerServiceImpl method");
		  CustomerDao ud=new CustomerDao();
		  rowsUpdateCount=ud.registerCustomer(customers);
		}
		catch(Exception e) 
		{
			LOGGER.error("Customer Signup failed");
			System.out.println(e);	
		}
		return rowsUpdateCount;
	
	}
	

}


