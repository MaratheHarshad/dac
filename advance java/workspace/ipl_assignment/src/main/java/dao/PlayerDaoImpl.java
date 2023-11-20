package dao;

import static utils.DBUtils.getCn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	
	public PlayerDaoImpl() throws SQLException {
		cn=getCn();
//		id , first_name,last_name, dob,batting_avg,wickets_taken....
		pst1 = cn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("Player dao created");
	}
	
	// method to add player to team
	@Override
	public String addPlayerToTeam(Player newPlayer, int teamId) throws SQLException {
		
		// set in params
//		first_name | last_name | dob | batting avg | wickets_taken | team_id
		
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, teamId);
		
		// exec update (DML)
		
		int rows = pst1.executeUpdate();
		
		if(rows == 1) {
			return "New player added to the team...";
		}
			
		return "Adding new player failed !!!";
		
	}

	@Override
	public void cleanUp() throws SQLException {
		
		if(pst1 != null) {
			pst1.close();
		}
		
		System.out.println("player dao cleaned up");
		
	}
	
	

}
