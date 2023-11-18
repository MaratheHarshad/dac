package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {
	//state (fields)
	private Connection connection;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	
	//def ctor
	public UserDaoImpl() throws SQLException{
		// get cn from db utils
		connection=openConnection();
		pst1=connection.prepareStatement("select first_name,last_name,dob,status from users where role=? and dob between ? and ?");
		
		pst2=connection.prepareStatement("select * from users where email=? and password=? ");
		
		pst3=connection.prepareStatement("update users set status=1 where id = ?");
		
		System.out.println("user dao created!");
	}

	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		// set IN params
		pst1.setString(1,role);
		pst1.setDate(2, begin);
		pst1.setDate(3, end);
		//exec query : execQuery() --- RST
		List<User> users=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				users.add(new User(rst.getString(1),rst.getString(2)
						,rst.getDate(3),rst.getBoolean(4)));
		}
		return users;//DAO rets populated list of users to tester.
	}
	
	// return type , POJO (User POJO)
	public User authenticateUser(String email, String password) throws SQLException {
		
		// set IN params of prepareStatement
		// paramPosition starts from 1 in SQL
		pst2.setString(1, email);
		pst2.setString(2, password);
		
		
		User authenticatedUser = null;
		
		try(ResultSet rst = pst2.executeQuery()){
			
//			id | first_name | last_name | email | password | dob | status | role
			while(rst.next()) {
//				System.out.println("id : " + rst.getInt(1));
				
//				firstName, String lastName,email,  Date dob, boolean votingStatus
				authenticatedUser = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
		}// rst.close()
		
		
		return authenticatedUser;
	}
	
	
	
	// method to update the voting status of a user
	@Override
	public void updateVotingStatus(User user) throws SQLException {
		
		System.out.println("inside update voting status method");
		
		// set IN params of preparedStatement 
		pst3.setInt(1, user.getUserId());
		
		int updateCount = pst3.executeUpdate();
		
		if(updateCount == 1) {
			System.out.println("Voting status of user " + user + " updated successfully");
		}else {
			System.out.println("failed to update the voting status of user");
		}
		
	}
	
	
	
	
	//clean up 
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up !");
	}

	

}
