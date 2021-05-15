package model;

import org.apache.log4j.Logger;

import logger.TestLog4jServlet;

/**
 * User.java
 * This is a model class represents a User entity

 *
 */
public class User {
	static final Logger LOGGER = Logger.getLogger(User.class);
	protected int id;
	protected String apdate;
	protected String aptime;
	protected String phoneno;
	protected String gender;
	protected String username;
	protected String disease;
	
	public User() {
	}
	
	public User(String apdate, String aptime, String phoneno, String gender ,String username,String disease) {
		super();
		this.apdate = apdate;
		this.aptime = aptime;
		this.phoneno = phoneno;
		this.gender = gender;
		this.username = username;
		this.disease = disease;
	}

	public User(int id,String apdate, String aptime, String phoneno, String gender ,String username,String disease) {
		super();
		this.id = id;
		this.apdate = apdate;
		this.aptime = aptime;
		this.phoneno = phoneno;
		this.gender = gender;
		this.username = username;
		this.disease = disease;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getApdate() {
		return apdate;
	}
	public void setApdate(String apdate) {
		this.apdate = apdate;
	}
	
	
	public String getAptime() {
		return aptime;
	}
	public void setAptime(String aptime) {
		this.aptime = aptime;
	}
	
	
	
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
     
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
}

