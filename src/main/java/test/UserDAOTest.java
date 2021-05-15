package test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import dao.UserDAO;
import model.User;

                                       
class UserDAOTest {
	private UserDAO user = new UserDAO();
	@Test
	
	void testbooking()throws SQLException{
		User obj = new User();
		obj.setApdate("2001-10-2");
		obj.setAptime("12pm");             
		obj.setDisease("headache");
	    obj.setGender("male");
	    obj.setPhoneno("1235556785"); 
	    obj.setUsername("jai123");
	    
	    int expected = 1;
		int actual = user.insertUser(obj);
		assertEquals(expected,actual);
	}
	
    @Test		
   void testupdate()throws SQLException{
    	User obj1 =new User();
    	obj1.setApdate("1998-10-29");
		obj1.setAptime("8pm");             
		obj1.setDisease("fever");
	    obj1.setGender("female");
	    obj1.setPhoneno("1234"); 
	    obj1.setUsername("jai123");
	    obj1.setId(47);
	    boolean expected=true;
	    boolean actual=user.updateUser(obj1);
	    assertEquals(expected,actual);
    	
    
   }
  
    @Test
    void testdelete()throws SQLException{
    	
    	int Id=52; 
    	boolean expected=true;	
    	boolean	actual = user.deleteUser(Id);
    	assertEquals(expected,actual);
    	
    }
    	
    
    @Test
    
    void testselectbyid()throws SQLException{
    	
    	int Id=62; 
    	boolean expected= true;
        boolean actual =false;
    	User obj = user.selectUser(Id);
    	if(!obj.getUsername().equals(null))
    	{
    		actual =true;
    	}
    		assertEquals(expected,actual);
    	
    
  }
    	
    
   
    @Test	
   
    void testlist(){
    	
    	boolean expected = true;
		boolean actual = false;
		List<User> arr = new ArrayList<User>();
		arr = user.selectAllUsers();
		for(int i=0;i<arr.size();i++) {
			if(!arr.get(i).getUsername().equals(null)) {
				actual = true;
			}
		}
		assertEquals(expected,actual);
	}
 	   
	

    }   
	
	












