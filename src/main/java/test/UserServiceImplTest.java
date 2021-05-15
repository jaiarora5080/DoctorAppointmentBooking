
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import model.User;
import service.UserServiceImpl;

class UserServiceImplTest {
	private UserServiceImpl user = new UserServiceImpl();


	@Test
	
	void testbooking()throws SQLException{
		User obj = new User();
		obj.setApdate("2001-10-29");
		obj.setAptime("12pm");             
		obj.setDisease("cold");
	    obj.setGender("male");
	    obj.setPhoneno("123456789"); 
	    obj.setUsername("jai123");
	    
	    int expected = 1;
		int actual = user.insertUser(obj);
		assertEquals(expected,actual);
	}
	
	
    @Test		
   void testupdate()throws SQLException{
    	User obj1 =new User();
    	obj1.setApdate("1998-10-29");
		obj1.setAptime("5pm");             
		obj1.setDisease("fever");
	    obj1.setGender("male");
	    obj1.setPhoneno("1234"); 
	    obj1.setUsername("jai123");
	    obj1.setId(63);
	    boolean expected=true;
	    boolean actual=user.updateUser(obj1);
	    assertEquals(expected,actual);
    	
    
   }
  
    @Test
    
    void testdelete()throws SQLException{
    	
    	int Id=63; 
    	boolean expected=true;	
    	boolean	actual = user.deleteUser(Id);
    	assertEquals(expected,actual);
    	
    }
    	
    
    @Test
    void testselectbyid()throws SQLException{
    	
    	int Id=52; 
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
