package service;

import java.sql.SQLException;

import model.Customer;

public interface CustomerService {

	int registerCustomer(Customer customers) throws ClassNotFoundException, SQLException;
	boolean loginUser(String username, String password) throws ClassNotFoundException, SQLException;
}
