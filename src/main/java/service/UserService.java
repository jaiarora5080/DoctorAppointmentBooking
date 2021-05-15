package service;

import java.sql.SQLException;
import java.util.List;

import model.User;



public interface UserService   {
	int insertUser(User user) throws SQLException ;
	User selectUser(int id);
	List<User> selectAllUsers();
	boolean deleteUser(int id) throws SQLException;
	boolean updateUser(User user) throws SQLException;
	void printSQLException(SQLException ex);
	

}
