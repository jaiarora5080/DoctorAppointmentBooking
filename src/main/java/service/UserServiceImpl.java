package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UserDAO;
import model.User;

public class UserServiceImpl implements UserService {
	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
  

	
public	int insertUser(User user) throws SQLException {
	int rowcount=0;
	try 
	{
		LOGGER.info("Calling UserServiceImpl method");
	  UserDAO ud=new UserDAO();
		rowcount= ud.insertUser(user);
	}
	catch(Exception e) 
	{
		LOGGER.error("Data not inserted");
		System.out.println(e);	
	}
	
	
	return rowcount;
  }




public	User selectUser(int id){
	User user = null;
try 
{
	LOGGER.info("Calling UserServiceImpl method");
  UserDAO ud=new UserDAO();
	user= ud.selectUser(id);
}
catch(Exception e) 
{
	LOGGER.error("booking not visible by ID");
	System.out.println(e);	
}
return user;
}




public	List<User> selectAllUsers()
{ List<User> users = new ArrayList<>();
try 
{
	LOGGER.info("Calling UserServiceImpl method");
  UserDAO ud=new UserDAO();
	users= ud.selectAllUsers();
}
catch(Exception e) 
{
	LOGGER.error("booking not visible");
	System.out.println(e);	
}
return users;


}


public	boolean deleteUser(int id) throws SQLException
{ boolean rowDeleted=false;
	try 
	{
	  LOGGER.info("Calling UserServiceImpl method");
	  UserDAO ud=new UserDAO();
	  rowDeleted=ud.deleteUser(id);
	}
	catch(Exception e) 
	{
		LOGGER.error("booking not deleted");
		System.out.println(e);	
	}
	return rowDeleted;
}



public	boolean updateUser(User user) throws SQLException
{
	boolean rowUpdated=false;
	try 
	{
	  LOGGER.info("Calling UserServiceImpl method");
	  UserDAO ud=new UserDAO();
	  rowUpdated=ud.updateUser(user);
	}
	catch(Exception e) 
	{
		LOGGER.error("booking not updated");
		System.out.println(e);	
	}
	return rowUpdated;
	}


public	void printSQLException(SQLException ex)
{


	try 
	{
	  LOGGER.info("Calling UserServiceImpl method");
	  UserDAO ud=new UserDAO();
	 ud.printSQLException(ex);
	}
	catch(Exception e) 
	{
		LOGGER.error("SQL exception not visible");
		System.out.println(e);	
	}
	
}





}




