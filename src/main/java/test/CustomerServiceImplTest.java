package test;



import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import model.Customer;
import service.CustomerServiceImpl;

class CustomerServiceImplTest {

	private CustomerServiceImpl customer = new CustomerServiceImpl();
	@Test
	
	void register() throws ClassNotFoundException,SQLException{
		Customer obj = new Customer();
		obj.setFirstName("ABC");
		obj.setLastName("DEF");
		obj.setEmailid("ABC@gmail.com");
		obj.setDate("1998-10-13");
		obj.setGender("Male");
		obj.setPhoneno("8527317473");
		obj.setPassword("1310");
		obj.setUsername("ABC1398");
		
		int expected = 1;
		int actual = customer.registerCustomer(obj);
		assertEquals(expected,actual);
	}

@Test



void testlogin() throws ClassNotFoundException, SQLException{
	
	String username="jai12345" ;
	String password="12345";
	boolean expected=true;	
	boolean	actual = customer.loginUser(username,password);
	assertEquals(expected,actual);
	
}

}
