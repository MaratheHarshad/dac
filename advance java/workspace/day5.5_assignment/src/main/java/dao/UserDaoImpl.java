/**
 * 
 */
package dao;

import static utils.DBUtils.getCn;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import pojos.Student;

/**
 * @author harsh
 *
 */
public class UserDaoImpl implements UserDao {

	private static Connection cn;
	private static PreparedStatement pst1;

	public UserDaoImpl() {

		try {

			// open the connection, and get the cn

			openConnection();
			cn = getCn();
			pst1 = cn.prepareStatement("insert into students values(?,?,?,?,?)");

		} catch (SQLException e) {
			System.out.println("erro in ctr of " + getClass());
			throw new RuntimeException("err in ctr of UserDaoImpl : ", e);
		}

	}

	@Override
	public void insertStudent(Student student) throws SQLException {
		
//		1. setInParams
		
//		first_name, last_name , marks, admission_status, course_id
		
		pst1.setString(1, student.getFirstName());
		pst1.setString(2, student.getLastName());
		pst1.setInt(3, student.getMarks());
		pst1.setBoolean(4, true);
		pst1.setInt(5, student.getSelectedCourse().getId());
		
		
		if(pst1.execute()) {
			System.out.println("Student details inserted successfully");
		}else {
			System.out.println("Error while inserting student details");
		}
		
		

	}
	
	@Override
	public void cleanUp() throws SQLException{
		
		if(cn != null) {
			cn.close();
		}
	}

}
