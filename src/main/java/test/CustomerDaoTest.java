package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.CustomerDao;
import model.Customer;

class CustomerDaoTest{
   private CustomerDao customer = new CustomerDao();
	@Test
	@Disabled
	void register() throws ClassNotFoundException,SQLException{
		Customer obj = new Customer();
		obj.setFirstName("EXF");
		obj.setLastName("WQG");
		obj.setEmailid("EXF@gmail.com");
		obj.setDate("1998-10-13");
		obj.setGender("Male");
		obj.setPhoneno("85217473");
		obj.setPassword("1310");
		obj.setUsername("EXF1398");
		
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


