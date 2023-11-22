package dao;

import java.sql.SQLException;

import pojos.Student;

public interface UserDao {
	
	// abstract method
	// method to insert student in the dbUserDao.javaUserDao.javaUserDao.java
	public void insertStudent(Student student) throws SQLException;

	// method to cleanup the resources
	
	public void cleanUp() throws SQLException;

	
	
	
}
