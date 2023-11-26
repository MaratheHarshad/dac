package dao;

import java.util.List;

import org.hibernate.*;
import pojos.Player;
import pojos.Team;

import static utils.HibernateUtils.*;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addPlayer(Player p, int teamId) {
		
		
		
		// 1. get a session from session factory
		
		Session session = getFactory().getCurrentSession();
		// 2. begin a transactin
		
		Transaction tx = session.beginTransaction();
		
		try {
			
//			3. access the team first, in which player should be inserted
			Team team = session.get(Team.class, teamId);
			
			//if team is exist
			if(team != null) {
				
				
				//team : PERSISTENT
				//establish bi dir asso bet entities : by calling helper method
				session.persist(p);
				team.addPlayer(p);
				
			}
			
			tx.commit();
			
			
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			
			throw e;
		}
		
		
		return "Player added with id : " + p.getPlayerId();
	}

	@Override
	public Team getTeamByAbbreviation(String abr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getTeamsByMaxAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTeamWicketsNBattingAvg(int teamId, int wickets, double minBattingAvg) {
		// TODO Auto-generated method stub
		
	}
	
	
}
